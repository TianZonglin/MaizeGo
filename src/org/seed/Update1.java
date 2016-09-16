package org.seed;

import org.email.Email;
import org.util.DbBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Update1 extends ActionSupport{
	int No;
	String Note;
    String maize;
	String borrow;
	String remain;
	String material;
	String beforeNum;
	String selectField;

	public String getSelectField() {
		return selectField;
	}








	public void setSelectField(String selectField) {
		this.selectField = selectField;
	}








	public String getBeforeNum() {
		return beforeNum;
	}








	public void setBeforeNum(String beforeNum) {
		this.beforeNum = beforeNum;
	}








	public String getMaterial() {
		return material;
	}








	public void setMaterial(String material) {
		this.material = material;
	}








	public String getMaize() {
		return maize;
	}








	public void setMaize(String maize) {
		this.maize = maize;
	}








	public String getBorrow() {
		return borrow;
	}








	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}








	public String getRemain() {
		return remain;
	}








	public void setRemain(String remain) {
		this.remain = remain;
	}








	public String getNote() {
		return Note;
	}








	public void setNote(String note) {
		Note = note;
	}







	public int getNo() {
		return No;
	}








	public void setNo(int no) {
		No = no;
	}
















	@SuppressWarnings({ "unchecked", "deprecation" })
	public String execute() throws Exception{
		String maizego[]=maize.split(", ");
    	Map attribute=ActionContext.getContext().getSession();
    	String table=(String) attribute.get("table");
    	ArrayList<String> field=(ArrayList)attribute.get("field");
    	String type=(String)attribute.get("userType");
    	DbBean db=new DbBean();

    	if(type.equals("admin"))
    	{
    		db.setAutoCommit(false);
    		Date date=new Date();
    		DateFormat df=DateFormat.getDateInstance();
    		String now=df.format(date);
    		String user=(String)attribute.get("user");

    		ArrayList al1=new ArrayList();    //存储修改后数据
    		ArrayList al2=new ArrayList();         //存储修改前数据
    		
    		
    		al1.add(No);
    		for(int i=0;i<maizego.length;i++)
    			al1.add(maizego[i]);
    		al1.add(Note);
    		al2=(ArrayList)attribute.get("seedlist");
    		
    		for(int i=1;i<al1.size();i++){
    			try{
	    			if(!al1.get(i).equals(al2.get(i))){
	    				String sql1="insert into seed_modification(`Modification_No`,`Modification_name`,`Before_value`,`After_value`,`user`,`date`,`Population`) ";
	    				sql1+="values('"+al1.get(0)+"','"+(String)field.get(i)+"','"+(String)al2.get(i)+"','"+(String)al1.get(i)+"','"+user+"','"+now+"','"+table+"');";
	    				String sql2="update `"+table+"` set `"+(String)field.get(i)+"`='"+(String)al1.get(i)+"' where `No`='"+al1.get(0)+"';";
	    		        db.executeUpdate(sql1);
	    		        db.executeUpdate(sql2);
	    				db.commit();
	    			}
    			}catch(Exception e){
    				e.printStackTrace();
    				try{
    					db.rollback();    					
    				}catch(Exception ex){
    					ex.printStackTrace();
    					return ERROR;
    				}
    				return ERROR;
    			}
    		}   
    		String sql3="select * from `"+table+"`;";
    		ResultSet rs=db.executeQuery(sql3);
    		al2.clear();
    		while(rs.next()){
    			for(int i=1;i<=field.size();i++)
    			al2.add(rs.getString(i));	
    		}
    		attribute.put("seed", al2);
    		return SUCCESS;

    	}else{
   		
    		Email mail=new Email();
    		

    		String []mate=material.split(", ");    // 接触的种子的材料名
    		String[] borrow_num=borrow.split(",");
    		String[] remain_num=remain.split(",");   		
    		
    		
    		System.out.println(borrow);
    		System.out.println(material);
    		String []before_num=beforeNum.split(", ");         //种子借出前的数量
    		String[] fieldSelected=selectField.split(", ");//借出的种子的字段名

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
        	//System.out.println(maize_11YN_borrow);
        	
        	
        	for(int i=0;i<mate.length;i++){
        		borrow_num[i]=borrow_num[i].trim();
        		remain_num[i]=remain_num[i].trim();
        		if(!borrow_num[i].equals("")&&!remain_num[i].equals(""))
			        {		
        			System.out.println(borrow_num[i]);
			        	String sql3="UPDATE `"+table+"` SET `"+fieldSelected[i]+"`='"+ remain_num[i]+"' where `No`='"+No+"';";
			        	String sql4="INSERT INTO seed_manage(`BorrowTime`,`Borrower`,`Number`,`BackTime`,`BackNumber`,`BeforeNum`,`AfterNum`,`Type`,`Notes`,`Population`) values('"+date+"','"+user+"','"+borrow_num[i]+"','"+backDate+"','','"+before_num[i]+"','"+ remain_num[i]+"','"+mate[i]+"','','"+table+"');";
			        	String sql10="insert into seed_modification(`Modification_No`,`Modification_name`,`Before_value`,`After_value`,`user`,`date`,`Population`) ";
			        	sql10+="values('"+No+"','"+mate[i]+"','"+before_num[i]+"','"+remain_num[i]+"','"+user+"','"+date+"','"+table+"');";
			        	mailContent+="BorrowName:"+mate[i]+"\nBorrowNumber:"+borrow_num[i]+"\nPopulation:"+table+"\n";
			        	try{ 
			        		
				        	db.executeUpdate(sql3);
					        db.executeUpdate(sql4);	
					        db.executeUpdate(sql10);
					        db.commit();
					        mail.setMail_body(mailContent);
					        mail.send();			        
			        	}catch(Exception e){
			        		System.out.println(e.getMessage());
			        		try{
			        			db.rollback();
			        		}catch(Exception ex){
			        			System.out.println(ex.getMessage());
			        		}	        		
			        	}        		
			        		
			        	}
        		
        	}
        	
        	
        	
        	
        	
        	/*
        	
        	if(maize_11YN_borrow!=null&&!maize_11YN_borrow.equals(""))
        	{
        		//String afterNum=String.valueOf(Integer.valueOf(maize_11YN_NUM)-Integer.valueOf(maize_11YN_borrow));
	        	String sql3="UPDATE seed_kd_ril SET `11YN_SEED_NUMBER`='"+ maize_11YN_remain+"' where `No`='"+No+"';";
	        	String sql4="INSERT INTO seed_manage(`BorrowTime`,`Borrower`,`Number`,`BackTime`,`BackNumber`,`BeforeNum`,`AfterNum`,`Type`,`Notes`) values('"+date+"','"+user+"','"+maize_11YN_borrow+"','"+backDate+"','','"+maize_11YN_NUM+"','"+ maize_11YN_remain+"','"+maize_11YN_NAME+"','');";
	        	String sql10="insert into seed_modification(`Modification_No`,`Modification_name`,`Before_value`,`After_value`,`user`,`date`) ";
	        	sql10+="values('"+No+"','11YN_SEED_NUMBER','"+maize_11YN_NUM+"','"+maize_11YN_remain+"','"+user+"','"+date+"');";
	        	mailContent+="BorrowName:"+maize_11YN_NAME+"\nBorrowNumber:"+maize_11YN_borrow+"\n";
	        	try{ 
	        		
		        	db.executeUpdate(sql3);
			        db.executeUpdate(sql4);	
			        db.executeUpdate(sql10);
			        db.commit();
			        mail.setMail_body(mailContent);
			        mail.send();			        
	        	}catch(Exception e){
	        		System.out.println(e.getMessage());
	        		try{
	        			db.rollback();
	        		}catch(Exception ex){
	        			System.out.println(ex.getMessage());
	        		}	        		
	        	}

	        }
        	if(maize_11YXH_borrow!=null&&!maize_11YXH_borrow.equals(""))
        	{
        		//String afterNum=String.valueOf(Integer.valueOf(maize_11YXH_NUM)-Integer.valueOf(maize_11YXH_borrow));
	        	String sql5="UPDATE seed_kd_ril SET `11YXH_SEED_NUMBER`='"+maize_11YXH_remain+"' where `No`='"+No+"';";
	        	String sql6="INSERT INTO seed_manage(`BorrowTime`,`Borrower`,`Number`,`BackTime`,`BackNumber`,`BeforeNum`,`AfterNum`,`Type`,`Notes`) values('"+date+"','"+user+"','"+maize_11YXH_borrow+"','"+backDate+"','','"+maize_11YXH_NUM+"','"+maize_11YXH_remain+"','"+maize_11YXH_NAME+"','');";
	        	String sql11="insert into seed_modification(`Modification_No`,`Modification_name`,`Before_value`,`After_value`,`user`,`date`) ";
	        	sql11+="values('"+No+"','11YXH_SEED_NUMBER','"+maize_11YXH_NUM+"','"+maize_11YXH_remain+"','"+user+"','"+date+"');";	        	
	        	mailContent+="BorrowName:"+maize_11YXH_NAME+"\nBorrowNumber:"+maize_11YXH_borrow+"\n";
	        	try{
	        		
		        	db.executeUpdate(sql5);
			        db.executeUpdate(sql6);	  
			        db.executeUpdate(sql11);
			        db.commit();
			        mail.setMail_body(mailContent);
			        mail.send();				        
	        	}catch(Exception e){
	        		System.out.println(e.getMessage());
	        		try{
	        			db.rollback();
	        		}catch(Exception ex){
	        			System.out.println(ex.getMessage());
	        		}	        		
	        	}

	        }  
        	if(maize_12RIL_borrow!=null&&!maize_12RIL_borrow.equals(""))
        	{
        		//String afterNum=String.valueOf(Integer.valueOf(maize_12RIL_NUM)-Integer.valueOf(maize_12RIL_borrow));
	        	String sql7="UPDATE seed_kd_ril SET `12RIL_SEED_NUMBER`='"+maize_12RIL_remain+"' where `No`='"+No+"';";
	        	String sql8="INSERT INTO seed_manage(`BorrowTime`,`Borrower`,`Number`,`BackTime`,`BackNumber`,`BeforeNum`,`AfterNum`,`Type`,`Notes`) values('"+date+"','"+user+"','"+maize_12RIL_borrow+"','"+backDate+"','','"+maize_12RIL_NUM+"','"+maize_12RIL_remain+"','"+maize_12RIL_NAME+"','');";
	        	String sql12="insert into seed_modification(`Modification_No`,`Modification_name`,`Before_value`,`After_value`,`user`,`date`) ";
	        	sql12+="values('"+No+"','12RIL_SEED_NUMBER','"+maize_12RIL_NUM+"','"+maize_12RIL_remain+"','"+user+"','"+date+"');";	        	
	        	mailContent+="BorrowName:"+maize_12RIL_NAME+"\n"+"BorrowNumber:"+maize_12RIL_borrow+"\n";
	        	try{
	        		
		        	db.executeUpdate(sql7);
			        db.executeUpdate(sql8);	
			        db.executeUpdate(sql12);
			        db.commit();
			        mail.setMail_body(mailContent);
			        mail.send();			        
	        	}catch(Exception e){
	        		System.out.println(e.getMessage());
	        		try{
	        			db.rollback();
	        		}catch(Exception ex){
	        			System.out.println(ex.getMessage());
	        		}
	        	}
	        	
	        	

	        } */
        	String sql9="select * from seed_manage where `Borrower`='"+user+"';";  
	    	try{
	        	ResultSet rs=db.executeQuery(sql9);
	        	ArrayList al=new ArrayList();
	        	while(rs.next()){
	        		for(int i=1;i<=11;i++)
	        		al.add(rs.getString(i));
	        	}
	        	attribute.put("borrow",al);
	        	}catch(Exception e){
	        		System.out.print(e.toString());
	        		return ERROR;
	        	}        	
        	return INPUT;
        	//sql3+="',`11YXH_SEED_NUMBER`='"+String.valueOf(Integer.valueOf(maize_11YXH_NUM)-Integer.valueOf(maize_11YXH_borrow))+"',`12RIL_SEED_NUMBER`='"+String.valueOf(Integer.valueOf(maize_12RIL_NUM)-Integer.valueOf(maize_12RIL_borrow))+"' where `No`="+No+";";
    }
    	
}
}
