import java.util.ArrayList;
import java.util.List;

public class Result {

	private String city;
	private int totalJobs;
	private String language;
	private List<String> pythonJobs;
	//private jobType;
	
	public Result() {
		pythonJobs = new ArrayList<String>();
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getTotalJobs() {
		return totalJobs;
	}
	public void setTotalJobs(int totalJobs) {
		this.totalJobs = totalJobs;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<String> getPythonJobs() {
		return pythonJobs;
	}
	public void setPythonJobs(List<String> pythonJobs) {
		this.pythonJobs = pythonJobs;
	}
	
}
