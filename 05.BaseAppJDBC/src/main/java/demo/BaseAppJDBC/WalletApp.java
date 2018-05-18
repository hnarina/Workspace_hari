package demo.BaseAppJDBC;
import demo.repo.WalletRepoImpl;
import demo.services.*;

import java.util.HashMap;
import java.util.Map;

import demo.beans.Customer;
import demo.repo.*;


public class WalletApp {
   
	public static void main(String[] args) {
	//	Map<String, Customer> data = new HashMap<String, Customer>();
		WalletRepoImpl repo = new WalletRepoImpl();
		WalletServiceImpl service = new WalletServiceImpl(repo);
		
		  
		//service.createAccount("Meenal", "9649658180", 9000);
		System.out.println(service.showBalance("9649658180"));
		//service.createAccount("haneef ", "1234512345", 2000);
	    System.out.println(service.showBalance("1234512345"));
	   // service.createAccount("harisai", "1234512346", 9000);
		System.out.println(service.showBalance("1234512345"));
		service.withdrawl("1234512345", 400);
		System.out.println(service.showBalance("1234512345"));
		service.deposit("1234512345", 1400);
		System.out.println(service.showBalance("1234512345"));
			
	}

}
