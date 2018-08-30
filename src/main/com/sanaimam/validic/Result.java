package com.sanaimam.validic;
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
		totalJobs = 0;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + totalJobs;
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
		Result other = (Result) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (totalJobs != other.totalJobs)
			return false;
		return true;
	}
	
}
