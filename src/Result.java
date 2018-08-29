import java.util.ArrayList;
import java.util.List;

public class Result {

	private String city;
	private int totalJobs;
	private List<JobLanguage> languages;
	private List<String> pythonJobs;
	//private jobType;
	
	public Result() {
		pythonJobs = new ArrayList<String>();
		languages = new ArrayList<JobLanguage>();
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
	public List<JobLanguage> getLanguages() {
		return languages;
	}
	public void setLanguages(List<JobLanguage> language) {
		this.languages = language;
	}
	public List<String> getPythonJobs() {
		return pythonJobs;
	}
	public void setPythonJobs(List<String> pythonJobs) {
		this.pythonJobs = pythonJobs;
	}
	
}
