package org.seed;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class List extends ActionSupport {
	String FieldNo;
	String LineName;
	public String getFieldNo() {
		return FieldNo;
	}
	public void setFieldNo(String fieldNo)  {
		FieldNo =fieldNo;
	}
	public String getLineName() {
		return LineName;
	}
	public void setLineName(String lineName){
		LineName = lineName;
	}
	
	public String getWebRoot()
	 {
	     String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
	     if (path.indexOf("WEB-INF") > 0) 
	     {
	        path = path.substring(0, path.indexOf("WEB-INF/classes"));
	     } 
	     return path;
	}
	
	public String execute () throws Exception{
		Map attribute=ActionContext.getContext().getSession();
		DbBean db=new DbBean();
		ResultSet rs=null;
		ArrayList al=new ArrayList();
		//System.out.println(LineName);
		String sql="select * from seedlist where `LineName`='"+LineName+"' and `FieldNo`='"+FieldNo+"';";
		String path=getWebRoot();
		String newpath=path+"file/seedlist.txt";
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        out.write("No\tFieldNo\tLineName\tlocation\tRemark1\tRemark2");
        out.newLine();
		try{
			rs=db.executeQuery(sql);			
			while(rs.next()){
				for(int i=1;i<=6;i++){					
					al.add(rs.getString(i));
					out.write(rs.getString(i)+"\t");
					//System.out.println(rs.getString(i));
				}
				out.newLine();
			}
			
			
		}catch(Exception e){
			System.out.println(e.toString());
			return ERROR;
		}
		out.flush();
		attribute.put("al",al);
		return SUCCESS;
		
	}

}
