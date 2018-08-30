
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
	
}
