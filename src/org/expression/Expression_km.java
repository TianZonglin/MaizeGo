package org.expression;

import org.util.DbBean;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public class Expression_km extends ActionSupport{
	private String inputdata;
	
	
	
	public String getInputdata() {
		return inputdata;
	}

	public void setInputdata(String inputdata) {
		this.inputdata = inputdata;
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

    public String execute() throws Exception{
    	Map attribute=ActionContext.getContext().getSession();
    	DbBean db=new DbBean();
    	ArrayList<String> datas=new ArrayList<String>();
    	ArrayList<String> field=new ArrayList<String>();
    	
		String term=inputdata;
		term=term.replace('\n', ',');
		System.out.println("2: "+term);
		term=term.replace('\t', ',');
		System.out.println("3: "+term);
		term=term.replace('\u0008', ',');
		System.out.println("4: "+term);
		term=term.replace('\r', ',');
		for(int g=0;g<10;g++)term=term.replace("  "," ");
        System.out.println("5: "+term);
        term=term.replace(' ', ',');
        for(int g=0;g<10;g++)term=term.replace(",,",",");
        System.out.println("6: "+term);
        

        String[] data = term.split(",");
		
		for(int k=0;k<data.length;k++)
		{
			System.out.println("#xx#"+data[k]);
			datas.add(data[k]);                                          //所输入的种子名   name_list
		}

		
	   	String sql="select * from `table 75` where  GeneID='"+datas.get(0)+"'";
    	for(int i=1;i<datas.size();i++){
    		sql+="or GeneID='"+datas.get(i)+"' ";
    	}
		
    	String sql0="show fields from `table 75`;";
    	ResultSet rs0=db.executeQuery(sql0);
    	
    	
    	
    	while(rs0.next()){
    		field.add(rs0.getString(1));
    		
    	}
    	
    	
    	
    	
    	
		String path=getWebRoot();

		String newpath=path+"file/expression_rpkm.txt";///////////////////////////////////////
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        for(int i=0;i<field.size();i++)
        	out.write(field.get(i)+"\t");
        out.newLine();

        System.out.println(sql);
    	try{
    	ResultSet rs=db.executeQuery(sql);
    	
    	ArrayList al=new ArrayList();
    	ArrayList<String> list2=new ArrayList<String>();
    	while(rs.next()){
    		list2.add(rs.getString(1));
    		for(int i=1;i<=field.size();i++){
    			
    		     al.add(rs.getString(i));
    		     out.write(rs.getString(i)+"\t");
    		}
    		out.newLine();
    	}
      	out.flush();
      	
      	
      	
      	
    	
 
    	ArrayList<String> list1=new ArrayList<String>();
      	list1 = datas;
      	list1.removeAll(list2);
      	System.out.print("xxxxxx are : ");
      	for(int i=0;i<list1.size();i++)System.out.println("‘"+list1.get(i)+"’");
      	
      	
      	


      
      	
      	
      	attribute.put("wdata", list1);
      	attribute.put("field", field);
    	attribute.put("info",al);
    	return SUCCESS;
    	}catch(Exception e){
    		return ERROR;
    	}

    	
    }

}
