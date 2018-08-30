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
		Gson gson = new Gson();
		
		//assemble url based on search parameters
		URL url = new URL("https://jobs.github.com/positions.json?location=" + city.replace(" ", "+"));

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
		
		//convert JSON to Response object and add to List
		String json = stringBuilder.toString();
		responses = gson.fromJson(json, new TypeToken<List<Response>>(){}.getType());
		
		return responses;
	}

	@Override
	public List<Result> createResult(List<Response> response, String language) {

		List<Result> summary = new ArrayList<Result>();
		Result result = new Result();
		//loop through all the responses and convert to appropriate field in the Result object
		response.forEach((r) -> {
			result.setCity(r.getLocation());
			//check if description contains a specific job, and add to the list based on if it's full time or part time
			if(r.getDescription().toUpperCase().contains(language.toUpperCase())) {
				int fullTimeCount = 0;
				int partTimeCount = 0;
				JobLanguage jobLanguage = new JobLanguage();
				jobLanguage.setTitle(language);
				if(r.getType().equalsIgnoreCase("full time")) {
					fullTimeCount++;
				} else {
					partTimeCount++;
				}
				jobLanguage.setFullTime(fullTimeCount);
				jobLanguage.setPartTime(partTimeCount);
				result.getLanguages().add(jobLanguage);
			}
		});
		summary.add(result);
		return summary;
	}

	@Override
	public void printSummary(ResourceCollection<List<Result>> summary) {
		for(List<Result> r : summary.getItems()) {
			r.forEach((item) -> {
				System.out.println(item.getCity() + ":");
				for(JobLanguage l : item.getLanguages()) {
					System.out.println(" - " + l.getTitle() + " Total: " + l.getTotal());
					System.out.println("   - Full Time: " + l.getFullTime());
					System.out.println("   - Part Time: " + l.getPartTime());
				}
			});
		}
	}

}
