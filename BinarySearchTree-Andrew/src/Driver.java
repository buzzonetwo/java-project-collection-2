import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
	
	public static DList<Integer> addSorted(DList<Integer> d, int x) {
		if (d.getLength() < 1) {
			d.addEnd(x);
		}
		else {
			boolean trigger = true;
			for (int i = -1; trigger && i < d.getLength(); i++) {
				if (x <= d.get(i)) {
					d.add(i, x);
					trigger = false;
				}
				else if (i == d.getLength()-1) {
					d.addEnd(x);
					trigger = false;
				}
			}
		}
		return d;
	}
	
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
		
		
		String line0;
		boolean strCheck0 = true;
		do {
			try {
				line0 = getInput("Would you like to use a \"list\" or a \"tree\"?");
				if (line0.replaceAll(" ", "").compareToIgnoreCase("tree") == 0 || line0.replaceAll(" ", "").compareToIgnoreCase("list") == 0) {
					strCheck0 = false;
				}
				else {
					System.out.println("That's not a \"list\" or a \"tree\"");
				}
			}
			finally {
			}
		} while (strCheck0);
		
		boolean treecheck = line0.replaceAll(" ", "").compareToIgnoreCase("tree") == 0;
		
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
		
		BST<Integer> b = new BST<Integer>();
		DList<Integer> d = new DList<Integer>();
		
		while (scanner1.hasNextInt()) {
			int g = scanner1.nextInt();
			if (treecheck) {
				b.add(g);
			}
			else {
				d = addSorted(d, g);
			}
		}
		scanner1.close();
		
		String line2;
		Scanner scanner2 = null;
		boolean fileCheck2 = true;
		do {
			try {
				line2 = getInput("Type in a file name to delete from:");
				scanner2 = new Scanner(new File(line2));
				fileCheck2 = false;
			}
			catch (FileNotFoundException e) {
				System.out.println("No file with that name");
			}
		} while (fileCheck2);
		
		while (scanner2.hasNextInt()) {
			int a = scanner2.nextInt();
			if (treecheck) {
				b.remove(a);
			}
			else {
				for (int i = 0; i < d.getLength(); i++) {
					if (d.get(i) == a) {
						d.remove(i);
						i--;
					}
				}
			}
		}
		scanner2.close();

		String line3 = getInput("Type in a file name to output to:");
		PrintWriter writer = new PrintWriter(line3, "UTF-8");
					
		if (treecheck) { 
			writer.print("Preorder: ");
			for (int i = 0; i < b.preOrder().getLength(); i++) {
				writer.print(b.preOrder().get(i) + " ");
			}	
			writer.println();
			writer.print("Inorder: ");
			for (int i = 0; i < b.inOrder().getLength(); i++) {
				writer.print(b.inOrder().get(i) + " ");
			}
			writer.println();
			writer.print("Postorder: ");
			for (int i = 0; i < b.postOrder().getLength(); i++) {
				writer.print(b.postOrder().get(i) + " ");
			}
		}
		else {
			writer.print("Inorder: ");
			for (int i = 0; i < d.getLength(); i++) {
				writer.print(d.get(i) + " ");
			}
		}
		writer.close();
	}
}
