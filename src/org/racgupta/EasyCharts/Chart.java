/**
 * 
 */
package org.racgupta.EasyCharts;

/**
 * @author racgupta
 *
 */
public class Chart extends Region {

	private String title = "Line Chart";
	
	private String titleCode;
	
	private Styles titleStyle;
	
	public String getTitleCode()
	{
		this.titleCode = "svg.append(\"text\").attr(\"x\","+getTotalWidth()/2+").attr(\"y\","+(0-getTopMargin()/2)+")"+       
        ".attr(\"text-anchor\", \"middle\")"+titleStyle.getStyles()+  
        ".text(\""+title+"\");\n";
		return this.titleCode;
	}
	
	
	public Chart() {
		super();
		titleStyle = new Styles();
		titleStyle.setFontSize("12");
		titleStyle.setFontFamily("sans-serif");
		titleStyle.setTextDecoration("underline");
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
