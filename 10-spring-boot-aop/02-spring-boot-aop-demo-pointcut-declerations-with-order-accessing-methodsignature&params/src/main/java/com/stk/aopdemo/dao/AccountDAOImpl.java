package com.stk.aopdemo.dao;

import com.stk.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String level;

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public void addAccount(Account theAccount, boolean vipflag) {
        System.out.println(getClass() + "Inside addAccount(Account theAccount, boolean vipflag)");
    }

    public String getName() {
        System.out.println(getClass() + ": getting Name getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setting Name setName()");
        this.name = name;
    }

    public String getLevel() {
        System.out.println(getClass() + ": getting level getLevel()");
        return level;
    }

    public void setLevel(String level) {
        System.out.println(getClass() + ": setting level setLevel()");
        this.level = level;
    }
}
