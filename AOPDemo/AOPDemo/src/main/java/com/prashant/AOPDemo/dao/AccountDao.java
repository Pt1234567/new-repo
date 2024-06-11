package com.prashant.AOPDemo.dao;

import com.prashant.AOPDemo.Account;

import java.util.List;

public interface AccountDao {


    List<Account> findAccount();
    List<Account> findAccount(boolean t);
    void addAccount(Account account,boolean Flag);

    void SayHello();

    public String getName();

    public void setName(String name) ;
    public int getCode();

    public void setCode(int code);

}
