package org.seed;

import org.util.DbBean;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class SeedManage extends ActionSupport{
	private String population;
	
	
	
	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getWebRoot()
	 {
	     String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
	     if (path.indexOf("WEB-INF") > 0) 
	     {
	        path = path.substring(0, path.indexOf("WEB-INF/classes"));
	     } 
	     return path;
	}

    public String execute() throws Exception{
    	Map attribute=ActionContext.getContext().getSession();
    	DbBean db=new DbBean();
    	ArrayList<String> field=new ArrayList<String>();
    	String sql0="show fields from `"+population+"`;";
    	ResultSet rs0=db.executeQuery(sql0);
    	while(rs0.next()){
    		field.add(rs0.getString(1));
    		
    	}
    	String sql="select * from `"+population+"`;";
		String path=getWebRoot();

		String newpath=path+"file/seed_info.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        for(int i=0;i<field.size();i++)
        	out.write(field.get(i)+"\t");
        out.newLine();

    	try{
    	ResultSet rs=db.executeQuery(sql);
    	ArrayList al=new ArrayList();
    	while(rs.next()){
    		for(int i=1;i<=field.size();i++){
    			
    		     al.add(rs.getString(i));
    		     out.write(rs.getString(i)+"\t");
    		}
    		out.newLine();
    	}
      	out.flush();
      	attribute.put("table", population);
      	attribute.put("field", field);
    	attribute.put("seed",al);
    	return SUCCESS;
    	}catch(Exception e){
    		return ERROR;
    	}

    	
    }

}
