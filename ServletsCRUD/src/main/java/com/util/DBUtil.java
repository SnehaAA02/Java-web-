package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {
	public static Connection createConnection() {
		Connection cn=null;
		try {
			String driver="org.apache.derby.jdbc.EmbeddedDriver";
			String databaseURL="jdbc:derby:C:\\Users\\dell\\MyDB;create=true";
			Class.forName(driver);
			cn= DriverManager.getConnection(databaseURL);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public static void closeAllConnection(Connection cn,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(cn!=null) {
				cn.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
