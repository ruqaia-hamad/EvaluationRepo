import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDSimpleFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.text.PDFTextStripper;

public class SearchFile {

	public static void Search() throws IOException {
		boolean isExit = true;

		Scanner sc = new Scanner(System.in);
		System.out.print("Please choose form where you want Search: " + "\n");
		System.out.print("1-TXT" + "\n");
		System.out.print("2-PDF " + "\n");
		Integer choose = sc.nextInt();
		if (choose == 1) {
			File file = new File("C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\writefile2.txt");
			List<String> wordsList = new ArrayList<String>();
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
		} else if (choose == 2) {

			List<String> wordsListpdf = new ArrayList<String>();
			File file = new File("C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\random.pdf");

			PDDocument document = PDDocument.load(file);
		
		
//			System.out.println(br);
			String[] words = null;

			String userinput2 = null;
			System.out.print("Please enter the words you want to Search | writ EXIT to stop" + "\n");

			while (sc.hasNext()) {
				userinput2 = sc.nextLine();
				if (userinput2.equalsIgnoreCase("EXIT")) {
					break;
				}

				wordsListpdf.add(userinput2);
			}
			for (int i = 0; i < document.getNumberOfPages(); i++) {
			    PDPage page = document.getPage(i);
				PDFTextStripper ps = new PDFTextStripper();
				String br = ps.getText(document);
			for (String n : wordsListpdf) {
				if (br.contains(n)) {
				     System.out.println("Found word '" + n+ "' in page " + (i + 1));
			
				 	File sourcefile = new File("C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\random.pdf");
					File targetfile = new File(
							"C:\\Users\\user015\\eclipse-workspace\\EvaluationTaskRaqiya\\\\MoveFromPDF");
					Files.copy(sourcefile.toPath(), targetfile.toPath(),
							StandardCopyOption.REPLACE_EXISTING);
				}
				else {
				     System.out.println(n + "this word not found "   );
				}
			}

	

		}
			document.close();}
	}
}
