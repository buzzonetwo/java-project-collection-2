package assignmentSeven;

public class Notebookpoop {

	public static void main(String[] args) {
		Notebook noter = new Notebook();
		noter.addNoteToEnd("Poop");
		noter.addNoteToEnd("Crazy");
		noter.addNoteToEnd("Stupid");
		noter.addNoteToFront("Abba");
		noter.addNoteToFront("Kappa");
		noter.printAllNotes();
		noter.replaceNote(2, "Shitter");
		noter.printAllNotes();
		System.out.println(noter.countNotesLongerThan(4));
		System.out.println(noter.averageNoteLength());
		System.out.println(noter.firstAlphabetically());
		noter.addNoteToEnd("Poop");
		noter.addNoteToEnd("Crazy");
		noter.addNoteToEnd("Stupid");
		noter.printAllNotes();
		noter.removeNotesBetween(4, 7);
		noter.printAllNotes();
		System.out.println(noter.listOfNotesContaining("t"));
		System.out.println(noter.countNumberOf("t"));
	
	
	
	}

}
