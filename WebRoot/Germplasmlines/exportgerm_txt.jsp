<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="org.germplasm.GermSearch" %> 

    <% //获得响应客户的输出流：
      OutputStream o=response.getOutputStream();
      //输出文件用的字节数组,每次发送500个字节到输出流：
      byte b[]=new byte[500];
      //下载的文件：
      File fileLoad=new File("","exportgerm.txt");
      //客户使用保存文件的对话框：
	  java.io.FileWriter fw = new java.io.FileWriter(fileLoad);     
      //java.io.BufferedWriter bw=new java.io.BufferedWriter(fw);   
      java.io.PrintWriter theout = new java.io.PrintWriter(fw);                  
      
      try 
      {
                GermSearch ps=new GermSearch();
                String path=ps.getWebRoot();
		        System.out.println("path: "+path);
		        String newpath=path+"file/germtypicdata.txt";
      
                String encoding="GBK";
                File file=new File(newpath);
                if(file.isFile() && file.exists())
                { 
                    //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null)
                    {
                        //System.out.println(lineTxt);
                        theout.write(lineTxt);
	                    theout.write("\n");
                    }
                    read.close();
                }
                else
                {
                     System.out.println("找不到指定的文件");
                }

        } 
        catch (Exception e) 
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
      
      
      theout.close();   
      fw.close();  
	  //out.clear();
      response.setHeader("Content-disposition","attachment;filename="+"exportgerm.txt");
      //通知客户文件的MIME类型：
      response.setContentType("application/csv");
      //通知客户文件的长度：
      long fileLength=fileLoad.length();
      String length=String.valueOf(fileLength);
      //response.setHeader("Content_Length",length);
      //读取文件book.zip,并发送给客户下载:
      FileInputStream in=new FileInputStream(fileLoad);
      int n=0;
	  o.flush();
      while((n=in.read(b))!=-1)
      { 
	  	o.write(b,0,n); 
	  }
      o.flush();
      o.close();
    %>
