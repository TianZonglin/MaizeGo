package ort.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class test 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		 FileOutputStream fos = new FileOutputStream("e:/test.txt");
         OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
         BufferedWriter out = new BufferedWriter(osw);
       
         out.write("慢慢炉火纯青了！");
         out.newLine();
         out.write("学完C++，Java确实很简单，但很棒！");
         out.newLine();
         out.write("学完C++，Java确实很简单，但很棒！");
         out.flush();

	}

}
