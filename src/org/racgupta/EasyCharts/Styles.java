package org.racgupta.EasyCharts;

public class Styles {

	private String textDecoration = "";
	private String fill = "";
	private String stroke = "";
	private String fontFamily = "";
	private String fontSize = "";
	private String name;
	private String styleCode;
	
	public String getTextDecoration() {
		if (textDecoration.length()>0)
			return ".style(\"text-decoration\",\""+textDecoration+"\")";
		else
			return "";
	}
	public void setTextDecoration(String textDecoration) {
		this.textDecoration = textDecoration;
	}
	public String getFill() {
		if(fill.length()>0)
			return ".style(\"fill\",\""+fill+"\")";
		else
			return "";
	}
	public void setFill(String fill) {
		this.fill = fill;
	}
	public String getStroke() {
		if(stroke.length()>0)
			return ".style(\"stroke\",\""+stroke+"\")";
		else
			return "";
	}
	public void setStroke(String stroke) {
		this.stroke = stroke;
	}
	public String getFontFamily() {
		if(fontFamily.length()>0)
			return ".style(\"font-family\",\""+fontFamily+"\")";
		else
			return "";
	}
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	public String getFontSize() {
		if(fontSize.length()>0)
			return ".style(\"font-size\",\""+fontSize+"\")";
		else
			return "";
	}
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}
	
	public String getStyles()
	{
		return getFill()+getFontFamily()+getFontSize()+getStroke()+getTextDecoration();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getStyleCode(){
		styleCode = "svg.selectAll(\""+getName()+"\")"+getStyles()+";";
		return styleCode;
	}
}
