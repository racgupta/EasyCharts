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
	private long tickInterval;
	private String unit;
	private String orient;
	int[] data;
	Date[] dateData;
	private String Domain;
	
	
	
	public String getData(int i)
	{
		if(i>data.length)
			return dateData[i].toGMTString();
		return ""+data[i];
	}
	
	
	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public void setData(Date[] data) {
		this.dateData = data;
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
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}

	public long getTickInterval() {
		return tickInterval;
	}

	public void setTickInterval(long tickInterval) {
		this.tickInterval = tickInterval;
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
		return Domain;
	}

	public void setDomain(String domain) {
		Domain = domain;
	}
	
	
}
