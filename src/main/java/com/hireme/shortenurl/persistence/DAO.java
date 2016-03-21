package com.hireme.shortenurl.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	private final String URL = "jdbc:mysql://173.194.230.214:3306/shortenurl";
	private final String USER = "admin";
	private final String PASS = "admin";	

	protected void open()  throws Exception{
		//Chamar o Driver (.jar) 
		Class.forName("com.mysql.jdbc.Driver");
		//Abrir a conexao com o banco
		con = DriverManager.getConnection(URL, USER, PASS);
	}
	
	protected void close()throws Exception{
		con.close();
	}
}
