package demo.services;
import demo.beans.*;

public interface WalletService {
public Customer createAccount(String name, String mobile, float amount);
public Customer showBalance(String mobile);
public boolean withdrawl(String mobile, float amount);
public boolean deposit(String mobile, float amount);

}
