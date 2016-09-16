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

public class PhenotypicSearch extends ActionSupport
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
		//"e:/123.txt"
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        
		try
		{
			  Map attibutes = ActionContext.getContext().getSession();
			  
			  ArrayList<PhenotypesOf294Rils441Crosses> phenotypesofcrosses_list = new ArrayList<PhenotypesOf294Rils441Crosses>();
			  double specificvalue=0.0;
			  String selectproperty="";
			  String sql="SELECT ";
			  if(phenotypeicmenu.equals("Search all types"))
			  {
				  sql=sql+"* FROM phenotypes_of_294_rils_441_crosses";
			  }
			  else
			  {
				  sql=sql+"ID, "+phenotypeicmenu+" FROM phenotypes_of_294_rils_441_crosses";
			  }
			  
			  if(!idmenu.equals("Search all ID"))
			  {
				  sql=sql+" where ID = '"+idmenu+"'"; 
			  }
			  sql=sql+";";
			  //System.out.println(sql);
			  
			  //String sql="SELECT * FROM phenotypes _of_ 294_ rils_441_crosses where Experiment_1 like '"+getName()+"%'"; 
			  rs = db.executeQuery(sql);
			  if(phenotypeicmenu.equals("Search all types"))
			  {
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
			  }
			  else if(!phenotypeicmenu.equals("Search all types") && idmenu.equals("Search all ID"))
			  {
				  out.write("ID	"+phenotypeicmenu);
			      out.newLine();
			      
				  while (rs.next()) 
				  { 
					    PhenotypesOf294Rils441Crosses phenotypesofrialscrosses = new PhenotypesOf294Rils441Crosses();
					    phenotypesofrialscrosses.setId(rs.getString(1));

					    if(phenotypeicmenu.equals("grainyield"))
					    { 	
					    	phenotypesofrialscrosses.setGrainyield(rs.getDouble(PhenotypesOf294Rils441CrossesDAO.GRAINYIELD));
					    	out.write(rs.getString(1)+"	"+rs.getDouble(PhenotypesOf294Rils441CrossesDAO.GRAINYIELD));
					    }
					    else if(phenotypeicmenu.equals("earlength"))
					    {
					    	phenotypesofrialscrosses.setEarlength(rs.getDouble(PhenotypesOf294Rils441CrossesDAO.EARLENGTH));
					    	out.write(rs.getString(1)+"	"+rs.getDouble(PhenotypesOf294Rils441CrossesDAO.EARLENGTH));
					    }
					    else if(phenotypeicmenu.equals("kernelweight"))
					    {
					    	phenotypesofrialscrosses.setKernelweight(rs.getDouble(PhenotypesOf294Rils441CrossesDAO.KERNELWEIGHT));
					    	out.write(rs.getString(1)+"	"+rs.getDouble(PhenotypesOf294Rils441CrossesDAO.KERNELWEIGHT));
					    }
					    else if(phenotypeicmenu.equals("rownumber"))
					    {
					    	phenotypesofrialscrosses.setRownumber(rs.getDouble(PhenotypesOf294Rils441CrossesDAO.ROWNUMBER));
					    	out.write(rs.getString(1)+"	"+rs.getDouble(PhenotypesOf294Rils441CrossesDAO.ROWNUMBER));
					    }
					    phenotypesofcrosses_list.add(phenotypesofrialscrosses);
					    
				        out.newLine();
					    
					    selectproperty=phenotypeicmenu;
				  }
			  }
			  else if(!phenotypeicmenu.equals("Search all types") && !idmenu.equals("Search all ID")) 
			  {
				  out.write("ID	"+phenotypeicmenu);
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
			    
			
			
//            List<PhenotypesOf294Rils441Crosses> phenotypesrlist = new ArrayList<PhenotypesOf294Rils441Crosses>();					
//			
//			
//				PhenotypesOf294Rils441CrossesDAO dao = new PhenotypesOf294Rils441CrossesDAO();
//				phenotypesrlist=dao.findAll();
//
//			if(phenotypesrlist==null)
//			{
//				System.out.println("11111111111111111111:   ");
//			}
//			else
//			{
//				System.out.println("222222222222222222222222222:   ");
//			}
		
//			Map attibutes = ActionContext.getContext().getSession();
//			String tablename = (String) attibutes.get("name");
//			ArrayList<MetabolicTraitsZy> metabolictraintszy_list = new ArrayList<MetabolicTraitsZy>();
////			String sql = "select * from " + TABLE_NAME 
////			+ " where " + FIELD_ARRIVAL_ID + " = '" + freightArrivalId + "'";
//			String sql="SELECT * FROM metabolic_traits_zy where Experiment_1 like '"+getName()+"%'"; 
//			rs = db.executeQuery(sql);
//				
//			while (rs.next()) 
//			{ 
//				MetabolicTraitsZy metabolictraintszy = new MetabolicTraitsZy();
//				metabolictraintszy.setExperiment1(rs.getString(1));
//				metabolictraintszy.setN0001(rs.getInt(MetabolicTraitsZyDAO.N0001));
//				metabolictraintszy.setN0002(rs.getInt(MetabolicTraitsZyDAO.N0002));
//				metabolictraintszy.setN0004(rs.getInt(MetabolicTraitsZyDAO.N0004));
//				metabolictraintszy.setN0005(rs.getInt(MetabolicTraitsZyDAO.N0005));
//				metabolictraintszy.setN0006(rs.getInt(MetabolicTraitsZyDAO.N0006));
//				
//				metabolictraintszy_list.add(metabolictraintszy);
//				
////			    str_cname_1=rs.getString("n0658");
////				str_cname_2=rs.getString("N0001");
////			    System.out.println(str_cname_1+"       "+str_cname_2);
//			}//while
//			
//			for(int i=0;i<metabolictraintszy_list.size();i++)
//			{
//				System.out.println(metabolictraintszy_list.get(i).getExperiment1()+"     "+metabolictraintszy_list.get(i).getN0001()+"       "+metabolictraintszy_list.get(i).getN0002()+"       "+metabolictraintszy_list.get(i).getN0004()+"       "+metabolictraintszy_list.get(i).getN0005());
//			}	


			  
			  
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
