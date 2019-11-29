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
public class AEWTable {
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
    
    
    
    	public static void FillAEWList() throws FileNotFoundException, IOException {
		
		int id;
		String AEWurl;
		String title;
		String image;
		ArrayList<AEW> AEWArticles = new ArrayList();
		
		Scanner reader = new Scanner(new File("//Users//markmiller//Downloads//AEW_Data.csv"));
		StringTokenizer row = new StringTokenizer("");
		
                AEWTable.deleteAEWTables();
                
		reader.nextLine();
		
		while (reader.hasNextLine()) {

			// get the next line of data
			row = new StringTokenizer(reader.nextLine(), ",");

			id = Integer.parseInt(row.nextToken());
			AEWurl = row.nextToken();
			title = row.nextToken();
			image = row.nextToken();

			AEWArticles.add(new AEW(id, AEWurl, title, image));
			
                        
                   try{
                      
                       Connection connection = DriverManager.getConnection(url, username, password);
          
                       PreparedStatement ps = null;
                          
                    String query = "INSERT INTO wrestling.aew (ArticleID, title, img, AEWurl) "
                                   + "VALUES (?,?,?,?)";
                             
                     ps = connection.prepareStatement(query);
                     ps.setInt(1, id);
                     ps.setString(2, title);
                     ps.setString(3,image);
                     ps.setString(4, AEWurl);
        
                     ps.executeUpdate();
                        
		}catch (SQLException e) {
                      System.err.println("Execption in UpdateAEW method");
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
        

        public static void deleteAEWTables() {
      
        try{
        Connection connection = DriverManager.getConnection(url, username, password);
        
       
        String preparedSQL = "SELECT * FROM wrestling.aew";
        
        PreparedStatement statement = connection.prepareStatement(preparedSQL);
        
        ResultSet results = statement.executeQuery();
        
        int totalEntrys = 0;
        
          while (results.next())
          { 
              totalEntrys = totalEntrys + 1;
          }
       
          {
        
       for (int i = 0; i < 50; i++) {
        
            preparedSQL = "DELETE FROM wrestling.aew WHERE ArticleID = " + i;
        
            statement = connection.prepareStatement(preparedSQL);

            statement.executeUpdate();
       }
      }
        }catch (SQLException e) {
            System.err.println("Execption in deleteAEW method");
            System.err.println(e.getMessage());
        }
        
        
    }    
        
         public static ArrayList<AEW> getAEWData() throws IOException {
                ArrayList<AEW> aewList = new ArrayList<AEW>();
		
                try{
		Connection connection = DriverManager.getConnection(url, username, password);
                String preparedSQL = "SELECT * FROM wrestling.aew";
        
                PreparedStatement statement = connection.prepareStatement(preparedSQL);
        
                ResultSet aewResults = statement.executeQuery();

                    while(aewResults.next()){
               
                        AEW result =  new AEW();
                            int id = aewResults.getInt("ArticleID");
                            String title = aewResults.getString("title");
                            String img = aewResults.getString("img");
                            String AEWurl = aewResults.getString("AEWurl");
                            
                          
                            result.setId(id);
                            result.setImg(img);
                            result.setTitle(title);
                            result.setUrl(AEWurl);
                             
                             aewList.add(result);
                        
                    }
				
                        
                
				
         }catch (SQLException e) {
            System.err.println("Execption in getAEWData");
            System.err.println(e.getMessage());
        }
                 return aewList;
     }
        
        
    }
    
   

