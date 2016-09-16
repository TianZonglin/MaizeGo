package org.seedbatch;

import org.email.Email;
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



public class T_test extends ActionSupport{
	 
	String select1;
	String select2;	
	String choose2;
 
	 
	public String getSelect1() {
		return select1;
	}

	public void setSelect1(String select1) {
		this.select1 = select1;
	}
	
	public String getSelect2() {
		return select2;
	}

	public void setSelect2(String select2) {
		this.select2 = select2;
	}
	
	public String getChoose2() {
		return choose2;
	}

	public void setChoose2(String choose2) {
		this.choose2 = choose2;
	}
	
 
	
	 
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
 
		Map attribute=ActionContext.getContext().getSession();
		DbBean db=new DbBean();
		
		String sql1="select pos from chr1_merged_all_snp";
		String sql2="show fields from phenoype_agri_traits";
		String sql3="show fields from chr1_merged_all_snp";
		ArrayList a1=new ArrayList();
    	ArrayList a2=new ArrayList();
    	ArrayList<String> a3=new ArrayList();
    	//ArrayList<String> a4=new ArrayList();
    	ResultSet rs3=db.executeQuery(sql3);
        
    	while(rs3.next()){
    		a3.add(rs3.getString(1));
    		//System.out.println(rs3.getString(1)); 
    	}
    	/*System.out.println("---1---"); 
    	String[] aa = new String[a3.size()];*/
   /* 	for(int i=0;i<a3.size();i++)
    	{//System.out.println("11111111111111"); 
    		 aa[i] = a3.get(i);
    		 if(aa[i].contains("CIMBL"))
    		 {
    			 System.out.println("222222222222222"); 
    			 a4.add(aa[i]);
    		 //System.out.println("------"+a4.get(i)+"-------");
    		}
    	}*/
    	System.out.println("---2---");
    	try{
        ResultSet rs1=db.executeQuery(sql1);
        while(rs1.next()){
    		a1.add(rs1.getString(1));
    	}
        
        ResultSet rs2=db.executeQuery(sql2);
    	while(rs2.next()){
    		a2.add(rs2.getString(1));
    	}
    	
    	 
    	attribute.put("rs1",a1); //select1=select2
    	attribute.put("rs2",a2); //choose2
    
    	 
    	attribute.put("choose1",a3); 
    	 
        }catch(Exception e){
	        System.out.print("--------T-test-error------"+e.toString());
	       return ERROR;
	    } 
        return SUCCESS;       
	}
}
    	
