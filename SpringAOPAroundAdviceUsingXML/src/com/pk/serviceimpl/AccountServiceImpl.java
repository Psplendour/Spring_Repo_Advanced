package com.pk.serviceimpl;
import com.pk.model.Account;
public class AccountServiceImpl {
      public Account updateAccountBalance(Account account,Long amount)
      {
    	  System.out.println("Account No: "+account.getAccountNumber()+", Amount: "+amount);
		return account;
      }
}
