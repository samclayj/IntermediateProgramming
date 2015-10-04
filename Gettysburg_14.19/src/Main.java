import java.util.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
	
	public static void main(String[] args) {
				
		Scanner input = new Scanner(System.in);
		
		try {
			URL url = createURL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
			input = createScanner(url);
		}
		catch(MalformedURLException ex) {
			System.out.println("Bad URL.");
		}
		catch(IOException ex) {
			System.out.println("Error creating scanner.");
		}
		catch(Exception ex) {
			System.out.println("Something went horribly wrong.");
		}
		
		long count = 0;
		while(input.hasNext()) {
			String s = input.next();
			count++;
		}
		
		System.out.println("Number of words: " + count);
			
		
	}
	
	public static URL createURL(String s) throws MalformedURLException {
		URL url = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
		return url;
	}
	
	public static Scanner createScanner(URL url) throws IOException {
		Scanner input = new Scanner(url.openStream());
		return input;
	}

}
