package org.mappingresult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.rowset.CachedRowSetImpl;

public class Gwas extends ActionSupport{
	
	String table;
	String trait;
	String material;
	String chr;
	String  year;
	String location;
	
	
	
	public String getTable() {
		return table;
	}



	public void setTable(String table) {
		this.table = table;
	}


	public String getTrait() {
		return trait;
	}


	public void setTrait(String trait) {
		this.trait = trait;
	}


	public String getMaterial() {
		return material;
	}




	public void setMaterial(String material) {
		this.material = material;
	}



	public String getChr() {
		return chr;
	}


	public void setChr(String chr) {
		this.chr = chr;
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


	@SuppressWarnings("unchecked")
	public void dealwithAMP(String []traits,Map attribute){
		ResultSet rs=null;
		DbBean db=new DbBean();
		for(String temp_trait:traits){ 
			String temp_table="gwas_"+temp_trait+"_amp_ear_traits_mlm";	
			//System.out.println("000000000");
			String sql = null;
			material=material.replaceAll( "chr","");
			if(!material.equals("0"))
			{
				//System.out.println("1111111");	
				sql="select `Site`,-LOG10(`p`) from "+temp_table+ " where `Locus` ='"+material+"'";
				//System.out.println(material);
				//System.out.println(sql);
			}
			CachedRowSetImpl temp=null;
			try {
				temp=new CachedRowSetImpl();
				rs=db.executeQuery(sql);
				temp.populate(rs);
				attribute.put(temp_trait,temp);
				//System.out.println(temp_trait);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
		}
		
	}
	
	@SuppressWarnings({ "unchecked" })
	public void dealwithRIL(String []traits,Map attribute){
		ResultSet rs=null;
		DbBean db=new DbBean();
		String temp_table="qtl_env_ear_trait_"+material;
		

		for(String trait:traits){ 
			CachedRowSetImpl temp=null;	
			String sql="select `cM`,`LOD` from `"+temp_table+"` where";
		//	if(!chr.equals("0")){
				sql+= " `Chr`='"+chr+"' and";
				//System.out.println("*******************************");
				
		//	}
			//if(!year.equals("Search all year")){
				sql+=" `Year`='"+year+"' and";
			//}
		//	if(!location.equals("Search all location")){
				sql+=" `Loc`='"+location+"' and";
		//	}
			sql+=" `Trait` ='"+trait+"';";
			try {
				temp=new CachedRowSetImpl();
				rs=db.executeQuery(sql);
				temp.populate(rs);
				attribute.put(trait,temp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
	}	
	
	
	@SuppressWarnings("unchecked")
	public String execute(){
		Map attribute=ActionContext.getContext().getSession();
		String []traits=trait.split(", ");
		//String []materials=material.split(", ");
		if(table.equals("AMP")){
			//System.out.println("----------");
			//System.out.println(table+"    "+material);
			dealwithAMP(traits,attribute);
			
		}else if(table.equals("RIL")){
			dealwithRIL(traits,attribute);
		}
		attribute.put("trait", traits);
		attribute.put("table", table);
		attribute.put("material", material);
		attribute.put("chr", chr);
		attribute.put("year", year);
		attribute.put("location", location);
		return SUCCESS;
	}

}
