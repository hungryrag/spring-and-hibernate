package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
	
}
