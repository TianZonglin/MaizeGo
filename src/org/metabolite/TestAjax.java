package org.metabolite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionSupport;

public class TestAjax extends ActionSupport{
	private String key;
	
	private ArrayList<String> msg = new ArrayList<String>();
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	
	public ArrayList<String> getMsg() {
		return msg;
	}
	
	public void setMsg(ArrayList<String> msg) {
		this.msg = msg;
	}
	
	public String execute(){
		
		DbBean db= new DbBean();
		
		String sql="select `Peak NO.` from `supplementary data 2` where `Peak NO.` like '"+key+"%' limit 0,14";
		ResultSet rs;	
		try {
			 rs= db.executeQuery(sql);
			while(rs.next()){
				msg.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
		
	}

}
