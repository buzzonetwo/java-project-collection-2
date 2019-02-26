import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class Driver2Decompress {

	public static void main(String[] args) throws IOException {


		String line2;
		File file2 = null;
		boolean fileCheck2 = true;
		while (fileCheck2) {
				line2 = Driver.getInput("Type in a file name to read from:");
				file2 = new File(line2);
				if (file2.exists())	fileCheck2 = false;
				else System.out.println("No file with that name");
		} 
		
		Decompressor d = new Decompressor(file2);
		String s = d.decode();
		String line4 = Driver.getInput("Type in a file name to output decompressed text to:");
		try {
			PrintWriter writer2 = new PrintWriter(new FileOutputStream(line4));
			writer2.write(s);
			writer2.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Type in a name next time");
		}

	}

}
