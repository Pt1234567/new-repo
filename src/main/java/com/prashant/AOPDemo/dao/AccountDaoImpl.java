package com.prashant.AOPDemo.dao;

import com.prashant.AOPDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Override
    public void addAccount(Account account,boolean Flag) {

        System.out.println(getClass()+": DOING MY WORK : ADDING ACCOUNT IN DB");

    }

    @Override
    public void SayHello() {
        System.out.println("Helllo Yoyoyoyoyo");
    }
}
