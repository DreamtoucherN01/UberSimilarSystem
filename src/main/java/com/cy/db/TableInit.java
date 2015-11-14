package com.cy.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.cy.util.TableInfo;


public class TableInit {
	private String driver=null;//驱动程序
    private String url=null;//odbc数据源
    private String newurl=null;//odbc数据源
    private String username=null;//用户名
    private String password=null;//密码
    private Connection con=null;
    
    
    public TableInit(){
        Properties p=new Properties();
        try{
            String filePath = TableInit.class.getClassLoader().getResource("db.properties").getPath();
            FileInputStream in=new FileInputStream(filePath);
            p.load(in);//从输入流中读取属性列表
            driver=p.getProperty("jdbc.driver");
            url=p.getProperty("jdbc.url");
            newurl=p.getProperty("jdbc.new.url");
            username=p.getProperty("username");
            password=p.getProperty("password");
            in.close();
            init();
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public TableInit(String driver,String url,String newurl,String username,String password){
        this.driver=driver;
        this.url=url;
        this.newurl = newurl;
        this.username=username;
        this.password=password;
    }
    
    public void init(){
    	con=null;
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,password);
            String databaseSql = "create database if not exists cy";
            Statement smt = con.createStatement();
            
            if (con != null) {
            	smt.executeUpdate(databaseSql);
            }
            
            smt.close();
            con.close();
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    private void initTable(Connection con) {
    	try {
			Statement newSmt = con.createStatement();
			
			newSmt.executeUpdate(TableInfo.seller);
			newSmt.executeUpdate(TableInfo.mall);
			newSmt.executeUpdate(TableInfo.car);
			newSmt.executeUpdate(TableInfo.buyer);
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    public void initialize(){
        con=null;
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(newurl,username,password);
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        initTable(con);
    }

}
