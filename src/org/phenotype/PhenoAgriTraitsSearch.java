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

public class PhenoAgriTraitsSearch extends ActionSupport
{
	private String phenotypeicmenu="";
	private String idmenu="";

	public String getPhenotypeicmenu() {
		return phenotypeicmenu;
	}

	public void setPhenotypeicmenu(String phenotypeicmenu) {
		this.phenotypeicmenu = phenotypeicmenu;
	}

	public String getIdmenu() {
		return idmenu;
	}

	public void setIdmenu(String idmenu) {
		this.idmenu = idmenu;
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

		System.out.println("path: "+path);
		String newpath=path+"file/phenotypicdata.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        
        //System.out.println(phenotypeicmenu+"       "+idmenu);
        
		try
		{
			  Map attibutes = ActionContext.getContext().getSession();
			  
			  ArrayList<PhenoypeAgriTraits> phenotypesofcrosses_list = new ArrayList<PhenoypeAgriTraits>();
			  double specificvalue=0.0;
			  String selectproperty="";
			  String sql="SELECT ";
			  if(phenotypeicmenu.equals("Search all types"))
			  {
				  sql=sql+"* FROM phenoype_agri_traits";
			  }
			  else
			  {
				  sql=sql+"Trait, "+phenotypeicmenu+" FROM phenoype_agri_traits";
			  }
			  
			  if(!idmenu.equals("Search all Trait"))
			  {
				  sql=sql+" where Trait = '"+idmenu+"'"; 
			  }
			  sql=sql+";";
			  //System.out.println(sql);
			  
			  rs = db.executeQuery(sql);
			  if(phenotypeicmenu.equals("Search all types"))
			  {
				  out.write("Trait	Plantheight	Earheight	Earleafwidth	Earleaflength	Tasselmainaxislength	Tasselbranchnumber	Leafnumberaboveear	Earlength	Eardiameter	Cobdiameter	Earrownumber	Kernernumberperrow	grainweight	cobweight	kernellength	Kernelwidth	Kernelthickness	Silkingtime	Pollenshed	Headingdate	cobcolor");
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
			  }
			  else if(!phenotypeicmenu.equals("Search all types") && idmenu.equals("Search all Trait"))
			  {
				  out.write("Trait	"+phenotypeicmenu);
			      out.newLine();
			      
				  while (rs.next()) 
				  { 
					    PhenoypeAgriTraits phenotypesofrialscrosses = new PhenoypeAgriTraits();
					    phenotypesofrialscrosses.setTrait(rs.getString(1));

					    if(phenotypeicmenu.equals("Plantheight"))
					    { 	
					    	phenotypesofrialscrosses.setPlantheight(rs.getDouble(PhenoypeAgriTraitsDAO.PLANTHEIGHT));
					    	out.write(rs.getString(1)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.PLANTHEIGHT));
					    }
					    else if(phenotypeicmenu.equals("Earheight"))
					    {
					    	phenotypesofrialscrosses.setEarlength(rs.getDouble(PhenoypeAgriTraitsDAO.EARHEIGHT));
					    	out.write(rs.getString(1)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARHEIGHT));
					    }
					    else if(phenotypeicmenu.equals("Earleafwidth"))
					    {
					    	phenotypesofrialscrosses.setEarleafwidth(rs.getDouble(PhenoypeAgriTraitsDAO.EARLEAFWIDTH));
					    	out.write(rs.getString(1)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARLEAFWIDTH));
					    }
					    else if(phenotypeicmenu.equals("Earleaflength"))
					    {
					    	phenotypesofrialscrosses.setEarleaflength(rs.getDouble(PhenoypeAgriTraitsDAO.EARLEAFLENGTH));
					    	out.write(rs.getString(1)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARLEAFLENGTH));
					    }
					    phenotypesofcrosses_list.add(phenotypesofrialscrosses);
					    
				        out.newLine();
					    
					    selectproperty=phenotypeicmenu;
				  }
			  }
			  else if(!phenotypeicmenu.equals("Search all types") && !idmenu.equals("Search all Trait")) 
			  {
				  out.write("Trait	"+phenotypeicmenu);
			      out.newLine();
			      
				  while (rs.next()) 
				  { 
					  specificvalue=rs.getDouble(phenotypeicmenu);
				  }
				  selectproperty=phenotypeicmenu;
				  
				  out.write(idmenu+"	"+specificvalue);
			      out.newLine();
			  }
			  
			  //System.out.println(phenotypesofcrosses_list.size());
			  out.flush();
			  
			  attibutes.put("phenotypesofcrosses_list", phenotypesofcrosses_list);
			  attibutes.put("specificvalue", specificvalue);
			  attibutes.put("selectproperty", selectproperty);
			  
			  attibutes.put("phenotypeicmenu", phenotypeicmenu);
			  attibutes.put("idmenu", idmenu);	  
			  
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
