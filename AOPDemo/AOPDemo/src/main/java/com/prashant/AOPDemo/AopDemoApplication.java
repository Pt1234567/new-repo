package com.prashant.AOPDemo;

import com.prashant.AOPDemo.Service.TrafficFortuneService;
import com.prashant.AOPDemo.dao.AccountDao;
import com.prashant.AOPDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopDemoApplication.class, args);


	}

    @Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDAO membershipDAO,TrafficFortuneService trafficFortuneService){
		return runner->{
//			demoTheBeforeAdvice(accountDao,membershipDAO);
//			demoTheAfterReturningAdvice(accountDao);
//			demoTheAfterThrowingAdvice(accountDao);
//			demoTheAfterAdvice(accountDao);
//			demoTheAroundAdvice(trafficFortuneService);
//			demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);

		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdviceRethrowException");

		System.out.println("Calling the fortune");

		boolean tripWire=true;

		String data=trafficFortuneService.getFortune(tripWire);

		System.out.println("\n My fortune is: "+data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdviceHandleException");

		System.out.println("Calling the fortune");

		boolean tripWire=true;

		String data=trafficFortuneService.getFortune(tripWire);

		System.out.println("\n My fortune is: "+data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdvice");

		System.out.println("Calling the fortune");

		String data=trafficFortuneService.getFortune();

		System.out.println("\n My fortune is: "+data);

		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDao accountDao) {
		//call method to find account
		List<Account> myAccount= null;

		try{
			boolean t=false;
			myAccount=accountDao.findAccount(t);
		}catch (Exception ex){
			System.out.println("\n\n Main Program : Caught Exception : "+ex);
		}

		//Display the Accounts

		System.out.println("\n\n Main Program : demo The After	Advice");
		System.out.println("----");

		System.out.println(myAccount);

		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDao accountDao) {
		//call method to find account
		List<Account> myAccount= null;

		try{
			boolean t=true;
			myAccount=accountDao.findAccount(t);
		}catch (Exception ex){
			System.out.println("\n\n Main Program : Caught Exception : "+ex);
		}

		//Display the Accounts

		System.out.println("\n\n Main Program : demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(myAccount);

		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDao accountDao) {
		//call method to find account
		List<Account> myAccount=accountDao.findAccount();

		//Display the Accounts

		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(myAccount);

		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDao accountDao,MembershipDAO membershipDAO) {

		//call the business method
		Account myAccount=new Account();
		myAccount.setName("Prashant");
		myAccount.setLevel("1");
		accountDao.addAccount(myAccount,true);

		System.out.println();
		System.out.println();

		accountDao.SayHello();

		System.out.println();
		System.out.println();

		membershipDAO.addAccount();

		System.out.println();
		System.out.println();

		membershipDAO.goToSleep();


		System.out.println();
		System.out.println();

		accountDao.setCode(23);
		System.out.println();
		System.out.println();
		accountDao.setName("Prashant");
		System.out.println();
		System.out.println();

		String name=accountDao.getName();
		System.out.println();
		System.out.println();
		int code=accountDao.getCode();
		System.out.println();
		System.out.println();

	}

}
