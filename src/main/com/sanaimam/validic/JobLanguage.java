package com.sanaimam.validic;

public class JobLanguage {
	
	private String title;
	private int fullTime;
	private int partTime;
	private int total;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getFullTime() {
		return fullTime;
	}
	public void setFullTime(int fullTime) {
		this.fullTime = fullTime;
	}
	public int getPartTime() {
		return partTime;
	}
	public void setPartTime(int partTime) {
		this.partTime = partTime;
	}
	public int getTotal() {
		return this.total = this.fullTime + this.partTime;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fullTime;
		result = prime * result + partTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + total;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobLanguage other = (JobLanguage) obj;
		if (fullTime != other.fullTime)
			return false;
		if (partTime != other.partTime)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (total != other.total)
			return false;
		return true;
	}
	
}
