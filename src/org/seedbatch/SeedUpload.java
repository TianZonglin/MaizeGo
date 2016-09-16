package org.seedbatch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;


import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SeedUpload extends ActionSupport{

	private  File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String tablename;
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}


	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	private  List<String> getXlsData() throws IOException, FileNotFoundException
	{

		Map attribute=ActionContext.getContext().getSession();
		List<String> list = new ArrayList<String>();
		//String e=upload.replace("\\","/");
		try{
			XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(upload));
			//String tablename=book.getSheetName(0);
	        attribute.put("tablename", uploadFileName);
				for(int i=0;i<book.getNumberOfSheets();i++){
					XSSFSheet sheet = book.getSheetAt(i);
					for(int rowIndex =0;rowIndex<sheet.getLastRowNum();rowIndex++){
					   XSSFRow row= sheet.getRow(rowIndex);
					   String line ="";		
					   for(int colIndex=0;colIndex<row.getLastCellNum();colIndex++){
					       line += row.getCell(colIndex)==null?"--":row.getCell(colIndex).toString()+";";
				      }
				      System.out.println(line);
				      if(!line.equals("")) list.add(line);
					   }
				}
		}catch(Exception e){
			e.printStackTrace();
			HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(upload));
			//tablename=book.getSheetName(0);
	        attribute.put("tablename", uploadFileName);
	        System.out.println(tablename);
			for(int i=0;i<book.getNumberOfSheets();i++){
			HSSFSheet sheet = book.getSheetAt(i);
			   for(int rowIndex =0;rowIndex<sheet.getLastRowNum();rowIndex++){
			   HSSFRow row= sheet.getRow(rowIndex);
			   String line ="";		
			      for(int colIndex=0;colIndex<row.getLastCellNum();colIndex++){
			          line += row.getCell(colIndex)==null?"--":row.getCell(colIndex).toString()+";";
			      }
			      if(!line.equals("")) list.add(line);
			   }
			}			
			
		}
		
		
		
		
		return list;
  }		
	
	public String execute() throws FileNotFoundException, IOException
	{

		System.out.println("seedwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww1");
 		Map attribute1=ActionContext.getContext().getSession();
		DbBean db=new DbBean();
		try
		{   System.out.println("seedwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2");
			List<String> list = getXlsData();
			System.out.println("seedwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4");
			String title=list.get(0);//获取表的第一行 属性
			String [] str=title.split(";");
			String c=" char(100)";
			String a="";
			for(int i=0;i<str.length-1;i++)
			{
				a+=str[i]+c+",";
			}
			a+=str[str.length-1]+c;//解决最后一个逗号问题
            String createtable_sql="create table `"+uploadFileName+"` ("+a+");";
            try 
            {
    			//Statement statement = db.conn.createStatement();
        	   // statement.executeUpdate(createtable_sql);//执行create语句
            	db.executeUpdate(createtable_sql);
        	    System.out.println("success");
        	} catch (SQLException e) {
        	    e.printStackTrace();
        	}            

            list.remove(0);
            for(String line : list)//String list[1][0]
			{
            	String content=line;
				String [] b=content.split(";");
				String d="";
				for(int k=0;k<b.length-1;k++)
				{
				    d+="'"+b[k]+"'"+",";
				}
				d+="'"+b[b.length-1]+"'";				
				String e="";
				for(int x=0;x<str.length-1;x++)
				{
				    e+="`"+str[x]+"`"+",";
				}
				e+="`"+str[str.length-1]+"`";
			
				String insert_sql="insert into `"+uploadFileName+"` ("+e+")values("+d+");";
				System.out.println(insert_sql);				
				Statement statement2 = db.conn.createStatement();        	     
	        	    statement2.executeUpdate(insert_sql);//执行insert
	        	    System.out.println("success");
	        	    statement2.close();  
			}
            db.close();
	    	return SUCCESS;
    	}
	    catch(Exception e)
	    {
	    	 db.close();
	    	e.printStackTrace();
    		return ERROR;
    	}
	}
	
}


