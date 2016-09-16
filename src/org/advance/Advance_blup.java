package org.advance;
import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.db.chr1_merged_all_snp.*;
import org.db.phenoype_agri_traits.PhenoypeAgriTraits;
import org.db.phenoype_agri_traits.PhenoypeAgriTraitsDAO;
import org.db.trait_year_location.*;
import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class Advance_blup extends ActionSupport{
	private String germplasmname="";//Input
	private String sel="";//select chro
	private String exp="";//start
	private String ecp="";//end
	
	private String cel="";//tree
	
	private String exp2="";
	private String sel2="";
	private String ecp2="";
	
	private String year="";
	private String location="";
	private String trait="";
	
	private String upload="";
	public String getGermplasmname()
	{
		return germplasmname;
	}
    public void setGermplasmname(String germplasmname)
    {
    	this.germplasmname=germplasmname;
    }
    public String getSel()
    {
    	return sel;
    }
    public void setSel(String sel)
    {
    	this.sel=sel;
    }
    public String getExp()
    {
    	return exp;
    }
    
    public void setExp(String exp)
    {
    	this.exp=exp;
    }
    public String getEcp()
    {
    	return exp;
    }
    
    public void setEcp(String ecp)
    {
    	this.ecp=ecp;
    }
    public void setCel(String cel)
    {
    	this.cel=cel;
    }
    public String getCel()
    {
    	return cel;
    }
    public String getExp2()
    {
    	return exp2;
    }
    public void setExp2(String exp2)
    {
    	this.exp2=exp2;
    }
    public String getSel2()
    {
    	return sel2;
    }
    public void setSel2(String sel2)
    {
    	this.sel2=sel2;
    }
    public String getEcp2()
    {
    	return exp2;
    }
    public void setEcp2(String ecp2)
    {
    	this.ecp2=ecp2;
    }
    
    public String getYear()
    {
    	return year;
    }
    public void setYear(String year)
    {
    	this.year=year;
    }
    
    public String getLocation()
    {
    	return location;
    }
    public void setLocation(String location)
    {
    	this.location=location;
    }
    
    
    public String getTrait()
    {
    	return trait;
    }
    public void setTrait(String trait)
    {
    	this.trait=trait;
    }
    public String getUpload()
    {
    	return upload;
    }
    public void setUpload(String upload)
    {
    	this.upload=upload;
    }
    
    
    private String[] checkbox = null;
	public String[] getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
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
		ResultSet rs_genotype = null;
		ResultSet rs_phenotype= null;
		ResultSet rs_year_location=null;
		String path=getWebRoot();
		System.out.println("path: "+path);
		String newpath=path+"file/Phenotypic.txt";
		String newpath1=path+"file/Genotypic.txt";
		
		String term=germplasmname;
		System.out.println("1: "+term);
		term=term.replace('\n', ',');
		System.out.println("2: "+term);
		term=term.replace('\t', ',');
		System.out.println("3: "+term);
		term=term.replace('\u0008', ',');
		System.out.println("4: "+term);
		term=term.replace('\r', ',');
		
        System.out.println("5: "+term);
        term=term.replace(' ', ',');
        System.out.println("5: "+term);
        
        ArrayList inputlist=new ArrayList();
		String[] data = term.split(",");
		for(int k=0;k<data.length;k++)
		{
			inputlist.add(data[k]);
		}
		if(inputlist.size()!=0)
 	    {
			while(inputlist.contains(""))
 	    	    inputlist.remove("");
 	    }
		
		String [] input=new String [inputlist.size()];
        System.out.println(inputlist.size());
		for(int k=0;k<inputlist.size();k++)
		{
		     input[k]=inputlist.get(k).toString();	  
		}
		System.out.println("++++++++++++++++++: ");
		for(int i=0;i<input.length;i++)
  	    {
			System.out.println(input[i]);
  	    }
				
		FileOutputStream fos = new FileOutputStream(newpath);                     //Phenotypic.txt
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);      
		FileOutputStream fos1 = new FileOutputStream(newpath1);                  //Genotypic.txt
        OutputStreamWriter osw1 = new OutputStreamWriter(fos1,"UTF-8");             
        BufferedWriter out1 = new BufferedWriter(osw1);      
    	try
		{
			  ArrayList listnew = new ArrayList();
			  ArrayList yearlist = new ArrayList();
			  ArrayList locationlist = new ArrayList();
			  ArrayList traitlist = new ArrayList();
			  
		      String sql_genotype="";
		      String sql_phenotype="";
		      String sql_year_location="";
		      String sql_columns_chr1="";

		 	  String val = "maize_";
			  String value = "";
	    	  
	    	  String starttextfield="";
	    	  String endtextfield="";
	    	  
	    	  //��ȡchr1_merged_all_anp�д��ڵĲ���
	    	  ResultSet columns_chr1=null;
	    	  sql_columns_chr1="DESCRIBE chr1_merged_all_snp;";
	    	  columns_chr1=db.executeQuery(sql_columns_chr1);
	    	  ArrayList acolumns_chr1=new ArrayList();
	    	  while(columns_chr1.next())
	    		  acolumns_chr1.add(columns_chr1.getString(1));
	    	  
	    	  
	    	  //System.out.println(germplasmname);
	          //System.out.println(upload);
	          
	          ArrayList checkboxlist=new ArrayList();
	          String checkboxstr="";
      	      if(this.checkbox!=null)
      	      {
		    	   for(int j=0;j<this.checkbox.length-1;j++)
		    	   {
		    		   checkboxlist.add(this.checkbox[j]);
//		    		   String[] data = this.checkbox[j].split("_");
//		    		   for(int k=0;k<data.length;k++)
//		    		   {
//		    			  System.out.print(data[k]+"  ");  
//		    		   }
		    	    }
      	      }
      	      if(checkboxlist.size()!=0)
      	      {
      	    	   if(checkboxlist.contains("Trait")) checkboxlist.remove("Trait");
      	    	   if(checkboxlist.contains("PhenotypeAgriTrait")) checkboxlist.remove("PhenotypeAgriTrait"); 
      	    	   
      	    	   for(int m=0;m<checkboxlist.size();m++)
     	    	   {
         	    	  checkboxstr+=checkboxlist.get(m)+",";
   		           }
         	      checkboxstr=checkboxstr.substring(0, checkboxstr.length()-1);
      	      }
      	      
      	      System.out.println(checkboxstr);
      	      System.out.println();
	          
	          
	          for(int i=0;i<input.length;i++)
	    	  {
	        	    //System.out.println("i= "+i);
	        	    //���list
	        	    listnew.clear();
	  			    yearlist.clear();
				    locationlist.clear();
				    traitlist.clear();
	        	    //���maize_����  
	        	    value=input[i];
	        	    if(value.charAt(0)>47&&value.charAt(0)<58)				    
			    	{
		    		    for(int t=0;t<value.length();t++)
			    	    {	
		    			   val+= value.charAt(t);
	    			    }				    		
		    		    value="";			    
	    			    for(int n=0;n<val.length();n++)
			    	    {
	    			       value+= val.charAt(n);
	    			    }
		    	    }
	        	    System.out.println(value);
	        	  
	    		    //year_location_trait
	        	    sql_year_location="SELECT ";
	        	    sql_year_location=sql_year_location+"value,year,location,trait FROM trait_year_location where material='"+input[i]+"'";
	        	    
			    	if(!year.equals("Search all year"))
				    	sql_year_location=sql_year_location+"and year='"+year+"'";
		    	
			      	if(!location.equals("Search all location"))
			      		sql_year_location=sql_year_location+" and location='"+location+"'";
			      	
			    	if(!trait.equals("Search all trait"))	
			    		sql_year_location=sql_year_location+" and trait='"+trait+"'";
	        	    
		    		System.out.println(sql_year_location);
		    		
		    		rs_year_location = db.executeQuery(sql_year_location);
		    		while(rs_year_location.next())
		    		{
		    			  listnew.add(rs_year_location.getString("value")); 
		    			  yearlist.add(rs_year_location.getString("year"));
		    			  locationlist.add(rs_year_location.getString("location"));
		    			  traitlist.add(rs_year_location.getString("trait"));
		    		}
		    		//System.out.println(listnew);
		    		//out.write("year_location_trait information: ");
					//out.newLine();
		    		if(i==0){
						out.write("material");
						//out.newLine();
						for(int t=0;t<listnew.size();t++){
							out.write("\t"+yearlist.get(t)+"-"+locationlist.get(t)+"-"+traitlist.get(t));	
							//out.newLine();
						}
		    		}
					out.newLine();
					out.write(input[i]);
					for(int t=0;t<listnew.size();t++){
						out.write("\t"+listnew.get(t));							
					}
					
				    //out.newLine();
                    //Genotype
				   // out1.write("Genotype: ");
				    //out1.newLine();
				   
				    
				    if(acolumns_chr1.contains(value))         //�ж���ѡ������chr1_merged_all_anp�Ƿ����
				    {
				    	System.out.println("*********************************************");
	        	    	listnew.clear();
	        	    	locationlist.clear();
	        	    	yearlist.clear();
	        	    	traitlist.clear();
	        	    	//out1.write("material:"+value);
	        	    	//out1.newLine();
	        	    	if(i==0){
	        	    	    out1.write("material\trs\talleles\tchrom\tpos\tstrand\tassembly\tcenter\tprotLSID\tassayLSID\tpaneLSID\tQCcode\tGenotypeValue");
		        	        out1.newLine();	        	    		
	        	    	}

	        	    	if(!sel.equals("choose")) 
		        	    {

		        	    	  starttextfield=exp;
		        	    	  endtextfield=ecp;
		        	    	  sql_genotype="SELECT rs,alleles,chrom,pos,strand,assembly,center,protLSID,assayLSID,paneLSID,QCcode,"+value+" from "+sel;
			      			  if(starttextfield.equals("") && endtextfield.equals(""))
			      			  {
			      				   sql_genotype=sql_genotype;
			      			  }
			      			  else if(starttextfield.equals("") || endtextfield.equals(""))
			      			  {
			      				  if(starttextfield.equals(""))
			      				  {
			      					sql_genotype=sql_genotype+" where pos = '"+endtextfield+"'";
			      				  }
			      				  else if(endtextfield.equals(""))
			      				  {
			      					sql_genotype=sql_genotype+" where pos = '"+starttextfield+"'";
			      				  }
			      				  
			      			  }
			      			  else if(!starttextfield.equals("") && !endtextfield.equals(""))
			      			  {  
			      				   sql_genotype=sql_genotype+" where pos between "+starttextfield+" and "+endtextfield;  
			      			  }
			      			  
			      			  sql_genotype=sql_genotype+";";
			      			  System.out.println(sql_genotype);
			       
			      			  rs_genotype = db.executeQuery(sql_genotype);
	
							  while (rs_genotype.next()) 
							  { 
								  out1.write(value+"\t");
								  for(int j=1;j<=12;j++)
									  out1.write(rs_genotype.getString(j)+"\t");
								  out1.newLine();
								      // listnew.add(rs_genotype.getString(j));
								 //locationlist.add(rs_genotype.getString(value));
							
							  }					
		
							  
		        	    }
		        	    
		        	    if(!sel2.equals("choose")) //�ڶ���
		        	    {
		        	    	  
		        	    	  starttextfield=exp2;
		        	    	  endtextfield=ecp2;
		        	    	  sql_genotype="SELECT rs,alleles,chrom,pos,strand,assembly,center,protLSID,assayLSID,paneLSID,QCcode,"+value+" from "+sel2;
			      			  if(starttextfield.equals("") && endtextfield.equals(""))
			      			  {
			      				   sql_genotype=sql_genotype;
			      			  }
			      			  else if(starttextfield.equals("") || endtextfield.equals(""))
			      			  {
			      				  if(starttextfield.equals(""))
			      				  {
			      					sql_genotype=sql_genotype+" where pos = '"+endtextfield+"'";
			      				  }
			      				  else if(endtextfield.equals(""))
			      				  {
			      					sql_genotype=sql_genotype+" where pos = '"+starttextfield+"'";
			      				  }
			      				  
			      			  }
			      			  else if(!starttextfield.equals("") && !endtextfield.equals(""))
			      			  {  
			      				   sql_genotype=sql_genotype+" where pos between "+starttextfield+" and "+endtextfield;  
			      			  }
			      			  
			      			  sql_genotype=sql_genotype+";";
			      			  System.out.println(sql_genotype);
			       
			      			  rs_genotype = db.executeQuery(sql_genotype);
	
							  while (rs_genotype.next()) 
							  { 
								  out1.write(value+"\t");
								  for(int j=1;j<=12;j++)
									  out1.write(rs_genotype.getString(j)+"\t");
								  out1.newLine();
									  //listnew.add(rs_genotype.getString(j));
								//traitlist.add(rs_genotype.getString(value));
							
							  }
							 // out.newLine();
		        	    }
		        	    

				    }
		        	    
		    	  }
	          out.close();
	          out1.close();
		      return SUCCESS;
		      
		}   
		catch(Exception e)
		{
			System.err.println(e.toString());
			return ERROR;
		}
		finally 
		{
		     //db.close();
		}
	}	
}     
	          
	         