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
	
	public String getTitleCode()
	{
		this.titleCode = "svg.append(\"text\").attr(\"x\","+getTotalWidth()/2+").attr(\"y\","+(0-getTopMargin()/2)+")"+       
        ".attr(\"text-anchor\", \"middle\").style(\"font-size\", \"12px\").style(\"text-decoration\", \"underline\")"+  
        ".text(\""+title+"\");\n";
		return this.titleCode;
	}
	
	
	public Chart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
