package org.seedbatch;

import org.util.DbBean;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class Update2 extends ActionSupport{
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    @SuppressWarnings("unchecked")
	public String execute() throws Exception{
    	Map attribute=ActionContext.getContext().getSession();
    	String table=(String) attribute.get("table");
    	ArrayList<String> field=(ArrayList) attribute.get("field");
    	ArrayList<String>  name  =new ArrayList();
    	ArrayList<String>  namelist  =new ArrayList();
    	System.out.println("--------- update2.java ---------"+field);
    	DbBean db=new DbBean();
    	
    	/*for(int i=0;i<field.size();i++)
    	{
    		if(field.contains("NAME"))
    		{
    			name.add(field.get(i));
    		}
    	}
    	for(int i=0;i<name.size();i++)
    	{
    		String sql88 = "select "+name.get(i)+" from `"+table+";";
    		System.out.println("name "+name.get(i));
    		System.out.println("table "+table);
    		ResultSet rss=db.executeQuery(sql88);
    		 
    	
    	while(rss.next()){
    		for(int k=1;k<=field.size();k++)
    		name.add(rss.getString(k));
    	}
    	}
    	System.out.println("CCCCCCCCCC "+name);
    	*/
    	
    	
    	
    	System.out.println("------- update2.java ---------"+table);
     
    	try{
    
    	
    	
    	return SUCCESS;
    	}catch(Exception e){
    		return ERROR;
    	}

    	
    }

}
