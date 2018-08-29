import java.util.List;

public interface JobsService {

	public List<Response> getJobsByCity(String city) throws Exception;
	
	public List<Result> createResult(List<Response> response);
	
	public void printSummary(List<Result> summary);
}
