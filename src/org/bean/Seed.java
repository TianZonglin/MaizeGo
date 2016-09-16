package org.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.util.DbBean;

import com.sun.rowset.CachedRowSetImpl;

public class Seed {
	public static CachedRowSetImpl getFieldFrom(String table){
		DbBean db=new DbBean();
		CachedRowSetImpl rowSet=null;
		String sql="show fields from `"+table+"`;";
		try {
			ResultSet rs=db.executeQuery(sql);
			rowSet=new CachedRowSetImpl();
			rowSet.populate(rs);
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			db.close();
		}
		
		return rowSet;
		
		
	}

}
