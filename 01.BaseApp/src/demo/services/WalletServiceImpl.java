package demo.services;
import demo.repo.*;
import demo.beans.*;

public class WalletServiceImpl implements WalletService {
	WalletRepoImpl repo;
  
	public WalletServiceImpl(WalletRepoImpl repo) {
		
		this.repo = repo;
	}

	@Override
	public Customer createAccount(String name, String mobile, float amount) {
	    
		Customer c1 = new Customer();
		Wallet w1 = new Wallet();
	    w1.setBalance(amount);
		c1.setName(name);
		c1.setMobileNumber(mobile);
	    c1.setWallet(w1);
		repo.save(c1);
		return c1;
	}

	@Override
	public Customer showBalance(String mobile) {
		
		return repo.findOne(mobile);
		
	}

	@Override
	public boolean withdrawl(String mobile, float amount) {
		Customer c = repo.findOne(mobile);
		Wallet w = c.getWallet();
		if(w.getBalance()>amount)
		{
			w.setBalance((w.getBalance()-amount));
			
		
		}
		return false;
	}

	@Override
	public boolean deposit(String mobile, float amount) {
		Customer c = repo.findOne(mobile);
		Wallet w = c.getWallet();
	     w.setBalance((w.getBalance()+amount));
	 	return true;
	}
	

}
