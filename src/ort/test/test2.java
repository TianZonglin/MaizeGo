package ort.test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.db.chr1_merged_all_snp.Chr1MergedAllSnp;
import org.db.chr1_merged_all_snp.Chr1MergedAllSnpDAO;
import org.db.metabolic_traits_zy.MetabolicTraitsZy;
import org.hibernate.HibernateException;
import org.util.DbBean;

public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//List<Chr1MergedAllSnp> chr1_merged = new ArrayList<Chr1MergedAllSnp>();
		DbBean db = new DbBean();
		ResultSet rrs = null;
		try
		{
			String sql="SELECT rs FROM chr1_merged_all_snp;"; 
			rrs = db.executeQuery(sql);
				
			while (rrs.next()) 
			{ 
				System.out.println(rrs.getString("rs"));
			
			}
			
//			Chr1MergedAllSnpDAO dao = new Chr1MergedAllSnpDAO();
//			chr1_merged=dao.findAll();
//			
//			
//			for(Chr1MergedAllSnp chr1me:chr1_merged)
//			{
//	 
//				System.out.println(chr1me.getRs());
//				
//	  	    }	
		
		} 
		catch (Exception e) 
		{
			System.err.println("Entity retrieval failed.");
			e.printStackTrace();
		} 

	}

}
