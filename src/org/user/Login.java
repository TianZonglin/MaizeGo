package org.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

import org.apache.struts2.ServletActionContext;
import org.util.DbBean;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class Login extends ActionSupport {
	String user;
	String password;
	String url;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() throws Exception {
		DbBean db=new DbBean();
		String sql="select `type` from user where `name`='"+user+"' and `pw`='"+password+"';"; 
		
		Map attibutes = ActionContext.getContext().getSession();
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
		try{
			ResultSet rs=db.executeQuery(sql);
			if(rs.next()){
				attibutes.put("user",user);
				attibutes.put("userType",rs.getString(1));
			}else{
				attibutes.put("user",null);
			}
				
				
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			db.close();
		}
		url=url.substring(8);		
		request.getRequestDispatcher(url).forward(request,response);
		return SUCCESS;
		
	}
	
	String uname;
	String pwd;
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String checkLogin() throws IOException{
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		DbBean db=new DbBean();
		String sql="select * from user where `name` = '"+uname+"' and `pw`= '"+pwd+"';";
		ResultSet rs=null;
		try{
		rs=db.executeQuery(sql);
		while(rs.next()){
			writer.write("success");
			return null;
		}
		    writer.write("failure");
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return null;
		
		
	}
	
}
