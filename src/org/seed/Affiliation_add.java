package org.seed;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.db.affiliation_borrow.AffiliationBorrow;
import org.db.affiliation_borrow.AffiliationBorrowDAO;
import org.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Affiliation_add extends ActionSupport{
	String name;
	String affiliation;
	String phone;
	String borrowNum;
	String note;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBorrowNum() {
		return borrowNum;
	}
	public void setBorrowNum(String borrowNum) {
		this.borrowNum = borrowNum;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String execute() throws Exception{
		Map attribute= ActionContext.getContext().getSession();
		AffiliationBorrow ab=new AffiliationBorrow();
		Date date=new Date();
		DateFormat df= DateFormat.getDateInstance();
		String now=df.format(date);
		ab.setDate(now);
		ab.setName(name);
		ab.setAffiliation(affiliation);
		ab.setBorrowNum(Integer.parseInt(borrowNum));
		ab.setPhone(phone);
		ab.setNote(note);
		AffiliationBorrowDAO  ao=new AffiliationBorrowDAO();
		org.hibernate.Session session = HibernateSessionFactory.getSession();
		ao.save(ab);
		
		List al=new ArrayList<AffiliationBorrow>();
		ArrayList al1=new ArrayList();
		al=ao.findAll();
		session.beginTransaction().commit();
		//System.out.println(al.get(0).toString());
		for(int i=0;i<al.size();i++){
			ab=(AffiliationBorrow) al.get(i);
			
			al1.add(ab.getNum());
			al1.add(ab.getDate());
			al1.add(ab.getName());
			al1.add(ab.getAffiliation());
			al1.add(ab.getPhone());
			al1.add(ab.getBorrowNum());
			al1.add(ab.getNote());
			
		}
		System.out.println(ab.getDate());
		attribute.put("affiliation",al1);
		
		
		
		
		return SUCCESS;
		
	}

}
