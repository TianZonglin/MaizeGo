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

public class Affiliation extends ActionSupport{
	
	
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
    	String sql="select * from affiliation_borrow";
		String path=getWebRoot();

		String newpath=path+"file/affiliation_borrow_info.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        out.write("Num\tDate\tName\tAffiliation\tPhone\tBorrowNum\tNote");
        out.newLine();

    	try{
    	ResultSet rs=db.executeQuery(sql);
    	ArrayList al=new ArrayList();
    	while(rs.next()){
    		for(int i=1;i<=7;i++){
    			
    		     al.add(rs.getString(i));
    		     out.write(rs.getString(i)+"\t");
    		}
    		out.newLine();
    	}
      	out.flush();
    	attribute.put("affiliation",al);
    	return SUCCESS;
    	}catch(Exception e){
    		return ERROR;
    	}

    	
    }

}
