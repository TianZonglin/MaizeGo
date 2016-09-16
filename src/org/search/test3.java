package org.search;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class test3 {
	public static boolean equals(Object []a,Object []b){
		if(a.length!=b.length)
			return false;
		else{
			ArrayList m=new ArrayList();
			ArrayList n=new ArrayList();
			for(int i=0;i<a.length;i++)
				m.add(a[i]);
			for(int i=0;i<b.length;i++)
				n.add(b[i]);
			for(int i=0;i<a.length;i++)
			{
				if(!n.contains(a[i]))
					return false;
			}
			for(int i=0;i<b.length;i++)
			{
				if(!m.contains(b[i]))
					return false;
			}
			return true;
		}
		
	}
	

	public  static void main(String[] args) throws Exception 
	{
		Object []a={12,1};
		Object []b={1,1};
		System.out.println(equals(a,b));
	
	}	
	
	
	
	
}

