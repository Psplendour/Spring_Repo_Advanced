package com.pk.serviceimpl;
import org.springframework.stereotype.Service;
import com.pk.model.Account;

@Service("accountService")
public class AccountServiceImpl {
      public void updateAccountBalance(Account account,Long amount)
      {
    	  System.out.println("Account No: "+account.getAccountNumber()+", Amount: "+amount);
      }
}
