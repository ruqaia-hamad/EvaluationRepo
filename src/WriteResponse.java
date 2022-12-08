import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;

public class WriteResponse {
	public static void write() throws IOException, InterruptedException {
		String url = "http://api.coindesk.com/v1/bpi/currentprice.json";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String responseB = response.body();

		FileWriter file = new FileWriter("C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\writefile2.txt");
		file.write(responseB);
		file.close();
		
	
		System.out.println("JSON file created");
		if (responseB.contains("error")) {

			Gson gson = new Gson();
			ErrorHandler errorhandler = gson.fromJson(responseB, ErrorHandler.class);
			System.out.println(errorhandler.getError());
		}

	}

	public static void read() {
		
		
		StringBuilder builder = new StringBuilder();
		String convertToString = " ";
		try {
		
			FileReader reader = new FileReader(
					"C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\writefile2.txt");

			BufferedReader bufferedReader = new BufferedReader(reader);

			String brRead;

			while ((brRead = bufferedReader.readLine()) != null) {
				  builder.append(brRead).append("\n");
	
				System.out.println(brRead);
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();

		}
		convertToString =  builder.toString();

	}
	public static void createDirectroy() {
		
		String path = "C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\MoveFromPDF";

		File file2 = new File(path);

		boolean bool = file2.mkdir();
		if (bool) {
			System.out.println("Directory created successfully");
		} else {
			System.out.println("Sorry couldn’t create specified directory");
		}
	
		
	}
}
