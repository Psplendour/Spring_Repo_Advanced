package com.pk.serviceimpl;

import com.pk.model.Account;

public interface AccounService {

	Account getAccountByCustomerId(String customerID) throws Exception;

}