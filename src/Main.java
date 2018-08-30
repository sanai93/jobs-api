import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static JobsServiceImpl jobsService;
	//private static ResourceCollection<> collection;
	private static List<Result> results;
	
	public static void main(String[] args) throws Exception {

		jobsService = new JobsServiceImpl();
		results = new ArrayList<>();
		//collection = new ResourceCollection<>();
		//String[] cities = {"Boston", "San Francisco", "Los Angeles" ,"Denver", "Boulder", "Chicago", "New York"};
		String[] cities = {"Boston"};
		String[] languages = {"Python", "Java"};
		
		//get response from Github
		for(String city : cities) {
			List<Response> jobs = jobsService.getJobsByCity(city);
			Result result = new Result(city);
			for(String language : languages) {
				JobLanguage jobLanguage = jobsService.searchJobsInCityByLanguage(result, jobs, language);
				result.getLanguages().add(jobLanguage);
				//collection.addItem(result);
			}
			results.add(result);
		}
		//print the summary
		//jobsService.printSummary(collection);
		jobsService.printSummary(results);
	}
	
}
