package org.search;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.db.phenotypes_294_rils_441_crosses.PhenotypesOf294Rils441Crosses;
import org.db.phenotypes_294_rils_441_crosses.PhenotypesOf294Rils441CrossesDAO;
import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PhenotypicScopeSearch extends ActionSupport
{
	private String scopephenotypicmenu="";
	private String starttextfield="";
	private String endtextfield="";

	public String getScopephenotypicmenu() {
		return scopephenotypicmenu;
	}

	public void setScopephenotypicmenu(String scopephenotypicmenu) {
		this.scopephenotypicmenu = scopephenotypicmenu;
	}

	public String getStarttextfield() {
		return starttextfield;
	}

	public void setStarttextfield(String starttextfield) {
		this.starttextfield = starttextfield;
	}
	
	public String getEndtextfield() {
		return endtextfield;
	}

	public void setEndtextfield(String endtextfield) {
		this.endtextfield = endtextfield;
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
		
		System.out.println(scopephenotypicmenu+"    "+starttextfield+"     "+endtextfield);
		
		String path=getWebRoot();
		//System.out.println("path: "+path);
		String newpath=path+"file/phenotypicdata.txt";
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        
		try
		{
			  Map attibutes = ActionContext.getContext().getSession();
			  
			  ArrayList<PhenotypesOf294Rils441Crosses> phenotypesofcrosses_list = new ArrayList<PhenotypesOf294Rils441Crosses>();
			  String sql="SELECT * ";
			  if(starttextfield.equals("") && endtextfield.equals(""))
			  {
				  sql=sql+" FROM phenotypes_of_294_rils_441_crosses";
			  }
			  else if(starttextfield.equals("") || endtextfield.equals(""))
			  {
				  if(starttextfield.equals(""))
				  {
					  sql=sql+" FROM phenotypes_of_294_rils_441_crosses"+" where "+scopephenotypicmenu+" = '"+endtextfield+"'";
				  }
				  else if(endtextfield.equals(""))
				  {
					  sql=sql+" FROM phenotypes_of_294_rils_441_crosses"+" where "+scopephenotypicmenu+" = '"+starttextfield+"'";
				  }
				  
			  }
			  else if(!starttextfield.equals("") && !endtextfield.equals(""))
			  {
				  sql=sql+" FROM phenotypes_of_294_rils_441_crosses"+" where "+scopephenotypicmenu+" between "+starttextfield+" and "+endtextfield;
			  }
			  
			  sql=sql+";";
			  //System.out.println(sql);
 
			  rs = db.executeQuery(sql);
			  
			  out.write("ID	grainyield	earlength	kernelweight	rownumber");
			  out.newLine();
			      
		      while (rs.next()) 
			  { 
				  PhenotypesOf294Rils441Crosses phenotypesofrialscrosses = new PhenotypesOf294Rils441Crosses();
			      phenotypesofrialscrosses.setId(rs.getString(1));
			      phenotypesofrialscrosses.setGrainyield(rs.getDouble(PhenotypesOf294Rils441CrossesDAO.GRAINYIELD));
				  phenotypesofrialscrosses.setEarlength(rs.getDouble(PhenotypesOf294Rils441CrossesDAO.EARLENGTH));
			      phenotypesofrialscrosses.setKernelweight(rs.getDouble(PhenotypesOf294Rils441CrossesDAO.KERNELWEIGHT));
				  phenotypesofrialscrosses.setRownumber(rs.getDouble(PhenotypesOf294Rils441CrossesDAO.ROWNUMBER));
						
				  phenotypesofcrosses_list.add(phenotypesofrialscrosses);
					    
				  out.write(rs.getString(1)+"	"+rs.getDouble(PhenotypesOf294Rils441CrossesDAO.GRAINYIELD)+"	"+rs.getDouble(PhenotypesOf294Rils441CrossesDAO.EARLENGTH)+"	"+rs.getDouble(PhenotypesOf294Rils441CrossesDAO.KERNELWEIGHT)+"	"+rs.getDouble(PhenotypesOf294Rils441CrossesDAO.ROWNUMBER));
				  out.newLine();
			  }//while
			  
			  //System.out.println(phenotypesofcrosses_list.size());
			  out.flush();
			  
			  attibutes.put("phenotypesofcrosses_list", phenotypesofcrosses_list);
			    
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
