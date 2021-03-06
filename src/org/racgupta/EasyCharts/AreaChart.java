/**
 * 
 */
package org.racgupta.EasyCharts;


/**
 * @author racgupta
 *
 */
public class AreaChart extends XYChart {

	private String areaChartCode;
	private Styles areaStyle;
	private Styles textStyle;
	
	public AreaChart() {
		super();
		areaStyle = new Styles();
		textStyle = new Styles();
		areaStyle.setFill("steelblue");
		textStyle.setFontFamily("sans-serif");
		textStyle.setName("text");
		textStyle.setFontSize("11");
		
		
		// TODO Auto-generated constructor stub
	}

	public String getLineChartCode(){
		areaChartCode = getXYChartCode();
		areaChartCode += "var line = d3.svg.area()"+
		   ".x(function(d) { return x(d.x); })"+
		   ".y0("+getHeight()+")"+ 
		   ".y1(function(d) { return y(d.y); });\n";
		areaChartCode +=  "svg.append(\"path\")"+
			      		  ".datum(data)"+areaStyle.getStyles()+
			      		  ".attr(\"class\", \"line\")"+
			      		  ".attr(\"d\", line);\n";
		return areaChartCode;
 
	}

	public static void main(String args[])
	{
		//int[] users = { 10, 15, 12, 14, 16};
		//int[] time = { 10, 20, 30, 40, 50};
		int[] users = { 10, 15, 12, 14, 16, 8, 9, 10};
		int[] time = { 100, 200, 300, 400, 500, 600, 700, 800 };

		//chart begins
		AreaChart lc = new AreaChart();
		lc.setTitle("Customized chart using D3JS");
		
		Axis x = new Axis();
		Axis y = new Axis();
		
		x.setTitle("Time");		
		x.setData(time);
		x.setOrient("bottom");
		
		y.setTitle("Users");		
		y.setData(users);
		y.setOrient("left");
		
		lc.setxAxis(x);
		lc.setyAxis(y);
		System.out.println(lc.getLineChartCode());
		
	}
		
}

