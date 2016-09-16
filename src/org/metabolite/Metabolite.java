package org.metabolite;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.rowset.CachedRowSetImpl;

@SuppressWarnings("serial")
public class Metabolite extends ActionSupport {
	String trait;
	String inputtrait;

	public String getInputtrait() {
		return inputtrait;
	}

	public void setInputtrait(String inputtrait) {
		this.inputtrait = inputtrait;
	}

	public String getTrait() {
		return trait;
	}

	public void setTrait(String trait) {
		this.trait = trait;
	}

	public String execute() throws Exception {
		Map<String, Object> attribute = ActionContext.getContext().getSession();
		DbBean db = new DbBean();
		DbBean db1 = new DbBean();
		HashMap<String, Integer> temp = new HashMap<String, Integer>();
		ByValueComparator comparator = new ByValueComparator(); // 重新写的排序
		List<Map.Entry<String, Integer>> bb = null;
		List<Map.Entry<String, Integer>> zy = null;
		List<Map.Entry<String, Integer>> e1 = null;
		List<Map.Entry<String, Integer>> e2 = null;
		List<Map.Entry<String, Integer>> e3 = null;
		if (trait.equals("Please select the compound")) {
			if (inputtrait != null || inputtrait != "") {
				trait = inputtrait;

				trait = trait.replace('\n', ':');

				trait = trait.replace('\t', ':');

				trait = trait.replace('\u0008', ':');

				trait = trait.replace('\r', ':');

				trait = trait.replace(',', ':');
				trait = trait.replace(' ', ':');

			}

		}
		trait = trait.split(":")[0];
		String sql1 = "select * from `supplementary data 2` where `Peak NO.`='"
				+ trait + "';";
		String sql2 = "select * from `supplementary data 3` where `Metabolic trait`='"
				+ trait + "';";
		String sql3 = "select * from `supplementary data 4` where `Metabolic trait`='"
				+ trait + "';";
		String sql4 = "select * from `supplementary data 5` where `Metabolite ID`='"
				+ trait + "';";
		String sql5 = "select * from `supplementary data metabolite picture` where `metabolite`='"
				+ trait + "';";
		String sql6 = "select column_name from information_schema.columns where table_name ='metabolic_traits_bb';";
		String sql7 = "select * from `metabolic_traits_bb` where `ID`='"
				+ trait + "';";
		String sql8 = "select `Experiment_1`,`" + trait
				+ "` from `metabolic_traits_zy`;";
		String sql9 = "select `Experiment_1`,`" + trait
				+ "` from `metabolic_traits_e1`;";
		String sql10 = "select `Experiment_2`,`" + trait
				+ "` from `metabolic_traits_e2`;";
		String sql11 = "select `Experiment_3`,`" + trait
				+ "` from `metabolic_traits_e3`;";
		CachedRowSetImpl data2 = new CachedRowSetImpl();
		CachedRowSetImpl data3 = new CachedRowSetImpl();
		CachedRowSetImpl data4 = new CachedRowSetImpl();
		CachedRowSetImpl data5 = new CachedRowSetImpl();
		CachedRowSetImpl dataPicture = new CachedRowSetImpl();
		ResultSet rs;
		ResultSet rs1;
		int i = 0;

		// 获取bb数据
		try {
			rs = db.executeQuery(sql6);
			rs1 = db1.executeQuery(sql7);
			rs.next(); // 去掉第一个字段（ID）
			i = 2; // 去掉第一个字段的数据

			while (rs1.next()) {
				while (rs.next()) {
					temp.put(rs.getString(1), rs1.getInt(i));
					i++;
				}
			}
			System.out.println(temp.size());
//			System.out.println("bb排序前：" + temp.entrySet().toString());

			bb = new ArrayList<Map.Entry<String, Integer>>(temp.entrySet());

			Collections.sort(bb, comparator);
/*			System.out.print("bb排序后：");
			for (i = 0; i < bb.size(); i++) {
				String id = bb.get(i).toString();
				System.out.print(id + " ");
			}

			System.out.println();*/
		} catch (Exception e) {
			System.out.println("bb中无所需数据");
			e.printStackTrace();
		}
		// 获取zy数据
		try {

			temp.clear();
			rs = db.executeQuery(sql8);
			while (rs.next()) {
				for (i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					temp.put(rs.getString(1), rs.getInt(2));

				}

			}
	//		System.out.println("zy排序前：" + temp.entrySet().toString());
			zy = new ArrayList<Map.Entry<String, Integer>>(temp.entrySet());
			Collections.sort(zy, comparator);

/*			System.out.print("zy排序后(" + zy.size() + "):");

			for (i = 0; i < zy.size(); i++) {
				String id = zy.get(i).toString();
				System.out.print(id + " ");
			}

			System.out.println();*/
		} catch (Exception e) {
			System.out.println("zy中无所需数据");
			// e.printStackTrace();
		}

		// 获取e2数据
		try {

			temp.clear();
			rs = db.executeQuery(sql10);
			while (rs.next()) {
				for (i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					temp.put(rs.getString(1), rs.getInt(2));

				}

			}
	//		System.out.println("e2排序前：" + temp.entrySet().toString());
			e2 = new ArrayList<Map.Entry<String, Integer>>(temp.entrySet());
			Collections.sort(e2, comparator);

/*			System.out.print("e2排序后(" + e2.size() + "):");

			for (i = 0; i < e2.size(); i++) {
				String id = e2.get(i).toString();
				System.out.print(id + " ");
			}

			System.out.println();*/
		} catch (Exception e) {
			System.out.println("e2中无所需数据");
			// e.printStackTrace();
		}

		// 获取e1数据
		try {

			temp.clear();
			rs = db.executeQuery(sql9);
			while (rs.next()) {
				for (i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					temp.put(rs.getString(1), rs.getInt(2));

				}

			}
	//		System.out.println("e1排序前：" + temp.entrySet().toString());
			e1 = new ArrayList<Map.Entry<String, Integer>>(temp.entrySet());
			Collections.sort(e1, comparator);

/*			System.out.print("e1排序后(" + e1.size() + "):");

			for (i = 0; i < e1.size(); i++) {
				String id = e1.get(i).toString();
				System.out.print(id + " ");
			}

			System.out.println();*/
		} catch (Exception e) {
			System.out.println("e1中无所需数据");
			// e.printStackTrace();
		}

		// 获取e3数据
		try {

			temp.clear();
			rs = db.executeQuery(sql11);
			while (rs.next()) {
				for (i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					temp.put(rs.getString(1), rs.getInt(2));

				}

			}
//			System.out.println("e3排序前：" + temp.entrySet().toString());
			e3 = new ArrayList<Map.Entry<String, Integer>>(temp.entrySet());
			Collections.sort(e3, comparator);

/*			System.out.print("e3排序后(" + e3.size() + "):");

			for (i = 0; i < e3.size(); i++) {
				String id = e3.get(i).toString();
				System.out.print(id + " ");
			}

			System.out.println();*/
		} catch (Exception e) {
			System.out.println("e3中无所需数据");
			// e.printStackTrace();
		}

		
		// 若e2不为空，对e1、e3参考e2进行排序

		if (e2 != null && e2.size() > 0) {
			List<Map.Entry<String, Integer>> e_new = new ArrayList(e2);
			
			
			if (e1 != null) {				          //对 e1进行排序
				for (i = 0; i < e2.size(); i++) {
					for (int j = 0; j < e1.size(); j++) {
						if (e2.get(i).getKey().equals(e1.get(j).getKey())) {
							e_new.set(i, e1.get(j));
							e1.remove(j);

						}
					}
				}
				e1 = e_new;

/*				System.out.print("e1按e2排序后(" + e1.size() + "):");

				for (i = 0; i < e1.size(); i++) {                
					String id = e1.get(i).toString();
					System.out.print(id + " ");
				}

				System.out.println();*/

			}
			
			if(e3!=null){                                //对e3进行排序
				
				for (i = 0; i < e2.size(); i++) {
					for (int j = 0; j < e3.size(); j++) {
						if (e2.get(i).getKey().equals(e3.get(j).getKey())) {
							e_new.set(i, e3.get(j));
							e3.remove(j);

						}
					}
				}
				e3 = e_new;

/*				System.out.print("e3按e2排序后(" + e3.size() + "):");

				for (i = 0; i < e3.size(); i++) {
					String id = e3.get(i).toString();
					System.out.print(id + " ");
				}

				System.out.println();*/

			}
		}else if(e1!=null){
			List<Map.Entry<String, Integer>> e_new = new ArrayList(e1);
			if(e3!=null){                                //对e3进行排序
				
				for (i = 0; i < e1.size(); i++) {
					for (int j = 0; j < e3.size(); j++) {
						if (e1.get(i).getKey().equals(e3.get(j).getKey())) {
							e_new.set(i, e3.get(j));
							e3.remove(j);

						}
					}
				}
				e3 = e_new;

/*				System.out.print("e3按e1排序后(" + e1.size() + "):");

				for (i = 0; i < e3.size(); i++) {
					String id = e3.get(i).toString();
					System.out.print(id + " ");
				}

				System.out.println();*/

			}

		}


		rs = db.executeQuery(sql1);
		data2.populate(rs);
		rs = db.executeQuery(sql2);
		data3.populate(rs);
		rs = db.executeQuery(sql3);
		data4.populate(rs);
		rs = db.executeQuery(sql4);
		data5.populate(rs);
		rs = db.executeQuery(sql5);
		dataPicture.populate(rs);
		rs.close();
		db.close();
		attribute.put("data2", data2);
		attribute.put("data3", data3);
		attribute.put("data4", data4);
		attribute.put("data5", data5);
		attribute.put("dataPicture", dataPicture);
		attribute.put("trait", trait);
		attribute.put("bb", bb);
		attribute.put("zy", zy);
		attribute.put("e1", e1);
		attribute.put("e2", e2);
		attribute.put("e3", e3);
		return SUCCESS;

	}

	// 重写比较器类
	public class ByValueComparator implements
			Comparator<Map.Entry<String, Integer>> {

		public int compare(Map.Entry<String, Integer> arg0,
				Map.Entry<String, Integer> arg1) {
			int key0 = arg0.getValue();
			int key1 = arg1.getValue();
			return key0 - key1;

		}

	}

}
