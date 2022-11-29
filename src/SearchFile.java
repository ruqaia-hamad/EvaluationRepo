import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearchFile {

	public static void Search() throws IOException {
		boolean isExit = true;
		while (isExit) {
			Scanner sc = new Scanner(System.in);

			File file = new File("C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\writefile2.txt");
			Set<String> wordSet = new HashSet<>();
			String[] words = null;
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String x;
			System.out.println("Please Enter Word");

			String userinput = sc.next();
			wordSet.add(userinput);

			int count = 0;
			while ((x = br.readLine()) != null) {
				words = x.split(" ");

				for (String word : words) {
					if (word.equals(userinput)) {

						System.out.println("the word is " + word);
						count++;

					}

				}
			}

			if (count != 0) {
				System.out.println("This word is present for " + count + " Times in the file");
			} else {
				System.out.println("This word is not in the file");
			}

			fileReader.close();
			System.out.println("if you want to add word to search press 1 and 2 to exit");
			Integer exit = sc.nextInt();
			if (exit == 1) {
				isExit = true;
			} else {
				isExit = false;
				System.out.println("GOOD BYE");
			}
		}
	}
}
