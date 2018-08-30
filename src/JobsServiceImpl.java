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

		// assemble url based on search parameters
		URL url = new URL("https://jobs.github.com/positions.json?location=" + city.replace(" ", "+"));

		// create HTTP connection
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.connect();

		// read the output
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line + "\n");
		}
		reader.close();

		// convert JSON to Response object and add to List
		String json = stringBuilder.toString();
		responses = gson.fromJson(json, new TypeToken<List<Response>>() {
		}.getType());

		return responses;
	}

	@Override
	public JobLanguage searchJobsInCityByLanguage(Result result, List<Response> responses, String language) {

		JobLanguage jobLanguage = new JobLanguage();
		jobLanguage.setTitle(language);

		// loop through all the responses and convert to appropriate field in
		// the Result object
		responses.forEach((job) -> {
			int fullTimeCount = jobLanguage.getFullTime();
			int partTimeCount = jobLanguage.getPartTime();
			
			// check if description contains a specific job, and add to the list
			// based on if it's full time or part time
			if (job.getDescription().toUpperCase().contains(language.toUpperCase())) {
				if (job.getType().equalsIgnoreCase("full time")) {
					fullTimeCount++;
				} else {
					partTimeCount++;
				}
			}
			jobLanguage.setFullTime(fullTimeCount);
			jobLanguage.setPartTime(partTimeCount);
		});
		
		return jobLanguage;
	}

	@Override
	public void printSummary(List<Result> summary) {
		summary.forEach((item) -> {
			int totalJobs = item.getTotalJobs();
			System.out.println(item.getCity() + ": " + totalJobs + " total jobs");

			for (JobLanguage l : item.getLanguages()) {
				double fullTimePercent = (l.getFullTime() * 100) / totalJobs;
				double partTimePercent = (l.getPartTime() * 100) / totalJobs;

				System.out.println(" - " + l.getTitle() + ": " + l.getTotal() + " jobs");
				System.out.println("   - Full Time: " + fullTimePercent + "%");
				System.out.println("   - Part Time: " + partTimePercent + "%");
			}
		});
	}

}
