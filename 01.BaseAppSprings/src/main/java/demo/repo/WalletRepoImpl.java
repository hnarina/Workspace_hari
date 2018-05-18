package demo.repo;


import java.util.Map;

import demo.beans.Customer;

public class WalletRepoImpl implements WalletRepo{
	Map<String, Customer> data;
	
	
	
	
	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		this.data = data;
	}

	@Override
	public boolean save(Customer c) {
		data.put(c.getMobileNumber(), c);
		return true;
	}

	@Override
	public Customer findOne(String mobile) {
		return data.get(mobile);
		
	}

}
