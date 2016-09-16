package org.seed;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SeedBorrow1 extends ActionSupport{
	String type;
	String name;
	String number;
	String borrow_num;
	String borrow_remain;
	public String getBorrow_remain() {
		return borrow_remain;
	}
	public void setBorrow_remain(String borrowRemain) {
		borrow_remain = borrowRemain;
	}
	public String getBorrow_num() {
		return borrow_num;
	}
	public void setBorrow_num(String borrowNum) {
		borrow_num = borrowNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	public String execute()throws Exception{
		DbBean db=new DbBean();
		Map attribute=ActionContext.getContext().getSession();
		String table=(String) attribute.get("table");
		ResultSet rs=null;
		ArrayList al = new ArrayList();
		String user=(String)attribute.get("user");
    	Date now=new Date();                                 //获取当前时间
    	Date back=new Date(); 
    	//获取归还时间
    	if(now.getMonth()<9)
    	    back.setMonth(now.getMonth()+4);
    	else{
    		back.setYear(now.getYear()+1);
    		back.setMonth(now.getMonth()+4-12);
    		
    	}
    	DateFormat d1 = DateFormat.getDateInstance();
    	String date= d1.format(now);                           //获取日期
    	String backDate= d1.format(back);
    	String no = null;
		String str=type.split("_")[0].concat("_SEED_NUMBER");
		String sql0="select No from `"+table+"` where `"+type+"`='"+name+"';";
		try{
			ResultSet rs1=db.executeQuery(sql0);
			while(rs1.next()){
				no=rs1.getString(1);
				
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		
   
		db.setAutoCommit(false);
		db.getConnection().setAutoCommit(false);
		//String afterNum=String.valueOf(Integer.parseInt(number)-Integer.parseInt(borrow_num));
		String sql1="UPDATE `"+table+"` SET `"+str+"`='"+borrow_remain+"' where `"+type+"`='"+name+"';";
		String sql2="INSERT INTO seed_manage(`BorrowTime`,`Borrower`,`Number`,`BackTime`,`BackNumber`,`BeforeNum`,`AfterNum`,`Type`,`Notes`,`Population`) values('"+date+"','"+user+"','"+borrow_num+"','"+backDate+"','','"+number+"','"+borrow_remain+"','"+name+"','','"+table+"');";
		String sql3="select * from seed_manage where `Borrower`='"+user+"';";
		String sql4="insert into seed_modification(`Modification_No`,`Modification_name`,`Before_value`,`After_value`,`user`,`date`,`Population`) ";
		sql4+="values('"+no+"','"+str+"','"+number+"','"+borrow_remain+"','"+user+"','"+date+"','"+table+"');";
		

		try{
			db.executeUpdate(sql1);
			db.executeUpdate(sql2);
			db.executeUpdate(sql4);
			db.commit();
		}catch(Exception e){
			System.out.println(e.getMessage()+"bbbbb");
			try{
				db.rollback();
			}catch(Exception ex){
				System.out.println(ex.getMessage()+"cccc");
				return ERROR;
			}
			return ERROR;
		}
		try{
			rs=db.executeQuery(sql3);	
			while(rs.next()){
	    		for(int i=1;i<=11;i++){
	    		
	    			 //out.write(rs.getString(i)+"\t");		
	    		    al.add(rs.getString(i));
	    		}				
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			db.close();
		}
		attribute.put("borrow",al);
		return SUCCESS;
		
		
		
		
	}
	

}
