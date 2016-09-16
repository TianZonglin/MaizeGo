package graph;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import org.util.DbBean;

import antlr.collections.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RelationresultHashtable extends ActionSupport{
	
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
	/*
     * 哈希表存储结构Hashtable<key,value>形式
     */
    public static Map<String,Vertex> vertexMap = new Hashtable<String,Vertex>();
    static class Data{
        public int id;
        public String second;
        public double value;
        public Data(int id,String second,double value){
            this.id=id;
            this.second=second;
            this.value=value;
        }
       }
    static class Vertex{
        public String firstname;
        public ArrayList<Data> data;
        public boolean visited=false;//是否被访问
        public Vertex(String firstname){
            this.firstname=firstname;
            data=new ArrayList<Data>();
        }
       }
    
    
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
        int i,j,columnCount,fomersize,location,sumNode=0;
		DbBean db=new DbBean();
		ArrayList<String> result=new ArrayList<String>();
		ArrayList<String> select=new ArrayList<String>();
		ResultSet rs = null;
		Vertex e;
		String path=getWebRoot();
        String newpath=path+"file/seed_info.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        out.write("ID"+"\t"+"first"+"\t"+"second"+"\t"+"value"+"\t");
        out.newLine();
		try{
		Map attributes =ActionContext.getContext().getSession();
		String sql="select * from `graph`;";
		rs=db.executeQuery(sql);
		columnCount=rs.getMetaData().getColumnCount();
		while(rs.next())
		{
			if(vertexMap.get(rs.getString(2))!=null)
	    	 {
	    	       e=vertexMap.get(rs.getString(2));
	    	 }
			else
			{
				   e=new Vertex(rs.getString(2));
	    		   vertexMap.put(rs.getString(2),e);
			}
			e.data.add(new Data(Integer.parseInt(rs.getString(1)),rs.getString(3),Double.parseDouble(rs.getString(4))));
		}
		/*
		 * 一级关联
		 */
		e=vertexMap.get(relationnode);
		e.visited=true;
		for(i=0;i<e.data.size();i++)
		{
			if(e.data.get(i).value>value)
			{
			result.add(e.data.get(i).id+"");
			result.add(e.firstname);
			result.add(e.data.get(i).second);
			result.add(e.data.get(i).value+"");
			select.add(e.data.get(i).second);
			sumNode++;
			out.write(e.data.get(i).id+"\t"+e.firstname+"\t"+e.data.get(i).second+"\t"+e.data.get(i).value);
			}
			out.newLine();
		}
		location=0;
		for(j=2;j<=floor;j++)
		{
			fomersize=select.size();
			for(;location<fomersize;location++)
			{
				e=vertexMap.get(select.get(location));
				if(!e.visited)
				{
				for(i=0;i<e.data.size();i++)
				{
					if(e.data.get(i).value>value )
					{
					result.add(e.data.get(i).id+"");
					result.add(e.firstname);
					result.add(e.data.get(i).second);
					result.add(e.data.get(i).value+"");
					select.add(e.data.get(i).second);
					out.write(e.data.get(i).id+"\t"+e.firstname+"\t"+e.data.get(i).second+"\t"+e.data.get(i).value);
					if(j<floor) sumNode++;
					}
					out.newLine();
				}
			    }
				e.visited=true;
			}
		}
		if(sumNode!=0)  sumNode++;
		//System.out.print(sumNode);
		/*for( i=0;i<result.size()/columnCount;i++)
        { 				          	         
		for(j=0;j<columnCount;j++)
        { 	
        System.out.print(result.get(columnCount*i+j)+"   ");
		}
		System.out.println();
		}*/
		out.flush();
		attributes.put("sumNode", sumNode);
		attributes.put("result",result);
		attributes.put("columnCount",columnCount);
		return SUCCESS;
	}catch(Exception e1)
	{
		System.err.println(e1.toString());
		return ERROR;
	}
	finally 
	{
		db.close();
	}
    }
}


