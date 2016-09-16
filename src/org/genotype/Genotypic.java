package org.genotype;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.db.chr1_merged_all_snp.Chr1MergedAllSnp;
import org.hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Genotypic extends ActionSupport {
	int page;
	
	
	
	
	
	public int getPage() {
		return page;
	}





	public void setPage(int page) {
		this.page = page;
	}





	public String execute(){
		
		Map attribute=ActionContext.getContext().getSession();
		Session session=HibernateSessionFactory.getSession();
		//Chr1MergerAllSnpDAO dao=new Chr1MergerAllSnp();
		String sql ;
		Query query;
		long total=0;
		if(attribute.get("total")!=null){
			total=(Long)attribute.get("total");
			
		}
		 
		 if(page>total){page=(int)total;}
		if(total==0){
			sql="select count(rs) from Chr1MergedAllSnp  as c";
			query=session.createQuery(sql);
			total=(Long)query.list().get(0);
			attribute.put("total", total/50);
			System.out.println(total/50);
		}
			
		sql="from Chr1MergedAllSnp  as c";
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
