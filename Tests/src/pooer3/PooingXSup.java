package pooer3;

public class PooingXSup {

	public static int caser;
	
	public static void modcaser(int i)
	{
		caser = i;
	}


	public static void getPooingXSup() {
		
		
		if (caser == 1) {
			for (int i = 1; i < 7; i++) {
				int j = i;
				while (j > 0) {
					System.out.print("X");
					j--;
				}
				System.out.println("");
			}
		}
		else if (caser == 2) {
			for (int i = 1; i < 7; i++) {
				int j = i;
				int k = 8 - j;
				while (k > 2) {
					System.out.print(" ");
					k--;
				}
							
				while (j > 0) {
					System.out.print("X");
					j--;
				}
				
				System.out.println("");
			}
		}
		
		else if (caser == 3) {
			for (int i = 1; i < 7; i++) {
				int j = i;
				int l = i + 1;
				int k = 8 - j;
				int m = 8 - l;
				while (k > 1) {
					System.out.print(" ");
					k--;
				}	
				while (j > 1) {
					System.out.print("X");
					j--;
				}
				while (l > 1) {
					System.out.print("X");
					l--;
				}		
				while (m > 1) {
					System.out.print(" ");
					m--;
				}
  
				
				System.out.println("");
			}
		}
		else if (caser == 4) {
			for (int i = 1; i < 7; i++) {
				int j = i;
				int k = 8 - j;
				while (j > 1) {
					System.out.print(" ");
					j--;
				}
				while (k > 1) {
					System.out.print("X");
					k--;
				}
				System.out.println("");
			}
		}
		else if (caser == 5) {
			for (int i = 1; i < 7; i++) {
				int j = i;
				int k = 6;

				if (j == 1 || j == 6) {
					while (k > 0) {
						System.out.print("X");
						k--;
					}
				}
				else
				{
					System.out.print("X    X");
				}
				
				System.out.println("");
			}
		}
		else {
			System.out.println("Type in an actual case");
		}
		
	}
	
	
}
