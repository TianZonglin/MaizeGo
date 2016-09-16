package org.seed;

import org.util.DbBean;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class Update extends ActionSupport{
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    @SuppressWarnings("unchecked")
	public String execute() throws Exception{
    	Map attribute=ActionContext.getContext().getSession();
    	String table=(String) attribute.get("table");
    	ArrayList<String> field=(ArrayList) attribute.get("field");
    	DbBean db=new DbBean();
    	String sql="select * from `"+table+"` where `No`="+id+";";
    	try{
    	ResultSet rs=db.executeQuery(sql);
    	ArrayList al=new ArrayList();
    	while(rs.next()){
    		for(int i=1;i<=field.size();i++)
    		al.add(rs.getString(i));
    	}
    	attribute.put("seedlist",al);
    	return SUCCESS;
    	}catch(Exception e){
    		return ERROR;
    	}

    	
    }

}
