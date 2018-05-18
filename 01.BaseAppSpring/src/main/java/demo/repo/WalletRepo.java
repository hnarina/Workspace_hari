package demo.repo;
import demo.beans.*;


public interface WalletRepo {
	public boolean save(Customer c);
	public Customer findOne(String mobile);
	
	}
