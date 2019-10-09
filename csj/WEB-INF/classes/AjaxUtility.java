import java.io.*;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import java.util.*;
import java.text.*;

import java.sql.*;

import java.io.IOException;
import java.io.*;



public class AjaxUtility {
	StringBuffer sb = new StringBuffer();
	boolean namesAdded = false;
	static Connection conn = null;
    static String message;
	public static String getConnection()
	{

		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartportables","root","cumin");
			message="Successfull";
			return message;
		}
		catch(SQLException e)
		{
			 message="unsuccessful";
		     return message;
		}
		catch(Exception e)
		{
			 message="unsuccessful";
		     return message;
		}
	}

	public  StringBuffer readdata(String searchId)
	{
		HashMap<String,ProductDetail> data;
		data=getData();

 	    Iterator it = data.entrySet().iterator();
        while (it.hasNext())
	    {
                    Map.Entry pi = (Map.Entry)it.next();
			if(pi!=null)
			{
				ProductDetail p=(ProductDetail)pi.getValue();
                if (p.getName().toLowerCase().startsWith(searchId))
                {
                        sb.append("<product>");
                        sb.append("<id>" + p.getId()+p.getName() + "</id>");
                        sb.append("<productName>" + p.getName() + "</productName>");
                        sb.append("</product>");
                }
			}
       }

	   return sb;
	}

	public static HashMap<String,ProductDetail> getData()
	{
		HashMap<String,ProductDetail> hm=new HashMap<String,ProductDetail>();
		try
		{
			getConnection();

		  String selectproduct1="select * from  wearabletechnology";
		  PreparedStatement pst1 = conn.prepareStatement(selectproduct1);
			ResultSet rs1 = pst1.executeQuery();
			String selectproduct2="select * from  phone";
			PreparedStatement pst2 = conn.prepareStatement(selectproduct2);
			ResultSet rs2 = pst2.executeQuery();
			String selectproduct3="select * from  Voiceassistant";
			PreparedStatement pst3 = conn.prepareStatement(selectproduct3);
			ResultSet rs3 = pst3.executeQuery();
			String selectproduct4="select * from  laptops";
			PreparedStatement pst4 = conn.prepareStatement(selectproduct4);
			ResultSet rs4 = pst4.executeQuery();

			while(rs1.next())
			{	ProductDetail p = new ProductDetail(rs1.getString("id"),rs1.getString("name"),rs1.getDouble("price"),rs1.getString("image"),rs1.getString("type"),rs1.getString("cond"),rs1.getDouble("discount"),"SmartPortables",rs1.getInt("num"));
				hm.put(rs1.getString("id")+rs1.getString("name"), p);

				System.out.print(p.getName()+","+p.getPrice());
			}
			while(rs2.next())
			{	ProductDetail p = new ProductDetail(rs2.getString("id"),rs2.getString("name"),rs2.getDouble("price"),rs2.getString("image"),rs2.getString("type"),rs2.getString("cond"),rs2.getDouble("discount"),"SmartPortables",rs2.getInt("num"));
				hm.put(rs2.getString("id")+rs2.getString("name"), p);

				System.out.print(p.getName()+","+p.getPrice());
			}
			while(rs3.next())
			{	ProductDetail p = new ProductDetail(rs3.getString("id"),rs3.getString("name"),rs3.getDouble("price"),rs3.getString("image"),rs3.getString("type"),rs3.getString("cond"),rs3.getDouble("discount"),"SmartPortables",rs3.getInt("num"));
				hm.put(rs3.getString("id")+rs3.getString("name"), p);

				System.out.print(p.getName()+","+p.getPrice());
			}
			while(rs4.next())
			{	ProductDetail p = new ProductDetail(rs4.getString("id"),rs4.getString("name"),rs4.getDouble("price"),rs4.getString("image"),rs4.getString("type"),rs4.getString("cond"),rs4.getDouble("discount"),"SmartPortables",rs4.getInt("num"));
				hm.put(rs4.getString("id")+rs4.getString("name"), p);

				System.out.print(p.getName()+","+p.getPrice());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;
	}
	// public static void storeData(HashMap<String,ProductDetail> productdata)
	// {
	// 	try
	// 	{
	//
	// 		getConnection();
	//
	// 		String insertIntoProductQuery = "INSERT INTO product(productId,productName,image,retailer,productCondition,productPrice,productType,discount) "
	// 		+ "VALUES (?,?,?,?,?,?,?,?);";
	// 		for(Map.Entry<String, ProductDetail> entry : productdata.entrySet())
	// 		{
	//
	// 			PreparedStatement pst = conn.prepareStatement(insertIntoProductQuery);
	// 			//set the parameter for each column and execute the prepared statement
	// 			pst.setString(1,entry.getValue().getId());
	// 			pst.setString(2,entry.getValue().getName());
	// 			pst.setString(3,entry.getValue().getImage());
	// 			pst.setString(4,entry.getValue().getRetailer());
	// 			pst.setString(5,entry.getValue().getCondition());
	// 			pst.setDouble(6,entry.getValue().getPrice());
	// 			pst.setString(7,entry.getValue().getType());
	// 			pst.setDouble(8,entry.getValue().getDiscount());
	// 			pst.execute();
	// 		}
	// 	}
	// 	catch(Exception e)
	// 	{
	//
	// 	}
	// }

}
