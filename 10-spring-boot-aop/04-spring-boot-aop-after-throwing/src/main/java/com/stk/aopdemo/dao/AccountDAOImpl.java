package com.stk.aopdemo.dao;

import com.stk.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String level;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

//        thrownig exception
        if(tripWire){
            throw new RuntimeException("Exception thrown on purpose:");
        }
//        create some accounts
        Account temp1 = new Account("Madhu", "Silver");
        Account temp2 = new Account("Maddy", "Platinum");
        Account temp3 = new Account("Susan", "Gold");

//        add them to list
        List<Account> accounts = new ArrayList<>();
        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

//        return the list
        return accounts;
    }

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
