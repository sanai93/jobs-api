public class Main {
	
	private static JobsServiceImpl jobsService;

	public static void main(String[] args) throws Exception {

		jobsService = new JobsServiceImpl();
		jobsService.getJobsByCity("Boston");

	}

}
