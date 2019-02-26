package assignmentSeven;

import java.util.ArrayList;

public class Notebook {

	private ArrayList<String> notes;
	
	public Notebook() {
		notes = new ArrayList<String>();
	}

	public void addNoteToEnd(String inputnote) {
		notes.add(inputnote);
	}
	
	public void addNoteToFront(String inputnote) {
		notes.add(0, inputnote);
	}
	
	public void printAllNotes() {
		int i = 1;
		for (String dt: notes) {
			System.out.println("#" + i + ": " + dt);
			i++;
		}
	}
	
	public void replaceNote(int inputindex, String inputString) {
		if (inputindex > notes.size() || inputindex < 1) {
			System.out.println("Error. No change!");
		}
		else {
			notes.set(inputindex, inputString);
		}
		
	}
	
	public int countNotesLongerThan(int length) {
		int count = 0;
		for (String dt: notes) {
			if (dt.length() > length) {
				count++;
			}
		}
		return count;
	}
	
	public double averageNoteLength() {
		double count = 0;
		for (String dt: notes) {
			count = count + dt.length();
		}
		
		return count/notes.size();
	}
	
	public String longestNote() {
		String str = "";
		for (String dt: notes) {
			if (dt.length() > str.length()) {
				str = dt;
			}
		}
		return str;
	}
	
	public String firstAlphabetically() {
		String str = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		for (String dt: notes) {
			if (dt.compareTo(str) < 0) {
				str = dt;
			}
		}
		return str;
	}
	
	public void removeNotesBetween(int startnote, int endnote) {
		if (startnote > notes.size() || startnote < 1 || endnote > notes.size() || endnote < 1) {
			System.out.println("Error. No change!");
		}
		else {
			for (int i  = endnote - 1; i > startnote - 2; i--) {
				notes.remove(i);
			}
		}
		
	}
	
	public ArrayList<String> listOfNotesContaining(String findString) {
		ArrayList<String> strl = new ArrayList<String>();
		for (String dt : notes) {
			if (dt.indexOf(findString) > 0) {
				strl.add(dt);
			}
		}
		return strl;
	}
	
	public int countNumberOf(String letter) {
		int count = 0;
		for (String dt : notes) {
			for (int i = 0; i < dt.length() - 1; i++) {
				if (dt.substring(i, i+1).equalsIgnoreCase(letter) == true) {
					count++;
				}
			}
		}
		return count;
	}
	
	public String name() {
		return "Andrew";
	}
}