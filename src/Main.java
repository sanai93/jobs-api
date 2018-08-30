import java.util.List;

public class Main {
	
	private static JobsServiceImpl jobsService;
	private static ResourceCollection<List<Result>> collection;
	
	public static void main(String[] args) throws Exception {

		jobsService = new JobsServiceImpl();
		collection = new ResourceCollection<List<Result>>();
		String[] cities = {"Boston", "San Francisco", "Los Angeles" ,"Denver", "Boulder", "Chicago", "New York"};
		//String[] cities = {"Denver"};
		String[] languages = {"Python", "Java"};
		
		//get response from Github
		for(String city : cities) {
			List<Response> jobs = jobsService.getJobsByCity(city);
			for(String language : languages) {
				List<Result> results = jobsService.createResult(jobs, language);
				collection.addItem(results);
			}
		}
		//print the summary
		jobsService.printSummary(collection);
	}
	
}
