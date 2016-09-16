package org.download;

/**
 * Dbtable entity. @author MyEclipse Persistence Tools
 */

public class Dbtable  implements java.io.Serializable
{


    // Fields    

     private String data;
     private String category;
     private String description;
     private String updatetime;
     private String filename;
    // Constructors

    /** default constructor */
    public Dbtable() {
    }

    
    /** full constructor */
    public Dbtable(String category) {
        this.category = category;
    }

    // Property accessors

    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUpdatetime() {
        return this.updatetime;
    }
    
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
    
    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
}