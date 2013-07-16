/**
 * 
 */
package org.racgupta.EasyCharts;

/**
 * @author racgupta
 * 
 */
public class XYChart extends Chart {

	
	

	public XYChart() {
		super();
		xAxis = new Axis();
		yAxis = new Axis();
		xAxis.setOrient("bottom");
		yAxis.setOrient("left");
		
	}

	private Axis xAxis;
	private Axis yAxis;

	private String dataCode;
	private String domainCode;
	private String axisCode;
	
	public String getDataCode() {
		if(convertData())
			return this.dataCode;
		else
			return null;
	}

	private String xyChartCode;
	
private Boolean convertData()
{
	dataCode = "var data=[";	
	if(xAxis.data.length != yAxis.data.length )
		return false;
	for(int i =0;i<xAxis.getData().length;i++)
	{
		dataCode +="{x:"+ xAxis.getData()[i]+",y:"+yAxis.getData()[i]+"},";
	}
	dataCode+="];\n";
	return true;
	
}
	public String getXYChartCode() {
		
		xyChartCode = getRegionCode();
		xyChartCode += getDataCode();		
		xyChartCode += getDomainCode();
		xyChartCode += getAxisCode();
		xyChartCode += "svg.append(\"g\")"+
				".attr(\"class\",\"x axis\")"+
				".attr(\"transform\", \"translate(0," + getHeight()+ ")\")"+
				".call(xAxis);"+
				"svg.append(\"g\")"+
				".attr(\"class\", \"y axis\")"+
				".call(yAxis);\n";
		
		return xyChartCode;
	}

	public void setxAxis(Axis xAxis) {
		this.xAxis = xAxis;
	}

	public void setyAxis(Axis yAxis) {
		this.yAxis = yAxis;
	}

	
	public String getDomainCode() {

		domainCode = "var xDomain=d3.extent(data, function(d) { return d.x; });\n";
		domainCode += "var yDomain=d3.extent(data, function(d) { return d.y; });\n";		
		domainCode += "x.domain(xDomain);\n";
		domainCode += "y.domain(yDomain);\n";
		return domainCode;
	}
	
	
	public String getAxisCode() {
		axisCode = "var xAxis = d3.svg.axis().scale(x).orient(\"" + xAxis.getOrient()+ "\");\n";
		axisCode += "var yAxis = d3.svg.axis().scale(y).orient(\""+ yAxis.getOrient()+ "\");\n";		
		return axisCode;
	}


}
