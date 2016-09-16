package graph;

import graph.Leastroad.Vertex;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Relationresult extends ActionSupport{
	
	String relationnode;
	int floor;
	double value;
	public String getRelationnode() {
		return relationnode;
	}
	public void setRelationnode(String relationnode) {
		this.relationnode= relationnode;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = Integer.parseInt(floor);
	}
	public int getValue() {
		return floor;
	}
	public void setValue(String value) {
		this.value =Double.parseDouble(value);
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
        int i,j,columnCount,location,fomersize,sumNode=0;
		DbBean db=new DbBean();
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<String> select=new ArrayList<String>();
		Map<String,String> nodeMap = new HashMap<String,String>();
		boolean visited[];
		visited=new boolean[1000000];
		ResultSet rs = null;
		String path=getWebRoot();
        String newpath=path+"file/seed_info.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        out.write("ID"+"\t"+"first"+"\t"+"second"+"\t"+"value"+"\t");
        out.newLine();
		try{
		Map attributes =ActionContext.getContext().getSession();
		String sql="select * from `expression`;";
		rs=db.executeQuery(sql);
		columnCount=rs.getMetaData().getColumnCount();
		location=0;
		/*
		 * 一级关联 
		 */
		while(rs.next())
		{
			visited[Integer.parseInt(rs.getString(1))]= false;
			if(rs.getString(2).equals(relationnode))
			{
				visited[Integer.parseInt(rs.getString(1))]= true;
				if(Double.parseDouble(rs.getString(4))>value)
				{
				for(i=1;i<=columnCount;i++)
		        {
                     result.add(rs.getString(i));
                     out.write(rs.getString(i)+"\t");
			    }
				out.newLine();
				}
			    if(nodeMap.get(relationnode)==null)
			    {
				   nodeMap.put(relationnode,"true");
				   sumNode++;
			    }
			    select.add(rs.getString(3));
			    sumNode++;
			    nodeMap.put(rs.getString(3),"true");
			}
	    }
		for(j=2;j<=floor;j++)
		{
			fomersize=select.size();
			for(;location<fomersize;location++)
			{
			rs=db.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getString(2).equals(select.get(location))&& visited[Integer.parseInt(rs.getString(1))]==false)
				{
					visited[Integer.parseInt(rs.getString(1))]=true;
					if(Double.parseDouble(rs.getString(4))>value)
					{
					for(i=1;i<=columnCount;i++)
			        {
	                     result.add(rs.getString(i));
	                     out.write(rs.getString(i)+"\t");
				    }
					out.newLine();
					select.add(rs.getString(3));
				    if(nodeMap.get(rs.getString(3))==null&&j<floor)
				    {
					   nodeMap.put(rs.getString(3),"true");
					   sumNode++;
				    }
					}
				 }
		    }
		    }
		}
		String show="Node  :  "+relationnode+"  "+"Level  :  "+floor+"  "+"Value  :  "+value;
		out.flush();
		/*
		 * 总结点个数
		 */
		//System.out.println(sumNode);
		attributes.put("sumNode",sumNode);
		/*
		 * result是最后结果，格式是(id,first,second,value)
		 * columnCount是列数，columnCount=4;
		 */
		attributes.put("show",show);
		attributes.put("result",result);
		attributes.put("columnCount",columnCount);
		if(result.size()==0){return ERROR;}
		return SUCCESS;
	}catch(Exception e)
	{
		System.err.println(e.toString());
		return ERROR;
	}
	finally 
	{
		db.close();
	}
	}
}
