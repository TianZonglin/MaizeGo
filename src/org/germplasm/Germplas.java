package org.germplasm;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.rowset.CachedRowSetImpl;

public class Germplas extends ActionSupport {
	String table;
	String subpop;
	String line;

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

	@SuppressWarnings("unchecked")
	public String execute() {
		System.out.println(line);
		Map attribute = ActionContext.getContext().getSession();
		DbBean db = new DbBean();
		String sql = new String();
		ResultSet rs = null;
		CachedRowSetImpl amp = null;
		CachedRowSetImpl f1 = null;
		CachedRowSetImpl ril = null;
		String[] temp_table = table.split(", ");
		for (int i = 0; i < temp_table.length; i++) {
			System.out.println("********" + temp_table[i]);
			if (temp_table[i].equals("AMP")) {
				temp_table[i] = "amp_ear_traits";
			} else if (temp_table[i].equals("AMP×tester")) {
				temp_table[i] = "f1_ear_traits";

			} else if (temp_table[i].equals("RIL")) {
				System.out.println("********" + temp_table[i]);
				temp_table[i] = "germplasm_ril";

			}
		}

		if (line != null) {
			String[] temp_line = line.split(", ");
			String temp_subpop = subpop.split(", ")[0];
			if (temp_table[0].equals("amp_ear_traits")) {
				sql = "SELECT DISTINCT `Subpopulations`,`Lines`,`SS`,`NSS`,`TST`,`Pedigree`,`Origin` "
						+ "from `germplasmlines` where `Subpopulations`= '"
						+ temp_subpop + "' and (`Lines`='" + temp_line[0] + "'";
				for (int i = 1; i < temp_line.length; i++) {
					sql += " or `Lines`='" + temp_line[i] + "'";
				}
				sql += ");";
				System.out.println(sql);
				try {
					rs = db.executeQuery(sql);
					amp = new CachedRowSetImpl();
					amp.populate(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (temp_table[0].equals("f1_ear_traits")) {
				System.out.println(temp_line[0]);
				sql = "SELECT distinct `LINE` from `f1_ear_traits` where `LINE`='"
						+ temp_line[0] + "'";
				
				for (int i = 1; i < temp_line.length; i++) {
					sql += " or `LINE`='" + temp_line[i] + "'";
				}
				System.out.println("Germ.....sql:"+sql);
				try {
					rs = db.executeQuery(sql);
					f1 = new CachedRowSetImpl();
					f1.populate(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp_table[0].equals("germplasm_ril")) {
				System.out.println("*****************RIL");

				sql = "SELECT distinct `POP`,`ARRAY_ID` from `germplasm_ril` where `POP`= '"
						+ temp_subpop
						+ "' and (`ARRAY_ID`='"
						+ temp_line[0]
						+ "'";
				for (int i = 1; i < temp_line.length; i++) {
					sql += " or `ARRAY_ID`='" + temp_line[i] + "'";
				}
				sql += ");";
				try {
					rs = db.executeQuery(sql);
					ril = new CachedRowSetImpl();
					ril.populate(rs);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} else if (subpop != null) {
			String[] temp_subpop = subpop.split(", ");
			if (temp_table[0].equals("amp_ear_traits")) {
				sql = "SELECT DISTINCT `Subpopulations`,`Lines`,`SS`,`NSS`,`TST`,`Pedigree`,`Origin` from `germplasmlines` "
						+ "where `Subpopulations`= '" + temp_subpop[0] + "'";
				for (int i = 1; i < temp_subpop.length; i++) {
					sql += " or `Subpopulations`='" + temp_subpop[i] + "'";
				}
				try {
					rs = db.executeQuery(sql);
					amp = new CachedRowSetImpl();
					amp.populate(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (temp_table[0].equals("f1_ear_traits")) {
				sql = "SELECT distinct `LINE` from `f1_ear_traits` where  `LINE` like '%"
						+ temp_subpop[0] + "'";
				for (int i = 1; i < temp_subpop.length; i++) {
					sql += " or `LINE` like '%" + temp_subpop[i] + "'";
				}
				try {
					rs = db.executeQuery(sql);
					f1 = new CachedRowSetImpl();
					f1.populate(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp_table[0].equals("germplasm_ril")) {

				sql = "SELECT distinct `POP`,`ARRAY_ID` from `germplasm_ril` where `POP`= '"
						+ temp_subpop[0] + "'";
				for (int i = 1; i < temp_subpop.length; i++) {
					sql += " or `POP`='" + temp_subpop[i] + "'";
				}
				try {
					rs = db.executeQuery(sql);
					ril = new CachedRowSetImpl();
					ril.populate(rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} else {
			for (int i = 0; i < temp_table.length; i++) {
				if (temp_table[i].equals("amp_ear_traits")) {
					sql = "SELECT DISTINCT `Subpopulations`,`Lines`,`SS`,`NSS`,`TST`,`Pedigree`,`Origin` from `germplasmlines` ;";

					try {
						rs = db.executeQuery(sql);
						amp = new CachedRowSetImpl();
						amp.populate(rs);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (temp_table[i].equals("f1_ear_traits")) {
					sql = "SELECT distinct `LINE` from `f1_ear_traits` ;";

					try {
						rs = db.executeQuery(sql);
						f1 = new CachedRowSetImpl();
						f1.populate(rs);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
				} else if (temp_table[i].equals("germplasm_ril")) {
					sql = "SELECT distinct `POP`,`ARRAY_ID` from `germplasm_ril` ;";

					try {
						rs = db.executeQuery(sql);
						ril = new CachedRowSetImpl();
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
		if (amp != null) {
			field.add("ID");
			field.add("SUBPOP");
			field.add("LINES");
			field.add("SS");
			field.add("NSS");
			field.add("TST");
			field.add("PEDIGREE");
			field.add("ORIGIN");
			
			
			
			
			
			String path = getWebRoot();

			String newpath = path + "file/germtypicdata.txt";// /////////////////////////////////////

			FileOutputStream fos = new FileOutputStream(newpath);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			BufferedWriter out = new BufferedWriter(osw);
			for (int i = 0; i < field.size(); i++) {
				out.write(field.get(i) + ",\t");
			}
			out.newLine();
			
			
			
			int j = 0;
			while (amp.next()) {
				j += 1;
				out.write(j + ",\t");
				for (int i = 1; i < field.size(); i++) {
					out.write(amp.getString(i) + ",\t");
				}
				out.newLine();
			}
			out.flush();
			
			out.close();
			
			
			
		}

		else if (ril != null) {
			field.add("ID");
			field.add("POP");
			field.add("ARRAY_ID");
			
			
			
			
			
			String path = getWebRoot();

			String newpath = path + "file/germtypicdata.txt";// /////////////////////////////////////

			FileOutputStream fos = new FileOutputStream(newpath);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			BufferedWriter out = new BufferedWriter(osw);
			for (int i = 0; i < field.size(); i++) {
				out.write(field.get(i) + ",\t");
			}
			out.newLine();
			
			int j = 0;
			while (ril.next()) {
				j += 1;
				out.write(j + ",\t");
				for (int i = 1; i < field.size(); i++) {
					out.write(ril.getString(i) + ",\t");
				}
				out.newLine();
			}
			out.flush();
			
			out.close();
			
		}

		else if (f1 != null) {
			field.add("ID");
			field.add("POP");
			field.add("LINE");

			
			String path = getWebRoot();

			String newpath = path + "file/germtypicdata.txt";// /////////////////////////////////////

			FileOutputStream fos = new FileOutputStream(newpath);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			BufferedWriter out = new BufferedWriter(osw);
			for (int i = 0; i < field.size(); i++) {
				out.write(field.get(i) + ",\t");
			}
			out.newLine();

			int j = 0;
			while (f1.next()) {
				j += 1;
				out.write(j + ",\t");
				out.write(f1.getString(1).split("×")[1] + ",\t");
				out.write(f1.getString(1) + ",\t");
				out.newLine();
			}
			out.flush();
			
			
			out.close();
		}			
		
			attribute.put("amp", amp);
			attribute.put("f1", f1);
			attribute.put("ril", ril);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String getWebRoot() {
		String path = getClass().getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF/classes"));
		}
		return path;
	}
}
