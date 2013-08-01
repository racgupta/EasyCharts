/**
 * 
 */
package org.racgupta.EasyCharts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;




/**
 * @author racgupta
 *
 */
public class MultiLineChart extends XYChart {

	private String lineChartCode;
	private Styles lineStyle;
	private Styles textStyle;
	ArrayList<Line> lines;
	
	public MultiLineChart() {
		super();
		lineStyle = new Styles();
		textStyle = new Styles();
		lineStyle.setFill("none");
		lineStyle.setStroke("blue");
		textStyle.setFontFamily("sans-serif");
		textStyle.setName("text");
		textStyle.setFontSize("11");
		lines = new ArrayList<Line>();
	}

	public String getLineChartCode(){
		lineChartCode = getXYChartCode();
		
		lineChartCode += "var line = d3.svg.line()"+
		   ".x(function(d) { return x(d.x); })"+
		    ".y(function(d) { return y(d.y); });\n";
		lineChartCode +=  "svg.append(\"path\")"+
			      		  ".datum(data)"+lineStyle.getStyles()+
			      		  ".attr(\"class\", \"line\")"+
			      		  ".attr(\"d\", line);\n";
		lineChartCode += getLinesCode();
		return lineChartCode;
 
	}
	
	public void addLines(Line l)
	{
		lines.add(l);
	}
	
	
	public String getLinesData()
	{
		String linesCode = "";
		//int i = 2;
		
		for (Line line : lines)
		{
			linesCode += convertData(line.getData());
		}
		return linesCode;
	}
	
	public String getLinesCode(){
		String linesCode = "";
		for (Line line : lines)
		{ 
			linesCode +=  "svg.append(\"path\")"+
		      		  ".datum("+convertData(line.getData())+")"+lineStyle.getStyles()+
		      		  ".attr(\"class\", \"line\")"+
		      		  ".attr(\"d\", line);\n";
		}
		return linesCode;
 
	}
	

	public static void main(String args[])
	{
		int[] values = { 10, 15, 12, 14, 16, 8, 9, 10,14,17,14,12,68,90,32,46,22,24,80,22,78,12,98};
		int[] data2  = { 1, 65, 62, 64, 66, 48, 79, 80,74,77,74,72,18,10,12,16,22,24,10,72,18,42,8};
		String[] users1 = { "A", "B", "C", "D", "E", "F", "G", "H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W"};
		int[] users = { 10, 20, 30, 40, 50, 60, 70, 80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230 };
		MultiLineChart lc = new MultiLineChart();
		lc.setTitle("Customized chart using D3JS");
		
		Line l = new Line();
		l.setData(data2);
		
		lc.addLines(l);
        Date[] dates = new Date[23];
        
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        int numDays = 23;
        
        // go 30 days back
        c.add(Calendar.DATE, 0 - numDays);
        
        // start a loop
        for(int i = 0; i < numDays; i++) {
               c.add(Calendar.DATE, i);
               dates[i] = c.getTime();
        }
        
        // here you have the date array for last 30 days
  //      System.out.println(Arrays.toString(dates));

		Axis x = new Axis();
		Axis y = new Axis();
		
		x.setTitle("Users"); //optional		
		x.setOrient("bottom"); //Optional
		
		
		// Use only one of below three function
		//x.setMin(0);		//Optional
		//x.setMax(300);		//Optional
		//x.setDomain(0,300);		//Optional
//		x.setTickCount(30);
	
		
		//x.setData(users);
		x.setData(dates);
		y.setTitle("Values");		// optional
		y.setOrient("left");		//optional
		y.setData(values);
		
		lc.setxAxis(x);
		lc.setyAxis(y);
		System.out.println(lc.getLineChartCode());
		
	}	
	
}

