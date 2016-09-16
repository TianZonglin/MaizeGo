package org.seedbatch;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ShowUpload extends ActionSupport{
	private static String tablename;

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;	
	}
    
	
	 public String execute() throws Exception{
		 System.out.println("showwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
		 Map attribute=ActionContext.getContext().getSession();
		 String tablename=(String)attribute.get("tablename"); 
    	 DbBean db=new DbBean();
	    	ArrayList<String> field=new ArrayList<String>();
	    	String sql0="show fields from `"+tablename+"`;";
//	    	System.out.println(sql0);
	    	ResultSet rs0=db.executeQuery(sql0);
	    	while(rs0.next()){
	    		field.add(rs0.getString(1));    		
	    	}
	    	String sql="select * from `"+tablename+"`;";
	    	try{
	        	ResultSet rs=db.executeQuery(sql);
	        	ArrayList al=new ArrayList();
	        	while(rs.next()){
	        		for(int i=1;i<=field.size();i++){        			
	        		     al.add(rs.getString(i));
	        		}
	        	}
	          	attribute.put("field", field);
	        	attribute.put("seed",al);
	        	attribute.put("tablename",tablename);
	        	return SUCCESS;
	        	}catch(Exception e){
	        		return ERROR;
	        	}	 
	 }
}
