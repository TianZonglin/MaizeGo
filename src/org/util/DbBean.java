package org.util;

import java.io.InputStream;
import java.sql.*;

/**
 * 
 * <p>
 * Title: dbBean.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author TanBo
 * @version 1.0
 */
public class DbBean {
	public java.sql.Connection conn = null; // connection object
	public ResultSet rs = null; // resultset object
	public Statement stmt = null; // statement object
	public PreparedStatement prepstmt = null; // preparedstatement object
	private static String drivers = null; // connection parameter:drivers
	private static String url = null; // connection parameter:url
	private static String user = null; // connection parameter:user
	private static String password = null; // connection parameter:password
	private static String dbName=null;
	
	

	static {
		try {
			// parameter init
			drivers ="com.mysql.jdbc.Driverr";
			dbName="maizego";
			user = "root";
			password = "";
			url ="jdbc:mysql://localhost/" + dbName + "?user=" + user+ "&password=" + password+"&characterEncoding=utf8";
			Class.forName("com.mysql.jdbc.Driver");;
			
		} catch (Exception e) {
			System.out.println("dbBean: init error!" + e.toString());
		}
	}
	/**
	 * init()
	 */
	
	public Connection getConnection() {
		return conn;
	}
	
	public DbBean() {
		try{
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			
		} catch (Exception e) {
			System.out.println("dbBean: init error!" + e.toString());
		}
		
	}

	/**
	 * @function prepareStatement
	 * @param sql
	 *            String
	 * @throws SQLException
	 */
	public void prepareStatement(String sql) throws SQLException {
		prepstmt = conn.prepareStatement(sql);
	}

	/**
	 * @function prepareStatement
	 * @param sql
	 *            String
	 * @param resultSetType
	 *            int
	 * @param resultSetConcurrency
	 *            int
	 * @throws SQLException
	 */
	public void prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		prepstmt = conn.prepareStatement(sql, resultSetType,
				resultSetConcurrency);
	}

	/**
	 * @function executeQuery
	 * @param sql
	 *            String
	 * @throws SQLException
	 * @return ResultSet
	 */
	public ResultSet executeQuery(String sql) throws SQLException {
		if (stmt != null) {
			return stmt.executeQuery(sql);
		} else
			return null;
	}

	/**
	 * @function executeQuery
	 * @throws SQLException
	 * @return ResultSet
	 */
	public ResultSet executeQuery() throws SQLException {
		if (prepstmt != null) {
			return prepstmt.executeQuery();
		} else
			return null;
	}

	/**
	 * @function executeUpdate
	 * @param sql
	 *            String
	 * @throws SQLException
	 */
	public void executeUpdate(String sql) throws SQLException {
		if (stmt != null)
			stmt.executeUpdate(sql);
	}

	/**
	 * @function executeUpdate
	 * @throws SQLException
	 */
	public void executeUpdate() throws SQLException {
		if (prepstmt != null)
			prepstmt.executeUpdate();
	}

	/**
	 * @function executeUpdate
	 * @throws SQLException
	 */
	public void executeBatch() throws SQLException {
		if (prepstmt != null)
			prepstmt.executeBatch();
	}

	/**
	 * @function addBatch
	 * @param value
	 *            String
	 * @throws SQLException
	 */
	public void addBatch(String value) throws SQLException {
		prepstmt.addBatch(value);
	}

	/**
	 * @function setString
	 * @param index
	 *            int
	 * @param value
	 *            String
	 * @throws SQLException
	 */
	public void setString(int index, String value) throws SQLException {
		prepstmt.setString(index, value);
	}

	/**
	 * @function setInt
	 * @param index
	 *            int
	 * @param value
	 *            int
	 * @throws SQLException
	 */
	public void setInt(int index, int value) throws SQLException {
		prepstmt.setInt(index, value);
	}

	/**
	 * @function setBoolean
	 * @param index
	 *            int
	 * @param value
	 *            boolean
	 * @throws SQLException
	 */
	public void setBoolean(int index, boolean value) throws SQLException {
		prepstmt.setBoolean(index, value);
	}

	/**
	 * @function setDate
	 * @param index
	 *            int
	 * @param value
	 *            Date
	 * @throws SQLException
	 */
	public void setDate(int index, Date value) throws SQLException {
		prepstmt.setDate(index, value);
	}

	/**
	 * @function setLong
	 * @param index
	 *            int
	 * @param value
	 *            long
	 * @throws SQLException
	 */
	public void setLong(int index, long value) throws SQLException {
		prepstmt.setLong(index, value);
	}

	/**
	 * @function setFloat
	 * @param index
	 *            int
	 * @param value
	 *            float
	 * @throws SQLException
	 */
	public void setFloat(int index, float value) throws SQLException {
		prepstmt.setFloat(index, value);
	}

	/**
	 * @function setBytes
	 * @param index
	 *            int
	 * @param value
	 *            byte[]
	 * @throws SQLException
	 */
	public void setBytes(int index, byte[] value) throws SQLException {
		prepstmt.setBytes(index, value);
	}

	/**
	 * @function setBinaryStream
	 * @param index
	 *            int
	 * @param value
	 *            InputStream
	 * @param len
	 *            int
	 * @throws SQLException
	 */
	public void setBinaryStream(int index, InputStream value, int len)
			throws SQLException {
		prepstmt.setBinaryStream(index, value, len);
	}

	/**
	 * @function setTimestamp
	 * @param index
	 *            int
	 * @param timestamp
	 *            Timestamp
	 * @throws SQLException
	 */
	public void setTimestamp(int index, Timestamp timestamp)
			throws SQLException {
		prepstmt.setTimestamp(index, timestamp);
	}

	/**
	 * @function setAutoCommit
	 * @param value
	 *            boolean
	 * @throws SQLException
	 */
	public void setAutoCommit(boolean value) throws SQLException {
		if (this.conn != null)
			this.conn.setAutoCommit(value);
	}

	/**
	 * @function commit
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		this.conn.commit();
	}

	/**
	 * @function rollback
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		this.conn.rollback();
	}

	/**
	 * @function close
	 * @throws Exception
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (Exception e) {
			System.out.println("dbBean close rs error!");
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (Exception e) {
				System.out.println("dbBean close stmt error!");
			} finally {
				try {
					if (prepstmt != null) {
						prepstmt.close();
						prepstmt = null;
					}
				} catch (Exception e) {
					System.out.println("dbBean close prepstmt error!");
				} finally {
					try {
						if (conn != null) {
							conn.close();
							conn = null;
						}
					} catch (Exception e) {
						System.out.println("dbBean close conn error!");
					}
				}
			}
		}
	}

}
