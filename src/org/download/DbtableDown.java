package org.download;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.util.DbBean;

//import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DbtableDown extends ActionSupport
{
	 public String getWebRoot()
	 {
	     String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
	     if (path.indexOf("WEB-INF") > 0) 
	     {
	        path = path.substring(0, path.indexOf("WEB-INF/classes"));
	     } 
	     return path;
	}
	
	public String execute() throws Exception 
	{	
		DbBean db = new DbBean();
		ResultSet rs = null;
		
		String path=getWebRoot();

		System.out.println("path: "+path);
		String newpath=path+"file/dbtabledata.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        
		HttpServletRequest request = ServletActionContext.getRequest();
		String did=(String)request.getParameter("did");        
		  
		try
		{
			String sql="SELECT `Data`,`Filename`FROM download";//这里感觉应该是download
			sql=sql+" where `Data` = "+"'"+did+"'";
			sql=sql+";";
			  
			rs = db.executeQuery(sql);
			  
			while (rs.next()) 
			{ 
				Dbtable dbtablecrosses = new Dbtable();
				dbtablecrosses.setFilename(rs.getString(DbtableDAO.FILENAME));
				String filename=rs.getString(DbtableDAO.FILENAME);
				request.setAttribute("filename",filename);
			}
			  
			out.flush();	  
			  
			return SUCCESS;

	    }
		catch(Exception e)
		{
			e.printStackTrace();
			rs.close();
			System.err.println(e.toString());
			return ERROR;
		}
		finally 
		{
			//db.close();
		}
		
	}
}
