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
//			demoTheAfterReturningAdvice(theAccountDAO);
//			demoTheAfterThrowingAdvice(theAccountDAO);
			demoTheAfterAdvice(theAccountDAO);
		};


	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		//		call method findAccounts();
		List<Account> accounts = null;
		boolean tripWire;
		try{
			tripWire = true;
			accounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc){
			System.out.println("\n\n========>>>From Main: Caught the exception: " + exc);
		}


//		print the account details
		System.out.println("\n\n========>>>From Main: ");
		System.out.println("-------");
		System.out.println(accounts);
		System.out.println("\n");
	}

//	output:
//	when no exception
//	====> @Before in performApiAnalytics()
//
//====> @Before in logToCloudAdvice()
//	In @After (finally) advice on method: AccountDAOImpl.findAccounts(..)
//
//
//			========>>>From Main:
//			-------
//			[Account{name='Madhu', level='Silver'}, Account{name='Maddy', level='Platinum'}, Account{name='Susan', level='Gold'}]


//	when exception occured
//====> @Before in performApiAnalytics()
//
//====> @Before in logToCloudAdvice()
//	In @After (finally) advice on method: AccountDAOImpl.findAccounts(..)
//
//
//			========>>>From Main: Caught the exception: java.lang.RuntimeException: Exception thrown on purpose:
//
//
//			========>>>From Main:
//			-------
//			null

}
