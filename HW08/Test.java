import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Test {
	public static void main(String[] args) {
		try {
			String str = "";
			File f = new File("reviewNeethu.txt");
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.startsWith("Rating")){
					str = line.substring(8,line.length());
				}
			}

		} catch (FileNotFoundException e) {

		}

		
	}
}