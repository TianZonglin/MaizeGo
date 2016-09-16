package org.seedbatch;

//import org.email.Email;
import org.util.DbBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;




public class Update_result extends ActionSupport{
	//private static final String[] String = null;
	String piliang;

	public String getPiliang() {
		return piliang;
	}

	public void setPiliang(String piliang) {
		this.piliang = piliang;
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
	@SuppressWarnings({ "unchecked", "deprecation" })
	public String execute() throws Exception{
 
		
		//Email mail=new Email();
		int mark = 1;
    	Map attribute=ActionContext.getContext().getSession();
    	String table=(String) attribute.get("table");
    	ArrayList<String> field=(ArrayList)attribute.get("field");
    	System.out.println("-----update_result------"+field);
    	ArrayList<String> name_list = new ArrayList();
    	ArrayList<String> num_list = new ArrayList();
    	
    	ArrayList<String> result = new ArrayList();
    	DbBean db=new DbBean();
        System.out.println("SSSSSSSSSSSSSs  "+piliang+" "+field);
    	 
		String term=piliang;
		term=term.replace('\n', ',');
		System.out.println("2: "+term);
		term=term.replace('\t', ',');
		System.out.println("3: "+term);
		term=term.replace('\u0008', ',');
		System.out.println("4: "+term);
		term=term.replace('\r', ',');
		for(int g=0;g<10;g++)term=term.replace("  "," ");
        System.out.println("5: "+term);
        term=term.replace(' ', ',');
        for(int g=0;g<10;g++)term=term.replace(",,",",");
        System.out.println("6: "+term);
        

        String[] data = term.split(",");
		if(data.length%2 !=0){
			mark=0;
			attribute.put("mark", mark);
			attribute.put("rs", "");
			}
		else{
		for(int k=0;k<data.length;k+=2)
		{
			System.out.println("#名称#"+data[k]);
			name_list.add(data[k]);                                          //所输入的种子名   name_list
		}
		for(int k=0;k<data.length;k+=2)
		{
			System.out.println("#数量#"+data[k+1]);                 
			num_list.add(data[k+1]);                                         //所输入的种子数量   num_list
		} 
		
		for(int k=0;k<num_list.size();k++)
		{              
			for(int i=num_list.get(k).length();--i>=0;){
				int chr=num_list.get(k).charAt(i);
				if(chr<48 || chr>57)mark=0;
			}                                         
		} 
		if(mark==0){
			mark=0;
			attribute.put("mark", mark);
			attribute.put("rs", "");
		}else{

    		db.setAutoCommit(false);
        	String user=(String)attribute.get("user");
        	Date now=new Date();
        	Date back=new Date();
        	if(now.getMonth()<9)
        	    back.setMonth(now.getMonth()+4);
        	else{
        		back.setYear(now.getYear()+1);
        		back.setMonth(now.getMonth()+4-12);
        		
        	}
        	DateFormat d1 = DateFormat.getDateInstance();
        	String date= d1.format(now);
        	String backDate= d1.format(back);
        	String mailContent="BorrowTime:"+date+"\n"+"Borrower:"+user+"\n"+"BackTime:"+backDate+"\n";

        	
		   
		  String[] lieming = new String[field.size()];
		  for(int i=0;i<field.size();i++)
		  {
			  lieming[i] = field.get(i); 
		  }
		 
		 	 
		
		

		    ArrayList<String> before_num = new ArrayList();
		    ArrayList<String> temp = new ArrayList();
		    ArrayList<String> name_list_success = new ArrayList();
		    ArrayList<String> num_list_success = new ArrayList();
		    ArrayList<String> lieming_num = new ArrayList();
		    ArrayList<String> lieming_name = new ArrayList();


		    
		    boolean flag = false;
		    for(int i=0;i<lieming.length;i++)
		    {
		    	if(lieming[i].contains("NUMBER"))                                   //含有NUMBER的列名 -> lieming_num
    			{
    				lieming_num.add(lieming[i]);	
    				flag = false;
 
    			}
		    	if(lieming[i].contains("NAME"))                                     //含有NAME的列名 -> lieming_name
		    	{
		    		if(flag){lieming_num.add(null);}
		    		lieming_name.add(lieming[i]); 
		    		temp.add(lieming[i].replace("_NAME",""));                      //种子名的前半标志 -> temp       
		    		flag = true;
		    	}
		    }


		    
		    
		    for(int i=0;i<lieming_name.size();i++) 
		    {
		    	System.out.println("--------lieming_name.get()------"+lieming_name.get(i));
		        System.out.println("--------temp.get()-----"  +temp.get(i));
		        System.out.println("--------lieming_num.get()-----"  +lieming_num.get(i));
		    }
		    
		    System.out.println(lieming_name.size());
		     
		    String success = "success";
		    String failure = "failed";
        	String sql11 = null;
        	boolean hasRows = false;
        	
        	
        	System.out.println("-"+name_list.size());
        	for(int k=0;k<name_list.size();k++)
        	{
        		hasRows = false;
        		for(int i=0;i<lieming_name.size();i++)
        		{
        			sql11="select * from `"+table+"` where "+lieming_name.get(i)+"='"+name_list.get(k)+"';";
        			System.out.println("--------select * from `"+table+"` where "+lieming_name.get(i)+"='"+name_list.get(k)+"';");
        			ResultSet s = db.executeQuery(sql11);
		    	    while(s.next()){
		    	    	hasRows = true;
		    	    	break;
		    	    }
        		}	
        		if(hasRows){ 
        			result.add(success);                                    //种子存在 success -> result
        			name_list_success.add(name_list.get(k));                //可以接借种的 种子名 -> name_list_success
        			num_list_success.add(num_list.get(k));                  //可以接借种的 种子数 -> num_list_success
        			}
        		else  result.add(failure);                                  //不存在 failure ->result
        
        		
        	}
        	System.out.println("-"+name_list.size());
        	
        	
        	
      
        	String backnum = "";
        	String afternum = "";
        	String notes = "";
        	
            
		    String[] tempp = new String[temp.size()];
		    for(int i=0;i<temp.size();i++)
		    {
		    	tempp[i] = temp.get(i);
		    	System.out.println("-----tempp[i]------"+tempp[i]);
		    }
		   
		    

		    
		    String sql10 = null;
		    String sql12 = null;
		    String sql13 = null;
		    int ii=0;
		    String aaa = null;
		    String bbb = null;
		    
		    for(int i=0;i<name_list.size();i++)   					//循环   ----  输入的示例个数
		    {  
		    	if(result.get(i).equals(success))                           //选择   ----  可借种子标记
		    	{  
		    		for(int k=0;k<lieming_name.size();k++)                         //循环   ----  含NAME的列名(所有可借种子类别)
		    		{   
		    			if((name_list.get(i)).contains(tempp[k]))                         //选择   ----  可借种子的种类名称 包含temp标记
		    			{  
		    				String sql1 = "select "+lieming_num.get(k)+" from `"+table+"` where "+lieming_name.get(k)+"='"+name_list.get(i)+"';";
		    				String sql111 = "select No from `"+table+"` where "+lieming_name.get(k)+"='"+name_list.get(i)+"';";
		    				ResultSet rs1 = db.executeQuery(sql1);
		    				while (rs1.next()) {		    						
		    					aaa = rs1.getString(1);
		    					 
		    				}
		    				ResultSet rs111 = db.executeQuery(sql111);
		    				while (rs111.next()) {		    						
		    					bbb = rs111.getString(1);
		    					 
		    				}
		    				before_num.add(aaa);
		    					 
		    				afternum = String.valueOf(Integer.parseInt(aaa) - Integer.parseInt(num_list.get(i))); 
		    				if( Integer.parseInt(afternum) >= 0 )
		    				{
		    					String sql3="UPDATE `"+table+"` SET `"+lieming_num.get(k)+"`= '"+afternum+"' where "+lieming_name.get(k)+"='"+name_list.get(i)+"';";
		    					System.out.println("UPDATE `"+table+"` SET `"+lieming_num.get(k)+"`= '"+afternum+"' where "+lieming_name.get(k)+"='"+name_list.get(i)+"';");
		    					db.executeUpdate(sql3);
		    					db.commit();
		    				}
		    				else
		    				{
		    					afternum = "excess";
		    					String sql3="UPDATE `"+table+"` SET `"+lieming_num.get(k)+"`= '"+aaa+"' where "+lieming_name.get(k)+"='"+name_list.get(i)+"';";
		    					System.out.println("UPDATE `"+table+"` SET `"+lieming_num.get(k)+"`= '"+aaa+"' where "+lieming_name.get(k)+"='"+name_list.get(i)+"';");
		    					db.executeUpdate(sql3);
		    					db.commit();
		    				}
		    			}
		    		}
		    	}
		    	else {
		    		afternum = "";before_num.add("");
		    		notes = "failed";
		    	}
		    	if((result.get(i).equals(success))&&(!afternum.equals("excess"))){

			    		
					    sql10="insert into seed_manage(`BorrowTime`,`Borrower`,`Number`,`BackTime`,`BackNumber`,`BeforeNum`,`AfterNum`,`Type`,`Notes`,`Population`) values('"+date+"','"+user+"','"+num_list.get(i)+"','"+backDate+"','"+backnum+"','"+before_num.get(i)+"','"+afternum+"','"+name_list.get(i)+"',' ','"+table+"');";// lieming_num.get(i)+"`=`"+ lieming_num.get(i)+"`-"+num_list.get(i)+                      
					    System.out.println("insert into seed_manage(`BorrowTime`,`Borrower`,`Number`,`BackTime`,`BackNumber`,`BeforeNum`,`AfterNum`,`Type`,`Notes`,`Population`) values('"+date+"','"+user+"','"+num_list.get(i)+"','"+backDate+"','"+backnum+"','"+before_num.get(i)+"','"+afternum+"','"+name_list.get(i)+"','"+result.get(i)+"','"+table+"');"); 
					    db.executeUpdate(sql10);
					    mailContent+="BorrowName:"+name_list.get(i)+"\nBorrowNumber:"+num_list.get(i)+"\nPopulation:"+table+"\n";
 
					
	    				String sql55="insert into seed_modification(`Modification_No`,`Modification_name`,`Before_value`,`After_value`,`user`,`date`,`Population`) values('"+bbb+"','"+name_list.get(i)+"','"+before_num.get(i)+"','"+afternum+"','"+user+"','"+date+"','"+table+"');";
	    				//String sql66="update `"+table+"` set `"+(String)field.get(i)+"`='"+(String)al1.get(i)+"' where `No`='"+al1.get(0)+"';";
	    		        db.executeUpdate(sql55);
	    		        //db.executeUpdate(sql66);
	    				db.commit();
					    
       
		    	}
		    	if(result.get(i).equals(success)&&(!afternum.equals("excess"))){ 
		    		notes = "success";
				    sql12="insert into seed_batch_manage(`BorrowTime`,`Borrower`,`Number`,`BackTime`,`BackNumber`,`BeforeNum`,`AfterNum`,`Type`,`Notes`,`Population`) values('"+date+"','"+user+"','"+num_list.get(i)+"','"+backDate+"','"+backnum+"','"+before_num.get(i)+"','"+afternum+"','"+name_list.get(i)+"','"+notes+"','"+table+"');";
				    db.executeUpdate(sql12);
					db.commit();     
		    	}
		    	if(afternum.equals("excess")){ 
		    		notes = "failed";
				    sql12="insert into seed_batch_manage(`BorrowTime`,`Borrower`,`Number`,`BackTime`,`BackNumber`,`BeforeNum`,`AfterNum`,`Type`,`Notes`,`Population`) values('"+date+"','"+user+"','"+num_list.get(i)+"','"+backDate+"','"+backnum+"','"+before_num.get(i)+"','"+afternum+"','"+name_list.get(i)+"','"+notes+"','"+table+"');";
				    db.executeUpdate(sql12);
					db.commit();     
		    	}
		    	if(result.get(i).equals(failure)){ 
				    sql12="insert into seed_batch_manage(`BorrowTime`,`Borrower`,`Number`,`BackTime`,`BackNumber`,`BeforeNum`,`AfterNum`,`Type`,`Notes`,`Population`) values('"+date+"','"+user+"','"+num_list.get(i)+"','"+backDate+"','"+backnum+"','"+before_num.get(i)+"','"+afternum+"','"+name_list.get(i)+"','"+notes+"','"+table+"');";
				    db.executeUpdate(sql12);
					db.commit();     
		    	}
		    }
		    
		   System.out.println(mailContent);
		  // mail.setMail_body(mailContent);
	      // mail.send();
        	
		  
        	String path=getWebRoot();
    		String newpath=path+"file/result_info.txt";
		    
		    
		    

        	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@------");
        	String sql9="select * from seed_batch_manage where Borrower = '"+user+"';";  
        	FileOutputStream fos = new FileOutputStream(newpath);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            
            BufferedWriter out = new BufferedWriter(osw);
            
            
            ArrayList<String> thisfield = new ArrayList();
            String sql5="show fields from seed_manage;";
        	ResultSet rs0=db.executeQuery(sql5);
        	while(rs0.next()){
        		thisfield.add(rs0.getString(1));	
        	}
            for(int i=0;i<thisfield.size();i++){
            	out.write(thisfield.get(i)+"\t");
            	System.out.println("wwwwwwwwwww  "+thisfield.get(i));
            }
            out.newLine();
        	
        	try{
	        	ResultSet rs=db.executeQuery(sql9);
	        	ArrayList al=new ArrayList();
	        	while(rs.next()){
	        		for(int i=1;i<=11;i++){
	        			
	        			al.add(rs.getString(i));

	        			out.write(rs.getString(i)+"\t");
	        	    }
	        	    out.newLine();
	        	}
	        	out.flush();
	        	attribute.put("borrow_info",al);
	            }catch(Exception e){
	        		System.out.print("--------update_result---e.toString()------"+e.toString());
	        		return ERROR;
	        	} 
			String str = "truncate seed_batch_manage;";
			db.executeQuery(str);
			mark = 1;
			attribute.put("mark",mark);
			}
		}
        	return SUCCESS;        	
    }   
	
}
