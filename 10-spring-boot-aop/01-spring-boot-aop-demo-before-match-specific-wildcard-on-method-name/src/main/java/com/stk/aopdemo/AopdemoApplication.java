package com.stk.aopdemo;

import com.stk.aopdemo.dao.AccountDAO;
import com.stk.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){


		return runner -> {
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};

	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

//		cal the addAccount
		theAccountDAO.addAccount();

//		cal the addAccount
		theMembershipDAO.addSillyMember();
	}

}
