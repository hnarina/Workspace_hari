package demo.repo;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import demo.beans.Customer;
@Repository
public class WalletRepoImpl implements WalletRepo{
	@Resource(name="map")
private	Map<String, Customer> data;
	
	
	
	
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
