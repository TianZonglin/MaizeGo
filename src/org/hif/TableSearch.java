package org.hif;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.Map;

import org.db.phenoype_agri_traits.*;
import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TableSearch extends ActionSupport
{
	private String minpos1="";
	private String maxpos1="";
	private String population="";




	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getMinpos1() {
		
		return minpos1;
	}

	public void setMinpos1(String minpos1) {
		if(minpos1.equals("")){minpos1="0";}
		this.minpos1 = minpos1;
	}

	public String getMaxpos1() {
		return maxpos1;
	}

	public void setMaxpos1(String maxpos1) {
		if(maxpos1.equals("")){maxpos1="0";}
		this.maxpos1 = maxpos1;
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
	
	public String execute() throws Exception 
	{	
		DbBean db = new DbBean();
		ResultSet rs = null;	
		String path=getWebRoot();

		String newpath=path+"file/bbmapdata.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        out.write("ID\tname\tchr\tpos_new\tmaterial");
        out.newLine();
		
		
		try
		{
			
			  Map attibutes = ActionContext.getContext().getSession();
	
			 // System.out.println(population);
			  String sql="SELECT * FROM `"+population+"` WHERE `pos_New` BETWEEN ";
				  sql=sql+Integer.parseInt(minpos1)+" AND "+Integer.parseInt(maxpos1)+";" ;
			 
			  rs = db.executeQuery(sql);
		   
		    	 while(rs.next()){
		    		 for(int i=6;i<=rs.getMetaData().getColumnCount();i++){
		    			 if(rs.getInt(i)==3){		    	
		    				 out.write(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getMetaData().getColumnName(i));		
		    				 out.newLine();
		    			 }
		    			 
		    		 }
		    	 }
		    	 out.flush();		     		     		  		    		     		
			return SUCCESS;

	    }
		catch(Exception e)
		{
			//rs.close();
			System.err.println(e.toString());
			return ERROR;
		}
		finally 
		{
			//db.close();
		}
		
	}
}
