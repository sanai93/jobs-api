import java.util.List;

public class Main {
	
	private static JobsServiceImpl jobsService;

	public static void main(String[] args) throws Exception {

		jobsService = new JobsServiceImpl();
		//get response from Github
		List<Response> response = jobsService.getJobsByCity("Boston");
		//convert json response to a Result object
		//print the summary
		jobsService.printSummary(jobsService.createResult(response));

	}

}
