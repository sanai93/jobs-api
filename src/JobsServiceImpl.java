import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JobsServiceImpl implements JobsService {

	@Override
	public List<Response> getJobsByCity(String city) throws Exception {
		List<Response> responses = new ArrayList<Response>();
		
		Response job = new Response();
		Gson gson = new Gson();
		
		//assemble url based on search parameters
		URL url = new URL("https://jobs.github.com/positions.json?location=" + city);

		//create HTTP connection
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.connect();

		//read the output
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line + "\n");
		}
		reader.close();
		
		//convert JSON to Response object
		String json = stringBuilder.toString();
		/*System.out.println("string builder:");
		System.out.println(json);
		System.out.println("GSON:");*/
		
		responses = gson.fromJson(json, new TypeToken<List<Response>>(){}.getType());
		//responses.forEach(x -> System.out.println(x.getLocation()));
		
		//add each response to the list of responses
		
		return responses;
	}

	@Override
	public List<Result> createResult(List<Response> response) {

		List<Result> summary = new ArrayList<Result>();
		
		response.forEach((r) -> {
			Result result = new Result();
			result.setCity(r.getLocation());
			
			if(r.getDescription().contains("Python")) {
				int fullTimeCount = 0;
				int partTimeCount = 0;
				
				JobLanguage python = new JobLanguage();
				python.setTitle("Python");
				if(r.getType().equalsIgnoreCase("full time")) {
					fullTimeCount++;
				} else {
					partTimeCount++;
				}
				python.setFullTime(fullTimeCount);
				python.setPartTime(partTimeCount);
				result.getLanguages().add(python);
				result.getPythonJobs().add(r.getId());
			}
			
			summary.add(result);
		});
		
		return summary;
	}

	@Override
	public void printSummary(List<Result> summary) {
		summary.forEach((item) -> {
			System.out.println(item.getCity() + ":");
			for(JobLanguage l : item.getLanguages()) {
				System.out.println("  language " + l.getTitle() + " Total: " + l.getTotal());
				System.out.println("    Full Time: " + l.getFullTime());
				System.out.println("    Part Time: " + l.getPartTime());
			}
		});
	}

}
