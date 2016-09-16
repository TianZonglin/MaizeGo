<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="org.hif.TableSearch" %> 

    <% //获得响应客户的输出流：
      OutputStream o = response.getOutputStream();
      //OutputStream o=response.getOutputStream();
      //输出文件用的字节数组,每次发送500个字节到输出流：
      byte b[]=new byte[500];      
      TableSearch ps=new TableSearch();
      String path=ps.getWebRoot();
	  System.out.println("path: "+path);
	  String newpath=path+"file/seed_info.txt";
      String encoding="GBK";
      File file=new File(newpath);
      
      response.setHeader("Content-disposition","attachment;filename="+"graph.txt");
      //通知客户文件的MIME类型：
      response.setContentType("application/txt");
      //通知客户文件的长度：
      //response.setHeader("Content_Length",length);
      //读取文件book.zip,并发送给客户下载:
      FileInputStream in=new FileInputStream(file);
      int n=0;
	  o.flush();
      while((n=in.read(b))!=-1)
      { 
	  	o.write(b,0,n); 
	  }
      o.flush();
      o.close();
    %>
