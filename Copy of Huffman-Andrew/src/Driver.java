import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
	
	/**
	 * Reads a string and exits if it has contains only whitespace and cancel
	 * @param s the input string
	 * @return the input string
	 * @throws IOException
	 */
	public static String getInput(String s) throws IOException {
		System.out.println(s);
		BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
		String str = input1.readLine();
		if (str.replaceAll(" ", "").compareToIgnoreCase("cancel") == 0) {
			System.exit(0);
		}
		return str;
	}

	public static void main(String[] args) throws IOException {
		
		String line1;
		Scanner scanner1 = null;
		boolean fileCheck1 = true;
		do {
			try {
				line1 = getInput("Type in a file name to read from:");
				scanner1 = new Scanner(new File(line1));
				fileCheck1 = false;
			}
			catch (FileNotFoundException e) {
				System.out.println("No file with that name");
			}
		} while (fileCheck1);
		
		String str = "";
		if (scanner1.hasNext()) {
			str = scanner1.nextLine();
			while (scanner1.hasNext()) {
				str = str + "\n";
				str += scanner1.nextLine();
			}

			String end = "\u0004";
			str += end;
			scanner1.close();
			
			Compressor c = new Compressor(str);
			String str2 = c.tableMap().toString();
			if (str2.indexOf("\n") > 0) {
				str2 = str2.substring(0,str2.indexOf("\n")) + "newline" + str2.substring(str2.indexOf("\n")+1);
			}
			str2 = str2.substring(0,str2.indexOf(end)) + "EOT" + str2.substring(str2.indexOf(end)+1);
			
			String line3 = getInput("Type in a file name to output table to:");
			PrintWriter writer = new PrintWriter(line3, "UTF-8");
			writer.print(str2);
			writer.close();
		}
		else {
			System.out.println("Nothing in file");
		}
	}
}
