package com.pk.model;
public class Account {
      private String accountNumber;
      private String accountDescription;	
      public Account(String accountNumber, String accountDescription) {
	  super();
	  this.accountNumber = accountNumber;
	  this.accountDescription = accountDescription;
	  }
	  public String getAccountNumber() {
			return accountNumber;
	  }
		
	public String getAccountDescription() {
			return accountDescription;
		}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber
				+ ", accountDescription=" + accountDescription + "]";
	}	
}
