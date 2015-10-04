import java.io.*;
import java.util.*;

public class Terms {

	private static PrintWriter writer;

	public static void main(String[] args) {

		//get current directory
		File direct = new File("/Users/SamJ/Desktop/Terms/Plists");

		//get all of the files matching maze.* in the current directory
		File[] files = direct.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.matches(".*FlashCards.plist");
			}
		});

		for(File f: files) {
			try {
				Scanner termsReader = new Scanner(f);
				ArrayList<String> stringList = new ArrayList<String>();

				while(termsReader.hasNext()) {
					stringList.add(termsReader.nextLine());
				}
				
				int eIndex = f.getName().indexOf(".plist");
				writer = new PrintWriter(new FileOutputStream("/Users/SamJ/Desktop/Terms/Plists/TextFiles" + "/" + f.getName().substring(0, eIndex) + ".txt"), true);

				boolean isAnswer = false;
				writer.println(f.getName().substring(0, eIndex));
				writer.println();

				for(String s: stringList) {
					if(s.matches(".*<key>Prompt</key>.*")) {
						writer.println("Prompt:");
						isAnswer = false;
					}
					if(s.matches(".*<string>.*</string>.*")) {
						int startIndex = s.indexOf("<string>") + ("<string>".length());
						int endIndex = s.indexOf("</string>");
						writer.println("\t" + s.substring(startIndex, endIndex));
						if(isAnswer)
							writer.println();
					}
					if(s.matches(".*<key>Answer</key>.*")) {
						writer.println("Answer:");
						isAnswer = true;
					}
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		//Check if files were found
		if(files.length == 0) {
			System.out.println("No Files were found.");
			System.exit(0);
		}


	}
	
}
