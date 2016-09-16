package org.seed;

import org.util.DbBean;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class BorrowUpdate extends ActionSupport{
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    public String execute() throws Exception{
    	Map attribute=ActionContext.getContext().getSession();
    	DbBean db=new DbBean();
    	String sql="select * from seed_manage where `ID`="+id+";";
    	try{
    	ResultSet rs=db.executeQuery(sql);
    	ArrayList al=new ArrayList();
    	while(rs.next()){
    		for(int i=1;i<=10;i++)
    		al.add(rs.getString(i));
    	}
    	attribute.put("borrow",al);
    	return SUCCESS;
    	}catch(Exception e){
    		return ERROR;
    	}

    	
    }

}
