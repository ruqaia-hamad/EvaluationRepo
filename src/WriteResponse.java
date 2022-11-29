import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WriteResponse {
	public static void Write() throws IOException, InterruptedException {
		String url = "http://api.coindesk.com/v1/bpi/currentprice.json";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String responseB = response.body();
		try {
			FileWriter file = new FileWriter(
					"C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\writefile.txt");
			file.write(responseB);
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("JSON file created");

	}

	public static void Read() {
		try {
			FileReader reader = new FileReader(
					"C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\writefile.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String brRead;

			while ((brRead = bufferedReader.readLine()) != null) {
				System.out.println(brRead);
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
