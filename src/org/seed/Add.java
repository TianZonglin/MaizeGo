package org.seed;

import org.util.DbBean;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class Add extends ActionSupport{
	String maize;
	String Note;






	public String getMaize() {
		return maize;
	}




	public void setMaize(String maize) {
		this.maize = maize;
	}




	public String getNote() {
		return Note;
	}




	public void setNote(String Note) {
		this.Note = Note;
	}




	public String execute() throws Exception{
    	Map attribute=ActionContext.getContext().getSession();
    	String []maizego=maize.split(", ");
    	String table=(String) attribute.get("table");
    	ArrayList field=(ArrayList) attribute.get("field");
    	DbBean db=new DbBean();   	
    	String sql="INSERT INTO `"+table+"`(";
    	for(int i=1;i<field.size()-1;i++)
    		sql+="`"+field.get(i)+"`,";
    	sql+="`NOTES`) VALUES(";
    	
    	for(int i=0;i<maizego.length;i++)
    	{
    		System.out.println(maizego[i]);
    		sql+="'"+maizego[i]+"',";
    	}
    	sql+="'"+Note+"')";
    	String sql1="select * from `"+table+"`;";
    	try{
    	db.executeUpdate(sql);
    	}catch(Exception e){
    		System.out.print(e.toString());
    		return ERROR;
    	}
    	try{
        	ResultSet rs=db.executeQuery(sql1);
        	ArrayList al=new ArrayList();
        	while(rs.next()){
        		for(int i=1;i<=field.size();i++)
        		al.add(rs.getString(i));
        	}
        	attribute.put("seed",al);
        	return SUCCESS;
        	}catch(Exception e){
        		System.out.print(e.toString());
        		return ERROR;
        	}   	

    	
    }

}
