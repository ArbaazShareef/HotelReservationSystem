import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class adminMySql {
	//static ProductSAXParser sp = new ProductSAXParser();
	
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation", "root", "tanmaya");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

// Getting (x3)
	public static ArrayList<String> getHotels(){
		ArrayList<String> myHotels = new ArrayList<String>();
		try{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation?autoReconnect=true&useSSL=false", "root", "tanmaya");
			Statement stat = conn.createStatement ();
			stat.executeQuery("SELECT DISTINCT HotelName FROM Products ORDER BY HotelName;");
			ResultSet resultSet = stat.getResultSet();
			while (resultSet.next ()){
		   		myHotels.add(resultSet.getString ("HotelName"));
			}
			resultSet.close();
			stat.close ();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return myHotels;
	}

	public static ArrayList<String> getCustomers(){
		ArrayList<String> myCustomers = new ArrayList<String>();
		try{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation?autoReconnect=true&useSSL=false", "root", "tanmaya");
			Statement stat = conn.createStatement ();
			stat.executeQuery("SELECT DISTINCT firstName FROM Registration ORDER BY firstName;");
			ResultSet resultSet = stat.getResultSet();
			while (resultSet.next ()){
				String myString = resultSet.getString ("firstName");
		   		myCustomers.add(myString);
			}
			resultSet.close();
			stat.close ();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return myCustomers;
	}

	public static ArrayList<String> getOrders(){
		ArrayList<String> myOrders = new ArrayList<String>();
		try{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation?autoReconnect=true&useSSL=false", "root", "tanmaya");
			Statement stat = conn.createStatement ();
			stat.executeQuery("SELECT DISTINCT OrderId FROM customerorders ORDER BY OrderId;;");
			ResultSet resultSet = stat.getResultSet();
			while (resultSet.next ()){
		   		myOrders.add(resultSet.getString ("OrderId"));
			}
			resultSet.close();
			stat.close ();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return myOrders;
	}

// Deleting (x3)
	public static void deleteHotel(String name){
		try{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation?autoReconnect=true&useSSL=false", "root", "tanmaya");
			Statement stat = conn.createStatement ();
			stat.executeQuery("SET SQL_SAFE_UPDATES=0;");
			stat.executeUpdate("DELETE FROM products WHERE HotelName = '"+name+"';");
			stat.executeQuery("SET SQL_SAFE_UPDATES=1;");
			stat.close ();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void deleteCustomer(String firstName){
		try{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation?autoReconnect=true&useSSL=false", "root", "tanmaya");
			Statement stat = conn.createStatement ();
			stat.executeQuery("SET SQL_SAFE_UPDATES=0;");
			stat.executeUpdate("DELETE FROM registration WHERE firstName = '"+firstName+"'");
			stat.executeQuery("SET SQL_SAFE_UPDATES=1;");
			stat.close ();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void deleteOrder(String OrderId){
		try{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation?autoReconnect=true&useSSL=false", "root", "tanmaya");
			Statement stat = conn.createStatement ();
			stat.executeQuery("SET SQL_SAFE_UPDATES=0;");
			stat.executeUpdate("DELETE FROM customerorders WHERE OrderId = '"+OrderId+"';");
			stat.executeQuery("SET SQL_SAFE_UPDATES=1;");
			stat.close ();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

// Adding (x3)
    public static void addHotel(String productId, String productName, String category, String type, String hotelName, String price, String location, String image, String sQuantity, String rQuantity, String sales, String description, String accessories){
		try{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation?autoReconnect=true&useSSL=false", "root", "tanmaya");
			Statement stat = conn.createStatement ();
			stat.executeUpdate("INSERT INTO products (ProductId, ProductName, Category, Type, HotelName, Price, Location, Image, SQuantity, RQuantity, Sales, Description, Accessories) VALUES ('"+productId+"', '"+productName+"', '"+category+"', '"+type+"', '"+hotelName+"', '"+price+"', '"+location+"', '"+image+"', '"+sQuantity+"', '"+rQuantity+"', '"+sales+"', '"+description+"', '"+accessories+"');");
			stat.close ();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

    public static void addCustomer(String firstName, String lastName, String emailId, String phoneNumber, String password){
		try{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation?autoReconnect=true&useSSL=false", "root", "tanmaya");
			Statement stat = conn.createStatement ();
			stat.executeUpdate("INSERT INTO registration (firstName, lastName, emailId, phoneNumber, password) VALUES ('"+firstName+"', '"+lastName+"', '"+emailId+"', '"+phoneNumber+"', '"+password+"');");
			stat.close ();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void addOrder(String orderId, String checkInDate, String checkOutDate, String productName, String Price, String UserId){
		try{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation?autoReconnect=true&useSSL=false", "root", "tanmaya");
			Statement stat = conn.createStatement ();
			stat.executeUpdate("INSERT INTO customerorders (OrderId, CheckInDate, CheckOutDate, ProductName, Price,  UserId) VALUES ('"+orderId+"', '"+checkInDate+"', '"+checkOutDate+"', '"+productName+"', '"+Price+"',  '"+UserId+"');");
			stat.close ();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}


