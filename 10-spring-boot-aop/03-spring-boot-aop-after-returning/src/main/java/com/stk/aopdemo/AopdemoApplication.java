package com.stk.aopdemo;

import com.stk.aopdemo.dao.AccountDAO;
import com.stk.aopdemo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){


		return runner -> {
			demoTheAfterReturningAdvice(theAccountDAO);
		};


	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

//		call method findAccounts();
		List<Account> accounts = theAccountDAO.findAccounts();

//		print the account details
		System.out.println("\n\n========>>>From Main: ");
		System.out.println("-------");
		System.out.println(accounts);
		System.out.println("\n");
	}
}
