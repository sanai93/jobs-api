import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static JobsServiceImpl jobsService;
	private static List<Result> results;
	
	public static void main(String[] args) throws Exception {

		jobsService = new JobsServiceImpl();
		results = new ArrayList<>();
		String[] cities = {"Boston", "San Francisco", "Los Angeles" ,"Denver", "Boulder", "Chicago", "New York"};
		String[] languages = {"Python", "Java", "JavaScript", "C#"};
		
		//get response from Github
		for(String city : cities) {
			//JSON to Response object
			List<Response> jobs = jobsService.getJobsByCity(city);
			Result result = new Result(city);
			//loop through each city and identify part time and full time jobs for each city
			for(String language : languages) {
				JobLanguage jobLanguage = jobsService.searchJobsInCityByLanguage(result, jobs, language);
				result.getLanguages().add(jobLanguage);
			}
			results.add(result);
		}
		//print the summary
		jobsService.printSummary(results);
	}
	
}
