package org.genotype;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.db.chr1_merged_all_snp.Chr1MergedAllSnp;
import org.db.phenotypes_294_rils_441_crosses.PhenotypesOf294Rils441Crosses;
import org.db.phenotypes_294_rils_441_crosses.PhenotypesOf294Rils441CrossesDAO;
import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GenotypicScopeSearch extends ActionSupport
{
	private String scopechromosomemenu="";
    private String scopegenotypicmenu="";
	private String starttextfield="";
	private String endtextfield="";

	
	public String getScopechromosomemenu() {
		return scopechromosomemenu;
	}

	public void setScopechromosomemenu(String scopechromosomemenu) {
		this.scopechromosomemenu = scopechromosomemenu;
	}
	
	public String getScopegenotypicmenu() {
		return scopegenotypicmenu;
	}

	public void setScopegenotypicmenu(String scopegenotypicmenu) {
		this.scopegenotypicmenu = scopegenotypicmenu;
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
		
		//System.out.println(scopegenotypicmenu+"    "+starttextfield+"     "+endtextfield);
		
		String path=getWebRoot();
		//System.out.println("path: "+path);
		String newpath=path+"file/genotypicdata.txt";
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        
		try
		{
			  Map attibutes = ActionContext.getContext().getSession();
			  
			  ArrayList<Chr1MergedAllSnp> genotypic_chr1_list = new ArrayList<Chr1MergedAllSnp>();
			  String sql="SELECT * ";
			  if(starttextfield.equals("") && endtextfield.equals(""))
			  {
				  sql=sql+" FROM chr1_merged_all_snp";
			  }
			  else if(starttextfield.equals("") || endtextfield.equals(""))
			  {
				  if(starttextfield.equals(""))
				  {
					  sql=sql+" FROM chr1_merged_all_snp"+" where "+scopegenotypicmenu+" = '"+endtextfield+"'";
				  }
				  else if(endtextfield.equals(""))
				  {
					  sql=sql+" FROM chr1_merged_all_snp"+" where "+scopegenotypicmenu+" = '"+starttextfield+"'";
				  }
				  
			  }
			  else if(!starttextfield.equals("") && !endtextfield.equals(""))
			  {
				  
				  if(scopegenotypicmenu.equals("pos"))
				  {
					  int begin = Integer.parseInt(starttextfield); 
					  int end = Integer.parseInt(endtextfield);
					  
					  if(begin<=end)
					  {
						  sql=sql+" FROM chr1_merged_all_snp"+" where "+scopegenotypicmenu+" between '"+starttextfield+"' and '"+endtextfield+"'";
					  }
					  else
					  {
						  sql=sql+" FROM chr1_merged_all_snp"+" where "+scopegenotypicmenu+" between '"+endtextfield+"' and '"+starttextfield+"'";
					  }
				  }
				  else if(scopegenotypicmenu.equals("rs"))//���˳��ɸĽ�
				  {
					  sql=sql+" FROM chr1_merged_all_snp"+" where "+scopegenotypicmenu+" between '"+starttextfield+"' and '"+endtextfield+"'";
				  }
			  }
			  
			  sql=sql+";";
			  //System.out.println(sql);
 
			  rs = db.executeQuery(sql);
			  
			  out.write("rs	alleles	chrom	pos	strand");
			  out.newLine();
			      
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
			  
			  //System.out.println(genotypic_chr1_list.size());
			  out.flush();
			  
			  attibutes.put("genotypic_chr1_list", genotypic_chr1_list);
			    
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
