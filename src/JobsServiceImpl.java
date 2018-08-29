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
		URL url;
		url = new URL("https://jobs.github.com/positions.json?description=python&location=" + city);

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
		System.out.println("string builder:");
		System.out.println(json);
		System.out.println("GSON:");
		
		responses = gson.fromJson(json, new TypeToken<List<Response>>(){}.getType());
		responses.forEach(x -> System.out.println(x.getLocation()));
		
		
		//add each response to the list of responses
		System.out.println(job.getLocation());
		
		return null;
	}

}
