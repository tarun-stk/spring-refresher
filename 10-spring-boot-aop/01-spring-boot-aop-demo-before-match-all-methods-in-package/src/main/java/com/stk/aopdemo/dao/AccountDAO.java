package com.stk.aopdemo.dao;

import com.stk.aopdemo.Account;

public interface AccountDAO {

    public void addAccount(Account theAccount, boolean vipFlag);

    public boolean doWork();
}
