import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws Exception {

		sendRequest();

	}

	public static void sendRequest() throws Exception {
		URL url;

		url = new URL("https://jobs.github.com/positions.json?description=python&location=new+york");

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.connect();

		// read the output from the server
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuilder stringBuilder = new StringBuilder();

		String line = null;
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line + "\n");
		}

		reader.close();
		System.out.println(stringBuilder.toString());
	}

}
