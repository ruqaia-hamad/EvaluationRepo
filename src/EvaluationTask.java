import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public  class EvaluationTask {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		boolean exitMenu = true;
		do {
			MainMenu.menu();
			Integer option = sc.nextInt();
			switch (option) {
			case 1:
				WriteResponse.Write();
				break;

			case 2:

				WriteResponse.Read();

				break;

			case 3:
				SearchFile.Search();

				break;

			case 4:
				MainMenu.thankMenu();
				exitMenu = false;
				break;

			}
		} while (exitMenu);
	}

}
