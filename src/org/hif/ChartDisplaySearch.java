package org.hif;
import java.awt.Color; 
import java.awt.Font; 
import java.awt.Shape;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.io.OutputStreamWriter;
import java.io.PrintWriter; 
import java.sql.ResultSet;
import java.text.NumberFormat; 
import java.text.SimpleDateFormat; 
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession; 

import org.apache.derby.client.net.Request;
import org.apache.struts2.ServletActionContext;
import org.db.phenoype_agri_traits.PhenoypeAgriTraits;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartRenderingInfo; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.axis.DateAxis; 
import org.jfree.chart.axis.NumberAxis; 
import org.jfree.chart.entity.StandardEntityCollection; 
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator; 
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer; 
import org.jfree.chart.servlet.ServletUtilities; 
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle; 
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day; 
import org.jfree.data.time.TimeSeries; 
import org.jfree.data.time.TimeSeriesCollection; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.ui.RectangleInsets; 
import org.jfree.ui.TextAnchor;
import org.util.DbBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/** 
* ����ͼ�Ļ��� 
*/ 
public class ChartDisplaySearch extends ActionSupport
{ 
	private String minpos2="";
	private String maxpos2="";
	private String step="";		
	private String population="";	
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}


	private double[] dot=new double[40];
    public String getMinpos2() {
		return minpos2;
	}
	public void setMinpos2(String minpos2) {
		if(minpos2.equals("")) minpos2="0";
		this.minpos2 =minpos2;
	}
	public String getMaxpos2() {
		return maxpos2;
	}
	public void setMaxpos2(String maxpos2) {
		if(maxpos2.equals("")) maxpos2="0";
		this.maxpos2 =maxpos2;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		if(step.equals("")) step="1";
		this.step = step;
	}
	
	
	/** 
	* ��������ͼƬ���ļ��� 
	* @param session 
	* @param pw 
	* @return ����ͼƬ���ļ��� 
	*/ 
	/*
	public String getLineXYChart(HttpSession session, PrintWriter pw) 
	{ 
	 DefaultCategoryDataset dataset = new DefaultCategoryDataset();;//�������ݼ� 
	 dataset=this.createDateSet();
	String fileName = null; 
	//����JFreeChart 
	JFreeChart chart = ChartFactory.createLineChart(
			"Trait-Plantheight", // chart title
			"Trait", // domain axis label
			"Plantheight", // range axis label
			dataset, // data
			PlotOrientation.VERTICAL, // orientation
			false, // include legend
			true, // tooltips
			false // urls
			);
	//����JFreeChart����ʾ����,��ͼ���ⲿ���ֽ��е��� 
	chart.setBackgroundPaint(Color.red);//��������ͼ����ɫ 
	//���������С����״ 
	Font font = new Font("����", Font.BOLD, 16); 
	TextTitle title = new TextTitle("Trait-Plantheight", font); 
	chart.setTitle(title); 
	//������ 
	TextTitle subtitle = 
	new TextTitle("ͼ��", new Font("����", Font.BOLD, 12)); 
	chart.addSubtitle(subtitle); 
	chart.setTitle(title); //���� 

	CategoryPlot plot = (CategoryPlot) chart.getPlot();//��ȡͼ�εĻ��� 
	plot.setBackgroundPaint(Color.lightGray);//�������񱳾�ɫ 
	plot.setDomainGridlinePaint(Color.black);//������������(Domain��)��ɫ 
	plot.setRangeGridlinePaint(Color.white);//�������������ɫ 
	plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));//��������ͼ��xy��ľ��� 
	plot.setDomainCrosshairVisible(true); 
	plot.setRangeCrosshairVisible(true); 
	LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer(); 
	renderer.setDrawOutlines(true); 
	renderer.setUseFillPaint(true);
	renderer.setShapesVisible(true);//���������Ƿ���ʾ���ݵ� 
	//customise the range axis...
	NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

	ChartRenderingInfo info = new ChartRenderingInfo( 
	new StandardEntityCollection()); 
	try 
	{ 
	fileName = ServletUtilities.saveChartAsPNG(chart,900,400, info, 
	session);//����ͼƬ 
	// Write the image map to the PrintWriter 
	ChartUtilities.writeImageMap(pw, fileName, info, false); 
	} 
	catch (IOException e) 
	{ 
	e.printStackTrace(); 
	} 
	pw.flush(); 
	return fileName;//��������ͼƬ���ļ��� 
	} 
	/** 
	* ��������ͼ����������ݼ� 
	* @return �������ݼ� 
	*/ 



	public String getWebRoot()
	{
	    String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
	    if (path.indexOf("WEB-INF") > 0) 
	    {
	       path = path.substring(0, path.indexOf("WEB-INF/classes"));
	    } 
	    return path;
	}


public String execute(){
	
	DbBean db = new DbBean();
	ResultSet rs = null;
	try
	{
		  
		  int num;
		  //ArrayList<PhenoypeAgriTraits> phenotypesofcrosses_list = new ArrayList<PhenoypeAgriTraits>();
		  String sql="show fields from `"+population+"`;";	  
		  rs = db.executeQuery(sql);
		  rs.last();
		  int column_num=rs.getRow();
		  System.out.println(column_num);
		  Boolean [] bl= new Boolean[column_num-6];		
		  for(int i=0;i<column_num-6;i++)
                bl[i]=false; 
		  for(int j=0;j<40;j++)
		  {

			  num=0;
			  //replace(pos_New,',','')���ַ���pos_New�е����С������ַ�ȥ��  convert()���ַ���ת��Ϊ����
			  //String sql1="SELECT * FROM "+population+" WHERE CONVERT(replace(pos_New,',',''),SIGNED INTEGER) BETWEEN ";
			  //sql1=sql1+Integer.toString(Integer.parseInt(minpos2)*1000000+j*Integer.parseInt(step)*1000000)+" AND "+Integer.toString(Integer.parseInt(maxpos2)*1000000+j*Integer.parseInt(step)*1000000)+";" ;
			  String sql1="SELECT * FROM `"+population+"` WHERE `pos_New` BETWEEN ";
			  sql1=sql1+(Integer.parseInt(minpos2)*1000000+j*Integer.parseInt(step)*1000000)+" AND "+(Integer.parseInt(maxpos2)*1000000+j*Integer.parseInt(step)*1000000)+";" ;			  
			  rs=db.executeQuery(sql1);
		  while(rs.next()){
			  
			   for(int i=6;i<column_num;i++){
				  if(rs.getInt(i)==3&&bl[i-6]==false){
						  bl[i-6]=true;
						  num++;
					  }
			   }
		  }
		  dot[j]=(double)num/(double)column_num;

		  }
	
	}	catch(Exception e)
	{
		//rs.close();
		System.err.println(e.toString());
	}
	
	
	
	
	 DefaultCategoryDataset dataset = new  DefaultCategoryDataset();//ʱ���������ݼ��� 
		//Series s1 = new Series("��ʷ����", Day.class);//����ʱ������Դ��ÿһ��//TimeSeries��ͼ����һ������ 
		//s1.add(new Day(day,month,year),value),������ݵ���Ϣ 
			 try {
				 String []st=new String[40];
				 
				for(int i=0;i<20;i++){
					st[i]=Integer.toString(Integer.parseInt(minpos2)+i*Integer.parseInt(step))+"-"+Integer.toString(Integer.parseInt(maxpos2)+i*Integer.parseInt(step));
				dataset.addValue(dot[i], "Classes",st[i]);
				  //System.out.println(dot[i]);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			


			String fileName = null; 
			//����JFreeChart 
			JFreeChart chart = ChartFactory.createLineChart(
					"Window-Rate", // chart title
					"Window", // domain axis label
					"Rate", // range axis label
					dataset, // data
					PlotOrientation.VERTICAL, // orientation
					false, // include legend
					true, // tooltips
					false // urls
					);
			//����JFreeChart����ʾ����,��ͼ���ⲿ���ֽ��е��� 
			chart.setBackgroundPaint(Color.lightGray);//��������ͼ����ɫ 
			//���������С����״ 
			Font font = new Font("����", Font.BOLD, 16); 
			TextTitle title = new TextTitle("Window-Rate", font); 
			chart.setTitle(title); 
			//������ 
			TextTitle subtitle = 
			new TextTitle("ͼ��", new Font("����", Font.BOLD, 12)); 
			chart.addSubtitle(subtitle); 
			chart.setTitle(title); //���� 

			CategoryPlot plot = (CategoryPlot) chart.getPlot();//��ȡͼ�εĻ��� 
			plot.setBackgroundPaint(Color.lightGray);//�������񱳾�ɫ 
			plot.setDomainGridlinePaint(Color.black);//������������(Domain��)��ɫ 
			plot.setRangeGridlinePaint(Color.white);//�������������ɫ 
			plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));//��������ͼ��xy��ľ��� 
			plot.setDomainCrosshairVisible(true); 
			plot.setRangeCrosshairVisible(true); 
			LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer(); 
			renderer.setDrawOutlines(true); 
			renderer.setUseFillPaint(true);
			renderer.setShapesVisible(true);//���������Ƿ���ʾ���ݵ� 
			
			
			// ��ʾ���ݵ����ֵ
			CategoryItemRenderer item = plot.getRenderer();
			item.setBaseItemLabelsVisible(true);
	        item.setPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
	        item.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	        item.setBaseItemLabelFont(new Font("Dialog", 1, 14));
	        plot.setRenderer(item);



			
			
			
			
			
			//customise the range axis...
			NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
			rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

			ChartRenderingInfo info = new ChartRenderingInfo( new StandardEntityCollection()); 
			try 
			{ 
				  HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST); 

				HttpSession session = request.getSession(); 

			fileName = ServletUtilities.saveChartAsPNG(chart,1200,400, info,session);//����ͼƬ 
			//String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;

			} 
			catch (IOException e) 
			{ 
			e.printStackTrace(); 
			} 
			ActionContext actionContext = ActionContext.getContext();

			Map session = actionContext.getSession();
			
			session.put("fileName",fileName);


			return SUCCESS;

}
}

