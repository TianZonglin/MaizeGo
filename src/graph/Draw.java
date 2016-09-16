package graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Draw extends ActionSupport{
	
	String list1;
	String list2;
	String list3;
	String list4;
	
	public String getList4() {
		return list4;
	}
	public void setList4(String list4) {
		this.list4 = list4;
	}
	public String getList1() {
		return list1;
	}
	public void setList1(String list1) {
		this.list1= list1;
	}
	public String getList2() {
		return list2;
	}
	public void setList2(String list2) {
		this.list2= list2;
	}
	public String getList3() {
		return list2;
	}
	public void setList3(String list3) {
		this.list3= list3;
	}
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		
		System.out.println("data1:"+list1);
		//System.out.println("data2:"+list2);
		//System.out.println("data3:"+list3);
		
	    int i;
		Map attribute =ActionContext.getContext().getSession();
		//int node1=0,node2=0,node3=0,node12=0,node23=0,node13=0,node123=0;//统计节点个数
/*		list1=list1.replace('\n', ',');
		list2=list2.replace('\n', ',');
		list3=list3.replace('\n', ',');
		list1=list1.replace('\r', ',');
		list2=list2.replace('\r', ',');
		list3=list3.replace('\r', ',');		
		System.out.println("data1:"+list1);*/
		//System.out.println("data2:"+list2);
		//System.out.println("data3:"+list3);		
		
		
		String[] data1 = list1.split("\r\n");
		String[] data2 = list2.split("\r\n");
		String[] data3 = list3.split("\r\n");
		String[] data4 = list4.split("\r\n");
		/*
		 * 将节点存到Map结构中，以便查询相同节点信息
		 */
/*		Map<String,String> datamap1=new HashMap<String,String>();
		Map<String,String> datamap2=new HashMap<String,String>();
		Map<String,String> datamap3=new HashMap<String,String>();
		Map<String,String> datamap4=new HashMap<String,String>();*/
		/*
		 * 将相同节点保存在ArrayList结构中
		 */
/*		ArrayList<String>  Node1=new ArrayList<String>();
		ArrayList<String>  Node2=new ArrayList<String>();
		ArrayList<String>  Node3=new ArrayList<String>();
		ArrayList<String>  Node12=new ArrayList<String>();
		ArrayList<String>  Node13=new ArrayList<String>();
		ArrayList<String>  Node23=new ArrayList<String>();
		ArrayList<String>  Node123=new ArrayList<String>();*/

		
		
		TreeSet<String>  Node1 = new TreeSet<String>();
		TreeSet<String>  Node2=new TreeSet<String>();
		TreeSet<String>  Node3=new TreeSet<String>();
		TreeSet<String>  Node4=new TreeSet<String>();
		TreeSet<String>  Node12=new TreeSet<String>();
		TreeSet<String>  Node13=new TreeSet<String>();
		TreeSet<String>  Node14=new TreeSet<String>();
		TreeSet<String>  Node23=new TreeSet<String>();
		TreeSet<String>  Node24=new TreeSet<String>();
		TreeSet<String>  Node34=new TreeSet<String>();
		TreeSet<String>  Node123=new TreeSet<String>();		
		TreeSet<String>  Node124=new TreeSet<String>();		
		TreeSet<String>  Node134=new TreeSet<String>();		
		TreeSet<String>  Node234=new TreeSet<String>();		
        TreeSet<String>  Node1234=new TreeSet<String>();		
		
		
		
		
		String str="hello,world";
	    
		/*
		 * 将节点存入Map
		 */
		for(i=0;i<data1.length;i++)
		{
		//	datamap1.put(data1[i], "true");
			Node1.add(data1[i]);
		}
	//	System.out.println(Node1.toString());
		for(i=0;i<data2.length;i++)
		{
		//	datamap2.put(data2[i], "true");
			Node2.add(data2[i]);
		}
		for(i=0;i<data3.length;i++)
		{
			//datamap3.put(data3[i], "true");
			Node3.add(data3[i]);
		}
		for(i=0;i<data4.length;i++)
		{
			//datamap3.put(data3[i], "true");
			Node4.add(data4[i]);
		}		
		/*
		 * 找寻相同节点
		 */
	/*	for(i=0;i<data1.length;i++)
		{
			if(datamap2.get(data1[i])!=null) {node12+=1;Node12.add(data1[i]);}
		}
		
	
		for(i=0;i<data1.length;i++)
		{
			if(datamap3.get(data1[i])!=null) {node13+=1;Node13.add(data1[i]);}
		}
	
		
		for(i=0;i<data2.length;i++)
		{
			if(datamap3.get(data2[i])!=null) {node23+=1;Node23.add(data2[i]);}
		}
		
		
		for(i=0;i<data3.length;i++)
		{
			if(datamap1.get(data3[i])!=null&&datamap2.get(data3[i])!=null) {node123+=1;Node123.add(data3[i]);}
		}
*/
		TreeSet temp_set = new TreeSet();
		for(String temp:Node1){
			if(Node2.contains(temp)){
				Node12.add(temp);
				temp_set.add(temp);
				Node2.remove(temp);
			}
			if(Node3.contains(temp)){
				Node13.add(temp);
				temp_set.add(temp);
				Node3.remove(temp);
			}
			if(Node4.contains(temp)){
				Node14.add(temp);
				temp_set.add(temp);
				Node4.remove(temp);
			}
		}
		Node1.removeAll(temp_set);
		
		
		
		temp_set.clear();
		for(String temp:Node2){			
			if(Node3.contains(temp)){
				Node23.add(temp);
				temp_set.add(temp);
				Node3.remove(temp);
			}
			if(Node4.contains(temp)){
				Node24.add(temp);
				temp_set.add(temp);
				Node4.remove(temp);
			}
			
		}	
		Node2.removeAll(temp_set);
		
		temp_set.clear();
		for(String temp:Node3){
			if(Node4.contains(temp)){
				Node34.add(temp);
				temp_set.add(temp);
				Node4.remove(temp);
			}
		}
		Node3.removeAll(temp_set);
		
		temp_set.clear();
		for(String temp:Node12){
			if(Node13.contains(temp)){
				Node123.add(temp);
				temp_set.add(temp);
				Node13.remove(temp);
				Node23.remove(temp);
			}
			if(Node14.contains(temp)){
				Node124.add(temp);
				temp_set.add(temp);
				Node14.remove(temp);
				Node24.remove(temp);
			}
			
		}	
		Node12.removeAll(temp_set);
		
		
		
		
		temp_set.clear();
		for(String temp:Node13){			
			if(Node14.contains(temp)){
				Node134.add(temp);
			    temp_set.add(temp);
				Node14.remove(temp);
				Node34.remove(temp);
			}
	
		}
		Node13.removeAll(temp_set);
		
		
		
		temp_set.clear();
		for(String temp:Node23){			
			if(Node24.contains(temp)){
				Node234.add(temp);
				temp_set.add(temp);
				Node24.remove(temp);
				Node34.remove(temp);
			}
	
		}			
		Node23.removeAll(temp_set);
		
		
		temp_set.clear();
		for(String temp:Node123){
			if(Node124.contains(temp)){
				Node1234.add(temp);
				temp_set.add(temp);
				Node124.remove(temp);
				Node134.remove(temp);
				Node234.remove(temp);
			}
	
		}	
		Node123.removeAll(temp_set);
		
		
		System.out.println(Node1.toString());
		System.out.println(Node2.toString());
		System.out.println(Node3.toString());
		System.out.println(Node4.toString());
		/*System.out.println(node12);
		System.out.println(node13);
		System.out.println(node23);
		System.out.println(node123);*/
		
/*		node1=data1.length-node12-node13+node123;
		node2=data2.length-node12-node23+node123;
		node3=data3.length-node13-node23+node123;
		node12=node12-node123;
		node13=node13-node123;
		node23=node23-node123;*/
		
		/*
		 * 将相同节点保存在Nodes中
		 */
		
/*		 String Nodes12="";
		 String Nodes13="";
		 String Nodes23="";
		 String Nodes123="";
		 for(i=0;i<Node12.size();i++)
		 {
			 Nodes12+=Node12.get(i);
		 }
		 Nodes12=Nodes12.replace('\n', ',');
		 System.out.println(Nodes12);
		 
		 for(i=0;i<Node13.size();i++)
		 {
			 Nodes13+=Node13.get(i);
		 }
		 Nodes13=Nodes13.replace('\n', ',');
		 System.out.println(Nodes13);
		 
		 for(i=0;i<Node23.size();i++)
		 {
			 Nodes23+=Node23.get(i);
		 }
		 Nodes23=Nodes23.replace('\n', ',');
		 System.out.println(Nodes23);
		 
		 for(i=0;i<Node123.size();i++)
		 {
			 Nodes123+=Node123.get(i);
		 }
		Nodes123=Nodes123.replace('\n', ',');*/
	// System.out.println(Nodes123);
/*		System.out.println("data1:"+data1[0]+"%"+data1[1]+"%"+data1[2]);
		System.out.println("data2:"+list2);
		System.out.println("data3:"+list3);
	    System.out.println("node123:"+node123);	*/	 
	//	attribute.put("str", str);
	//	attribute.put("Nodes12", Nodes12);
	//	attribute.put("Nodes13", Nodes13);
	//	attribute.put("Nodes23", Nodes23);
	//	attribute.put("Nodes123", Nodes123);
		attribute.put("node1", Node1);
		attribute.put("node2", Node2);
		attribute.put("node3", Node3);
		attribute.put("node4", Node4);
		attribute.put("node12", Node12);
		attribute.put("node13", Node13);
		attribute.put("node14", Node14);
		attribute.put("node23", Node23);
		attribute.put("node24", Node24);
		attribute.put("node34", Node34);
		attribute.put("node123", Node123);
		attribute.put("node124", Node124);
		attribute.put("node134", Node134);
		attribute.put("node234", Node234);
		attribute.put("node1234", Node1234);
		return SUCCESS;
		}
}

