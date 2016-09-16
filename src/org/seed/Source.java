package org.seed;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Source extends ActionSupport {
	String fieldNo;
	ArrayList<String> al=new ArrayList<String>();
	DbBean db=new DbBean();

	public String getFieldNo() {
		return fieldNo;
	}

	public void setFieldNo(String fieldNo) {
		this.fieldNo = fieldNo;
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
	
	
	
	public void getsource(String field){
		
		ResultSet rs=null;
		
		String sql="select `Source1`,`Source2` from seedsource where `FieldNo`='"+field+"';";
		try{
			rs=db.executeQuery(sql);	
			while(rs.next())
			{
				//System.out.println(rs.getString(1)+"  aaa "+rs.getString(2));
				if(!rs.getString(1).equals("")&&rs.getString(1)!=null){
					System.out.println(rs.getString(1));
				    al.add(rs.getString(1));
				//getsource(rs.getString(1));
				}
				if(!rs.getString(2).equals("")&&rs.getString(2)!=null){
					System.out.println(rs.getString(2));
				    al.add(rs.getString(2));
				//getsource(rs.getString(2));
				}
			}
	
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}	
	
		
	public String execute() throws Exception{
		Map attribute=ActionContext.getContext().getSession();
		//DbBean db=new DbBean();
		ResultSet rs=null;
		ArrayList<String> al1=new ArrayList<String>();
		
		String term=fieldNo;
		term=term.replace('\n', ',');
		System.out.println("2: "+term);
		term=term.replace('\t', ',');
		System.out.println("3: "+term);
		term=term.replace('\u0008', ',');
		System.out.println("4: "+term);
		term=term.replace('\r', ',');
		
        System.out.println("5: "+term);
        term=term.replace(' ', ',');
        System.out.println("5: "+term);
        
        //ArrayList inputlist=new ArrayList();
        String[] data = term.split(",");
		
		for(int k=0;k<data.length;k++)
		{
			al.add(data[k]);
		}
		if(al.size()!=0)
 	    {
			while(al.contains(""))
 	    	    al.remove("");
 	    }
		
		//al.add(fieldNo);
		
		for(int i=0;i<al.size();i++){
			getsource((String)al.get(i));
		}
		/*
		for(int i=0;i<al.size();i++){
			System.out.println(al.get(i));
		}*/
		String sql="select * from seedsource where `FieldNo`='"+al.get(0)+"'";
		for(int i=1;i<al.size();i++)
			sql=sql+" or `FieldNo`='"+al.get(i)+"'";
		String path=getWebRoot();
		String newpath=path+"file/seedsource.txt";
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        out.write("No\tFieldNo\tSource1\tSource2\tLineName\tRemark1");
        out.newLine();
		try{
			rs=db.executeQuery(sql);			
			while(rs.next()){
				for(int i=1;i<7;i++){
				al1.add(rs.getString(i));
				out.write(rs.getString(i)+"\t");
				//System.out.println(rs.getString(i));
				}
				out.newLine();
			}
			out.flush();
			
			
		}catch(Exception e){
			System.out.println(e.toString());
			return ERROR;
		}  
		attribute.put("al", al1);
		return SUCCESS;
	}



	

}	
	
