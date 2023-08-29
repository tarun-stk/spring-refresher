package com.stk.aopdemo;

import com.stk.aopdemo.dao.AccountDAO;
import com.stk.aopdemo.dao.MembershipDAO;
import com.stk.aopdemo.service.FortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   FortuneService theFortuneService){


		return runner -> {
//			demoTheAfterReturningAdvice(theAccountDAO);
//			demoTheAfterThrowingAdvice(theAccountDAO);
//			demoTheAfterAdvice(theAccountDAO);

			demoTheAroundAdvice(theFortuneService);
		};




	}

	private void demoTheAroundAdvice(FortuneService theFortuneService) {

//		call the method
		System.out.println("\n=====>>>>Main: calling the getFortune() method");
		String fortune = theFortuneService.getFortune();

//		get the fortune
		System.out.println("\n========>>>Main: fotune: " + fortune);
		System.out.println("\n========>>>Main: finished");
	}
}
