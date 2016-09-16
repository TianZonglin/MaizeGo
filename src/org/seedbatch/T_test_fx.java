package org.seedbatch;

import org.email.Email;
import org.util.DbBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;



public class T_test_fx extends ActionSupport{
	 
	String select1;
	String select2;	
	String choose2;
	String choose1;
 
	 
	public String getSelect1() {
		return select1;
	}

	public void setSelect1(String select1) {
		this.select1 = select1;
	}
	
	public String getSelect2() {
		return select2;
	}

	public void setSelect2(String select2) {
		this.select2 = select2;
	}
	
	public String getChoose1() {
		return choose1;
	}

	public void setChoose1(String choose1) {
		this.choose1 = choose1;
	}
	
	public String getChoose2() {
		return choose2;
	}

	public void setChoose2(String choose2) {
		this.choose2 = choose2;
	}
	
	
	 
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
        
		Map attribute=ActionContext.getContext().getSession();
		
		ArrayList<String> trait_all = (ArrayList)attribute.get("rs1");
		
		//ArrayList<String> choose1 = (ArrayList)attribute.get("choose1");
 
		String select_1=select1;
		String select_2=select2;
		//String table=(String) attribute.get("table");
		DbBean db=new DbBean();
		
		//ArrayList<String> trait_all = new ArrayList();
		ArrayList<String> trait_in  = new ArrayList(); 
		ArrayList<String> ch_field  = new ArrayList(); 
		ArrayList<String> t_table   = new ArrayList(); 
		ArrayList<String> pat_field   = new ArrayList(); 
		/*String[] term = new String[choose1.size()];
        for(int i=0;i<choose1.size();i++)
        {
           term[i] = choose1.get(i);
           term[i] = term[i].replaceAll("_","");
           System.out.println("1: "+term[i]);
        }*/
        String term1 = choose1;
		term1 = term1.replace(' ',',');
		System.out.println("3: "+term1);
        String[] data1 = term1.split(",,");
		for(int k=0;k<data1.length;k++)
		{
			if(data1[k].contains("_"))
			{
				data1[k] = data1[k].replace("_","");			
			}
			ch_field.add(data1[k]);
		}
		for(int i=0;i<ch_field.size();i++)System.out.println("#111111111111111111111111111111111111   #"+ch_field.get(i));
        
		
		String term2 = choose2;
		term2 = term2.replace(' ',',');
		System.out.println("3: "+term2);
        String[] data2 = term2.split(",,");
		for(int k=0;k<data2.length;k++)
		{
			if(data2[k].contains("_"))
			{
				data2[k] = data2[k].replace("_","");			
			}
			pat_field.add(data2[k]);
		}
		for(int i=0;i<pat_field.size();i++)System.out.println("#0000000000000000000000000   #"+pat_field.get(i));
		
	
		
		
		
		//System.out.println("--------1---------"+select_1);
		//System.out.println("--------2---------"+select_2);
		
		for(int i=0;i<trait_all.size();i++)
		{//System.out.println("1111111111  "+trait_all.get(i));
		
		 if(select_1.equals(trait_all.get(i)))
		   {//System.out.println("2222222222");
		       for(int k=i;k<trait_all.size();k++)
		       {//System.out.println("333333333");
			       trait_in.add(trait_all.get(k));
		           if(select_2.equals(trait_all.get(k)))break;
			   }
		   }   
		} 
		for(int i=0;i<trait_in.size();i++)System.out.println("#111111   #"+trait_in.get(i)+"#111111   #"+trait_in.size());
	    
		
		
		for(int i=0;i<trait_in.size();i++)
		{
			for(int k=0;k<ch_field.size();k++)
			{
				String sql1 = "select "+ch_field.get(k)+" from chr1_merged_all_snp where pos='"+trait_in.get(i)+"'";
				ResultSet rs1=db.executeQuery(sql1);
		    	while(rs1.next()){
		    		t_table.add(rs1.getString(1));
		    	}
			}
		}
		for(int i=0;i<t_table.size();i++)System.out.println("#111111   #"+t_table.get(i)+"#111111   #"+t_table.size());
		
		
		
		
		
		ArrayList<String> T  = new ArrayList();
		ArrayList<String> lie_2  = new ArrayList();
		int hang = trait_in.size();
		int lie  = ch_field.size();
		
		
		
		for(int i= 0; i<hang; i++)
		{ 
			ArrayList<String> Tarr_x  = new ArrayList();
			ArrayList<String> Tarr_y  = new ArrayList();
			ArrayList<String> Tarr_z  = new ArrayList();//the mark -- only for to classify
			ArrayList<Integer> n1      = new ArrayList();
			ArrayList<Integer> n2      = new ArrayList();

			ArrayList cc  = new ArrayList();
			String str = t_table.get(i*lie);
			int x =0;
			for(int k = i*lie; k<(i+1)*lie; k++)
			{ 
				 
				if(t_table.get(k).equals(str))
				{
					Tarr_x.add(t_table.get(k));
					n1.add(x);
				}
				else 
				{
					Tarr_y.add(t_table.get(k));
					n2.add(x);
					 
				}
				x++;
			}
			
			
			if(Tarr_y.size()!=0)
			{	
				String str1 = Tarr_y.get(0);
				for(int k = 0;k < Tarr_y.size(); k++)
				{
					if(Tarr_y.get(k).equals(str1))continue;
					else  Tarr_z.add(Tarr_y.get(k));	
				}
				System.out.println("-------------------------------------------------------------Tarr_z.size()-------"+Tarr_z.size());
			}
			
			
			

			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			if(Tarr_x.size()!=0 && Tarr_y.size()!=0&&Tarr_z.size()==0)
			{ 
				System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			    lie_2.add(trait_in.get(i));
				System.out.println("-------------------------------------------     "+lie_2.get(0));
				for(int ii=0;ii<Tarr_x.size();ii++)System.out.println("--------Tarr_x------------"+Tarr_x.get(ii)+"---"+n1.get(ii)+"----------");
			    for(int ii=0;ii<Tarr_y.size();ii++)System.out.println("--------Tarr_y------------"+Tarr_y.get(ii)+"---"+n2.get(ii)+"----------");
			    for(int j = 0;j< pat_field.size(); j++)
			    {
			    	System.out.println("11111111111111111111111111");
			    	ArrayList Array_1  = new ArrayList();
			    	ArrayList Array_2  = new ArrayList();
			    	for(int k =0;k < Tarr_x.size(); k++)
			    	{
			    		System.out.println("22222222222222222222222222");
			    		String sql1 = "select "+pat_field.get(j)+" from phenoype_agri_traits where Trait = '"+ch_field.get(n1.get(k).intValue())+"';";
			    		System.out.println("select "+pat_field.get(j)+" from phenoype_agri_traits where Trait = '"+ch_field.get(n1.get(k).intValue())+"';");
			    		ResultSet rs1 =  db.executeQuery(sql1);
			    		while(rs1.next()){
			    			Array_1.add(rs1.getString(1));
			    		}					
			    	}
			    	//for(int ii=0;i<Array_1.size();ii++)System.out.println("----------------------"+Array_1.get(ii));
			    	for(int k =0;k < Tarr_y.size(); k++)
			    	{
			    		System.out.println("333333333333333333333333333");
			    		String sql2 = "select "+pat_field.get(j)+" from phenoype_agri_traits where Trait = '"+ch_field.get(n2.get(k).intValue())+"';";
			    		System.out.println("select "+pat_field.get(j)+" from phenoype_agri_traits where Trait = '"+ch_field.get(n2.get(k).intValue())+"';");
			    		ResultSet rs2 =  db.executeQuery(sql2);
			    		while(rs2.next()){
			    			Array_2.add(rs2.getString(1));
			    		}					
			    	}
			    	//for(int ii=0;i<Array_2.size();ii++)System.out.println("**********************"+Array_2.get(ii));

			    	System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
				   
				   
					for(int ii=0;ii<Array_1.size();ii++){System.out.println("**********************"+Array_1.get(ii)); }
					for(int ii=0;ii<Array_2.size();ii++){System.out.println("----------------------"+Array_2.get(ii)); }
				
					
					//start calculate
					float suma = 0;
					float sumb = 0;
					for(int ii=0;ii<Array_1.size();ii++){suma+=Float.parseFloat((String)Array_1.get(ii));}
					//对x1求和  
					for(int ii=0;ii<Array_2.size();ii++){sumb+=Float.parseFloat((String)Array_2.get(ii));}
					//对x2求和
					float avga=suma/(Array_1.size());//x1平均值
					float avgb=sumb/(Array_2.size());//x2平均值
				System.out.println("x1  x2 ---  "+avga+" "+avgb);
					float hea=0;
					float heb=0;
				    for(int ii=0;ii<Array_1.size();ii++)//x1差后求和
				    	{hea+=(Float.parseFloat((String)Array_1.get(ii))-avga)*(Float.parseFloat((String)Array_1.get(ii))-avga);}
				    for(int ii=0;ii<Array_2.size();ii++)//x2差后求和
				    	{heb+=(Float.parseFloat((String)Array_2.get(ii))-avgb)*(Float.parseFloat((String)Array_2.get(ii))-avgb);}
				System.out.println("hea  heb ---  "+hea+" "+heb);
				    float fenzi=hea+heb;//分子
				    float fenmu=(Array_1.size()-1)+(Array_2.size()-1);//分母
				System.out.println("fenzi  fenmu ---  "+fenzi+" "+fenmu);
				    float qianmian=fenzi/fenmu;//前一个分式
				    float houmian=(float)1/Array_1.size()+(float)1/Array_2.size();//后一个分式
				System.out.println("1/Array_1.size()  1/Array_2.size() ---  "+Array_1.size()+" "+Array_2.size()+" ");
					float limian=qianmian*houmian;//开方前
					float S=(float) Math.sqrt(limian);//S（x1-x2）
				
					float t=(avga-avgb)/S;
					T.add(String.valueOf(t));
				 	}
			    	for(int ii=0;ii<T.size();ii++)System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@   "+T.get(ii)+"   @@"); 
				}
				
			}  //此循环for(i= 0; i<hang; i++)结束
		
		
		
		
	
		attribute.put("count",ch_field.size());
		attribute.put("select_1",select_1); //choose1
    	attribute.put("select_2",select_2); //choose1
    	attribute.put("t_table",t_table); //choose1
    	attribute.put("t_lie",ch_field); //choose1
    	attribute.put("t_hang",trait_in); //choose1
    	attribute.put("pat_field",pat_field);
    	attribute.put("t_hang",trait_in);
    	attribute.put("lie_2",lie_2);
    	attribute.put("T",T);
    	//int a = (Integer)attribute.get("count");
    	System.out.print("*******************************************"+t_table.get(1)+"***********");
    	
    	try{
    	 
        }catch(Exception e){
	        System.out.print("--------T-test-error------"+e.toString());
	       return ERROR;
	    } 
        return SUCCESS;       
	}
}
	
