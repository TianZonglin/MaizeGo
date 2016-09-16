package ort.test;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
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
public class advance2 extends ActionSupport{
	private String germplasmname="";
	private String sel="";
	private String exp="";
	private String ecp="";
	private String cel="";
	private String exp1="";
	private String sel1="";
	private String ecp1="";
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
    public String getExp1()
    {
    	return exp1;
    }
    public void setExp1(String exp1)
    {
    	this.exp1=exp1;
    }
    public String getSel1()
    {
    	return sel1;
    }
    public void setSel1(String sel1)
    {
    	this.sel1=sel1;
    }
    public String getEcp1()
    {
    	return exp1;
    }
    public void setEcp1(String ecp1)
    {
    	this.ecp1=ecp1;
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
		ResultSet rrs = null;
		ResultSet rrrs =null;
		ResultSet rsnew=null;
		String path=getWebRoot();
		System.out.println("path: "+path);
		String newpath=path+"file/advance.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        System.out.println("1111111111");
        System.out.println(germplasmname);
        System.out.println(getGermplasmname());
        System.out.println(exp);
      
    
    	try
		{
			  Map attibutes = ActionContext.getContext().getSession();
			 
		      String sql="SELECT ";
		      String sq="SELECT ";
		      String sqlnew="SELECT ";
		      String selectresult="";
		      String selectResult="";
		      String selectresult1="";
		      String selectResult1="";
		 	  String val = "maize_";
			  String value = "";
	    	  String sqlpos="SELECT ";
	    	  
	          System.out.println(upload);
	    	  //�����
//	    	  FileReader fr = null; 
//	    	  //aaaaaaaaaaaaa 
//	    	  
//	    
//	    	  
//	    	  
//	    	  fr = new FileReader(upload);
//	          int c = 0;
//	          while ((c = fr.read()) != -1) {
//	            
//	            System.out.print((char)c);
//	        
//	          }
//	          
//	          fr.close();
	          
	          
	          
	          
	          
		      if(!sel.equals("choose")&&!exp.equals("")&&ecp.equals(""))
		      {
		    
		    	  for(int i=0;i<germplasmname.length();i++)
		    	  {
		    		  if(germplasmname.codePointAt(i)!=10&&germplasmname.codePointAt(i)!=13) {
		    			    value += germplasmname.charAt(i);
		    			   }
		    		  System.out.println(value+"111111111111111111");
		    	  if((germplasmname.codePointAt(i)==10||germplasmname.codePointAt(i)==13)&&!value.equals(""))
		    	  {
		    
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
				    	
				    	
				    	sqlnew=sqlnew+"value FROM trait_year_location where ";
		    	if(!year.equals("Search all year")&&location.equals("Search all location")&&trait.equals("Search all trait"))
				    	sqlnew=sqlnew+"year='"+year+"'";
		    	
		      	if(!year.equals("Search all year")&&(!location.equals("Search all location")||!trait.equals("Search all trait")))
		      		sqlnew=sqlnew+"year='"+year+"' and ";
		      	
		    	if(!location.equals("Search all location")&&!trait.equals("Search all trait"))
		    			sqlnew=sqlnew+"location='"+location+"' and ";
		    	if(!location.equals("Search all location")&&trait.equals("Search all trait"))
		    		    sqlnew=sqlnew+"location='"+location+"'";
		    	if(!trait.equals("Search all trait"))
		    		sqlnew=sqlnew+"trait='"+trait+"'";
		  	
		  	  
		
				    	if(!year.equals("Search all year")||!location.equals("Search all location")||!trait.equals("Search all trait"))
				    	{
				    		
				    		
				    	   	sqlnew=sqlnew+" and material='"+value+"';";
				    		  System.out.println(sqlnew);
				    		  ArrayList listnew = new ArrayList();
				    		  System.out.println(sqlnew);
				    		  rsnew = db.executeQuery(sqlnew);
				    		  System.out.println(sqlnew);
				    		  while(rsnew.next())
				    		  {
				    			  listnew.add(rsnew.getString("value")); 
				    		  }
				    		  out.write("value: "+listnew);
						      out.newLine();
				    	}
			
				    	
				    	
				    	
				    	
				    	
				    	
				    	
				    	
				    	
				  sql=sql+""+value+" FROM "+getSel()+" where pos='"+exp+"';";
				  sq=sq+""+cel+" FROM phenoype_agri_traits where Trait='"+value+"';";
				  System.out.println(sql);
				  System.out.println(sq);
				  rs = db.executeQuery(sql);
				  out.write("pos: "+exp);
			      out.newLine();
			      
				  out.write("value: "+value);
			      out.newLine();
			      
			   
				  while (rs.next()) 
				  { 
					  selectresult=rs.getString(value);
				  }
				  out.write("selectresult: "+selectresult);
			      out.newLine();
				  rrs=db.executeQuery(sq);
				  while(rrs.next())
				  {
					  selectResult=rrs.getString(cel);
				  }
				   out.write(cel);
				     
				  out.write(": "+selectResult);
			      out.newLine();
			      System.out.println("22222222222aaaa");
			      out.flush();
			      attibutes.put("germplasmname",getGermplasmname());
			      attibutes.put("exp",getExp());
			      attibutes.put("selectresult",selectresult);
			      attibutes.put("selectResult",selectResult);
			      attibutes.put("cel",cel); 
			      value="";
			      sql="SELECT ";
			      sq="SELECT ";
			      sqlnew="SELECT ";
		    	  }
		    	  }
		      }
		      
		      
		      
		      
		      
		      if(!sel.equals("choose")&&exp.equals("")&&!ecp.equals(""))//�ж���Щ��ҳԪ�����������
		      {
		    	  
		    	  
		  
		    	  for(int i=0;i<germplasmname.length();i++)//�������germplasmname�е��������ȡ������ȥ��germplasmname�еĻس��Լ��ո�
		    	  {
		    		  if(germplasmname.codePointAt(i)!=10&&germplasmname.codePointAt(i)!=13) {
		    			    value += germplasmname.charAt(i);
		    			   }
		    		  System.out.println(value+"111111111111111111");
		    	  if((germplasmname.codePointAt(i)==10||germplasmname.codePointAt(i)==13)&&!value.equals(""))
		    	  {
		    		  
		    		  
		    	
				    	if(value.charAt(0)>47&&value.charAt(0)<58)			  //���maize_����	    
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
		    	
				  sql=sql+""+value+" FROM "+getSel()+" where pos ='"+ecp+"';";
				  sq=sq+""+cel+" FROM phenoype_agri_traits where Trait='"+value+"';";
				  System.out.println(sql);
				  System.out.println(sq);
				  System.out.println(germplasmname);
				  rs = db.executeQuery(sql);
				
				  System.out.println("aaaaaaaaaaa");
				  out.write("pos: "+ecp);
			      out.newLine();
			      
				  out.write("value: "+value);
			      out.newLine();
			      
			    
			      
			      System.out.println("22222222222aaaa");
				  while (rs.next()) 
				  { 
					  selectresult=rs.getString(value);
				  }
				  rrs=db.executeQuery(sq);
				  out.write("selectresult: "+selectresult);
			      out.newLine();
				  while(rrs.next())
				  {
					  selectResult=rrs.getString(cel);
				  }
				  out.write(cel);
				     
				  out.write(": "+selectResult);
			      out.newLine();
			      System.out.println("3333333333aaaaa");
			      out.flush();
			      attibutes.put("germplasmname",getGermplasmname());
			      attibutes.put("exp",getEcp());
			      attibutes.put("selectresult",selectresult);
			      attibutes.put("selectResult",selectResult);
			      attibutes.put("cel",cel); 
			      System.out.println("44444444444aaaaaa");
			      value="";
			      sql="SELECT ";
			      sq="SELECT ";
		    	  }
		    	  }
		      }
		      
		      
		      
		      
		      
		      if(!sel.equals("choose")&&!exp.equals("")&&!ecp.equals(""))
		      {
		    	  
		    	
	
		 
		    	  for(int i=0;i<germplasmname.length();i++)
		    	  {
		    		  if(germplasmname.codePointAt(i)!=10&&germplasmname.codePointAt(i)!=13) {
		    			    value += germplasmname.charAt(i);
		    			   }
		    		  System.out.println(value+"111111111111111111");
		    		  if((germplasmname.codePointAt(i)==10||germplasmname.codePointAt(i)==13)&&!value.equals(""))
		    	  {
		    			  
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
		    		  ArrayList list = new ArrayList();
			    	  ArrayList listpos = new ArrayList();
				  sql=sql+""+value+" FROM "+getSel()+" where pos between "+exp+" and "+ecp+";";
				  sqlpos=sqlpos+"pos FROM "+getSel()+" where pos between "+exp+" and "+ecp+";";
				  sq=sq+""+cel+" FROM phenoype_agri_traits where Trait='"+value+"';";
				  System.out.println(sql);
				  System.out.println(sq);
				  System.out.println(sqlpos);
				  rs = db.executeQuery(sql);
				
				  System.out.println("aaaaaaaaaaa123");
				  out.write("value: "+value);
			      out.newLine();
			    
			      
			      System.out.println("22222222222aaaa123");
				  while (rs.next()) 
				  { 
					  list.add(rs.getString(value));
				
				  }
					 out.write("selectresult: "+list);
				     out.newLine();
				  rrs=db.executeQuery(sq);
				  while(rrs.next())
				  {
					  selectResult=rrs.getString(cel);
				
			
					  
				  }
				  out.write(cel);
				     
				  out.write(": "+selectResult);
			      out.newLine();
				  rrrs=db.executeQuery(sqlpos);
				    System.out.println("3333333333aaaaa123");
				  while(rrrs.next())
				  {
					  listpos.add(rrrs.getString("pos"));
					
				  }
				
				  out.write("pos: "+listpos);
				     out.newLine();
					 
			      out.flush();
			      attibutes.put("germplasmname",getGermplasmname());
			      attibutes.put("exp",getEcp());
			      attibutes.put("list",list);
			      attibutes.put("selectResult",selectResult);
			      attibutes.put("cel",cel); 
			      attibutes.put("listpos",listpos);
			      System.out.println("44444444444aaaaaa123");
			      value="";
			      sql="SELECT ";
			      sq="SELECT ";
			      sqlpos="SELECT ";
		    	  }
		    	  }
		      }
		      
		      
		      
		      
		      
		      
		      if(!sel.equals("choose")&&exp.equals("")&&ecp.equals(""))
		      {
		 
		 
		    	  
		    	  for(int i=0;i<germplasmname.length();i++)
		    	  {
		    		  
		    		  if(germplasmname.codePointAt(i)!=10&&germplasmname.codePointAt(i)!=13) {
		    			    value += germplasmname.charAt(i);
		    			   }
		    		  System.out.println(value+"111111111111111111");
		    		  
		    		  if((germplasmname.codePointAt(i)==10||germplasmname.codePointAt(i)==13)&&!value.equals(""))
		    	  {
		    			  
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
		    	  ArrayList list = new ArrayList();
		    	  ArrayList listpos = new ArrayList();
		    	
				  sql=sql+""+value+" FROM "+getSel()+" ;";
				  sqlpos=sqlpos+"pos FROM "+getSel()+";";
				  sq=sq+""+cel+" FROM phenoype_agri_traits where Trait='"+value+"';";
				  System.out.println(sql);
				  System.out.println(sq);
				  System.out.println(germplasmname);
				  rs = db.executeQuery(sql);
				
				  System.out.println("aaaaaaaaaaa123");
				  out.write("value: "+value);
			      out.newLine();
			    
			      System.out.println("22222222222aaaa123");
				  while (rs.next()) 
				  { 
					  list.add(rs.getString(value));
				  }
				  out.write("selectresult: "+list);
			      out.newLine();
				  rrs=db.executeQuery(sq);
				  while(rrs.next())
				  {
					  selectResult=rrs.getString(cel);
				  }
				  out.write(cel);
				     
				  out.write(": "+selectResult);
			      out.newLine();
				  rrrs=db.executeQuery(sqlpos);
				    System.out.println("3333333333aaaaa123");
				  while(rrrs.next())
				  {
					  listpos.add(rrrs.getString("pos"));
				  }
				  out.write("pos: "+listpos);
			      out.newLine();
			      System.out.println("44444444aaaaa123");
			      out.flush();
			      attibutes.put("germplasmname",getGermplasmname());
			      attibutes.put("exp",getEcp());
			      attibutes.put("list",list);
			      attibutes.put("selectResult",selectResult);
			      attibutes.put("cel",cel); 
			      attibutes.put("listpos",listpos);
			      System.out.println("44444444444aaaaaa123");
			      value="";
			      sql="SELECT ";
			      sq="SELECT ";
			      sqlpos="SELECT ";
		    	  }
		    	  }
		      }
		      
		      
		      value="";
		      rs=null;
		      
		    
		      
		      if(!sel1.equals("choose")&&!exp1.equals("")&&ecp1.equals(""))
		      {
		    
		    	  for(int i=0;i<germplasmname.length();i++)
		    	  {
		    		  if(germplasmname.codePointAt(i)!=10&&germplasmname.codePointAt(i)!=13) {
		    			    value += germplasmname.charAt(i);
		    			   }
		    		  System.out.println(value+"111111111111111111");
		    	  if((germplasmname.codePointAt(i)==10||germplasmname.codePointAt(i)==13)&&!value.equals(""))
		    	  {
		    		  
		    		  
		    		  
		    		  
		    		  
		    		  
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
		    	
				  sql=sql+""+value+" FROM "+getSel1()+" where pos='"+exp1+"';";
				  sq=sq+""+cel+" FROM phenoype_agri_traits where Trait='"+value+"';";
				  System.out.println(sql);
				  System.out.println(sq);
			      System.out.println("123112311111111111111111111");
				  rs = db.executeQuery(sql);
				  System.out.println("123112311111111111111111111");
				  out.write("pos: "+exp1);
			      out.newLine();
			      
				  out.write("value: "+value);
			      out.newLine();
			      System.out.println("123112311");
			      out.write("cel: "+cel);
			      out.newLine();
				  while (rs.next()) 
				  { 
					  selectresult=rs.getString(value);
				  }
				  out.write("selectresult: "+selectresult);
			      out.newLine();
				  rrs=db.executeQuery(sq);
				  while(rrs.next())
				  {
					  selectResult=rrs.getString(cel);
				  }
				  out.write("selectResult: "+selectResult);
			      out.newLine();
			      System.out.println("22222222222aaaa");
			      out.flush();
			      attibutes.put("germplasmname",getGermplasmname());
			      attibutes.put("exp",getExp());
			      attibutes.put("selectresult",selectresult);
			      attibutes.put("selectResult",selectResult);
			      attibutes.put("cel",cel); 
			      value="";
			      sql="SELECT ";
			      sq="SELECT ";
		    	  }
		    	  }
		      }
		      
		      
		      
		      
		      
		      if(!sel1.equals("choose")&&exp1.equals("")&&!ecp1.equals(""))
		      {
		    	  
		    	  
		  
		    	  for(int i=0;i<germplasmname.length();i++)
		    	  {
		    		  if(germplasmname.codePointAt(i)!=10&&germplasmname.codePointAt(i)!=13) {
		    			    value += germplasmname.charAt(i);
		    			   }
		    		  System.out.println(value+"111111111111111111");
		    	  if((germplasmname.codePointAt(i)==10||germplasmname.codePointAt(i)==13)&&!value.equals(""))
		    	  {
		    		  
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
		    	
				  sql=sql+""+value+" FROM "+getSel1()+" where pos ='"+ecp1+"';";
				  sq=sq+""+cel+" FROM phenoype_agri_traits where Trait='"+value+"';";
				  System.out.println(sql);
				  System.out.println(sq);
				  System.out.println(germplasmname);
				  rs = db.executeQuery(sql);
				
				  System.out.println("aaaaaaaaaaa");
				  out.write("pos: "+ecp1);
			      out.newLine();
			      
				  out.write("value: "+value);
			      out.newLine();
			      
			      out.write("cel: "+cel);
			      out.newLine();
			      
			      System.out.println("22222222222aaaa");
				  while (rs.next()) 
				  { 
					  selectresult=rs.getString(value);
				  }
				  rrs=db.executeQuery(sq);
				  out.write("selectresult: "+selectresult);
			      out.newLine();
				  while(rrs.next())
				  {
					  selectResult=rrs.getString(cel);
				  }
				  out.write("selectResult: "+selectResult);
			      out.newLine();
			      System.out.println("3333333333aaaaa");
			      out.flush();
			      attibutes.put("germplasmname",getGermplasmname());
			      attibutes.put("exp",getEcp());
			      attibutes.put("selectresult",selectresult);
			      attibutes.put("selectResult",selectResult);
			      attibutes.put("cel",cel); 
			      System.out.println("44444444444aaaaaa");
			      value="";
			      sql="SELECT ";
			      sq="SELECT ";
		    	  }
		    	  }
		      }
		      
		      
		      
		      
		      
		      if(!sel1.equals("choose")&&!exp1.equals("")&&!ecp1.equals(""))
		      {
		    	  
		    	
	
		 
		    	  for(int i=0;i<germplasmname.length();i++)
		    	  {
		    		  if(germplasmname.codePointAt(i)!=10&&germplasmname.codePointAt(i)!=13) {
		    			    value += germplasmname.charAt(i);
		    			   }
		    		  System.out.println(value+"111111111111111111");
		    		  if((germplasmname.codePointAt(i)==10||germplasmname.codePointAt(i)==13)&&!value.equals(""))
		    	  {
		    			  
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
		    		  ArrayList list = new ArrayList();
			    	  ArrayList listpos = new ArrayList();
				  sql=sql+""+value+" FROM "+getSel1()+" where pos between "+exp1+" and "+ecp1+";";
				  sqlpos=sqlpos+"pos FROM "+getSel1()+" where pos between "+exp1+" and "+ecp1+";";
				  sq=sq+""+cel+" FROM phenoype_agri_traits where Trait='"+value+"';";
				  System.out.println(sql);
				  System.out.println(sq);
				  System.out.println(sqlpos);
				  rs = db.executeQuery(sql);
				
				  System.out.println("aaaaaaaaaaa123");
				  out.write("value: "+value);
			      out.newLine();
			      out.write("cel: "+cel);
			      out.newLine();
			      
			      System.out.println("22222222222aaaa123");
				  while (rs.next()) 
				  { 
					  list.add(rs.getString(value));
				
				  }
					 out.write("selectresult: "+list);
				     out.newLine();
				  rrs=db.executeQuery(sq);
				  while(rrs.next())
				  {
					  selectResult=rrs.getString(cel);
				
			
					  
				  }
				  out.write("selectResult: "+selectResult);
			      out.newLine();
				  rrrs=db.executeQuery(sqlpos);
				    System.out.println("3333333333aaaaa123");
				  while(rrrs.next())
				  {
					  listpos.add(rrrs.getString("pos"));
					
				  }
				
				  out.write("pos: "+listpos);
				     out.newLine();
					 
			      out.flush();
			      attibutes.put("germplasmname",getGermplasmname());
			      attibutes.put("exp",getEcp());
			      attibutes.put("list",list);
			      attibutes.put("selectResult",selectResult);
			      attibutes.put("cel",cel); 
			      attibutes.put("listpos",listpos);
			      System.out.println("44444444444aaaaaa123");
			      value="";
			      sql="SELECT ";
			      sq="SELECT ";
			      sqlpos="SELECT ";
		    	  }
		    	  }
		      }
		      
		      
		      
		      
		      
		      
		      if(!sel1.equals("choose")&&exp1.equals("")&&ecp1.equals(""))
		      {
		 
		 
		    	  
		    	  for(int i=0;i<germplasmname.length();i++)
		    	  {
		    		  
		    		  if(germplasmname.codePointAt(i)!=10&&germplasmname.codePointAt(i)!=13) {
		    			    value += germplasmname.charAt(i);
		    			   }
		    		  System.out.println(value+"111111111111111111");
		    		  
		    		  if((germplasmname.codePointAt(i)==10||germplasmname.codePointAt(i)==13)&&!value.equals(""))
		    	  {
		    			  
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
		    	  ArrayList list = new ArrayList();
		    	  ArrayList listpos = new ArrayList();
		    	
				  sql=sql+""+value+" FROM "+getSel1()+" ;";
				  sqlpos=sqlpos+"pos FROM "+getSel1()+";";
				  sq=sq+""+cel+" FROM phenoype_agri_traits where Trait='"+value+"';";
				  System.out.println(sql);
				  System.out.println(sq);
				  System.out.println(germplasmname);
				  rs = db.executeQuery(sql);
				
				  System.out.println("aaaaaaaaaaa123");
				  out.write("value: "+value);
			      out.newLine();
			      out.write("cel: "+cel);
			      out.newLine();
			      System.out.println("22222222222aaaa123");
				  while (rs.next()) 
				  { 
					  list.add(rs.getString(value));
				  }
				  out.write("selectresult: "+list);
			      out.newLine();
				  rrs=db.executeQuery(sq);
				  while(rrs.next())
				  {
					  selectResult=rrs.getString(cel);
				  }
				  out.write("selectResult: "+selectResult);
			      out.newLine();
				  rrrs=db.executeQuery(sqlpos);
				    System.out.println("3333333333aaaaa123");
				  while(rrrs.next())
				  {
					  listpos.add(rrrs.getString("pos"));
				  }
				  out.write("pos: "+listpos);
			      out.newLine();
			      System.out.println("44444444aaaaa123");
			      out.flush();
			      attibutes.put("germplasmname",getGermplasmname());
			      attibutes.put("exp",getEcp());
			      attibutes.put("list",list);
			      attibutes.put("selectResult",selectResult);
			      attibutes.put("cel",cel); 
			      attibutes.put("listpos",listpos);
			      System.out.println("44444444444aaaaaa123");
			      value="";
			      sql="SELECT ";
			      sq="SELECT ";
			      sqlpos="SELECT ";
		    	  }
		    	  }
		      }
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
		      
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
    
    

