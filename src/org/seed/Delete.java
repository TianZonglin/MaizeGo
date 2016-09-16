package org.seed;

import org.util.DbBean;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class Delete extends ActionSupport{
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    public String execute() throws Exception{
    	Map attribute=ActionContext.getContext().getSession();
    	String table=(String) attribute.get("table");
    	ArrayList field=(ArrayList) attribute.get("field");
    	DbBean db=new DbBean();
    	DbBean db1=new DbBean();
    	ResultSet rs1=null;
    	ArrayList al1=new ArrayList();
    	String sql="delete from `"+table+"` where `No`="+id+";";//删除对应No数据
    	String sql1="select * from `"+table+"`;";//查询seed_kd_ril中所以数据
    	try{
    		db.executeUpdate(sql);
    		ResultSet rs=db.executeQuery(sql1);
    		ArrayList al=new ArrayList();
    	while(rs.next()){
    		for(int i=1;i<=field.size();i++)
    		al.add(rs.getString(i));
    	}
    	attribute.put("seed",al);
    	return SUCCESS;
    	}catch(Exception e){
    		e.printStackTrace();
    		return ERROR;
    	}

    	
    }

}
