<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="org.hif.TableSearch"%>

<%
	//获得响应客户的输出流：
	OutputStream ou=response.getOutputStream();
	ou.write(new byte[]{ (byte)0xEF,(byte)0xBB,(byte)0xBF });
	BufferedWriter o =new BufferedWriter(new OutputStreamWriter(ou,"UTF-8"));
	 
	//输出文件用的字节数组,每次发送500个字节到输出流：
	char b[] = new char[500];
	TableSearch gs = new TableSearch();
	String path = gs.getWebRoot();
	System.out.println("path: " + path);
	String newpath = path + "file/seedlist.txt";
	File file = new File(newpath);
	response.setHeader("Content-disposition", "attachment;filename="+ "seedlist.csv");
	//o.write(new String(new   byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF })); 
	//o.write(new byte[]{ (byte)0xEF,(byte)0xBB,(byte)0xBF }); 
	//response.setCharacterEncoding("UTF-8");
	//通知客户文件的MIME类型：
	response.setContentType("application/csv");
	//读取文件book.zip,并发送给客户下载:	
	 // 写入文件头部
    InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
    BufferedReader br = new BufferedReader(read);
    int n = 0;
	o.flush();
	String line=null;
	String s[];
	while((line=br.readLine()).length()!=0){
	line=line.replace(",","");
    //System.out.println(line);
	s=line.split("\t");
	for(n=0;n<s.length;n++){
	o.write(s[n]);
	o.write(",");
	System.out.println(s[n]);
	}
	o.newLine();
	o.flush();
	}

	br.close();
	o.flush();
	o.close();

%>
