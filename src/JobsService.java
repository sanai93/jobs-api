import java.util.List;

public interface JobsService {

	public List<Response> getJobsByCity(String city) throws Exception;
	
	public List<Result> createResult(List<Response> response, String language);
	
	public void printSummary(ResourceCollection<List<Result>> summary);
}
