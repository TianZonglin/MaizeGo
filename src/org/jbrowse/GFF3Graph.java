package org.jbrowse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.rowset.CachedRowSetImpl;

public class GFF3Graph extends ActionSupport{
	String featurename;

	public String getFeaturename() {
		return featurename;
	}

	public void setFeaturename(String featurename) {
		this.featurename = featurename;
	}
	
	
	@SuppressWarnings({ "unchecked", "null" })
	public String execute(){
		Map attribute = ActionContext.getContext().getSession();
		DbBean db = new DbBean();
		String sql1="select COLUMN_NAME from information_schema.COLUMNS where TABLE_NAME = 'table 75'";
		String sql2="select * from `table 75` where `GeneID` = '"+featurename+"';";
		ResultSet rs=null;

		CachedRowSetImpl fields=null;
		CachedRowSetImpl data=null;
	
		try {
			fields = new CachedRowSetImpl();
			data=new CachedRowSetImpl();		

			rs= db.executeQuery(sql2);
			data.populate(rs);
			rs= db.executeQuery(sql1);			
			fields.populate(rs);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			db.close();
		}
		attribute.put("fields", fields);
		attribute.put("data", data);
		attribute.put("featurename", featurename);
		db.close();
		return SUCCESS;
	}

}
