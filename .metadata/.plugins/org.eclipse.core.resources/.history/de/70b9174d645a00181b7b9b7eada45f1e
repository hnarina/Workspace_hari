package demo.repo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import demo.beans.Customer;
import demo.beans.Wallet;

public class WalletRepoImpl implements WalletRepo{

	@Override
	public boolean save(Customer c) {
		Wallet w = c.getWallet();
		int wr=0;
		
		try {
		String jdbcDriver="com.mysql.jdbc.Driver";
		Class.forName(jdbcDriver);
		String jdbcURL = "jdbc:mysql://localhost:3306/test";
	    Connection con = DriverManager.getConnection(jdbcURL);
		PreparedStatement insertWallet =con.prepareStatement("insert into Wallet(balance) values(?)");
		insertWallet.setFloat(1,w.getBalance()); 
		insertWallet.executeUpdate();
		PreparedStatement stmt=con.prepareStatement("select wallet_id from Wallet where balance ="+w.getBalance()+"");  
		ResultSet rs=stmt.executeQuery();  
		while(rs.next())
		wr = rs.getInt("wallet_id");
		PreparedStatement insertCustomer =con.prepareStatement("insert into Customer(name,mobileNumber,wallet_id) values(?,?,?) ");
		insertCustomer.setString(1,c.getName()); 
		insertCustomer.setString(2,c.getMobileNumber());
		insertCustomer.setInt(3, wr);
		insertCustomer.executeUpdate();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return true;
	}
	@Override
	public Customer findOne(String mobile) {
		
		return null;
	
		
	}

}
