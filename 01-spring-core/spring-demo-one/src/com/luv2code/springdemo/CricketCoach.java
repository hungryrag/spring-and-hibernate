package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	// add new fields for email & team
	private String email, team;
	
	public CricketCoach() {
		System.out.println("Cricket Coach: inside no-arg constructor");
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("Cricket Coach: inside setter method - setEmail");
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Cricket Coach: inside setter method - setTeam");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Field practice 20 minutes, intense.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
}
