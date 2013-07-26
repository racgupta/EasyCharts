/**
 * 
 */

package org.racgupta.EasyCharts;

import java.util.Date;



/**
 * @author racgupta
 * 
 */
public class Axis{

	public Axis() {
	}


	private String title;
	private long min;
	private long max;
	private long tickCount = -1;
	
	private String unit;
	private String orient;
	private String domain;
	
	private int[] intData;
	private Date[] dateData;
	private String[] strData;
	
	private int dataLen = -1;
	private int intLen = -1;
	private int strLen = -1;
	private int dateLen = -1;
	
	public String getData(int i)
	{
		if(intLen>-1)
			return ""+intData[i];
		if(dateLen>-1)
			return dateData[i].toGMTString();
		if(strLen>-1)
			return strData[i];
		return "";
	}
	

	public void setData(int[] data) {
		this.intData = data;
		this.intLen = data.length;
		this.dataLen = data.length;
		
	}

	public void setData(Date[] data) {
		this.dateData = data;
		this.dateLen = data.length;
		this.dataLen = data.length;
	}
	
	public void setData(String[] data) {
		this.strData = data;
		this.strLen = data.length;
		this.dataLen = data.length;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getMin() {
		return min;
	}

	public void setMin(long min) {
		this.min = min; 
		this.domain = "["+min+",d3.max(data, function(d) { return d.x; })]";
		
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
		this.domain = "[d3.min(data, function(d) { return d.x; }),"+this.max+"]";
	}

	
	public void setDomain(long min, long max) {
		this.min = min;
		this.max = max;
		this.domain = "["+min+","+this.max+"]";
	}

	
	public long getTickCount() {
		return tickCount;
	}

	public void setTickCount(long tickCount) {
		this.tickCount = tickCount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getOrient() {
		return orient;
	}

	public void setOrient(String orient) {
		this.orient = orient;
	}

		
	public String getDomain() {
		return domain;
	}


	
	
	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getDataLen() {
		return dataLen;
	}
	
	
}
