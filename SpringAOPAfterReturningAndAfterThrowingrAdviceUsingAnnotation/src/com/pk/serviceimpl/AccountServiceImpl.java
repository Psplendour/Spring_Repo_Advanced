package com.pk.serviceimpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.stereotype.Service;
import com.pk.model.Account;
@Service("accountService")
public class AccountServiceImpl implements AccounService {
	
	  private static Map<String,Account> map =null;
	  static
	  {
		  map =new HashMap<>();
		  map.put("ABCDE12345", new Account("4444333322222","Saving Account"));
		  map.put("12345abcde", new Account("999988887777","Current Account"));
		  
	  }    
    @Override
	public Account getAccountByCustomerId(String customerID) throws Exception
      {
    	  if(customerID == null) {
    		  throw new Exception("Customer id is Invalid");
    	  }
    	  Account account=null;
    	 Set<Entry<String, Account>> entrySet = map.entrySet();
    	 for (Entry<String, Account> entry : entrySet) {
			if(entry.getKey().equals(customerID));
			{
				account= entry.getValue();
			}
		}
		return account;
      }
}