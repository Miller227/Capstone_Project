/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;
import java.io.Serializable;
/**
 *
 * @author Parker
 */
public class WT implements Serializable {
  
    private int id;
    private String title;
    private String img;
    private String url;
    
    public WT(){
      id = 0;
      title = "t";
      img = "t";
      url = "t";
      
    }
    
    public WT(int id, String url, String title, String img){
      this.id = 0;
      this.title = "t";
      this.img = "t";
      this.url = "t";
      
    }
    
      public int getId() {
        return id;
    }
    
      public String getTitle(){
       return title;
    }
      
      public String getImg() {
       return img;
    }
    
      public String getUrl() {
       return url;
    }
      
      public void setId(int id) {
        this.id = id;
        
        }
      public void setTitle(String title){
       this.title = title;
      }
      
      public void setImg(String img){
      this.img = img;
      }
      
      public void setUrl(String url){
      this.url = url;
      }
      
      
}
