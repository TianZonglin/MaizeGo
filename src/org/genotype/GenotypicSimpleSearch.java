package org.genotype;

import org.hibernate.HibernateSessionFactory;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.db.chr1_merged_all_snp.Chr1MergedAllSnp;
import org.db.chr1_merged_all_snp.Chr1MergedAllSnpDAO;
import org.hibernate.Session;
import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GenotypicSimpleSearch extends ActionSupport
{
	private String chromosomemenu="";
	private String simplegenotypicmenu="";
	private String specificrs="";

	public String getChromosomemenu() {
		return chromosomemenu;
	}

	public void setChromosomemenu(String chromosomemenu) {
		this.chromosomemenu = chromosomemenu;
	}

	public String getSimplegenotypicmenu() {
		return simplegenotypicmenu;
	}

	public void setSimplegenotypicmenu(String simplegenotypicmenu) {
		this.simplegenotypicmenu = simplegenotypicmenu;
	}
	public String getSpecificrs() {
		return specificrs;
	}

	public void setSpecificrs(String specificrs) {
		this.specificrs = specificrs;
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
		
		//System.out.println(chromosomemenu+"      "+simplegenotypicmenu+"        "+specificrs);
		
		String path=getWebRoot();
		//System.out.println("path: "+path);
		String newpath=path+"file/genotypicdata.txt";

		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        
		try
		{
			  Map attibutes = ActionContext.getContext().getSession();
			  Session session=HibernateSessionFactory.getSession();
			  
			  
			  ArrayList<Chr1MergedAllSnp> genotypic_chr1_list = new ArrayList<Chr1MergedAllSnp>();
			  
			  String specificvalue="";
			  String selectproperty="";
			 String sql="SELECT ";
			  //String sql="";
			  if(simplegenotypicmenu.equals("Search all types"))
			  {
				  sql=sql+"* ";
			  }
			  else
			  {
				  sql=sql+"rs, "+simplegenotypicmenu;
			  }
			  
			  if(chromosomemenu.equals("chromosome_1"))
			  {
				  sql=sql+"from Chr1_Merged_All_Snp";
			  }
			  //else if
	  
			  if(!specificrs.equals(""))
			  {
				  sql=sql+" where rs = '"+specificrs+"'"; 
			  }
			  //sql=sql+";";
			  //System.out.println(sql);
			 // System.out.println("there");
			  //Query query=session.createQuery(sql);
			 // query.setFirstResult(1);
			  //query.setMaxResults(50);			  
			  

			 // rs=(ResultSet)query.uniqueResult();
			  //System.out.println("here");
			  
			  
		  
			  rs = db.executeQuery(sql);
			  
			  if(simplegenotypicmenu.equals("Search all types"))
			  {
				  
				  out.write("rs	alleles	chrom	pos	strand");
			      out.newLine();
			      if(chromosomemenu.equals("chromosome_1"))
				  {
			    	  while (rs.next()) 
					  {    
			    		    Chr1MergedAllSnp chr1mas = new Chr1MergedAllSnp();
			    		    chr1mas.setRs(rs.getString(1));
			    		    chr1mas.setAlleles(rs.getString(2));
			    		    chr1mas.setChrom(rs.getString(3));
			    		    chr1mas.setPos(rs.getString(4));
			    		    chr1mas.setStrand(rs.getString(5));

			    		    genotypic_chr1_list.add(chr1mas);
						    
						    out.write(rs.getString(1)+"	"+rs.getString(2)+"	"+rs.getString(3)+"	"+rs.getString(4)+"	"+rs.getString(5));
					        out.newLine();
						}//while
				  }
			      
			  } else if(!simplegenotypicmenu.equals("Search all types") && specificrs.equals(""))
			  {
				  out.write("rs	"+simplegenotypicmenu);
			      out.newLine();
			      
				  while (rs.next()) 
				  { 				  
					    Chr1MergedAllSnp chr1mergedsnp = new Chr1MergedAllSnp();
					    chr1mergedsnp.setRs(rs.getString(1));

					    if(simplegenotypicmenu.equals("alleles"))
					    { 	
					    	chr1mergedsnp.setAlleles(rs.getString(Chr1MergedAllSnpDAO.ALLELES));
					    	out.write(rs.getString(1)+"	"+rs.getString(Chr1MergedAllSnpDAO.ALLELES));
					    }
					    else if(simplegenotypicmenu.equals("chrom"))
					    {
					    	chr1mergedsnp.setChrom(rs.getString(Chr1MergedAllSnpDAO.CHROM));
					    	out.write(rs.getString(1)+"	"+rs.getString(Chr1MergedAllSnpDAO.CHROM));
					    }
					    else if(simplegenotypicmenu.equals("pos"))
					    {
					    	chr1mergedsnp.setPos(rs.getString(Chr1MergedAllSnpDAO.POS));
					    	out.write(rs.getString(1)+"	"+rs.getString(Chr1MergedAllSnpDAO.POS));
					    }
					    else if(simplegenotypicmenu.equals("strand"))
					    {
					    	chr1mergedsnp.setStrand(rs.getString(Chr1MergedAllSnpDAO.STRAND));
					    	out.write(rs.getString(1)+"	"+rs.getString(Chr1MergedAllSnpDAO.STRAND));
					    }
					    genotypic_chr1_list.add(chr1mergedsnp);
					    
				        out.newLine();
					    
					    selectproperty=simplegenotypicmenu;
				  }
			  }
			  else if(!simplegenotypicmenu.equals("Search all types") && !specificrs.equals("")) 
			  {
				  out.write("ID	"+simplegenotypicmenu);
			      out.newLine();
			      
				  while (rs.next()) 
				  { 
					  specificvalue=rs.getString(simplegenotypicmenu);
				  }
				  selectproperty=simplegenotypicmenu;
				  
				  out.write(specificrs+"	"+specificrs);
			      out.newLine();
			  }
			  
			  //System.out.println(genotypic_chr1_list.size());
			  out.flush();
			  
			  attibutes.put("genotypic_chr1_list", genotypic_chr1_list);
			  attibutes.put("specificvalue", specificvalue);
			  attibutes.put("selectproperty", selectproperty);
			  
			  attibutes.put("simplegenotypicmenu", simplegenotypicmenu);
			  attibutes.put("specificrs", specificrs);
		  
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
			db.close();
		}
		
	}
}
