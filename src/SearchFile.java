import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SearchFile {

	public static void Search() throws IOException {
		boolean isExit = true;

		Scanner sc = new Scanner(System.in);

		File file = new File("C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\writefile2.txt");
		List<String> wordsList = new ArrayList<>();
		String[] words = null;

		String userinput = null;
		System.out.print("Please enter the words you want to Search | writ EXIT to stop" + "\n");

		while (sc.hasNext()) {
			userinput = sc.nextLine();
			if (userinput.equalsIgnoreCase("EXIT")) {
				break;
			}

			wordsList.add(userinput);
		}

		for (String n : wordsList) {

			FileReader fileReader = new FileReader(file);

			BufferedReader br = new BufferedReader(fileReader);
			String x;
			int count = 0;
			while ((x = br.readLine()) != null) {
				words = x.split(" ");

				for (String word : words) {
					if (word.contains(n)) {

//						System.out.println("the word is " + n);
						count++;

					}

				}
			}

			if (count > 1) {

				System.out.println(n + " " + "This word is present for " + count + " Times in the file");
			} else if (count == 1) {

				System.out.println(n + "" + "This word is unique ");

			}

			else {
				System.out.println(n + " " + "This word is not in the file");
			}

			fileReader.close();

		}
	}
}
