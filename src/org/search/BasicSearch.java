package org.search;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import org.db.metabolic_traits_zy.MetabolicTraitsZy;
import org.db.metabolic_traits_zy.MetabolicTraitsZyDAO;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BasicSearch extends ActionSupport
{
	private String name="";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String execute() throws Exception 
	{	
		DbBean db = new DbBean();
		ResultSet rs = null;
		try
		{
			Map attibutes = ActionContext.getContext().getSession();
			String tablename = (String) attibutes.get("name");
			ArrayList<MetabolicTraitsZy> metabolictraintszy_list = new ArrayList<MetabolicTraitsZy>();
//			String sql = "select * from " + TABLE_NAME 
//			+ " where " + FIELD_ARRIVAL_ID + " = '" + freightArrivalId + "'";
			String sql="SELECT * FROM metabolic_traits_zy where Experiment_1 like '"+getName()+"%'"; 
			rs = db.executeQuery(sql);
				
			while (rs.next()) 
			{ 
				MetabolicTraitsZy metabolictraintszy = new MetabolicTraitsZy();
				metabolictraintszy.setExperiment1(rs.getString(1));
				metabolictraintszy.setN0001(rs.getInt(MetabolicTraitsZyDAO.N0001));
				metabolictraintszy.setN0002(rs.getInt(MetabolicTraitsZyDAO.N0002));
				metabolictraintszy.setN0004(rs.getInt(MetabolicTraitsZyDAO.N0004));
				metabolictraintszy.setN0005(rs.getInt(MetabolicTraitsZyDAO.N0005));
				metabolictraintszy.setN0006(rs.getInt(MetabolicTraitsZyDAO.N0006));
				
				metabolictraintszy_list.add(metabolictraintszy);
				
//			    str_cname_1=rs.getString("n0658");
//				str_cname_2=rs.getString("N0001");
//			    System.out.println(str_cname_1+"       "+str_cname_2);
			}//while
			
			for(int i=0;i<metabolictraintszy_list.size();i++)
			{
				System.out.println(metabolictraintszy_list.get(i).getExperiment1()+"     "+metabolictraintszy_list.get(i).getN0001()+"       "+metabolictraintszy_list.get(i).getN0002()+"       "+metabolictraintszy_list.get(i).getN0004()+"       "+metabolictraintszy_list.get(i).getN0005());
			}
			

			
			
//			System.out.println("111111111111111111111111: "+getName());
//			MetabolicTraitsZyDAO freightArrivalDAO = new MetabolicTraitsZyDAO();
//			int int_value=671000;
//			Object value=(Object)int_value;
//			ArrayList<MetabolicTraitsZy> freightArrivals = null;
//			System.out.println("333333333333333333333333: ");
//			Object [] oo=freightArrivalDAO.findByProperty("n0002", value).toArray();
//			System.out.println("2222222222222222222: ");
//			System.out.println("dddddd "+oo.length);
//			System.out.println();		
//			MetabolicTraitsZy freightArrivals = new MetabolicTraitsZy();
//			MetabolicTraitsZyDAO freightArrivalDAO = new MetabolicTraitsZyDAO();
//			freightArrivals = freightArrivalDAO.findById(getName());
			
			
			
			
			attibutes.put("metabolictraintszy_list", metabolictraintszy_list);
			
			return SUCCESS;

	    }
		catch(Exception e)
		{
			rs.close();
			System.err.println(e.toString());
			return ERROR;
		}
		finally 
		{
			//db.close();
		}
		
	}
}
