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
		
		  
		service.createAccount("Meenal", "9649658180", 9000);
	//	System.out.println(service.showBalance("9649658180"));
		service.createAccount("harisai ", "7702508656", 1000);
	//	System.out.println(service.showBalance("7702508656"));
		service.createAccount("ramteja", "1234567890", 6000);
	//	System.out.println(service.showBalance("1234567890"));
		/*service.withdrawl("7702508656", 400);
		System.out.println(service.showBalance("7702508656"));
		service.deposit("7702508656", 1400);
		System.out.println(service.showBalance("7702508656"));
		*/
		//
		
	}

}
