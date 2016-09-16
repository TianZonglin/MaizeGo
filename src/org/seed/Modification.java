package org.seed;

import org.apache.struts2.ServletActionContext;
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

import javax.servlet.http.HttpServletResponse;

public class Modification extends ActionSupport{
	
	
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
    	HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
    	String type=(String)attribute.get("userType");
    	String user=(String)attribute.get("user");
    	
    	DbBean db=new DbBean();
    	
    	String sql="select * from seed_modification ";
    	if(!type.equals("admin"))
    		sql+="where `user`='"+user+"';";
		String path=getWebRoot();

		String newpath=path+"file/modification.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        out.write("ID\tModification_No\tModification_name\tBefore_value\tAfter_value\tuser\tdate\tPopulation");
        out.newLine();

    	try{
    	ResultSet rs=db.executeQuery(sql);
    	ArrayList al=new ArrayList();
    	while(rs.next()){
    		for(int i=1;i<=8;i++){
    			
    		     al.add(rs.getString(i));
    		     out.write(rs.getString(i)+"\t");
    		}
    		out.newLine();
    	}
      	out.flush();
    	attribute.put("seed",al);
    	return SUCCESS;
    	}catch(Exception e){
    		return ERROR;
    	}

    	
    }

}
