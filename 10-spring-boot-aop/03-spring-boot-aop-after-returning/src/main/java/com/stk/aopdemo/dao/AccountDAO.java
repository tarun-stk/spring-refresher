package com.stk.aopdemo.dao;

import com.stk.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

//    Add a new method find Accounts
    public List<Account> findAccounts();
    public void addAccount();

    public void addAccount(Account theAccount, boolean vipflag);

    public String getName() ;

    public void setName(String name) ;

    public String getLevel() ;

    public void setLevel(String level) ;
}
