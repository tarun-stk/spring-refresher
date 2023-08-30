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
//			demoTheAroundAdvice(theFortuneService);
//			demoTheAroundAdviceHandleException(theFortuneService);

			demoTheAroundAdviceRethrowException(theFortuneService);
		};




	}

	private void demoTheAroundAdviceRethrowException(FortuneService theFortuneService) {
//		call the method
		System.out.println("\n=====>>>>Main: calling the getFortune() method");
//		Adding tripWire to generate exception.
		boolean tripWire = true;
		String fortune = theFortuneService.getFortune(tripWire);

//		get the fortune
		System.out.println("\n========>>>Main: fotune: " + fortune);
		System.out.println("\n========>>>Main: finished");
	}

}
