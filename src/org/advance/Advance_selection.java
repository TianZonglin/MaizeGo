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
public class Advance_selection extends ActionSupport{
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
		String newpath=path+"file/advance.txt";
		
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
				
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);      
      
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
	          
//	          String [] input=new String [2];
//	          input[0]="CML432";
//	          input[1]="1323";
	          
	          for(int i=0;i<input.length;i++)
	    	  {
	        	    System.out.println("i= "+i);
	        	    //���list
	        	    listnew.clear();
	  			    yearlist.clear();
				    locationlist.clear();
				    traitlist.clear();
	        	    //���maize_����  
	        	    out.write("The information of "+input[i]+ ":");
			        out.newLine();
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
		    		System.out.println(listnew);
		    		out.write("year_location_trait information: ");
					out.newLine();
					/*
					if(!year.equals("Search all year"))    out.write("year: "+year+"    ");
					if(!location.equals("Search all location"))    out.write("location: "+location+"    ");
					if(!trait.equals("Search all trait"))    out.write("trait: "+trait);
					out.newLine();					
		    		out.write("    "+listnew);*/
					out.write("material\tyear\tlocation\ttrait\tvalue");
					out.newLine();
					for(int t=0;t<listnew.size();t++){
						out.write(input[i]+"\t"+yearlist.get(t)+"\t"+locationlist.get(t)+"\t"+traitlist.get(t)+"\t"+listnew.get(t)+"\t");	
						out.newLine();
					}
					
				    //out.newLine();
	        	    
	        	    
                    //Genotype
				    out.write("Genotype: ");
				    out.newLine();
				    
				    if(acolumns_chr1.contains(value))         //�ж���ѡ������chr1_merged_all_anp�Ƿ����
				    {
				    	System.out.println("*********************************************");
	        	    	listnew.clear();
	        	    	locationlist.clear();
	        	    	yearlist.clear();
	        	    	traitlist.clear();
		        	    if(!sel.equals("choose")) //��һ��
		        	    {

		        	    	  starttextfield=exp;
		        	    	  endtextfield=ecp;
		        	    	  sql_genotype="SELECT pos,"+value+" from "+sel;
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
								  listnew.add(rs_genotype.getString("pos"));
								 locationlist.add(rs_genotype.getString(value));
							
							  }					
		
							  //out.newLine();
		        	    }
		        	    
		        	    if(!sel2.equals("choose")) //�ڶ���
		        	    {
		        	    	  
		        	    	  starttextfield=exp2;
		        	    	  endtextfield=ecp2;
		        	    	  sql_genotype="SELECT pos,"+value+" from "+sel2;
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
								  yearlist.add(rs_genotype.getString("pos"));
								 traitlist.add(rs_genotype.getString(value));
							
							  }
							 // out.newLine();
		        	    }
		        	    
		        	    
		        	    
		        	    
		        	    
		        	    if(listnew.size()!=0&&yearlist.size()!=0)          //����ѡ���ѡ��
		        	    {		        	    	 	
			        	    String name1=sel.split("_")[0];
			        	    String name2=sel2.split("_")[0];		        	    		        	   		        	    
							  out.write("position_"+name1+"\tname_"+name1+"\tposition_"+name2+"\tname_"+name2);
							  out.newLine();
							  if(listnew.size()<yearlist.size())
							  {
								  for(int m=0;m<listnew.size();m++){
									  out.write(String.valueOf(listnew.get(m))+"\t");
									  out.write(String.valueOf(locationlist.get(m)+"\t"));
									  out.write(String.valueOf(yearlist.get(m))+"\t");
									  out.write(String.valueOf(traitlist.get(m)));								  
									  out.newLine();
									  }
								  for(int m=listnew.size();m<yearlist.size();m++){
									  out.write(""+"\t");
									  out.write(String.valueOf(""+"\t"));
									  out.write(String.valueOf(yearlist.get(m))+"\t");
									  out.write(String.valueOf(traitlist.get(m)));								  
									  out.newLine();									  
									  
								  }  
							  }
							  else
							  {
								  for(int m=0;m<yearlist.size();m++){
									  out.write(String.valueOf(listnew.get(m))+"\t");
									  out.write(String.valueOf(locationlist.get(m)+"\t"));
									  out.write(String.valueOf(yearlist.get(m))+"\t");
									  out.write(String.valueOf(traitlist.get(m)));								  
									  out.newLine();
									  }
								  for(int m=yearlist.size();m<listnew.size();m++){
									  out.write(String.valueOf(listnew.get(m))+"\t");
									  out.write(String.valueOf(locationlist.get(m)+"\t"));							  
									  out.newLine();								  
									  
								  }  								  
								  
							  }
		        	    }else if(listnew.size()!=0)		           //ֻ�е�һ��ѡ�ѡ��
			        	    {
			        	    String name1=sel.split("_")[0];	        	    		        	   		        	    
							  out.write("position_"+name1+"\tname_"+name1);
							  out.newLine();
								  for(int m=0;m<listnew.size();m++){
									  out.write(String.valueOf(listnew.get(m))+"\t");
									  out.write(String.valueOf(locationlist.get(m)+"\t"));							  
									  out.newLine();
									  }

							  }else if(yearlist.size()!=0){	             //ֻ�еڶ���ѡ�ѡ��
				        	     String name2=sel2.split("_")[0];		        	    		        	   		        	    
								  out.write("position_"+name2+"\tname_"+name2);
								  out.newLine();
									  for(int m=0;m<yearlist.size();m++){
										  out.write(String.valueOf(yearlist.get(m))+"\t");
										  out.write(String.valueOf(traitlist.get(m)));								  
										  out.newLine();
										  }
								  
							  }
				    }
		        	    //phenotype
		        	    if(!checkboxstr.equals(""))
		        	    {
		        	    	sql_phenotype="Select "+checkboxstr+" FROM phenoype_agri_traits where Trait='"+input[i]+"';";
							System.out.println(sql_phenotype);
							rs_phenotype = db.executeQuery(sql_phenotype);
							out.write("Phenotype: ");
						    out.newLine();
						    
							while (rs_phenotype.next()) 
							{ 
								 out.write("material\t");
								  for(int n=0;n<checkboxlist.size();n++)
								  {
									  out.write(checkboxlist.get(n)+"\t");
								  }
								  out.newLine();
								  out.write(input[i]);
								  for(int n=0;n<checkboxlist.size();n++)
								  {
									  out.write("\t"+rs_phenotype.getString(checkboxlist.get(n).toString()));								
								  }	
								  out.newLine();
							}
							//out.write("");
							//out.newLine();
	
		        	    }
		        	    
		    	  }
	         
	         
	          out.flush();
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
	          
	         