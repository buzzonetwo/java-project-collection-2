package assignmentThree;

public class pooheater {

	public static void main(String[] args) {
		CentralHeating c = new CentralHeating("sfs","34r");
		c.incrementOne();
		c.printHeaterInfo();
		c.decrementTwo();
		c.printHeaterInfo();
		c.incrementTwo();
		c.printHeaterInfo();
		c.decrementOne();
		c.decrementOne();
		c.decrementOne();
		c.printHeaterInfo();
		c.average();
		c.printHeaterInfo();
		c.changeIncrement(3);
		c.decrementOne();
		c.decrementOne();
		c.incrementTwo();
		c.printHeaterInfo();
		c.average();
		c.printHeaterInfo();
		System.out.print(c.hottestRoom());
	}

}
