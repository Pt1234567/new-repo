package com.prashant.AOPDemo.dao;

import com.prashant.AOPDemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{

    private String name;
    private int code;

    @Override
    public List<Account> findAccount() {

        return findAccount(false);

    }

    @Override
    public List<Account> findAccount(boolean t) {

        if(t){
            throw  new RuntimeException("Chal bhag yaha se!!!");
        }
        List<Account> myAccount=new ArrayList<>();

        Account temp=new Account("Prashant","Gold");
        Account temp1=new Account("Prash","Silver");
        myAccount.add(temp);
        myAccount.add(temp1);

        return myAccount;

    }

    @Override
    public void addAccount(Account account,boolean Flag) {

        System.out.println(getClass()+": DOING MY WORK : ADDING ACCOUNT IN DB");

    }

    @Override
    public void SayHello() {
        System.out.println("Helllo Yoyoyoyoyo");
    }

    public String getName() {
        System.out.println(getClass()+": in getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": in setName");
        this.name = name;
    }

    public int getCode() {
        System.out.println(getClass()+": in setName");
        return code;
    }

    public void setCode(int code) {
        System.out.println(getClass()+": in setCode");
        this.code = code;
    }
}
