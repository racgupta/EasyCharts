package org.racgupta.EasyCharts;

public class Line {
	
		public Line() {
		}


		private String title;
		private int[] data;
		private int dataLen = -1;
		private String color;
		
		public String getColor() {
			return color;
		}


		public void setColor(String color) {
			this.color = color;
		}


		public String getData(int i)
		{
			if(dataLen>-1)
				return ""+data[i];
			return "";
		}
		
		public int[] getData()
		{
			return data;
		}

		public void setData(int[] data) {
			this.data = data;
			this.dataLen = data.length;
			
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		
	}

