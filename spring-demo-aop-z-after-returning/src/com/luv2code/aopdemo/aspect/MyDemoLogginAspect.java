package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
	public void demoLogging(JoinPoint theJoinPoint) {		
		System.out.println("\n=========>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig); // calls toString()
		
		// display method arguments
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args and print them
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account ac = (Account) tempArg;
				
				System.out.println("Account name: " + ac.getName());
				System.out.println("Account name: " + ac.getLevel());
			}
		}		
	}
	
	// add a new advice for @AfterReturning on findAccounts methods
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountsAdvice(
						JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=========>>> Executing @AfterReturning on method: " + method);
				
		// print out the results of the method call
		System.out.println("\n=========>>> Result is: " + result);
		
		// let's post-process the data ... let's modify it
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n=========>>> Result is: " + result);
		
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		for(Account tempAc : result) {
			// get uppercase version of name
			String theUpperName = tempAc.getName().toUpperCase();
			
			// update the name on the account
			tempAc.setName(theUpperName);
		}
		
	}
	
}
