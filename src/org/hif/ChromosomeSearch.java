package org.hif;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChromosomeSearch extends ActionSupport{
	double minpos;
	double maxpos;
	String chr;
	String population;
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public double getMinpos() {
		return minpos;
	}
	public void setMinpos(String minpos) {
		this.minpos = Double.parseDouble(minpos);
	
	}
	public double getMaxpos() {
		return maxpos;
	}
	public void setMaxpos(String maxpos) {
		this.maxpos =Double.parseDouble(maxpos);

			
	}
	public String getChr() {
		return chr;
	}
	public void setChr(String chr) {
		this.chr = chr;
	}
	/*******************************************
	//��ȡȾɫ����С����
	public int getMin(String chr){
		int min=0;
		DbBean db = new DbBean();
		ResultSet rs = null;	
		String sql="SELECT MIN(CONVERT(REPLACE(pos_New,',',''),UNSIGNED INTEGER))FROM bb_map_all WHERE `chr` = '"+chr+"';";
		try {
			rs=db.executeQuery(sql);
			while(rs.next())
				min=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		
			db.close();
		}

		return min;	
	}
	//��ȡȾɫ����󳤶�
	public int getMax(String chr){
		int max=0;
		DbBean db = new DbBean();
		ResultSet rs = null;	
		String sql="SELECT MAX(CONVERT(REPLACE(pos_New,',',''),UNSIGNED INTEGER))FROM bb_map_all WHERE `chr` = '"+chr+"';";
		try {
			rs=db.executeQuery(sql);
			while(rs.next())
				max=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.close();
		}

		return max;	
	}
	 * @throws SQLException 
	********************************************/
	
	//获取连续杂合区间的结束位置
	public String getpos_end(ResultSet rs) throws SQLException{
		String local_pos_end=null;
		local_pos_end=rs.getString(1);
		if(rs.next()){
		if(rs.getString(2).equals("3"))
			return getpos_end(rs);
		else
			return local_pos_end;}
		else
			return local_pos_end;
			
		
	}
	
	
	
	
	
	public String execute() throws Exception 
	{	
		int i=0;
		//System.out.println(chr);
		//min=this.getMin(chr);
		//max=this.getMax(chr);
		DbBean db = new DbBean();
		DbBean db1=new DbBean();
		ArrayList<String> rows=new ArrayList<String>();
		
		ResultSet rs = null;	
		try{
		Map<String, Object> attributes =ActionContext.getContext().getSession();	
		String sql="show fields from `"+population+"`;";
		rs=db.executeQuery(sql);
		while(rs.next())
		{
			if(i<5){
				i++;
				continue;
			}

			//sql="SELECT replace(pos_New,',','') FROM bb_map_all WHERE" ;	
			//System.out.println(population);
			sql="SELECT replace(pos_New,',',''),`"+rs.getString(1)+"` FROM `"+population+"` WHERE" ;	
			//sql=sql+"`"+rs.getString(1)+"`"+"=3 And `chr` ='"+chr+"' And replace(pos_New,',','') BETWEEN "+minpos+" AND "+maxpos+";";
			sql=sql+"`chr` ='"+chr+"' And replace(pos_New,',','') BETWEEN "+minpos+" AND "+maxpos+";";  //  ��ȡ�ò�����ָ��Ⱦɫ������λ��
			ResultSet rs1=db1.executeQuery(sql);
			ArrayList<String> pos_begin=new ArrayList<String>();
			ArrayList<String> pos_end=new ArrayList<String>();//Ⱦɫ��ָ��λ�õĳ���
			
			
			
			
			while(rs1.next())
			{
				if(rs1.getString(2).equals("3")){
					pos_begin.add(rs1.getString(1));
					pos_end.add(getpos_end(rs1));
				}
 
			}


			if(pos_begin.size()!=0)
			{
				//System.out.println(pos_begin.toString());
				//System.out.println(pos_end.toString());				
				rows.add(rs.getString(1));
				attributes.put(rs.getString(1)+"_begin",pos_begin);
				attributes.put(rs.getString(1)+"_end",pos_end);
			}
			//System.out.println(pos.size());
			
		}
		attributes.put("materials",rows);
		attributes.put("min", minpos);               
		attributes.put("max", maxpos);              //最大位置
		attributes.put("chr", chr);                //染色体
		attributes.put("population", population);  // 表名
		//attributes.put("maxpos", maxpos);
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
