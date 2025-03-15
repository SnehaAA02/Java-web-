package com.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Product;
import com.util.DBUtil;

public class ProductDAO {
	public List<Product> viewAllProduct() {
		List<Product> resultOfView = new ArrayList<Product>();
		try {
			Connection cn=DBUtil.createConnection();
			PreparedStatement ps= cn.prepareStatement("select * from product");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 int productId=rs.getInt(1);
				 String name=rs.getString(2);
				 double price=rs.getDouble(3);
				 int quantityAvailable=rs.getInt(4);
				 Product p=new Product(productId,name,price,quantityAvailable);
				 resultOfView.add(p);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
		return resultOfView;
	}
	
	public boolean registerProduct(Product p) {
		boolean registerResult=false;
		try {
			Connection cn=DBUtil.createConnection();
			PreparedStatement ps=cn.prepareStatement("insert into product values(?,?,?,?)");
			ps.setInt(1, p.getProductId());
			ps.setString(2, p.getName());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getQuantityAvailable());
			int result=ps.executeUpdate();
			if(result>0) {
				registerResult=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return registerResult;
	}
	
	public boolean updateProduct(int id,double price) {
		boolean updateResult=false;
		try {
			Connection cn=DBUtil.createConnection();
			PreparedStatement ps=cn.prepareStatement("update product set price=? where id=?");
			ps.setDouble(1, price);
			ps.setInt(2, id);
			int result=ps.executeUpdate();
			if(result>0) {
				updateResult=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return updateResult;
	}
	
	public boolean deleteProduct(int id) {
		boolean deleteResult=false;
		try {
			Connection cn=DBUtil.createConnection();
			PreparedStatement ps=cn.prepareStatement("delete from product where id=?");
			ps.setInt(1, id);
			int result=ps.executeUpdate();
			if(result>0) {
				deleteResult=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return deleteResult;
	}
	}
