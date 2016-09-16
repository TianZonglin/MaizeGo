package graph;



import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;


import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("serial")
public class Leastroad extends ActionSupport{
	
	String firstnode;
	String secondnode;
	public String getFirstnode() {
		return firstnode;
	}
	public void setFirstnode(String firstnode) {
		this.firstnode= firstnode;
	}
	public String getSecondnode() {
		return secondnode;
	}
	public void setSecondnode(String secondnode) {
		this.secondnode= secondnode;
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
	    public static int INFINITY = 90000;
	    /*
	     * 哈希表存储结构HashMap<key,value>形式
	     */
	    public static Map<String,Vertex> vertexMap = new HashMap<String,Vertex>();
	   
	    /*
	     * 存储边信息
	     * 包含目的结点和cost值以及id值
	     */
	    static class Edge{
	        public Vertex dest;
	        public double cost;
	        public int id;//边的id
	        public Edge(int id,Vertex d,double c){
	            this.dest = d;
	            this.cost = c;
	            this.id=id;
	        }
	        
	    }
	    /*
	     * 可以比较大小的静态类
	     */
	    static class Vertex implements Comparable<Vertex>{
	        public String name;//结点名字
	        public List<Edge> adj;//邻接边的信息
	        public double dist;
	        public Vertex prev;//前驱结点
	        public double values;//前驱结点到该结点的值
	        public int id;//前驱结点到该结点的id
	        public boolean visited;//是否被访问
	        public Vertex(String nm){
	            this.name = nm;
	            adj = new ArrayList<Edge>();
	            reset();
	        }
	        public void reset(){
	            visited = false;
	            dist=9000;
	        }
	        public int compareTo(Vertex o) {
	            double c = o.dist;
	            
	            return dist < c ? -1:dist > c ? 1:0;
	        }
	        
	    }
	    
	    public static void dijkstra(String startName,String endName){
	        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();//该队列以权值升序排列，因为Vertex实现Comparable接口
	        Vertex start = vertexMap.get(startName);
	        start.dist = 0;
	        for(Vertex v:vertexMap.values())
	            pq.add(v);
	        int seenNum = 0;
	        while(!pq.isEmpty()&&seenNum < vertexMap.size()){
	            Vertex v = pq.remove();
	            if(v.name.equals(endName))
	            {
	               System.out.println(startName+"--->"+endName+":."+v.dist);
	            break;
	            }
	            if(v.visited)
	                continue;
	            v.visited= true;
	            seenNum++;
	            for(Edge e:v.adj){ 
	                Vertex w = e.dest;
	                double v_to_w = e.cost;
	                if(w.dist > v.dist + v_to_w){
	                    w.dist = v.dist + v_to_w;
	                    w.prev = v;
	                    w.values=v_to_w;
	                    w.id=e.id;
	                    pq.remove(w);//出队
	                    pq.add(w);//按优先级插在队头，先插入的在队头，依次往后
	                    
	                }
	            }
	        }
	    }
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		ArrayList  result=new ArrayList();
		DbBean db=new DbBean();
		ResultSet rs = null;	
		Vertex e,e1;
		int columnCount;
		String path=getWebRoot();
        String newpath=path+"file/seed_info.txt";
		
		FileOutputStream fos = new FileOutputStream(newpath);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter out = new BufferedWriter(osw);
        out.write("ID"+"\t"+"first"+"\t"+"second"+"\t"+"value"+"\t");
        out.newLine();
		try{
		Map attributes =ActionContext.getContext().getSession();
		if(firstnode.equals(secondnode))
		{
			return "SUC";
		}
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
		    	 if(vertexMap.get(rs.getString(3))!=null)
		    	 {
		    		   e1=vertexMap.get(rs.getString(3));
		    	 }
		    	 else  
		    	 {
		    		 e1=new Vertex(rs.getString(3));
		    		 vertexMap.put(rs.getString(3),e1);
		    	 }
		         e.adj.add(new Edge(Integer.parseInt(rs.getString(1)),e1,Double.parseDouble(rs.getString(4))));
		     }
	        /*
	         * 添加所有的结点，为每个结点添加邻接边，邻接边信息储存在List中间
	         * 创建目的结点
	         *  将各个结点采用<key,value>形式保存在HashMap,提高效率
	         *  结点信息保存完毕，开始dijkstra算法
	         */
	    dijkstra(firstnode,secondnode);
	    e=vertexMap.get(firstnode);
	    e1=vertexMap.get(secondnode);
	    while(e1.prev!=e)
	    {
	    	result.add(Double.toString(e1.values));
	    	result.add(e1.name);
	    	result.add(e1.prev.name);
	    	result.add(Integer.toString(e1.id));
	    	out.write(Integer.toString(e1.id)+"\t"+e1.prev.name+"\t"+e1.name+"\t"+e1.values);
	    	out.newLine();
	    	e1=e1.prev;
	    }
	    result.add(Double.toString(e1.values));
    	result.add(e1.name);
    	result.add(e1.prev.name);
    	result.add(Integer.toString(e1.id));
    	out.write(Integer.toString(e1.id)+"\t"+e1.prev.name+"\t"+e1.name+"t"+e1.values);
	    /*for(int i=result.size()-1;i>=0;i--)
	    {
	    	System.out.println(result.get(i)+"  ");
	    }*/
    	
    	/*
    	 * result格式是(secondnode,value,prenode,value——firstnode)
    	 */
    	String show="From"+"  "+firstnode+"  "+"To"+"  "+secondnode+"\n"+"The Least Cost Is : "+vertexMap.get(secondnode).dist;
    	out.flush();
	    if(result.size()==0) return ERROR;
	    attributes.put("show",show);
		attributes.put("result",result);
		attributes.put("columnCount",columnCount);
		return SUCCESS;
	}catch(Exception e3)
	{
		System.err.println(e3.toString());
		return ERROR;
	}
	finally 
	{
		db.close();
	}
	}	
}

