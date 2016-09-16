package org.metabolite;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Data5 extends ActionSupport{
	
	
	@SuppressWarnings("unchecked")
	public String execute(){
		
		Map attribute =ActionContext.getContext().getSession();
		ArrayList<String> list=new ArrayList();
		DbBean db=new DbBean();
		String sql="select * from `supplementary data 5`;";
		int columnCount=0;
		try{
			ResultSet rs=db.executeQuery(sql);
			columnCount=rs.getMetaData().getColumnCount();
			while(rs.next()){
				for(int i=1;i<=columnCount;i++){
					list.add(rs.getString(i));
				}
	
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		attribute.put("data", list);
		attribute.put("columnCount", columnCount);
		return SUCCESS;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
