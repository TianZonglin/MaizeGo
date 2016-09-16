package org.genotype;

import org.hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.util.DbBean;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.db.chr1_merged_all_snp.Chr1MergedAllSnp;
import org.db.chr2_merged_all_snp.Chr2MergedAllSnp;
import org.db.chr3_merged_all_snp.Chr3MergedAllSnp;
import org.hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Genotypic_new1 extends ActionSupport {
	int page;
	
	
	
	
	
	public int getPage() {
		return page;
	}





	public void setPage(int page) {
		this.page = page;
	}





	@SuppressWarnings("unchecked")
	public String execute(){
		DbBean db=new DbBean();
		Map attribute=ActionContext.getContext().getSession();
		Session session=HibernateSessionFactory.getSession();
		//Chr1MergerAllSnpDAO dao=new Chr1MergerAllSnp();
		
		String startt = (String) attribute.get("start");
		String endd = (String) attribute.get("end");
		String cnt = attribute.get("chr_num").toString();
		
		System.out.println("######################### "+cnt);
		
		
		String sql ;
		Query query;
		long total=0;
		if(attribute.get("total")!=null){
			total=(Long)attribute.get("total");
			
		}
		 
		 if(page>total){page=(int)total;}
		if(total==0){
			
			
			
			System.out.println("-------------------------------2");
			sql="select count(rs) from chr"+cnt+"_merged_all_snp  where pos between  "+startt+"  and  "+endd+"  ";
			
			ResultSet rs;
			try {
				ArrayList all  = new ArrayList();    
				rs = db.executeQuery(sql);
				
			    while(rs.next()){
	    		     all.add(rs.getString(1));		    		
	    	    }
			    
				   
			    


				total = Long.valueOf((String)all.get(0));
				attribute.put("total", total/50);
				System.out.println(total/50);
			        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
			
		sql="from Chr"+cnt+"MergedAllSnp as c where c.pos between '"+startt+"' and '"+endd+"'  ";
		query=session.createQuery(sql);
		query.setFirstResult(50*page);
		query.setMaxResults(50);
		List list=query.list();
		ArrayList al=new ArrayList();
		for(int i=0;i<list.size();i++){
			al.add(list.get(i));
			
		}
		
		attribute.put("list", al);
		attribute.put("currentpage", page);
		session.close();

		return SUCCESS;
		
	}

}
