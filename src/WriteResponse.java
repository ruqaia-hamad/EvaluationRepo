import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
	public static void Write() throws IOException, InterruptedException {
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

	public static void Read() throws Throwable {
		
		
		
		
		File file = new File(	"C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\writefile2.txt");
		ObjectInputStream ois = null;
		try {
			if (file.isFile()) {
				ois = new ObjectInputStream(new FileInputStream(file));
				StringBuilder sb = (StringBuilder) new StringBuilder(ois.readObject().toString());
				ois.close();
				System.out.println(sb.toString() + "\n");

			}
		} catch (IOException exception) {
			System.out.println("An unexpected error is occurred.");
			exception.printStackTrace();
		}
	}

}
