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
* 曲线图的绘制 
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
	* 返回生成图片的文件名 
	* @param session 
	* @param pw 
	* @return 生成图片的文件名 
	*/ 
	/*
	public String getLineXYChart(HttpSession session, PrintWriter pw) 
	{ 
	 DefaultCategoryDataset dataset = new DefaultCategoryDataset();;//建立数据集 
	 dataset=this.createDateSet();
	String fileName = null; 
	//建立JFreeChart 
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
	//设置JFreeChart的显示属性,对图形外部部分进行调整 
	chart.setBackgroundPaint(Color.red);//设置曲线图背景色 
	//设置字体大小，形状 
	Font font = new Font("宋体", Font.BOLD, 16); 
	TextTitle title = new TextTitle("Trait-Plantheight", font); 
	chart.setTitle(title); 
	//副标题 
	TextTitle subtitle = 
	new TextTitle("图表", new Font("黑体", Font.BOLD, 12)); 
	chart.addSubtitle(subtitle); 
	chart.setTitle(title); //标题 

	CategoryPlot plot = (CategoryPlot) chart.getPlot();//获取图形的画布 
	plot.setBackgroundPaint(Color.lightGray);//设置网格背景色 
	plot.setDomainGridlinePaint(Color.black);//设置网格竖线(Domain轴)颜色 
	plot.setRangeGridlinePaint(Color.white);//设置网格横线颜色 
	plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));//设置曲线图与xy轴的距离 
	plot.setDomainCrosshairVisible(true); 
	plot.setRangeCrosshairVisible(true); 
	LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer(); 
	renderer.setDrawOutlines(true); 
	renderer.setUseFillPaint(true);
	renderer.setShapesVisible(true);//设置曲线是否显示数据点 
	//customise the range axis...
	NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

	ChartRenderingInfo info = new ChartRenderingInfo( 
	new StandardEntityCollection()); 
	try 
	{ 
	fileName = ServletUtilities.saveChartAsPNG(chart,900,400, info, 
	session);//生成图片 
	// Write the image map to the PrintWriter 
	ChartUtilities.writeImageMap(pw, fileName, info, false); 
	} 
	catch (IOException e) 
	{ 
	e.printStackTrace(); 
	} 
	pw.flush(); 
	return fileName;//返回生成图片的文件名 
	} 
	/** 
	* 建立生成图形所需的数据集 
	* @return 返回数据集 
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
			  //replace(pos_New,',','')将字符串pos_New中的所有‘，’字符去掉  convert()将字符串转换为数字
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
	
	
	
	
	 DefaultCategoryDataset dataset = new  DefaultCategoryDataset();//时间曲线数据集合 
		//Series s1 = new Series("历史曲线", Day.class);//创建时间数据源，每一个//TimeSeries在图上是一条曲线 
		//s1.add(new Day(day,month,year),value),添加数据点信息 
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
			//建立JFreeChart 
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
			//设置JFreeChart的显示属性,对图形外部部分进行调整 
			chart.setBackgroundPaint(Color.lightGray);//设置曲线图背景色 
			//设置字体大小，形状 
			Font font = new Font("宋体", Font.BOLD, 16); 
			TextTitle title = new TextTitle("Window-Rate", font); 
			chart.setTitle(title); 
			//副标题 
			TextTitle subtitle = 
			new TextTitle("图表", new Font("黑体", Font.BOLD, 12)); 
			chart.addSubtitle(subtitle); 
			chart.setTitle(title); //标题 

			CategoryPlot plot = (CategoryPlot) chart.getPlot();//获取图形的画布 
			plot.setBackgroundPaint(Color.lightGray);//设置网格背景色 
			plot.setDomainGridlinePaint(Color.black);//设置网格竖线(Domain轴)颜色 
			plot.setRangeGridlinePaint(Color.white);//设置网格横线颜色 
			plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));//设置曲线图与xy轴的距离 
			plot.setDomainCrosshairVisible(true); 
			plot.setRangeCrosshairVisible(true); 
			LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer(); 
			renderer.setDrawOutlines(true); 
			renderer.setUseFillPaint(true);
			renderer.setShapesVisible(true);//设置曲线是否显示数据点 
			
			
			// 显示数据点的数值
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

			fileName = ServletUtilities.saveChartAsPNG(chart,1200,400, info,session);//生成图片 
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

