package org.seed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.db.affiliation_borrow.AffiliationBorrow;
import org.db.affiliation_borrow.AffiliationBorrowDAO;
import org.hibernate.HibernateSessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Affiliation_delete extends ActionSupport{
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String execute() throws Exception{
		Map attribute=ActionContext.getContext().getSession();		
		AffiliationBorrowDAO  ao=new AffiliationBorrowDAO();
		org.hibernate.Session session = ao.getSession();
		AffiliationBorrow ab=ao.findById(Integer.parseInt(id));
	    Transaction tr=session.beginTransaction();
		ao.delete(ab);
		
		List al=new ArrayList<AffiliationBorrow>();
		ArrayList al1=new ArrayList();
		al=ao.findAll();
		tr.commit();
		
		//System.out.println(al.get(0).toString());
		for(int i=0;i<al.size();i++){
			AffiliationBorrow ab1=new AffiliationBorrow();
			ab1=(AffiliationBorrow) al.get(i);
			
			al1.add(ab1.getNum());
			al1.add(ab1.getDate());
			al1.add(ab1.getName());
			al1.add(ab1.getAffiliation());
			al1.add(ab1.getPhone());
			al1.add(ab1.getBorrowNum());
			al1.add(ab1.getNote());
			
		}
		//System.out.println(ab.getDate());
		attribute.put("affiliation",al1);		
		
		
		return SUCCESS;
	}

}
