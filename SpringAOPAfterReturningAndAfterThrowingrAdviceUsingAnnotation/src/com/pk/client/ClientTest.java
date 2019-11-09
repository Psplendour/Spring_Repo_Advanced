package com.pk.client;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.pk.model.Account;
import com.pk.serviceimpl.AccounService;
import com.pk.serviceimpl.AccountServiceImpl;
public class ClientTest {
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");		
		AccounService accountService = context.getBean("accountService",AccountServiceImpl.class);
		//Account account = accountService.getAccountByCustomerId("ABCDE12345");
		Account account = accountService.getAccountByCustomerId(null);
		if(account != null)
		{
			System.out.println(account.getAccountNumber()+"\t"+account.getAccountDescription());
		}
		context.close();
	}
}
