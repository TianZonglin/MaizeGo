package org.user;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LoginOut extends ActionSupport {
	String url;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String execute() throws Exception {
		Map attibutes = ActionContext.getContext().getSession();
		HttpServletResponse response = (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 
			attibutes.put("user",null);
			attibutes.put("userType",null);
			url=url.substring(8);
			//System.out.println(url);
			try{
			request.getRequestDispatcher(url).forward(request,response);
			}catch(Exception e){
				e.printStackTrace();
			}
			//response.sendRedirect(url);
			return SUCCESS;
	
	}
	
	
}
