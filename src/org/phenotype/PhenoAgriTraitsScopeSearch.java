package org.phenotype;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.db.phenoype_agri_traits.*;
import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PhenoAgriTraitsScopeSearch extends ActionSupport
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
		
		//System.out.println(scopephenotypicmenu+"    "+starttextfield+"     "+endtextfield);
		
		String path=getWebRoot();
		//System.out.println("path: "+path);
		String newpath=path+"file/phenotypicdata.txt";
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        
		try
		{
			  Map attibutes = ActionContext.getContext().getSession();
			  
			  ArrayList<PhenoypeAgriTraits> phenotypesofcrosses_list = new ArrayList<PhenoypeAgriTraits>();
			  String sql="SELECT * ";
			  if(starttextfield.equals("") && endtextfield.equals(""))
			  {
				  sql=sql+" FROM phenoype_agri_traits";
			  }
			  else if(starttextfield.equals("") || endtextfield.equals(""))
			  {
				  if(starttextfield.equals(""))
				  {
					  sql=sql+" FROM phenoype_agri_traits"+" where "+scopephenotypicmenu+" = '"+endtextfield+"'";
				  }
				  else if(endtextfield.equals(""))
				  {
					  sql=sql+" FROM phenoype_agri_traits"+" where "+scopephenotypicmenu+" = '"+starttextfield+"'";
				  }
				  
			  }
			  else if(!starttextfield.equals("") && !endtextfield.equals(""))
			  {
				  sql=sql+" FROM phenoype_agri_traits"+" where "+scopephenotypicmenu+" between "+starttextfield+" and "+endtextfield;
			  }
			  
			  sql=sql+";";
			  //System.out.println(sql);
 
			  rs = db.executeQuery(sql);
			  
			  out.write("Trait	grainyield	earlength	kernelweight	rownumber");
			  out.newLine();
			      
		      while (rs.next()) 
			  { 
		    	  PhenoypeAgriTraits phenotypesofrialscrosses = new PhenoypeAgriTraits();
				    phenotypesofrialscrosses.setTrait(rs.getString(1));
				    phenotypesofrialscrosses.setPlantheight(rs.getDouble(PhenoypeAgriTraitsDAO.PLANTHEIGHT));
				    phenotypesofrialscrosses.setEarheight(rs.getDouble(PhenoypeAgriTraitsDAO.EARHEIGHT));
				    phenotypesofrialscrosses.setEarleafwidth(rs.getDouble(PhenoypeAgriTraitsDAO.EARLEAFWIDTH));
				    phenotypesofrialscrosses.setEarleaflength(rs.getDouble(PhenoypeAgriTraitsDAO.EARLEAFLENGTH));
				    
				    phenotypesofrialscrosses.setTasselmainaxislength(rs.getDouble(PhenoypeAgriTraitsDAO.TASSELMAINAXISLENGTH));
				    phenotypesofrialscrosses.setTasselbranchnumber(rs.getDouble(PhenoypeAgriTraitsDAO.TASSELBRANCHNUMBER));
				    phenotypesofrialscrosses.setLeafnumberaboveear(rs.getDouble(PhenoypeAgriTraitsDAO.LEAFNUMBERABOVEEAR));
				    phenotypesofrialscrosses.setEarlength(rs.getDouble(PhenoypeAgriTraitsDAO.EARLENGTH));
				    phenotypesofrialscrosses.setEardiameter(rs.getDouble(PhenoypeAgriTraitsDAO.EARDIAMETER));
				    
				    phenotypesofrialscrosses.setCobdiameter(rs.getDouble(PhenoypeAgriTraitsDAO.EARLEAFLENGTH));
				    phenotypesofrialscrosses.setEarrownumber(rs.getDouble(PhenoypeAgriTraitsDAO.EARROWNUMBER));
				    phenotypesofrialscrosses.setKernernumberperrow(rs.getDouble(PhenoypeAgriTraitsDAO.KERNERNUMBERPERROW));
				    phenotypesofrialscrosses.setGrainweight(rs.getDouble(PhenoypeAgriTraitsDAO.GRAINWEIGHT));
				    phenotypesofrialscrosses.setCobweight(rs.getDouble(PhenoypeAgriTraitsDAO.COBWEIGHT));
				    
				    phenotypesofrialscrosses.setKernellength(rs.getDouble(PhenoypeAgriTraitsDAO.KERNELLENGTH));
				    phenotypesofrialscrosses.setKernelwidth(rs.getDouble(PhenoypeAgriTraitsDAO.KERNELWIDTH));
				    phenotypesofrialscrosses.setKernelthickness(rs.getDouble(PhenoypeAgriTraitsDAO.KERNELTHICKNESS));
				    phenotypesofrialscrosses.setSilkingtime(rs.getDouble(PhenoypeAgriTraitsDAO.SILKINGTIME));
				    phenotypesofrialscrosses.setPollenshed(rs.getDouble(PhenoypeAgriTraitsDAO.POLLENSHED));
				    
				    phenotypesofrialscrosses.setHeadingdate(rs.getDouble(PhenoypeAgriTraitsDAO.HEADINGDATE));
				    phenotypesofrialscrosses.setCobcolor(rs.getString(PhenoypeAgriTraitsDAO.COBCOLOR));
					
				    phenotypesofcrosses_list.add(phenotypesofrialscrosses);
				    
				    out.write(rs.getString(1)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.PLANTHEIGHT)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARHEIGHT)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARLEAFWIDTH)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARLEAFLENGTH)+"	"
				    		+rs.getDouble(PhenoypeAgriTraitsDAO.TASSELMAINAXISLENGTH)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.TASSELBRANCHNUMBER)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.LEAFNUMBERABOVEEAR)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARLENGTH)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARDIAMETER)+"	"
				    		+rs.getDouble(PhenoypeAgriTraitsDAO.EARLEAFLENGTH)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARROWNUMBER)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.KERNERNUMBERPERROW)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.GRAINWEIGHT)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.COBWEIGHT)+"	"
				    		+rs.getDouble(PhenoypeAgriTraitsDAO.KERNELLENGTH)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.KERNELWIDTH)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.KERNELTHICKNESS)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.SILKINGTIME)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.POLLENSHED)+"	"
				    		+rs.getDouble(PhenoypeAgriTraitsDAO.HEADINGDATE)+"	"+rs.getString(PhenoypeAgriTraitsDAO.COBCOLOR));
				    
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
