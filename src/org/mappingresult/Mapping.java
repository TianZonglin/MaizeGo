package org.mappingresult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Mapping extends ActionSupport{
	int chr;
	public int getChr() {
		return chr;
	}
	public void setChr(String chr) {
		this.chr = Integer.parseInt(chr);
	}

	public String execute() throws Exception 
	{	
		
		DbBean db = new DbBean();
		DbBean db1 = new DbBean();
		DbBean db2 = new DbBean();		
		ArrayList<String> pos=new ArrayList<String>();
		ArrayList<String> lod=new ArrayList<String>();	
		ArrayList<String> pos1=new ArrayList<String>();
		ArrayList<String> lod1=new ArrayList<String>();	
		ArrayList<String> pos2=new ArrayList<String>();
		ArrayList<String> lod2=new ArrayList<String>();			
		ResultSet rs = null;	
		ResultSet rs1 = null;
		ResultSet rs2 = null;		
		try{
		Map<String, Object> attributes =ActionContext.getContext().getSession();	
//		String sql1="SELECT pos,-LOG10(lod) FROM bb_qtl_el WHERE `chrom`= "+chr+";";
//		String sql2="SELECT POS_BEGIN_RE,-LOG10(lrt) FROM result_lrt_el WHERE `CHR`= "+chr+";";
//		String sql3="SELECT loci,-LOG10(p) FROM gwas WHERE `chr`="+chr+";";
//		
//		String sql11="SELECT pos,-LOG10(lod),chrom FROM bb_qtl_el;";
//		String sql21="SELECT POS_BEGIN_RE,-LOG10(lrt),CHR FROM result_lrt_el;";
//		String sql31="SELECT loci,-LOG10(p),chr FROM gwas;";
		
		String sql1="SELECT pos,lod FROM bb_qtl_el WHERE `chrom`= "+chr+";";
		String sql2="SELECT POS_BEGIN_RE,lrt FROM result_lrt_el WHERE `CHR`= "+chr+";";
		String sql3="SELECT loci,-LOG10(Pvalue) FROM gwas WHERE `chr`="+chr+";";
		
		String sql11="SELECT pos,lod,chrom FROM bb_qtl_el;";
		String sql21="SELECT POS_BEGIN_RE,lrt,CHR FROM result_lrt_el;";
		String sql31="SELECT loci,-LOG10(Pvalue),chr FROM gwas;";
		
		
		if(chr==0){
			rs=db.executeQuery(sql11);
			rs1=db1.executeQuery(sql21);
			rs2=db2.executeQuery(sql31);
			attributes.put("chr","All Chr");
			
			while(rs.next())
			{
				if (rs.getString(3).equals("2")){
					pos.add(String.valueOf(Integer.parseInt(rs.getString(1))+301354135));
				}
				else if (rs.getString(3).equals("3")){
					pos.add(String.valueOf(Integer.parseInt(rs.getString(1))+538423009));
					
				}
				else if (rs.getString(3).equals("4")){
					pos.add(String.valueOf(Integer.parseInt(rs.getString(1))+770563183));
					
				}
				else if (rs.getString(3).equals("5")){
					pos.add(String.valueOf(Integer.parseInt(rs.getString(1))+1012036687));
					
				}
				else if (rs.getString(3).equals("6")){
					pos.add(String.valueOf(Integer.parseInt(rs.getString(1))+1229909539));
					
				}
				else if (rs.getString(3).equals("7")){
					pos.add(String.valueOf(Integer.parseInt(rs.getString(1))+1399083892));
					
				}
				else if (rs.getString(3).equals("8")){
					pos.add(String.valueOf(Integer.parseInt(rs.getString(1))+1575848654));
					
				}
				else if (rs.getString(3).equals("9")){
					pos.add(String.valueOf(Integer.parseInt(rs.getString(1))+1751642413));
					
				}
				else if (rs.getString(3).equals("10")){
					pos.add(String.valueOf(Integer.parseInt(rs.getString(1))+1908393119));
					
				}
				lod.add(rs.getString(2));
				
			}
			while(rs1.next())
			{
				if (rs1.getString(3).equals("2")){
					pos1.add(String.valueOf(Integer.parseInt(rs1.getString(1))+301354135));
				}
				else if (rs1.getString(3).equals("3")){
					pos1.add(String.valueOf(Integer.parseInt(rs1.getString(1))+538423009));
					
				}
				else if (rs1.getString(3).equals("4")){
					pos1.add(String.valueOf(Integer.parseInt(rs1.getString(1))+770563183));
					
				}
				else if (rs1.getString(3).equals("5")){
					pos1.add(String.valueOf(Integer.parseInt(rs1.getString(1))+1012036687));
					
				}
				else if (rs1.getString(3).equals("6")){
					pos1.add(String.valueOf(Integer.parseInt(rs1.getString(1))+1229909539));
					
				}
				else if (rs1.getString(3).equals("7")){
					pos1.add(String.valueOf(Integer.parseInt(rs1.getString(1))+1399083892));
					
				}
				else if (rs1.getString(3).equals("8")){
					pos1.add(String.valueOf(Integer.parseInt(rs1.getString(1))+1575848654));
					
				}
				else if (rs1.getString(3).equals("9")){
					pos1.add(String.valueOf(Integer.parseInt(rs1.getString(1))+1751642413));
					
				}
				else if (rs1.getString(3).equals("10")){
					pos1.add(String.valueOf(Integer.parseInt(rs1.getString(1))+1908393119));
					
				}
				lod1.add(rs1.getString(2));
				
			}
			while(rs2.next())
			{
				if (rs2.getString(3).equals("2")){
					pos2.add(String.valueOf(Integer.parseInt(rs2.getString(1))+301354135));
				}
				else if (rs2.getString(3).equals("3")){
					pos2.add(String.valueOf(Integer.parseInt(rs2.getString(1))+538423009));
					
				}
				else if (rs2.getString(3).equals("4")){
					pos2.add(String.valueOf(Integer.parseInt(rs2.getString(1))+770563183));
					
				}
				else if (rs2.getString(3).equals("5")){
					pos2.add(String.valueOf(Integer.parseInt(rs2.getString(1))+1012036687));
					
				}
				else if (rs2.getString(3).equals("6")){
					pos2.add(String.valueOf(Integer.parseInt(rs2.getString(1))+1229909539));
					
				}
				else if (rs2.getString(3).equals("7")){
					pos2.add(String.valueOf(Integer.parseInt(rs2.getString(1))+1399083892));
					
				}
				else if (rs2.getString(3).equals("8")){
					pos2.add(String.valueOf(Integer.parseInt(rs2.getString(1))+1575848654));
					
				}
				else if (rs2.getString(3).equals("9")){
					pos2.add(String.valueOf(Integer.parseInt(rs2.getString(1))+1751642413));
					
				}
				else if (rs2.getString(3).equals("10")){
					pos2.add(String.valueOf(Integer.parseInt(rs2.getString(1))+1908393119));
					
				}
				lod2.add(rs2.getString(2));	
			}
		}else{			
			rs=db.executeQuery(sql1);
			rs1=db1.executeQuery(sql2);
			rs2=db2.executeQuery(sql3);
			attributes.put("chr","Chr"+chr);
			while(rs.next())
			{
				pos.add(rs.getString(1));
				lod.add(rs.getString(2));
				
			}
			while(rs1.next())
			{
				pos1.add(rs1.getString(1));
				lod1.add(rs1.getString(2));
				
			}
			while(rs2.next())
			{
				pos2.add(rs2.getString(1));
				lod2.add(rs2.getString(2));	
			}		
		}

		attributes.put("pos",pos);
		attributes.put("lod", lod);
		attributes.put("pos1",pos1);
		attributes.put("lod1", lod1);
		attributes.put("pos2",pos2);
		attributes.put("lod2", lod2);		
			
		return SUCCESS;
	}catch(Exception e)
	{
		//rs.close();
		System.err.println(e.toString());
		return ERROR;
	}
	finally 
	{
		db.close();
	}

}
}
