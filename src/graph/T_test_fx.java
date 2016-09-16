package graph;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class T_test_fx extends ActionSupport{
	 
	String select1;
	String select2;	
	String choose2;
	String choose1;
	String chr;
 
	 
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
	
	public String getChr() {
		return chr;
	}

	public void setChr(String chr) {
		this.chr = chr;
	}
	
	
	 
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
//	   System.out.println(select1+select2+choose1+choose2);
		DbBean db=new DbBean();
		Map attribute=ActionContext.getContext().getSession();
		
		
		
		
/*		ArrayList a1=new ArrayList();
		String sqlx="select pos from chr1_merged_all_snp";
		ResultSet rsx=db.executeQuery(sqlx);
	        while(rsx.next()){
	    		a1.add(rsx.getString(1));
	    	}

		//ArrayList<String> choose1 = (ArrayList)attribute.get("choose1");
	    ArrayList<String> trait_all = a1;
	    
	    System.out.println("---------------------------***********************----"+trait_all.size());*/
	    
		String select_1=select1;
		String select_2=select2;
		//String table=(String) attribute.get("table");
		
		
		//ArrayList<String> trait_all = new ArrayList();
 
		ArrayList<String> ch_field  = new ArrayList(); 
		ArrayList<String> ch_temp  = new ArrayList();
		ArrayList<String> t_table   = new ArrayList(); 
		ArrayList<String> pat_field   = new ArrayList(); 
		ArrayList<String> pat_temp   = new ArrayList(); 
		/*String[] term = new String[choose1.size()];
        for(int i=0;i<choose1.size();i++)
        {
           term[i] = choose1.get(i);
           term[i] = term[i].replaceAll("_","");
           System.out.println("1: "+term[i]);
        }*/
        String term1 = choose1;
		term1=term1.replace('\n', ',');
		System.out.println("2: "+term1);
		term1=term1.replace('\t', ',');
		System.out.println("3: "+term1);
		term1=term1.replace('\u0008', ',');
		System.out.println("4: "+term1);
		term1=term1.replace('\r', ',');
		for(int g=0;g<10;g++)term1=term1.replace("  "," ");
        System.out.println("5: "+term1);
        term1=term1.replace(' ', ',');
        for(int g=0;g<10;g++)term1=term1.replace(",,",",");
        System.out.println("6: "+term1);
        


        String[] data1 = term1.split(",");
		for(int k=0;k<data1.length;k++)
		{
/*			if(data1[k].contains("_"))
			{
				data1[k] = data1[k].replace("_","");			
			}*/
			ch_temp.add(data1[k]);
		}
		for(int i=0;i<ch_temp.size();i++){
			ArrayList<String> tt=new ArrayList();
			String sql = "select count(*) from information_schema.columns where  table_name='chr"+chr+"_merged_all_snp' and column_name='"+ch_temp.get(i)+"'  ";
			ResultSet r=db.executeQuery(sql);
	        while(r.next()){
	        	tt.add(r.getString(1));
	    	}
	        if(Integer.valueOf(tt.get(0))==1) ch_field.add(ch_temp.get(i));  
		}
		for(int i=0;i<ch_field.size();i++)System.out.println("ch_field-"+ch_field.get(i));
	    for(int i=0;i<ch_temp.size();i++)System.out.println("ch_temp-"+ch_temp.get(i));
		
        
		
        String term2 = choose2;
		term2=term2.replace('\n', ',');
		System.out.println("2: "+term2);
		term2=term2.replace('\t', ',');
		System.out.println("3: "+term2);
		term2=term2.replace('\u0008', ',');
		System.out.println("4: "+term2);
		term2=term2.replace('\r', ',');
		for(int g=0;g<10;g++)term2=term2.replace("  "," ");
        System.out.println("5: "+term2);
        term2=term2.replace(' ', ',');
        for(int g=0;g<10;g++)term2=term2.replace(",,",",");
        System.out.println("6: "+term2);
        


        String[] data2 = term2.split(",");
		
		for(int k=0;k<data2.length;k++)
		{
/*			if(data2[k].contains("_"))
			{
				data2[k] = data2[k].replace("_","");			
			}*/
			pat_temp.add(data2[k]);
		}
		for(int i=0;i<pat_temp.size();i++){
			ArrayList<String> tt=new ArrayList();
			String sql = "select count(*) from information_schema.columns where  table_name='phenoype_agri_traits' and column_name='"+pat_temp.get(i)+"'  ";
			ResultSet r=db.executeQuery(sql);
	        while(r.next()){
	        	tt.add(r.getString(1));
	    	}
	        if(Integer.valueOf(tt.get(0))==1) pat_field.add(pat_temp.get(i));  
		}
		for(int i=0;i<pat_field.size();i++)System.out.println("pat_field-"+pat_field.get(i));
	    for(int i=0;i<pat_temp.size();i++)System.out.println("pat_temp-"+pat_temp.get(i));
	
		
		
		
		//System.out.println("--------1---------"+select_1);
		//System.out.println("--------2---------"+select_2);
		
/*		for(int i=0;i<trait_all.size();i++)
		{//System.out.println("1111111111  "+trait_all.get(i));
		
		 if(select_1.equals(trait_all.get(i)))
		   {//System.out.println("2222222222");
		       for(int k=i;k<trait_all.size();k++)
		       {//System.out.println("333333333");
			       trait_in.add(trait_all.get(k));
		           if(select_2.equals(trait_all.get(k)))break;
			   }
		   }   
		} */

/*	//update by wangfan	
		for(int i=0;i<trait_all.size()-1;i++)
		{System.out.println("1111111111  "+trait_all.get(i));
			int temp1=Integer.parseInt(select_1);
			int temp2=Integer.parseInt(trait_all.get(i));
			int temp4=Integer.parseInt(select_2);
			if(temp1<=temp2)
			   {System.out.println("2222222222");
			       for(int k=i;k<trait_all.size()-1;k++)
			       {System.out.println("333333333");
			    	   
			    		int temp5=Integer.parseInt(trait_all.get(k));			    	
			            if(temp4<temp5)break;
			            trait_in.add(trait_all.get(k));
				   }
			       break;
			   }   
		 } 	*/	 
		int flag = 1;
		ArrayList<String> trait_in=new ArrayList();
		String sqla="select pos from chr"+chr+"_merged_all_snp where pos between "+select1+" and "+select2+"; ";
		
		ResultSet rsa=db.executeQuery(sqla);
	        while(rsa.next()){
	        	trait_in.add(rsa.getString(1));
	    	}
	        if(trait_in.size()==0||pat_field.size()==0||ch_field.size()==0)flag=0;      
if(trait_in.size()!=0 && pat_field.size()!=0 && ch_field.size()!=0){
	
		System.out.println(sqla);
		
		
		for(int i=0;i<trait_in.size();i++)System.out.println("#111111   #"+trait_in.get(i)+"#111111   #"+trait_in.size());
	    
 		
	String strt ="";
		
		for(int k=0;k<ch_field.size()-1;k++){
			strt+="`"+ch_field.get(k)+"`,";
		}
		strt+="`"+ch_field.get(ch_field.size()-1)+"`";
		String sqlt = "select "+strt+" from chr"+chr+"_merged_all_snp where pos='"+trait_in.get(0)+"' ";
		for(int i=1;i<trait_in.size();i++){
			sqlt+="or pos='"+trait_in.get(i)+"'";
		}
		
		
		System.out.println(sqlt);
		ResultSet rst=db.executeQuery(sqlt);
    	while(rst.next()){
    		for(int i=1;i<=ch_field.size();i++)
    		t_table.add(rst.getString(i));
    	}
/*			for(int i=0;i<trait_in.size();i++)
		{
			for(int k=0;k<ch_field.size();k++)
			{
				String sql1 = "select "+ch_field.get(k)+" from chr"+chr+"_merged_all_snp where pos='"+trait_in.get(i)+"'";
				ResultSet rs1=db.executeQuery(sql1);
				 
		    	while(rs1.next()){
		    		t_table.add(rs1.getString(1));	
		    	}
		    	System.out.println("----------------------------------------------------------------------------------"+i+"---"+k+"-----------"+t_table.get(k));
			}
		}*/
 
		for(int i=0;i<t_table.size();i++)System.out.println("#111111   #"+t_table.get(i)+"#111111   #"+t_table.size());
		
		
		
		
	//if(t_table.size()!=0){
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
			
			
			System.out.println("----------------------------------------------------------------------------------"+i+"---"+lie+"-----------"+i*lie);
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
			
			
			

			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+Tarr_x.size()+"---"+ Tarr_y.size()+"---"+Tarr_z.size());
			if(Tarr_x.size()!=0 && Tarr_y.size()!=0&&Tarr_z.size()==0)
			{ 
				System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			    lie_2.add(trait_in.get(i));
				System.out.println("-------------------------------------------     "+lie_2.get(0));
				for(int ii=0;ii<Tarr_x.size();ii++)System.out.println("--------Tarr_x------------"+Tarr_x.get(ii)+"---"+n1.get(ii)+"----------");
			    for(int ii=0;ii<Tarr_y.size();ii++)System.out.println("--------Tarr_y------------"+Tarr_y.get(ii)+"---"+n2.get(ii)+"----------");
			    for(int j = 0;j< pat_field.size(); j++)
			    {
			    	//System.out.println("11111111111111111111111111");
			    	ArrayList Array_1  = new ArrayList();
			    	ArrayList Array_2  = new ArrayList();
			    	for(int k =0;k < Tarr_x.size(); k++)
			    	{
			    		//System.out.println("22222222222222222222222222");
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
			    		//System.out.println("333333333333333333333333333");
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
				
					
				if(Array_1.size()>1&&Array_2.size()>1){
					TTest mytest = new TTest();
					double a[] = new double[Array_1.size()];
					double b[] = new double[Array_2.size()];
					for(int ii=0;ii<Array_1.size();ii++){
						a[ii] = Double.parseDouble((String)Array_1.get(ii));
					}
					for(int ii=0;ii<Array_2.size();ii++){
						b[ii] = Double.parseDouble((String)Array_2.get(ii));
					}					
					double s;
					DecimalFormat df = new DecimalFormat( "0.00000 ");
					s = mytest.tTest(a, b);
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$--->>"+s);
					
					//start calculate
/*					float suma = 0;
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
				System.out.println("qianmian  houmian ---  "+qianmian+" "+houmian);
					float S=(float) Math.sqrt(limian);//S（x1-x2）
				
					float t=(avga-avgb)/S;
				System.out.println("limian  avga avgb S  --- "+limian+" "+avga+" "+avgb+" "+S);		*/		
					T.add(String.valueOf(df.format(s)));
					}else{
						T.add("NA");
					}
				
				 }
			    	for(int ii=0;ii<T.size();ii++)System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@   "+T.get(ii)+"   @@");     	
			  }else if(Tarr_y.size()==0){
										
					lie_2.add(trait_in.get(i));
					for(int j = 0;j< pat_field.size(); j++){
						T.add("NA");
					}
					
					
				}
			
			
			
			
			
			
				
			}  //此循环for(i= 0; i<hang; i++)结束
		
		
		//updated by wangfan 
		//phenoype_agri_traits表中的性状数据
		ArrayList<String> data_attribute= new ArrayList<String>();  
		for(int k=0;k<ch_field.size();k++){
			 String temp_sql="";
			 for(int j = 0;j< pat_field.size()-1; j++){
				 temp_sql+=pat_field.get(j)+',';
			 }
			 temp_sql+=pat_field.get(pat_field.size()-1);
			 System.out.println(temp_sql);
			 temp_sql="select "+temp_sql+" from phenoype_agri_traits where `Trait` = '"+ch_field.get(k)+"'";
			 ResultSet rs=db.executeQuery(temp_sql);
			 while(rs.next()){
				 for(int j = 1;j<= pat_field.size(); j++){
					 data_attribute.add(rs.getString(j));
				 }
			 }
		
		}
		for(int ii=0;ii<data_attribute.size();ii++){System.out.println("data_attribute**********************"+data_attribute.get(ii)); }
		for(int ii=0;ii<T.size();ii++){System.out.println("**************T********"+T.get(ii)); }
		for(int ii=0;ii<lie_2.size();ii++){System.out.println("*****lie_2********************"+lie_2.get(ii)); }
		for(int ii=0;ii<t_table.size();ii++){System.out.println("*****t_table********************"+t_table.get(ii)); }
		for(int ii=0;ii<ch_field.size();ii++){System.out.println("*************t_lie************"+ch_field.get(ii)); }
		for(int ii=0;ii<trait_in.size();ii++){System.out.println("************t_hang*************"+trait_in.get(ii)); }
 
		
		attribute.put("data_attribute",data_attribute);
		attribute.put("count",ch_field.size());
    	attribute.put("t_table",t_table); //choose1
    	attribute.put("t_lie",ch_field); //choose1
    	attribute.put("t_hang",trait_in); //choose1
    	attribute.put("pat_field",pat_field);
 
    	attribute.put("lie_2",lie_2);
    	attribute.put("T",T);
	}   	
  
 	
    	try{
    		attribute.put("flag",flag);
        }catch(Exception e){
	        System.out.print("--------T-test-error------"+e.toString());
	       return ERROR;
	    } 
        return SUCCESS;       
	}
}
	