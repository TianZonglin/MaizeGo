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

public class SeedBorrow extends ActionSupport{
	String table;
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	String type;
	String name;
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
	@SuppressWarnings({ "unchecked" })
	public String execute()throws Exception{
		DbBean db=new DbBean();
		Map attribute=ActionContext.getContext().getSession();
		ResultSet rs=null;
		ArrayList al = new ArrayList();
		String str=type.split("_")[0].concat("_SEED_NUMBER");
		String tablee = "seed_"+table.toLowerCase();
		System.out.println(tablee);
		
		if(str.equals("RILS_SEED_NUMBER")){
			String sql="select `"+type+"` from `"+tablee+"` where `"+type+"`='"+name+"';";
			System.out.println(sql);
			try{
				rs=db.executeQuery(sql);
				while(rs.next()){
					al.add(type);
					al.add(rs.getString(1));
					al.add(rs.getString(2));
				}
			}catch(Exception e){
				System.out.println(e.getMessage());

				return ERROR;
			}
	        finally{
				db.close();
			}
		}else{
			String sql="select `"+type+"`,`"+str+"`"+" from `"+tablee+"` where `"+type+"`='"+name+"';";
			
			System.out.println(sql);
			try{
				rs=db.executeQuery(sql);
				while(rs.next()){
					al.add(type);
					al.add(rs.getString(1));
					al.add(rs.getString(2));
				}
			}catch(Exception e){
				System.out.println(e.getMessage());

				return ERROR;
			}
	        finally{
				db.close();
			}
		}
		

		attribute.put("table", table);
		attribute.put("borrow",al);
		return SUCCESS;
		
		
		
		
	}
	

}
