package demo.BaseAppJavaConfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import demo.beans.Customer;
import demo.repo.WalletRepoImpl;
import demo.services.WalletServiceImpl;
@Configuration
@ComponentScan
public class AppConfig {
	
 
	@Bean(value="map")
	public Map<String, Customer> getMap()
	{
		return new HashMap<String, Customer>();
	}
	
	@Bean(value="repo")
	 public WalletRepoImpl getRepo() {
		 WalletRepoImpl repo = new WalletRepoImpl(getMap());
		 return  repo;
	 }
	
	@Bean(value="service")
	 public WalletServiceImpl getService() {
		 WalletServiceImpl service = new WalletServiceImpl(getRepo());
		 return service;
	 }
	
}
