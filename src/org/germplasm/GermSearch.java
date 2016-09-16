package org.germplasm;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.db.germplasmlines.*;
import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GermSearch extends ActionSupport
{
	private String germtypeicmenu="";
	private String idmenu="";

	public String getGermtypeicmenu() {
		return germtypeicmenu;
	}

	public void setGermtypeicmenu(String germtypeicmenu) {
		this.germtypeicmenu = germtypeicmenu;
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
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception 
	{	
		System.out.println("222222222222222222222222222222222: ");
		DbBean db = new DbBean();
		ResultSet rs = null;
		
		String path=getWebRoot();

		System.out.println("path: "+path);
		String newpath=path+"file/germtypicdata.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        
        //System.out.println(germtypeicmenu+"       "+idmenu);
        
		try
		{
			  Map attibutes = ActionContext.getContext().getSession();
			  
			  ArrayList<Germplasmlines> germtypesofcrosses_list = new ArrayList<Germplasmlines>();
			  String specificvalue="";
			  String selectproperty="";
			  String sql="SELECT ";
			  if(germtypeicmenu.equals("Search all types"))
			  {
				  sql=sql+"* FROM germplasmlines";
			  }
			  else
			  {
				  sql=sql+"`Lines`,`"+germtypeicmenu+"` FROM germplasmlines";
			  }
			  
			  if(!idmenu.equals("Search all Lines"))
			  {
				  sql=sql+" where `Lines` = '"+idmenu+"'"; 
			  }
			  sql=sql+";";
			  System.out.println(sql);//���SQL���
			  
			  rs = db.executeQuery(sql);
			  if(germtypeicmenu.equals("Search all types"))
			  {
				  out.write("Lines	 SS	   NSS	 TST  Pedigree Origin Subpopulations");
			      out.newLine();
			      
				  while (rs.next()) 
				  { 
					    Germplasmlines germtypesofrialscrosses = new Germplasmlines();
					    germtypesofrialscrosses.setLines(rs.getString(1));
					    germtypesofrialscrosses.setSs(rs.getString(GermplasmlinesDAO.SS));
					    germtypesofrialscrosses.setNss(rs.getString(GermplasmlinesDAO.NSS));
					    germtypesofrialscrosses.setTst(rs.getString(GermplasmlinesDAO.TST));
					    germtypesofrialscrosses.setPedigree(rs.getString(GermplasmlinesDAO.PEDIGREE));
					    
					    germtypesofrialscrosses.setOrigin(rs.getString(GermplasmlinesDAO.ORIGIN));
					    germtypesofrialscrosses.setSubpopulations(rs.getString(GermplasmlinesDAO.SUBPOPULATIONS));
					 /* phenotypesofrialscrosses.setLeafnumberaboveear(rs.getDouble(PhenoypeAgriTraitsDAO.LEAFNUMBERABOVEEAR));
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
					    phenotypesofrialscrosses.setCobcolor(rs.getString(PhenoypeAgriTraitsDAO.COBCOLOR));*/
						
					    germtypesofcrosses_list.add(germtypesofrialscrosses);
					    
					    out.write(rs.getString(1)+"	"+rs.getString(GermplasmlinesDAO.SS)+"	"+rs.getString(GermplasmlinesDAO.NSS)+"	"+rs.getString(GermplasmlinesDAO.TST)+"	"+rs.getString(GermplasmlinesDAO.PEDIGREE)+"	"
					    		+rs.getString(GermplasmlinesDAO.ORIGIN)+"	"+rs.getString(GermplasmlinesDAO.SUBPOPULATIONS)+"	"//+rs.getDouble(PhenoypeAgriTraitsDAO.LEAFNUMBERABOVEEAR)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARLENGTH)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARDIAMETER)+"	"
					    		//+rs.getDouble(PhenoypeAgriTraitsDAO.EARLEAFLENGTH)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.EARROWNUMBER)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.KERNERNUMBERPERROW)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.GRAINWEIGHT)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.COBWEIGHT)+"	"
					    		//+rs.getDouble(PhenoypeAgriTraitsDAO.KERNELLENGTH)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.KERNELWIDTH)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.KERNELTHICKNESS)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.SILKINGTIME)+"	"+rs.getDouble(PhenoypeAgriTraitsDAO.POLLENSHED)+"	"
					    		//+rs.getDouble(PhenoypeAgriTraitsDAO.HEADINGDATE)+"	"+rs.getString(PhenoypeAgriTraitsDAO.COBCOLOR)
					    		); 
				        out.newLine();
					}//while
			  }
			  else if(!germtypeicmenu.equals("Search all types") && idmenu.equals("Search all Lines"))
			  {
				  out.write("Lines	"+germtypeicmenu);
			      out.newLine();
			      
				  while (rs.next()) 
				  { 
					    Germplasmlines germtypesofrialscrosses = new Germplasmlines();
					    germtypesofrialscrosses.setLines(rs.getString(1));

					    if(germtypeicmenu.equals("SS"))
					    { 	
					    	germtypesofrialscrosses.setSs(rs.getString(GermplasmlinesDAO.SS));
					    	out.write(rs.getString(1)+"	"+rs.getString(GermplasmlinesDAO.SS));
					    }
					    else if(germtypeicmenu.equals("NSS"))
					    {
					    	germtypesofrialscrosses.setNss(rs.getString(GermplasmlinesDAO.NSS));
					    	out.write(rs.getString(1)+"	"+rs.getString(GermplasmlinesDAO.NSS));
					    }
					    else if(germtypeicmenu.equals("TST"))
					    {
					    	germtypesofrialscrosses.setTst(rs.getString(GermplasmlinesDAO.TST));
					    	out.write(rs.getString(1)+"	"+rs.getString(GermplasmlinesDAO.TST));
					    }
					    else if(germtypeicmenu.equals("Pedigree"))
					    {
					    	germtypesofrialscrosses.setPedigree(rs.getString(GermplasmlinesDAO.PEDIGREE));
					    	out.write(rs.getString(1)+"	"+rs.getString(GermplasmlinesDAO.PEDIGREE));
					    }
					    else if(germtypeicmenu.equals("Origin"))
					    {
					    	germtypesofrialscrosses.setOrigin(rs.getString(GermplasmlinesDAO.ORIGIN));
					    	out.write(rs.getString(1)+"	"+rs.getString(GermplasmlinesDAO.ORIGIN));
					    }
					    else if(germtypeicmenu.equals("Subpopulations"))
					    {
					    	germtypesofrialscrosses.setSubpopulations(rs.getString(GermplasmlinesDAO.SUBPOPULATIONS));
					    	out.write(rs.getString(1)+"	"+rs.getString(GermplasmlinesDAO.SUBPOPULATIONS));
					    }
					    germtypesofcrosses_list.add(germtypesofrialscrosses);
					    
				        out.newLine();
					    
					    selectproperty=germtypeicmenu;
				  }
			  }
			  else if(!germtypeicmenu.equals("Search all types") && !idmenu.equals("Search all Lines")) 
			  {
				  out.write("Lines	"+germtypeicmenu);
			      out.newLine();
			      
				  while (rs.next()) 
				  { 
					  specificvalue=rs.getString(germtypeicmenu);
				  }
				  selectproperty=germtypeicmenu;
				  
				  out.write(idmenu+"	"+specificvalue);
			      out.newLine();
			  }
			  
			  System.out.println(germtypesofcrosses_list.size());
			  out.flush();
			  
			  attibutes.put("germtypesofcrosses_list", germtypesofcrosses_list);
			  attibutes.put("specificvalue",specificvalue);
			  attibutes.put("selectproperty",selectproperty);
			  
			  attibutes.put("germtypeicmenu", germtypeicmenu);
			  attibutes.put("idmenu", idmenu);	  
			  
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
