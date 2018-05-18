package demo.repo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import com.mysql.jdbc.Statement;

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
		//String m1=mobile;
		Customer c = new Customer();
		Wallet w= new Wallet();
		String name=null,mobilenumber=null;
		float amount=0;
		try {
			String jdbcDriver="com.mysql.jdbc.Driver";
			Class.forName(jdbcDriver);
			String jdbcURL = "jdbc:mysql://localhost:3306/test";
		    Connection con = DriverManager.getConnection(jdbcURL);
			java.sql.Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select name,mobileNumber,balance from customer c inner join wallet w on c.wallet_id=w.wallet_id where mobileNumber="+mobile);  
			
			while(rs.next())
			{
			
			name=rs.getString("name");
			mobilenumber=rs.getString("mobileNumber");
			amount=rs.getFloat("balance");
			c.setName(name);
			c.setMobileNumber(mobilenumber);
			c.setWallet(w);
			w.setBalance(amount);
			
			
			
			}
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		
		return c;
	
		
	}
	@Override
	public boolean update(Customer c) {
		// TODO Auto-generated method stub
		//Customer c1 = c;
		Wallet w1= c.getWallet();
		String name=null,mobilenumber=null;
		float amount=0;
		try {
			String jdbcDriver="com.mysql.jdbc.Driver";
			Class.forName(jdbcDriver);
			String jdbcURL = "jdbc:mysql://localhost:3306/test";
		    Connection con = DriverManager.getConnection(jdbcURL);
			java.sql.Statement stmt=con.createStatement();  
		    stmt.executeUpdate("update customer c inner join wallet w on c.wallet_id=w.wallet_id set balance="+w1.getBalance()+" where mobileNumber="+c.getMobileNumber());  
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		return false;
	}

}
