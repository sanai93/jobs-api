import java.util.List;

public class Main {
	
	private static JobsServiceImpl jobsService;
	private static ResourceCollection<List<Result>> collection;
	
	public static void main(String[] args) throws Exception {

		jobsService = new JobsServiceImpl();
		collection = new ResourceCollection<List<Result>>();
		String[] cities = {"Boston", "Denver"}; 
		String[] jobs = {"Python", "Java"};
		
		//get response from Github
		for(String city : cities) {
			List<Response> response = jobsService.getJobsByCity(city);
			for(String job : jobs) {
				List<Result> results = jobsService.createResult(response, job);
				collection.addItem(results);
			}
		}
		//print the summary
		jobsService.printSummary(collection);
	}

}
