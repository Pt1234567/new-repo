package com.prashant.AOPDemo;

import com.prashant.AOPDemo.dao.AccountDao;
import com.prashant.AOPDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopDemoApplication.class, args);


	}

    @Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDAO membershipDAO){
		return runner->{
			demoTheBeforeAdvice(accountDao,membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDao accountDao,MembershipDAO membershipDAO) {

		//call the business method
		Account myAccount=new Account();
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
	}

}
