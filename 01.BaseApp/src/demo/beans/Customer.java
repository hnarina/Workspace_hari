package demo.beans;

public class Customer {
	private String name;
	private String mobileNumber;
	private Wallet wallet;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  name + " " + mobileNumber + " " + wallet.getBalance();
	}
 	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

}
