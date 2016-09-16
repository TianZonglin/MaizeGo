package org.seed;

import org.util.DbBean;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

@SuppressWarnings("serial")
public class BorrowAdd extends ActionSupport{
	String BorrowTime;
	String Borrower;
	String Number;
	String BackTime;
	String BackNumber;
	String BeforeNum;
	String AfterNum;
	String Type;
	String Notes;
	String Population;
	








	public String getPopulation() {
		return Population;
	}









	public void setPopulation(String population) {
		Population = population;
	}









	public String getType() {
		return Type;
	}









	public void setType(String type) {
		Type = type;
	}









	public String getBorrowTime() {
		return BorrowTime;
	}









	public void setBorrowTime(String borrowTime) {
		BorrowTime = borrowTime;
	}









	public String getBorrower() {
		return Borrower;
	}









	public void setBorrower(String borrower) {
		Borrower = borrower;
	}









	public String getNumber() {
		return Number;
	}









	public void setNumber(String number) {
		Number = number;
	}









	public String getBackTime() {
		return BackTime;
	}









	public void setBackTime(String backTime) {
		BackTime = backTime;
	}









	public String getBackNumber() {
		return BackNumber;
	}









	public void setBackNumber(String backNumber) {
		BackNumber = backNumber;
	}









	public String getNotes() {
		return Notes;
	}









	public void setNotes(String notes) {
		Notes = notes;
	}









	public String execute() throws Exception{
    	Map attribute=ActionContext.getContext().getSession();
   
    	DbBean db=new DbBean();
    	String sql="INSERT INTO seed_manage(`BorrowTime`,`Borrower`,`Number`,`BackTime`,`BackNumber`,`BeforeNum`,`AfterNum`,`Type`,`Notes`,`Population`)";
    	sql=sql+"VALUES('"+BorrowTime+"','"+Borrower+"','"+Number+"','"+BackTime+"','"+BackNumber+"','"+BeforeNum+"','"+AfterNum+"','"+Type+"','"+Notes+"','"+Population+"')";
    	System.out.println(sql);
    	String sql1="select * from seed_manage;";
    	System.out.println(sql);
    	try{
    	db.executeUpdate(sql);
    	}catch(Exception e){
    		System.out.print(e.toString());
    		return ERROR;
    	}
    	String sqlll = "flush privileges;";
    	db.executeQuery(sqlll);
    	
    	try{
        	ResultSet rs=db.executeQuery(sql1);
        	ArrayList al=new ArrayList();
        	while(rs.next()){
        		for(int i=1;i<=11;i++)
        		{
        		al.add(rs.getString(i));
        		//System.out.println(rs.getString(i));
        		}
        	}
        	attribute.put("borrow",al);
        	return SUCCESS;
        	}catch(Exception e){
        		System.out.print(e.toString());
        		return ERROR;
        	}   	

    	
    }









	public String getBeforeNum() {
		return BeforeNum;
	}









	public void setBeforeNum(String beforeNum) {
		BeforeNum = beforeNum;
	}









	public String getAfterNum() {
		return AfterNum;
	}









	public void setAfterNum(String afterNum) {
		AfterNum = afterNum;
	}

}
