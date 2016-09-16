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
import org.db.chr4_merged_all_snp.Chr4MergedAllSnp;
import org.db.chr5_merged_all_snp.Chr5MergedAllSnp;
import org.db.chr6_merged_all_snp.Chr6MergedAllSnp;
import org.db.chr7_merged_all_snp.Chr7MergedAllSnp;
import org.db.chr8_merged_all_snp.Chr8MergedAllSnp;
import org.db.chr9_merged_all_snp.Chr9MergedAllSnp;
import org.db.chr10_merged_all_snp.Chr10MergedAllSnp;
 
import org.hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class Genotypic_new extends ActionSupport{
	private String genotypic;
	private String select11;
	int page;
	
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public String getGenotypic() {
		return genotypic;
	}

	public void setGenotypic(String genotypic) {
		this.genotypic = genotypic;
	}
	
	public String getSelect11() {
		return select11;
	}

	public void setSelect11(String select11) {
		this.select11 = select11;
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

    public String execute() throws Exception{
    	Map attribute=ActionContext.getContext().getSession();
    	DbBean db=new DbBean();
    	System.out.println(select11);
    	
    	
    	String sqlt = " select count(*) from information_schema.columns where table_schema='maizego' and table_name='zmb73_genebyloci' ;";
		ResultSet temp = db.executeQuery(sqlt);
		int column = 0;
		while(temp.next())column = Integer.parseInt(temp.getString(1));
		
    	String path=getWebRoot();
		String newpath=path+"file/genotypic_data.txt";
		
		/**
		 * modified in 2016.1.1 
		 * excute buildSessionFactory() before getSession() 
		 */
		Session session = new Configuration().configure().buildSessionFactory().openSession() ;
		session=HibernateSessionFactory.getSession();	    
		 
		
    	
    	
    	
    	
        if(select11.equals("Gene_Symbols")){
        	ArrayList al=new ArrayList();
	    	String sql0="select * from zmb73_genebyloci where `Gene_Symbol` = '"+genotypic+"';";
	        System.out.println(sql0);

	        ResultSet rs=db.executeQuery(sql0);
	        
	    	while(rs.next()){
	    		for(int i=1;i<=5;i++){
	    			
	    		     al.add(rs.getString(i));

	    		}

	    	}

	    	attribute.put("data",al);
	    	ArrayList bl=new ArrayList();
	        ArrayList<String> data = (ArrayList)attribute.get("data");
	        String exchange = "1";
			if((data.size()!=0)){
				
				String start = (String) data.get(3);
				String end = (String) data.get(4);
				attribute.put("start",start);
				attribute.put("end",end);
				exchange = data.get(2);
				
				System.out.println("------"+start+"------" +end);
				System.out.println("-------------------------------------->num->" +data.get(2));
				
				
		
				
				
	    		String sql ;
	    		Query query;
	    		long total=0;
	    		attribute.remove("total");///////////////////////////////////
	    		if(attribute.get("total")!=null){
	    			total=(Long)attribute.get("total");
	    			
	    		}
	    		 
	    		if(page>total){page=(int)total;}
	    		if(total==0){
	    			System.out.println("---------------222222222222222222222222");
	    			sql="select count(rs) from chr"+data.get(2)+"_merged_all_snp  where pos between  "+start+"  and  "+end+"  ";
	    			ResultSet rss=db.executeQuery(sql);
	    		    ArrayList all  = new ArrayList();    
	    		    
	    		    while(rss.next()){
	    		    		     all.add(rss.getString(1));		    		
	    		    	}

					total = Long.valueOf((String)all.get(0));
					System.out.println("total---------->"+total);
	    			attribute.put("total", total/50);
	    		
	    		}
	    		System.out.println("-------------------------------3"+total*50);
	    			
	    		sql="from Chr"+data.get(2)+"MergedAllSnp as c where c.pos between  "+start+"  and  "+end+"  ";
	    		System.out.println(sql);
	    		query=session.createQuery(sql);//where c.rs between 'chr1.S_100339360' and 'chr1.S_10037221'
	    		query.setFirstResult(50*page);
	    		query.setMaxResults(50);
	    		List list=query.list();
	    		System.out.println("list---------->"+list.size());	
	    		for(int i=0;i<list.size();i++){
	    			bl.add(list.get(i));
	    			
	    		}
	    		
	    		
	    		attribute.put("currentpage", page);
	    		int mark =1;
	    		attribute.put("mark",mark);

			}else{
				int mark =2;
				attribute.put("mark",mark);
			}
			
			attribute.put("chr_num",exchange);
			System.out.println("-----------------------------" + bl.size());
			attribute.put("list",bl);
			
	    	
        }else{/////////////////////////////////////////////////////////////////////////////////////////////
        	
        	int mark =1;
        	ArrayList bl=new ArrayList();
        	
        	System.out.println(genotypic);
        	
        	String term=genotypic;
    		term=term.replace(':', '.');
    		term=term.replace('\n', '.');
    		term=term.replace('\t', '.');
    		term=term.replace('\r', '.');
    		term=term.replace('\u0008', '.');   		
    		for(int g=0;g<10;g++)term=term.replace("  "," ");
            term=term.replace(' ', '.');
            for(int g=0;g<10;g++)term=term.replace("..",".");
            System.out.println("6: "+term); 
            

            String[] datap = term.split("\\.");
            System.out.println(">>>>>>>>>>>>>>>>>> "+datap.length);
    		if(datap.length==3){
    			System.out.println("-------------------------------1");
	    		String chr = datap[0];
	    		String pos_start = datap[1];
	    		String pos_end = datap[2];
	    		String chr_num = ""; 
	    		if(chr.length()>=4)chr_num = chr.substring(3);
	    		else{mark=0;}
	    		
	    		
	    	    for(int i=chr_num.length();--i>=0;){
	    			int x = chr_num.charAt(i);
	    			if( x<48 || x>57 )mark=0;
	    		}                                         
	    		if(mark!=0){
	    			if( Integer.valueOf(chr_num)>10 || Integer.valueOf(chr_num)<1 )mark=0;
	    		}
	    	    for(int i=pos_start.length();--i>=0;){
	    			int x = pos_start.charAt(i);
	    			if( x<48 || x>57 )mark=0;
	    		}  
	    	    for(int i=pos_end.length();--i>=0;){
	    			int x = pos_end.charAt(i);
	    			if( x<48 || x>57 )mark=0;
	    		}  
	    	    attribute.put("chr_num",chr_num);
	    	    attribute.put("mark",mark);
	    		

    		    
				if((pos_start.length()!=0)&&(pos_end.length()!=0)&&(mark!=0)){
					if(Integer.valueOf(pos_start)>Integer.valueOf(pos_end)){
						String tem = pos_start;
						pos_start = pos_end;
						pos_end = tem;						
					}
					String start = pos_start;
					String end = pos_end;
					attribute.put("start",start);
					attribute.put("end",end);
					
					System.out.println("------"+start+"------" +end);
					
		    		   		
		    		String sql ;
		    		Query query;
		    		long total=0;
		    		attribute.remove("total");///////////////////////////////////
		    		if(attribute.get("total")!=null){
		    			total=(Long)attribute.get("total");
		    			
		    		}
		    		 
		    		if(page>total){page=(int)total;}
		    		if(total==0){
		    			System.out.println("---------------222222222222222222222222");
		    			sql="select count(rs) from chr"+chr_num+"_merged_all_snp  where pos between  "+start+"  and  "+end+"  ";
		    			System.out.println(sql);	
		    			ResultSet rs=db.executeQuery(sql);
		    		    ArrayList all  = new ArrayList();    
		    		    
		    		    while(rs.next()){
		    		    		     all.add(rs.getString(1));		    		
		    		    	}

						total = Long.valueOf((String)all.get(0));
						System.out.println("total---------->"+total);
		    			attribute.put("total", total/50);
		    		
		    		}
		    		System.out.println("-------------------------------3"+total*50);
		    			
		    		sql="from Chr"+chr_num+"MergedAllSnp as c where c.pos between  "+start+"  and  "+end+"  ";
		    		System.out.println(sql);	
		    		query=session.createQuery(sql);//where c.rs between 'chr1.S_100339360' and 'chr1.S_10037221'
		    		query.setFirstResult(50*page);
		    		query.setMaxResults(50);
		    		List list=query.list();
		    		System.out.println("list---------->"+page);	
		    		for(int i=0;i<list.size();i++){
		    			bl.add(list.get(i));
		    			
		    		}
		    		
		    		
		    		attribute.put("currentpage", page);
		    		session.close();
	
				}
				else{
 
				}
	
    		}else{System.out.println("-----------------------------");
    			bl.clear();
    			mark=0;
    			attribute.put("mark",mark);
    			attribute.put("chr_num","");
    		}
    		 
    		System.out.println("-----------------------------" + bl.size());

    		attribute.put("list",bl);

    		
        }
	    	

    	
    	try{
    		
    		

    		attribute.put("column123",column);
        	attribute.put("path123",newpath);
    		
    		
    		
    		attribute.put("name",select11);
	    	return SUCCESS;
	    }catch(Exception e){
	    	return ERROR;
	    }

    	
    }

}
