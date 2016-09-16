package org.hif;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.rowset.CachedRowSetImpl;

public class Material extends ActionSupport {
	String material;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	// ��ȡȾɫ����С����
	/********************
	 * @SuppressWarnings("null") public int[] getMin(){ int min[] = new int[10];
	 *                           DbBean db = new DbBean(); ResultSet rs = null;
	 *                           for(int i=0;i<10;i++) { String sql="SELECT MIN(CONVERT(REPLACE(pos_New,',',''),UNSIGNED INTEGER))FROM bb_map_all WHERE `chr` = 'chr"
	 *                           +(i+1)+"';"; try { rs=db.executeQuery(sql);
	 *                           while(rs.next()) min[i]=rs.getInt(1); } catch
	 *                           (SQLException e) { // TODO Auto-generated catch
	 *                           block e.printStackTrace(); } } return min; }
	 * 
	 *                           //��ȡȾɫ����󳤶�
	 * @SuppressWarnings("null") public int[] getMax(){ int max[]=new int[10];
	 *                           DbBean db = new DbBean(); ResultSet rs = null;
	 *                           for(int i=0;i<10;i++){
	 * 
	 *                           String sql="SELECT MAX(CONVERT(REPLACE(pos_New,',',''),UNSIGNED INTEGER))FROM bb_map_all WHERE `chr` = 'chr"
	 *                           +(i+1)+"';"; try { rs=db.executeQuery(sql);
	 *                           while(rs.next()) max[i]=rs.getInt(1); } catch
	 *                           (SQLException e) { // TODO Auto-generated catch
	 *                           block e.printStackTrace(); } } return max; }
	 ******************************************/
	// ��ȡĳ��Ⱦɫ������ֵ
	@SuppressWarnings("null")
	public int getMax(int i) {
		int max = 0;
		DbBean db = new DbBean();
		ResultSet rs = null;
		String sql = "SELECT MAX(`pos_new`) FROM `hif_b73/by804` WHERE `chr` = "
				+ i + ";";
		try {
			rs = db.executeQuery(sql);
			while (rs.next())
				max = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
	}

	// ��ȡ�����Ӻϵ����ֵ
	public String getpos_end(ResultSet rs) throws SQLException {
		String local_pos_end = null;
		local_pos_end = rs.getString(1);
		if (rs.next()) {
			if (rs.getString(2).equals("3"))
				return getpos_end(rs);
			else
				return local_pos_end;
		} else
			return local_pos_end;

	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		Map<String, Object> attributes = ActionContext.getContext()
				.getSession();
		String population = (String) attributes.get("population");
		StringBuffer seed_population = new StringBuffer("seed_"); // 获取对应seed表
		seed_population = seed_population.append(population.substring(4));

		DbBean db = new DbBean();
		ArrayList<String> rows = new ArrayList<String>();
		ArrayList<String> rate = new ArrayList<String>();
		ArrayList<Integer> max = new ArrayList<Integer>();
		ArrayList<String> seed = new ArrayList<String>();
		String rate_all = null; // 总的杂合率

		System.out.println(population);
		System.out.println(seed_population);
		// System.out.println(chr);
		// int min[],max[];
		int all_max = this.getMax(1);
		String sql;
		String sql1 = "select * from `" + seed_population
				+ "` where `ARRAY_ID`='" + material + "';"; // 对应seed表中对应材料的数据
		String sql11 = "select column_name from information_schema.columns where table_name ='"
				+ seed_population + "';"; // 对应seed表的字段名
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		CachedRowSetImpl seed_column = new CachedRowSetImpl();
		// min=this.getMin();
		// max=this.getMax();
		try{

			rs2 = db.executeQuery(sql1);


			// ��ȡsee_kd_ril�����
			while (rs2.next()) {
				for (int i = 0; i < rs2.getMetaData().getColumnCount(); i++)
					seed.add(rs2.getString(i + 1));

			}

			rs3 = db.executeQuery(sql11);
			seed_column.populate(rs3);
			attributes.put("seed_column", seed_column);
			attributes.put("seed", seed);			

		}catch(Exception e){	}		
		
		
		
		try {

			int sum = 0, num = 0;

			for (int i = 1; i <= 10; i++) {
				sql = "SELECT `pos_New`,`" + material + "` FROM `" + population
						+ "` WHERE";
				sql = sql + "`chr` =" + i + ";";
				ResultSet rs1 = db.executeQuery(sql);
				ArrayList<String> pos_begin = new ArrayList<String>();
				ArrayList<String> pos_end = new ArrayList<String>();// Ⱦɫ��ָ��λ�õĳ���
				rs1.last(); // ���ָ��֪�����һ�����
				int n = rs1.getRow();
				int m = 0;
				// System.out.println(n);
				rs1.beforeFirst();
				while (rs1.next()) {
					if (rs1.getString(2).equals("3")) {
						pos_begin.add(rs1.getString(1));
						pos_end.add(getpos_end(rs1));
						m++;
						num++;
					}
					sum++;
				}
				// System.out.println(pos_begin.toString());
				// System.out.println(pos_end.toString());
				// System.out.println(n);
				// System.out.println(m);
				// System.out.println((double)m/n*100);
				max.add(getMax(i));
				rows.add("chr" + i);
				rate.add(String.format("%.2f", (double) m / n * 100)); // 取两位小数
				attributes.put("chr" + i + "_begin", pos_begin);
				attributes.put("chr" + i + "_end", pos_end);
				rs1.close();
				// System.out.println(rows.toString());
				// System.out.println("chr"+i+"_begin");
			}

			//rate_all = String.format("%.4f", (double) num / sum * 100);
			String sql2="select `RATE` from `hif_heterozygosityrate` where `ARRAY_ID`='"+material+"';";
			ResultSet  rs4=(db.executeQuery(sql2));
			if(rs4.next()){
				rate_all=rs4.getString(1);
			}
			attributes.put("rate_all", rate_all);

			// attributes.put("min", min);
			attributes.put("rate", rate); // �Ӻ���
			attributes.put("all_max", all_max); // Ⱦɫ��1�ĳ��ȣ�������Ⱦɫ���е���󳤶�
			attributes.put("chr", rows); // Ⱦɫ����
			attributes.put("max", max); // ÿ��Ⱦɫ��ĳ���
			attributes.put("material", material); // ���ѯ�Ĳ�����

			return SUCCESS;
		} catch (Exception e) {
			// rs.close();
			e.printStackTrace();
			return ERROR;
		} finally {
			db.close();
		}

	}
}
