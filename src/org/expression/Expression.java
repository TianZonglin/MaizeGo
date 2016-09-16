package org.expression;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Expression extends ActionSupport {
	String sel;

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	@SuppressWarnings("null")
	public String execute() throws Exception {
		Map<String, Object> attributes =ActionContext.getContext().getSession();	
		DbBean db = new DbBean();
		ResultSet rs = null;	
		String sql=null;
		ArrayList<String> a=new ArrayList<String>();
		ArrayList<String> trait=new ArrayList<String>();
		ArrayList<String> material=new ArrayList<String>();
		String[] str=sel.split(", ");
		if(str.length!=0){rs=db.executeQuery("select Trait from expression;");while(rs.next())trait.add(rs.getString(1));}
		for(int i=0;i<str.length;i++){
			if(!str[i].equals("Trait")){
				material.add(str[i]);
				sql="select "+str[i]+" from expression;";
				rs=db.executeQuery(sql);
				while(rs.next())
					a.add(rs.getString(1));
				attributes.put(str[i],a);
			}
		}
		attributes.put("material", material);
		attributes.put("trait",trait);
		return SUCCESS;
	}

		

}
