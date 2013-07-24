/**
 * 
 */
package org.racgupta.EasyCharts;

/**
 * @author racgupta
 * 
 */
public class XYChart extends Chart {

		Styles lineStyle;
		Styles textStyle;
		private String domainCode;
	

	public XYChart() {
		super();
		lineStyle = new Styles("path.domain");
		lineStyle.setFill("none");
		lineStyle.setStroke("#000");
		textStyle = new Styles();
		textStyle.setFontSize("12");
		textStyle.setFontFamily("sans-serif");
	}
	private Axis xAxis;
	private Axis yAxis;
	private String axisCode;
	private String dataCode;
	private String axisTitle;
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
	
	if(xAxis.getDataLen() != yAxis.getDataLen())
		return false;
	for(int i =0;i<xAxis.getDataLen();i++)
	{
		dataCode +="{x:"+ xAxis.getData(i)+",y:"+yAxis.getData(i)+"},";
	}
	dataCode+="];\n";
	return true;
	
}
	public String getXYChartCode() {
		xyChartCode = getDataCode();	
		xyChartCode += getRegionCode();
		xyChartCode += getDomainCode();
		xyChartCode += getAxisCode();
		xyChartCode +=getTitleCode();
		xyChartCode += "svg.append(\"g\")"+
				".attr(\"class\",\"x axis\")"+textStyle.getStyles()+
				".attr(\"transform\", \"translate(0," + getHeight()+ ")\")"+
				".call(xAxis);\n";
		xyChartCode +="svg.append(\"text\").attr(\"x\","+(getTotalWidth()/2)+").attr(\"y\","+(getHeight()+getBottomMargin())+")"+
				textStyle.getStyles()+".attr(\"text-anchor\", \"middle\").text(\""+xAxis.getTitle()+"\");\n";
		xyChartCode +="svg.append(\"g\")"+
				".attr(\"class\", \"y axis\")"+textStyle.getStyles()+
				".call(yAxis);\n";
		xyChartCode +="svg.append(\"text\").attr(\"y\","+(0-getLeftMargin())+").attr(\"dy\", \"1em\").attr(\"transform\",\"rotate(-90)\")"+
				textStyle.getStyles()+".attr(\"x\","+(0-getHeight()/2)+").attr(\"text-anchor\", \"middle\").text(\""+yAxis.getTitle()+"\");\n";
		xyChartCode += lineStyle.getStyleCode();
		return xyChartCode;
	}
	public void setxAxis(Axis xAxis) {
		this.xAxis = xAxis;
	}

	public void setyAxis(Axis yAxis) {
		this.yAxis = yAxis;
	}

	

	
	
	public String getAxisCode() {
		String test =(xAxis.getOrient()!=null) ?  xAxis.getOrient():"bottom"; 
		axisCode = "var xAxis = d3.svg.axis().scale(x).orient(\"" + test+ "\")";
		axisCode += (xAxis.getTickCount()>0) ?  ".ticks("+xAxis.getTickCount()+")":"";
		axisCode += ";\n"; 
		test =(yAxis.getOrient()!=null) ?  yAxis.getOrient():"left";
		axisCode += "var yAxis = d3.svg.axis().scale(y).orient(\"" + test+ "\")";		
		axisCode += (yAxis.getTickCount()>0) ?  ".ticks("+yAxis.getTickCount()+")":"";
		axisCode += ";\n"; 
		return axisCode;
	}
	public String getAxisTitle(){
		axisTitle ="svg.append(\"text\").attr(\"x\","+(getTotalWidth()/2)+")"+
					".attr(\"y\","+(getHeight()+getBottomMargin()/2)+").attr(\"text-anchor\", \"middle\").text(\""+xAxis.getTitle()+"\");";
		axisTitle +="svg.append(\"text\").attr(\"y\","+(getTotalHeight()/2)+")"+
				".attr(\"x\","+(0-getLeftMargin()/2)+").attr(\"transform\", \"rotate(-90)\").attr(\"text-anchor\", \"middle\").text(\""+xAxis.getTitle()+"\");";

		return axisTitle;
	}

	public String getDomainCode() {
		if(xAxis.getDomain()!=null)
			domainCode = "x.domain("+xAxis.getDomain()+");\n";
		else
			domainCode = "x.domain(d3.extent(data, function(d) { return d.x; }));\n";
		if(yAxis.getDomain()!=null)
			domainCode += "y.domain("+yAxis.getDomain()+");\n";
		else
			domainCode +="y.domain(d3.extent(data, function(d) { return d.y; }));\n";
		return domainCode;
	}
	

}
