/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;

import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Iterator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
/**
 *
 * @author Parker
 */
public class WTTable {
    static String url = "jdbc:mysql://localhost:3306/wrestling";
    static String username = "user";
    static String password = "123";

    static Connection connection = null;
    static PreparedStatement selectProduct = null;
    static ResultSet resultset = null;
    	
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    
    
    
    	public static void FillWTList() throws FileNotFoundException, IOException {
		
		int id;
		String WTurl;
		String title;
		String image;
		ArrayList<WT> WTArticles = new ArrayList();
		
		Scanner reader = new Scanner(new File("//Users//markmiller//Downloads//WrestleTalk_Data.csv"));
		StringTokenizer row = new StringTokenizer("");
		
                WTTable.deleteWTTables();
                
		reader.nextLine();
		
		while (reader.hasNextLine()) {

			// get the next line of data
			row = new StringTokenizer(reader.nextLine(), ",");

			id = Integer.parseInt(row.nextToken());
			WTurl = row.nextToken();
			title = row.nextToken();
			image = row.nextToken();

			WTArticles.add(new WT(id, WTurl, title, image));
			
                        
                   try{
                      
                       Connection connection = DriverManager.getConnection(url, username, password);
          
                       PreparedStatement ps = null;
                          
                    String query = "INSERT INTO wrestling.wt (ArticleID, title, img, WTurl) "
                                   + "VALUES (?,?,?,?)";
                             
                     ps = connection.prepareStatement(query);
                     ps.setInt(1, id);
                     ps.setString(2, title);
                     ps.setString(3,image);
                     ps.setString(4, WTurl);
        
                     ps.executeUpdate();
                        
		}catch (SQLException e) {
                      System.err.println("Execption in UpdateWT method");
                      System.err.println(e.getMessage());
                       }
                
                
              /*  
                for (int i = 0; i < 30; i++){
                
                   WWE newArticle = new WWE();
                   
                   newArticle = WWEArticles.get(i);
                   
                   try{
                      
                       Connection connection = DriverManager.getConnection(url, username, password);
          
                          PreparedStatement ps = null;
                          
                             String query = "INSERT INTO wrestling.wwe (ArticleID, title, img, WWEurl) "
                                   + "VALUES (?,?,?,?)";
                             
                     ps = connection.prepareStatement(query);
                     ps.setInt(1, newArticle.getId());
                     ps.setString(2, newArticle.getTitle());
                     ps.setString(3,newArticle.getImg());
                     ps.setString(4, newArticle.getUrl());
        
                     ps.executeUpdate();
        
                     }catch (SQLException e) {
                      System.err.println("Execption in UpdateWWE method");
                      System.err.println(e.getMessage());
                       }
                  }
                    */
               }
                
        }
        

        public static void deleteWTTables() {
      
        try{
        Connection connection = DriverManager.getConnection(url, username, password);
        
       
        String preparedSQL = "SELECT * FROM wrestling.wt";
        
        PreparedStatement statement = connection.prepareStatement(preparedSQL);
        
        ResultSet results = statement.executeQuery();
        
        int totalEntrys = 0;
        
          while (results.next())
          { 
              totalEntrys = totalEntrys + 1;
          }
       
          {
        
       for (int i = 0; i < 50; i++) {
        
            preparedSQL = "DELETE FROM wrestling.wt WHERE ArticleID = " + i;
        
            statement = connection.prepareStatement(preparedSQL);

            statement.executeUpdate();
       }
      }
        }catch (SQLException e) {
            System.err.println("Execption in deleteWT method");
            System.err.println(e.getMessage());
        }
        
        
    }    
        
         public static ArrayList<WT> getWTData() throws IOException {
                ArrayList<WT> wtList = new ArrayList<WT>();
		//WWE result =  new WWE();
                try{
		Connection connection = DriverManager.getConnection(url, username, password);
                String preparedSQL = "SELECT * FROM wrestling.wt";
        
                PreparedStatement statement = connection.prepareStatement(preparedSQL);
        
                ResultSet wtResults = statement.executeQuery();

                    while(wtResults.next()){
               
                        WT result =  new WT();
                            int id = wtResults.getInt("ArticleID");
                            String title = wtResults.getString("title");
                            String img = wtResults.getString("img");
                            String WTurl = wtResults.getString("WTurl");
                            
                          
                            result.setId(id);
                            result.setImg(img);
                            result.setTitle(title);
                            result.setUrl(WTurl);
                             
                             wtList.add(result);
                        
                    }
				
                        
                
				
         }catch (SQLException e) {
            System.err.println("Execption in getWWEMethod");
            System.err.println(e.getMessage());
        }
                 return wtList;
     }
        
        
    }
    
   

