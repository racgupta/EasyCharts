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
		return lineChartCode;
 
	}

	public static void main(String args[])
	{
		int[] values = { 10, 15, 12, 14, 16, 8, 9, 10,14,17,14,12,68,90,32,46,22,24,80,22,78,12,98};
		String[] users1 = { "A", "B", "C", "D", "E", "F", "G", "H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W"};
		int[] users = { 10, 20, 30, 40, 50, 60, 70, 80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230 };
		LineChart lc = new LineChart();
		lc.setTitle("Customized chart using D3JS");
		
		Axis x = new Axis();
		Axis y = new Axis();
		
		x.setTitle("Users"); //optional		
		x.setOrient("bottom"); //Optional
		
		
		// Use only one of below three function
		x.setMin(0);		//Optional
		x.setMax(300);		//Optional
		x.setDomain(0,300);		//Optional
		x.setTickCount(30);
	
		
		x.setData(users);
		
		y.setTitle("Values");		// optional
		y.setOrient("left");		//optional
		y.setData(values);
		
		lc.setxAxis(x);
		lc.setyAxis(y);
		System.out.println(lc.getLineChartCode());
		
	}	
}

