package org.racgupta.EasyCharts;

public class Region {

	private int totalWidth;
	private int totalHeight;
	private int leftMargin;
	private int rightMargin;
	private int topMargin;
	private int bottomMargin;

	private int width;
	private int height;

	
	private String xArea;	
	private String yArea;
	private String regionCode;
	private String svgRegion;

	public Region() {
		super();
		this.totalWidth = 800;
		this.totalHeight = 600;
		this.leftMargin = 40;
		this.rightMargin = 20;
		this.topMargin = 40;
		this.bottomMargin = 40;
		

	}	


	public String getSvgRegion() {
		this.svgRegion = "var svg = d3.select(\"body\").append(\"svg\")"+
			    ".attr(\"width\","+this.totalWidth+")"+
			    ".attr(\"height\","+this.totalHeight+")"+
			    ".append(\"g\")"+
			    ".attr(\"transform\", \"translate(" + this.leftMargin + "," + this.topMargin + ")\");\n";
		
		return svgRegion;
		
	}


	public int getTotalWidth() {
		return totalWidth;
	}

	public int getTotalHeight() {
		return totalHeight;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLeftMargin() {
		return leftMargin;
	}

	public void setLeftMargin(int leftMargin) {
		this.leftMargin = leftMargin;
	}

	public int getRightMargin() {
		return rightMargin;
	}

	public void setRightMargin(int rightMargin) {
		this.rightMargin = rightMargin;
	}

	public int getTopMargin() {
		return topMargin;
	}

	public void setTopMargin(int topMargin) {
		this.topMargin = topMargin;
	}

	public int getBottomMargin() {
		return bottomMargin;
	}

	public void setBottomMargin(int bottomMargin) {
		this.bottomMargin = bottomMargin;
	}

	public String getXLinearScale(){
		this.width = this.totalWidth - this.leftMargin - this.rightMargin;
		xArea="var x = d3.scale.linear().range([0," + getWidth()+"]);\n";
		return xArea;
		
	}
	public String getXTimeScale(){
		this.width = this.totalWidth - this.leftMargin - this.rightMargin;
		xArea="var x = d3.time.scale().range([0," + getWidth()+"]);\n";
		return xArea;
		
	}
	public String getYArea(){
		this.height = this.totalHeight - this.topMargin - this.bottomMargin;
		yArea="var y = d3.scale.linear().range(["+ getHeight()+",0]);\n";
		return yArea;
		
	}
	
	public String getRegionCode()
	{
		this.regionCode = getXLinearScale()+getYArea()+getSvgRegion();
		return regionCode;
	}
}
