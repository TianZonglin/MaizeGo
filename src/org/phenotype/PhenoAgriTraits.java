package org.phenotype;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.rowset.CachedRowSetImpl;

public class PhenoAgriTraits extends ActionSupport {
	String table;
	String subpop;
	String line;
	String trait;
	String year;
	String location;
	String classifys;

	public String getTrait() {
		return trait;
	}


	public void setTrait(String trait) {
		this.trait = trait;
	}





	public String getYear() {
		return year;
	}





	public void setYear(String year) {
		this.year = year;
	}





	public String getLocation() {
		return location;
	}





	public void setLocation(String location) {
		this.location = location;
	}





	public String getTable() {
		return table;
	}





	public void setTable(String table) {
		this.table = table;
	}





	public String getSubpop() {
		return subpop;
	}





	public void setSubpop(String subpop) {
		this.subpop = subpop;
	}





	public String getLine() {
		return line;
	}





	public void setLine(String line) {
		this.line = line;
	}

	
	
	
	public String getClassifys() {
		return classifys;
	}





	public void setClassifys(String classifys) {
		this.classifys = classifys;
	}
	
	
	
	
	public String[] dealTrait(String trait[]){
         
		Vector<String> temp=new Vector<String>();
		for(String t:trait){
			if(!t.equals("HKW")&&!t.equals("KL")&&!t.equals("KTW")&&!t.equals("KT")&&!t.equals("KW")){
				temp.add(t);
			}
		}
		String temp1[] = new String[temp.size()];
		for(int i=0;i<temp.size();i++){
			temp1[i]=temp.get(i);
		}
		return temp1;
	}
	public String getWebRoot() {
		String path = getClass().getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF/classes"));
		}
		return path;
	}


	@SuppressWarnings("unchecked")
	public String execute(){
		//System.out.println(line);
		Map attribute=ActionContext.getContext().getSession();
		DbBean db=new DbBean();
		ResultSet rs=null;
		CachedRowSetImpl amp=null;
		CachedRowSetImpl f1=null;
		CachedRowSetImpl ril=null;	
		String[] temp_table=table.split(", ");
		String[] temp_trait=trait.split(", ");
		String[] temp_year=year.split(", ");	
		String[] temp_location=location.split(", ");		
		for(int i=0;i<temp_table.length;i++){
			if(temp_table[i].equals("AMP")){
				temp_table[i]="amp_ear_traits";
			}else if(temp_table[i].equals("AMP×tester")){
				temp_table[i]="f1_ear_traits";
				
			}else if(temp_table[i].equals("RIL")){
				//System.out.println("********"+temp_table[i]);
				//temp_table[i]="phenotype_10ril_ear_traits";
				temp_table[i]="phenotype_10ril_traits";
			}
		}
		
		if(line!=null){
			String []temp_line=line.split(", ");
			String temp_subpop=subpop.split(", ")[0];
			if(temp_table[0].equals("amp_ear_traits")){
				temp_trait=dealTrait(temp_trait);       //过滤
				
				String sql="SELECT * from `amp_ear_traits` where `SUBPOP`= '"+temp_subpop+"'";
				if(!temp_trait[0].equals("Search all trait")){
					sql="SELECT `ID`,`SUBPOP`,`LINE`,`LOC`,`YEAR`";
					for(int i=0;i<temp_trait.length;i++){
						sql=sql+",`"+temp_trait[i]+"`";
						
					}
					sql=sql+" from `amp_ear_traits` where `SUBPOP`= '"+temp_subpop+"'";
				}
				if(!temp_year[0].equals("Search all year")){
					sql=sql+" and (`YEAR`="+temp_year[0];
					for(int i=1;i<temp_year.length;i++){
						sql+=" or `YEAR`="+temp_year[i];
					}
					sql+=")";
				}
				if(!temp_location[0].equals("Search all location")){
					sql=sql+" and (`LOC`='"+temp_location[0]+"'";
					for(int i=1;i<temp_location.length;i++){
						sql+=" or `LOC`='"+temp_location[i]+"'";
					}
					sql+=")";
				}
				sql+=" and (`LINE`='"+temp_line[0]+"'";
				for(int i=1;i<temp_line.length;i++){
					sql+=" or `LINE`='"+temp_line[i]+"'";	
				}
				sql+=");";
				System.out.println(sql);
				try {
					rs=db.executeQuery(sql);
					
					String str1 = "";
					String str2 = "";
					String sqll = "";
				
						if(!temp_trait[0].equals("Search all trait")) {
							str1 = "drop table if exists amp_temp;create table amp_temp( ID int(11),SUBPOP varchar(255),LINE varchar(255),LOC varchar(255),YYYY varchar(255)";
							for(int i=0;i<temp_trait.length;i++) {
								str2 += ","+temp_trait[i].toUpperCase()+" varchar(255)";
						    }
							sqll = str1 + str2 +")";
					    }else{ 
					    	sqll = "drop table if exists amp_temp;create table amp_temp( " +
					    			"ID int(11),SUBPOP varchar(255),LINE varchar(255),LOC varchar(255),YYYY varchar(255)," +
					    			"EarLength varchar(255),EarDiameter varchar(255),EarRowNumber varchar(255),RowKernelNumber varchar(255)," +
					    			"EarWeight varchar(255),CobWeight varchar(255) )";	
					    }
						System.out.println(sqll);
						
					amp=new CachedRowSetImpl();
					amp.populate(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else if(temp_table[0].equals("f1_ear_traits")){
				
				temp_trait=dealTrait(temp_trait);       //过滤
				String sql="SELECT * from `f1_ear_traits` where  (`LINE`='"+temp_line[0]+"'";
				if(!temp_trait[0].equals("Search all trait")){
					sql="SELECT `ID`,`LINE`,`LOC`,`YEAR`";
					for(int i=0;i<temp_trait.length;i++){
						sql=sql+",`"+temp_trait[i]+"`";
						
					}
					sql=sql+" from `f1_ear_traits` where (`LINE`= '"+temp_line[0]+"'";
				}
				for(int i=1;i<temp_line.length;i++){
					sql+=" or `LINE`='"+temp_line[i]+"'";	
				}	
				sql+=")";
				
				
				if(!temp_year[0].equals("Search all year")){
					sql=sql+" and (`YEAR`="+temp_year[0];
					for(int i=1;i<temp_year.length;i++){
						sql+=" or `YEAR`="+temp_year[i];
					}
					sql+=")";
				}
				if(!temp_location[0].equals("Search all location")){
					sql=sql+" and (`LOC`='"+temp_location[0]+"'";
					for(int i=1;i<temp_location.length;i++){
						sql+=" or `LOC`='"+temp_location[i]+"'";
					}
					sql+=")";
				}
				
				

				try {
					rs=db.executeQuery(sql);
					f1=new CachedRowSetImpl();
					f1.populate(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(temp_table[0].equals("phenotype_10ril_traits")){
				
				//System.out.println("*************here");
				String sql="SELECT * from `phenotype_10ril_traits` where `POP`= '"+temp_subpop+"'";
				if(!temp_trait[0].equals("Search all trait")){
					sql="SELECT `ID`,`POP`,`LINE`,`LOC`,`YEAR`";
					for(int i=0;i<temp_trait.length;i++){
						sql=sql+",`"+temp_trait[i]+"`";
						
					}
					sql=sql+" from `phenotype_10ril_traits` where `POP`= '"+temp_subpop+"'";
				}
				if(!temp_year[0].equals("Search all year")){
					sql=sql+" and (`YEAR`="+temp_year[0];
					for(int i=1;i<temp_year.length;i++){
						sql+=" or `YEAR`="+temp_year[i];
					}
					sql+=")";
				}
				if(!temp_location[0].equals("Search all location")){
					sql=sql+" and (`LOC`='"+temp_location[0]+"'";
					for(int i=1;i<temp_location.length;i++){
						sql+=" or `LOC`='"+temp_location[i]+"'";
					}
					sql+=")";
				}
				sql+=" and (`LINE`='"+temp_line[0]+"'";
				for(int i=1;i<temp_line.length;i++){
					sql+=" or `LINE`='"+temp_line[i]+"'";	
				}
				sql+=");";
				try {
					rs=db.executeQuery(sql);
					ril=new CachedRowSetImpl();
					ril.populate(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
	
		}else if(subpop!=null){
			String[] temp_subpop=subpop.split(", ");
			if(temp_table[0].equals("amp_ear_traits")){
				temp_trait=dealTrait(temp_trait);       //过滤
				String sql="SELECT * from `amp_ear_traits` where (`SUBPOP`= '"+temp_subpop[0]+"'";
				if(!temp_trait[0].equals("Search all trait")){
					sql="SELECT `ID`,`SUBPOP`,`LINE`,`LOC`,`YEAR`";
					for(int i=0;i<temp_trait.length;i++){
						sql=sql+",`"+temp_trait[i]+"`";
						
					}
					sql=sql+" from `amp_ear_traits` where (`SUBPOP`= '"+temp_subpop[0]+"'";
				}				
								
				for(int i=1;i<temp_subpop.length;i++){
					sql+=" or `SUBPOP`='"+temp_subpop[i]+"'";	
				}
				sql+=")";
				
				if(!temp_year[0].equals("Search all year")){
					sql=sql+" and (`YEAR`="+temp_year[0];
					for(int i=1;i<temp_year.length;i++){
						sql+=" or `YEAR`="+temp_year[i];
					}
					sql+=")";
				}
				if(!temp_location[0].equals("Search all location")){
					sql=sql+" and (`LOC`='"+temp_location[0]+"'";
					for(int i=1;i<temp_location.length;i++){
						sql+=" or `LOC`='"+temp_location[i]+"'";
					}
					sql+=")";
				}				
				
				
				try {
					rs=db.executeQuery(sql);
					amp=new CachedRowSetImpl();
					amp.populate(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else if(temp_table[0].equals("f1_ear_traits")){
				temp_trait=dealTrait(temp_trait);       //w过滤
				String sql="SELECT * from `f1_ear_traits` where  (`LINE` like '%"+temp_subpop[0]+"'";

				if(!temp_trait[0].equals("Search all trait")){
					sql="SELECT `ID`,`LINE`,`LOC`,`YEAR`";
					for(int i=0;i<temp_trait.length;i++){
						sql=sql+",`"+temp_trait[i]+"`";
						
					}
					sql=sql+" from `f1_ear_traits` where (`LINE` like '%"+temp_subpop[0]+"'";
				}				
																			
				
				for(int i=1;i<temp_subpop.length;i++){
					sql+=" or `LINE` like '%"+temp_subpop[i]+"'";	
				}
				sql+=")";
				if(!temp_year[0].equals("Search all year")){
					sql=sql+" and (`YEAR`="+temp_year[0];
					for(int i=1;i<temp_year.length;i++){
						sql+=" or `YEAR`="+temp_year[i];
					}
					sql+=")";
				}
				if(!temp_location[0].equals("Search all location")){
					sql=sql+" and (`LOC`='"+temp_location[0]+"'";
					for(int i=1;i<temp_location.length;i++){
						sql+=" or `LOC`='"+temp_location[i]+"'";
					}
					sql+=")";
				}				
				
				System.out.println(sql);
				
				try {
					rs=db.executeQuery(sql);
					f1=new CachedRowSetImpl();
					f1.populate(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(temp_table[0].equals("phenotype_10ril_traits")){
				String sql="SELECT * from `phenotype_10ril_traits` where (`POP`= '"+temp_subpop[0]+"'";
				if(!temp_trait[0].equals("Search all trait")){
					sql="SELECT `ID`,`POP`,`LINE`,`LOC`,`YEAR`";
					for(int i=0;i<temp_trait.length;i++){
						sql=sql+",`"+temp_trait[i]+"`";
						
					}
					sql=sql+" from `phenotype_10ril_traits` where (`POP`= '"+temp_subpop[0]+"'";
				}				
								
				for(int i=1;i<temp_subpop.length;i++){
					sql+=" or `POP`='"+temp_subpop[i]+"'";	
				}
				sql+=")";
				
				if(!temp_year[0].equals("Search all year")){
					sql=sql+" and (`YEAR`="+temp_year[0];
					for(int i=1;i<temp_year.length;i++){
						sql+=" or `YEAR`="+temp_year[i];
					}
					sql+=")";
				}
				if(!temp_location[0].equals("Search all location")){
					sql=sql+" and (`LOC`='"+temp_location[0]+"'";
					for(int i=1;i<temp_location.length;i++){
						sql+=" or `LOC`='"+temp_location[i]+"'";
					}
					sql+=")";
				}				
				
				
				try {
					rs=db.executeQuery(sql);
					ril=new CachedRowSetImpl();
					ril.populate(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
	
		}else{
			for(int i=0;i<temp_table.length;i++){
				
				
				if(temp_table[i].equals("amp_ear_traits")){
					temp_trait=dealTrait(temp_trait);       //过滤
					String sql="SELECT * from `amp_ear_traits`";
					
					
					if(!temp_trait[0].equals("Search all trait")){
						sql="SELECT `ID`,`SUBPOP`,`LINE`,`LOC`,`YEAR`";
						for(int j=0;j<temp_trait.length;j++){
							sql=sql+",`"+temp_trait[j]+"`";
							
						}
						sql=sql+" from `amp_ear_traits` ";
					}	
										
					
					if(!temp_year[0].equals("Search all year")){
						sql=sql+" where (`YEAR`="+temp_year[0];
						for(int j=1;j<temp_year.length;j++){
							sql+=" or `YEAR`="+temp_year[j];
						}
						sql+=")";
						if(!temp_location[0].equals("Search all location")){
							sql=sql+" and (`LOC`='"+temp_location[0]+"'";
							for(int j=1;j<temp_location.length;j++){
								sql+=" or `LOC`='"+temp_location[j]+"'";
							}
							sql+=")";
						}
					}else if(!temp_location[0].equals("Search all location")){
						sql=sql+" where (`LOC`='"+temp_location[0]+"'";
						for(int j=1;j<temp_location.length;j++){
							sql+=" or `LOC`='"+temp_location[j]+"'";
						}
						sql+=")";
					}	
					try {
						rs=db.executeQuery(sql);
						amp=new CachedRowSetImpl();
						amp.populate(rs);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}else if(temp_table[i].equals("f1_ear_traits")){
					temp_trait=dealTrait(temp_trait);       //过滤
					String sql="SELECT * from `f1_ear_traits` ";
					if(!temp_trait[0].equals("Search all trait")){
						sql="SELECT `ID`,`LINE`,`LOC`,`YEAR`";
						for(int j=0;j<temp_trait.length;j++){
							sql=sql+",`"+temp_trait[j]+"`";
							
						}
						sql=sql+" from `f1_ear_traits` ";						
						
					}
					if(!temp_year[0].equals("Search all year")){
						sql=sql+" where (`YEAR`="+temp_year[0];
						for(int j=1;j<temp_year.length;j++){
							sql+=" or `YEAR`="+temp_year[j];
						}
						sql+=")";
						if(!temp_location[0].equals("Search all location")){
							sql=sql+" and (`LOC`='"+temp_location[0]+"'";
							for(int j=1;j<temp_location.length;j++){
								sql+=" or `LOC`='"+temp_location[j]+"'";
							}
							sql+=")";
						}
					}else if(!temp_location[0].equals("Search all location")){
						sql=sql+" where (`LOC`='"+temp_location[0]+"'";
						for(int j=1;j<temp_location.length;j++){
							sql+=" or `LOC`='"+temp_location[j]+"'";
						}
						sql+=")";
					}	
					try {
						rs=db.executeQuery(sql);
						f1=new CachedRowSetImpl();
						f1.populate(rs);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
				}else if(temp_table[i].equals("phenotype_10ril_traits")){
					String sql="SELECT * from `phenotype_10ril_traits`";
					
					
					if(!temp_trait[0].equals("Search all trait")){
						sql="SELECT `ID`,`POP`,`LINE`,`LOC`,`YEAR`";
						for(int j=0;j<temp_trait.length;j++){
							sql=sql+",`"+temp_trait[j]+"`";
							
						}
						sql=sql+" from `phenotype_10ril_traits` ";
					}	
										
					
					if(!temp_year[0].equals("Search all year")){
						sql=sql+" where (`YEAR`="+temp_year[0];
						for(int j=1;j<temp_year.length;j++){
							sql+=" or `YEAR`="+temp_year[j];
						}
						sql+=")";
						if(!temp_location[0].equals("Search all location")){
							sql=sql+" and (`LOC`='"+temp_location[0]+"'";
							for(int j=1;j<temp_location.length;j++){
								sql+=" or `LOC`='"+temp_location[j]+"'";
							}
							sql+=")";
						}
					}else if(!temp_location[0].equals("Search all location")){
						sql=sql+" where `LOC`='"+temp_location[0]+"'";
						for(int j=1;j<temp_location.length;j++){
							sql+=" or `LOC`='"+temp_location[j]+"'";
						}
					}	
					try {
						rs=db.executeQuery(sql);
						ril=new CachedRowSetImpl();
						ril.populate(rs);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				
					
				}
				
			}
		}
		

		
		
		
		try {
		
		ArrayList<String> field = new ArrayList<String>();
 
		if(amp!=null){
			if(!temp_trait[0].equals("Search all trait")) {
				
				System.out.println("not Search all trait");
				
				field.add("ID");
				field.add("SUBPOP");
				field.add("LINE");
				field.add("LOC");
				field.add("YEAR");
				
				for(int i=0;i<temp_trait.length;i++) {
					field.add((temp_trait[i].toUpperCase())); //添加项
				}
			}else{
				System.out.println("Search all trait");
				field.add("ID");
				field.add("SUBPOP");
				field.add("LINE");
				field.add("LOC");
				field.add("YEAR");
				
				field.add("EarLength");
				field.add("EarDiameter");
				field.add("EarRowNumber");
				field.add("RowKernelNumber");
				field.add("EarWeight");
				
				field.add("CobWeight");
			}
			
			System.out.println("这里是内部"+field.size()+" amp :"+amp.getMetaData().getColumnCount());
			
			
			String path = getWebRoot();

			String newpath = path + "file/aaaaaaaaaaaaaaa.txt";// /////////////////////////////////////

			FileOutputStream fos = new FileOutputStream(newpath);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			BufferedWriter out = new BufferedWriter(osw);
			for (int i = 0; i < field.size(); i++) {
				out.write(field.get(i) + ",\t");
			}
			out.newLine();
			int j = 0;
			while (amp.next()) {
				for (int i = 1; i <= field.size(); i++) {
					out.write(amp.getString(i) + ",\t");
				}
				out.newLine();
			}
			out.flush();
			
			out.close();
			
		}
		
		
		
		
		
		if(ril!=null){
			if(!temp_trait[0].equals("Search all trait")) {
				
				System.out.println("not Search all trait");
				
				field.add("ID");
				field.add("SUBPOP");
				field.add("LINE");
				field.add("LOC");
				field.add("YEAR");
				
				for(int i=0;i<temp_trait.length;i++) {
					field.add((temp_trait[i].toUpperCase())); //添加项
				}
			}else{
				System.out.println("Search all trait");
				field.add("ID");
				field.add("SUBPOP");
				field.add("LINE");
				field.add("LOC");
				field.add("YEAR");
				
				field.add("EarLength");
				field.add("EarDiameter");
				field.add("EarRowNumber");
				field.add("RowKernelNumber");
				field.add("EarWeight");
				
				field.add("CobWeight");
				field.add("HKW");
				field.add("KL");
				field.add("KTW");
				field.add("KT");
				
				field.add("KW");
			}
			
			System.out.println("这里是内部"+field.size()+" ril :"+ril.getMetaData().getColumnCount());
			
			
			String path = getWebRoot();

			String newpath = path + "file/aaaaaaaaaaaaaaa.txt";// /////////////////////////////////////

			FileOutputStream fos = new FileOutputStream(newpath);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			BufferedWriter out = new BufferedWriter(osw);
			for (int i = 0; i < field.size(); i++) {
				out.write(field.get(i) + ",\t");
			}
			out.newLine();
			int j = 0;
			while (ril.next()) {
				for (int i = 1; i <= field.size(); i++) {
					out.write(ril.getString(i) + ",\t");
				}
				out.newLine();
			}
			out.flush();
			
			out.close();
			
		}
		
		
		
		
		
		
		if(f1!=null){
			if(!temp_trait[0].equals("Search all trait")) {
				
				System.out.println("not Search all trait");
				
				field.add("ID");
				field.add("LINE");
				field.add("LOC");
				field.add("YEAR");
				
				for(int i=0;i<temp_trait.length;i++) {
					field.add((temp_trait[i].toUpperCase())); //添加项
				}
			}else{
				System.out.println("Search all trait");
				field.add("ID");
				field.add("LINE");
				field.add("LOC");
				field.add("YEAR");
				
				
				field.add("EarLength");
				field.add("EarDiameter");
				field.add("EarRowNumber");
				field.add("RowKernelNumber");
				field.add("EarWeight");
				
				field.add("CobWeight");
			}
			
			System.out.println("这里是内部"+field.size()+" f1 :"+f1.getMetaData().getColumnCount());
			
			
			String path = getWebRoot();

			String newpath = path + "file/aaaaaaaaaaaaaaa.txt";// /////////////////////////////////////

			FileOutputStream fos = new FileOutputStream(newpath);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			BufferedWriter out = new BufferedWriter(osw);
			for (int i = 0; i < field.size(); i++) {
				out.write(field.get(i) + ",\t");
			}
			out.newLine();
			int j = 0;
			while (f1.next()) {
				for (int i = 1; i <= field.size(); i++) {
					out.write(f1.getString(i) + ",\t");
				}
				out.newLine();
			}
			out.flush();
			
			out.close();
			
		}
		
		
	
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			
		attribute.put("trait", temp_trait);
		attribute.put("amp", amp);
		attribute.put("f1", f1);
		attribute.put("ril", ril);
			

		
		return SUCCESS;
		
		

		
	}
	
	
	

}
