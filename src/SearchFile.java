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
		
		Scanner sc = new Scanner(System.in);

		File file = new File("C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\writefile2.txt");

		String[] words = null;
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String x;

		System.out.print("Please enter the number of strings you want to enter" + "\n");
		int userinput = sc.nextInt();
		Set<String> wordSet = new HashSet<>();

		System.out.print("Please enter " + userinput + " words" + "\n");
		for (int i = 0; i < userinput; i++) {
			String userword = sc.next();
			wordSet.add(userword);

		}
		String result = String.join(" ", wordSet);
		System.out.println(result);
		int count = 0;
		while ((x = br.readLine()) != null) {
			words = x.split(" ");

			for (String word : words) {
				if (word.equals(result)) {

					System.out.println("the word is " + result);
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
	}

}
