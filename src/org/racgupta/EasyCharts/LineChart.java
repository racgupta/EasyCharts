/**
 * 
 */
package org.racgupta.EasyCharts;




/**
 * @author racgupta
 *
 */
public class LineChart extends XYChart {

	private String lineChartCode;
	private Styles lineStyle;
	private Styles textStyle;

	
	public LineChart() {
		super();
		lineStyle = new Styles();
		textStyle = new Styles();
		lineStyle.setFill("none");
		lineStyle.setStroke("blue");
//		lineStyle.setName("path");
		textStyle.setFontFamily("sans-serif");
		textStyle.setName("text");
		textStyle.setFontSize("11");
		
		
		// TODO Auto-generated constructor stub
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
	//	lineChartCode +=lineStyle.getStyleCode();
	//	lineChartCode +=textStyle.getStyleCode();
		return lineChartCode;
 
	}

	public static void main(String args[])
	{
		
		int[] users = { 10, 15, 12, 14, 16, 8, 9, 10};
		int[] time = { 100, 200, 300, 400, 500, 600, 700, 800 };
//		System.out.println("Inside Main"+time.length);
		//chart begins
		LineChart lc = new LineChart();
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

