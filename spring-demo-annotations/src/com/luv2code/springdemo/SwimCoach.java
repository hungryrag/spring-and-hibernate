package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SwimCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach() {
		System.out.println(">> SwimCoach: inside default constructor");
	}
	
	
	public String getEmail() {
		return email;
	}

	
//	@Value("${foo.email}")
//	public void setEmail(String email) {
//		this.email = email;
//	}

	public String getTeam() {
		return team;
	}

	
//	@Value("${foo.team}")
//	public void setTeam(String team) {
//		this.team = team;
//	}

	@Override
	public String getDailyWorkout() {
		
		return "Swim a double lap";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
