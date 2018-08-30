import java.util.ArrayList;
import java.util.List;

public class Result {

	private String city;
	private int totalJobs;
	private List<JobLanguage> languages;
	
	public Result(String city) {
		this.city = city;
		languages = new ArrayList<JobLanguage>();
		totalJobs = 0;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getTotalJobs() {
		languages.forEach((l) -> {
			totalJobs = totalJobs + l.getTotal();
		});
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
	
}
