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
	private String domainCode;
	
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
		lineChartCode += getDomainCode();
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
		int[] users = { 10, 15, 12, 14, 16, 8, 9, 10,14,17,14,12,68,90,32,46,22,24,80,22,78,12,98};
		int[] time = { 10, 20, 30, 40, 50, 60, 70, 80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230 };
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
	
	public String getDomainCode() {

		domainCode = "var xDomain=d3.extent(data, function(d) { return d.x; });\n";
		domainCode += "var yDomain=d3.extent(data, function(d) { return d.y; });\n";		
		domainCode += "x.domain(xDomain);\n";
		domainCode += "y.domain(yDomain);\n";
		return domainCode;
	}
	
}

