package com.DAOclass.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DBconnect.util.DataBaseConnect;
import com.getset.util.Getsetclass;

public class Dao {
	static Connection con=DataBaseConnect.connect();
	public static List<Getsetclass>getAllRecords(){
		List<Getsetclass>p=new ArrayList<>();
		try {
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from bill");
			while(rs.next()) {
				Getsetclass g=new Getsetclass();
				g.setId(rs.getInt("id"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getFloat("price"));
				g.setQty(rs.getInt("qty"));
				g.setTotalprice(rs.getFloat("totalprice"));
				p.add(g);
			}
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		return p;} 
	
	
	
	public static boolean insertRecord(int id, String name,int qty,float price,float totalprice) {
		String sql="insert into bill values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			
			ps.setInt(3, qty);
			ps.setFloat(4, price);
			ps.setFloat(5, totalprice);
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public static Getsetclass searchById(int id) {
		Getsetclass g=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from bill where id =?");
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			g=new Getsetclass();
			rs.next();
			g.setId(rs.getInt("id"));
			g.setName(rs.getString("name"));
			g.setQty(rs.getInt("qty"));
			g.setPrice(rs.getFloat("price"));
			
			g.setTotalprice(rs.getFloat("totalprice"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
		
	}
	public static boolean deleteRecord(int id) {
		String sql = "delete from bill where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i>0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static  boolean updateRecord(Getsetclass get ) {
		String sql="update bill set name=?, qty=?, price=?, totalprice=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, get.getName());
			ps.setInt(2, get.getQty());
			ps.setFloat(3, get.getPrice());
			ps.setFloat(4, get.getTotalprice());
			ps.setInt(5, get.getId());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
}
}
