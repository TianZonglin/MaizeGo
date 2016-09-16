package org.hif;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MaterialInformation extends ActionSupport{
	
	
	String material;
	
	
	
	
	
	public String getMaterial() {
		return material;
	}





	public void setMaterial(String material) {
		this.material = material;
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
	
	
	




	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		
		Map attribute =ActionContext.getContext().getSession();
		String population=(String)attribute.get("population");
		String sql="select `ID`,`name`,`chr`,`pos_New`,`pos_g`,`"+material+"` from `"+population+"`;";
		//String sql="select `ID`,`name`,`chr`,`pos_New`,`pos_g`,`HZAU.601.3` from hif_b73_by804ril;";
		
		DbBean db=new DbBean();
		String path=getWebRoot()+"file/"+material+".txt";
		//String path=getWebRoot()+"file/HZAU.601.3.txt";
		File file=new File(path);
		BufferedWriter out=null;
		try {
			FileOutputStream fos=new FileOutputStream(file);
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
			out = new BufferedWriter(osw);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return ERROR;
		}
		
		ResultSet rs=null;
		try {
			rs=db.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
        out.write("ID\tname\tchr\tpos_New\tpos_g\t"+material);
        out.newLine();		
		while(rs.next()){
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				out.write(rs.getString(i)+"\t");
			}
			out.newLine();

		}
		out.close();
		
		
		
		return SUCCESS;
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
