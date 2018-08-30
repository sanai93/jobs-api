import java.util.List;

public interface JobsService {

	public List<Response> getJobsByCity(String city) throws Exception;
	
	public JobLanguage searchJobsInCityByLanguage(Result result, List<Response> response, String language);
	
	//public void printSummary(ResourceCollection<List<Result>> summary);
	public void printSummary(List<Result> summary);
}
