package org.home;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
//import org.db.dbtable.*;
import org.home.*;
import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Homepaper extends ActionSupport
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
		DbBean db0 = new DbBean();
		ResultSet rs = null;
		ResultSet rs0 = null;
		String[] classnum=new String[200];
		
		String path=getWebRoot();

//		System.out.println("path: "+path);
		String newpath=path+"file/dbtabledata.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
       OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
              
		try
		{
			Map attibutes = ActionContext.getContext().getSession();
			  
			ArrayList<Dbtable> dbtablecrosses_list = new ArrayList<Dbtable>();
			ArrayList<Dbtable> whatclass_list = new ArrayList<Dbtable>();
			  
			String sql0="SELECT DISTINCT `Category` FROM paper";
			System.out.println(sql0);
			  
			rs0 = db0.executeQuery(sql0);

			while (rs0.next())
			{
				Dbtable whatclass = new Dbtable();
				whatclass.setCategory(rs0.getString(DbtableDAO.CATEGORY));
				whatclass_list.add(whatclass);
			}
			for(int i=0;i<whatclass_list.size();i++)
			{
			    String sql="SELECT `Data`,`Category`,`Description`,`UpdateTime`,`Filename`FROM paper";	  
			    sql=sql+" where `Category` = "+"'"+whatclass_list.get(i).getCategory()+"'";   
			    sql=sql+";";
			    System.out.println(sql);
			    System.out.println(sql);//���SQL���
			  
			    rs = db.executeQuery(sql);
			    
	  
				while (rs.next()) 
				{ 
					Dbtable dbtablecrosses = new Dbtable();
					    
					dbtablecrosses.setData(rs.getString(DbtableDAO.DATA));
					dbtablecrosses.setCategory(rs.getString(DbtableDAO.CATEGORY));
					dbtablecrosses.setDescription(rs.getString(DbtableDAO.DESCRIPTION));
					dbtablecrosses.setUpdatetime(rs.getString(DbtableDAO.UPDATETIME));
					dbtablecrosses.setFilename(rs.getString(DbtableDAO.FILENAME));
					    
					dbtablecrosses_list.add(dbtablecrosses);
					    
					out.write(rs.getString(DbtableDAO.DATA)+" "+rs.getString(DbtableDAO.CATEGORY)+" "+rs.getString(DbtableDAO.DESCRIPTION)+" "
							+rs.getString(DbtableDAO.UPDATETIME));
				    out.newLine();
			
				 }
				System.out.println(dbtablecrosses_list.size());
				classnum[i]=dbtablecrosses_list.size()+"";
			}
			  out.flush();
			  
			  attibutes.put("dbtablecrosses_list",dbtablecrosses_list);
			  HttpServletRequest request = ServletActionContext.getRequest();
			  //request.setAttribute("classnum",classnum);
			  attibutes.put("classnum",classnum);
			  attibutes.put("whatclass_list", whatclass_list);	  
			  
			return SUCCESS;

	    }
		catch(Exception e)
		{
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
