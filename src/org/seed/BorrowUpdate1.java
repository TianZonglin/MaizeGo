package org.seed;

import org.util.DbBean;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class BorrowUpdate1 extends ActionSupport{
	int ID;
	String BorrowTime;
	String Borrower;
	String Number;
	String BackTime;
	String BackNumber;
	String BeforeNum;
	String AfterNum;
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







	String Type;
	String Notes;
	
	


   


	public int getID() {
		return ID;
	}







	public void setID(int iD) {
		ID = iD;
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







	public String getType() {
		return Type;
	}







	public void setType(String type) {
		Type = type;
	}







	public String getNotes() {
		return Notes;
	}







	public void setNotes(String notes) {
		Notes = notes;
	}







	public String execute() throws Exception{
    	Map attribute=ActionContext.getContext().getSession();
    	//String user=(String) attribute.get("user");
    	DbBean db=new DbBean();
    	//����seed_manage
    	String sql="UPDATE seed_manage SET `BorrowTime`='"+BorrowTime+"',`Borrower`='"+Borrower+"',`Number`='"+Number+"',`BackTime`='"+BackTime+"',`BackNumber`='"+BackNumber+"',`BeforeNum`='"+BeforeNum+"',`AfterNum`='"+AfterNum+"',`Type`='"+Type+"',`Notes`='"+Notes+"' WHERE `ID`="+ID+";";
    	
    	String sql1="select * from seed_manage;";           //��ѯ��ݿ�


    	try{
    	db.executeUpdate(sql);
    	}catch(Exception e){
    		System.out.print(e.toString());
    		return ERROR;
    	}
    	try{
        	ResultSet rs=db.executeQuery(sql1);
        	ArrayList al=new ArrayList();
        	while(rs.next()){
        		for(int i=1;i<=10;i++)
        		al.add(rs.getString(i));
        	}
        	attribute.put("borrow",al);
        	return SUCCESS;
        	}catch(Exception e){
        		System.out.print(e.toString());
        		return ERROR;
        	}   	

    	
    }

}
