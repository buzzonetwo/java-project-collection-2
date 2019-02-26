package g;

import java.util.Arrays;

public class j  {

	public static String x = ("tqaxwfrwpdpnowbacnwqcdpwuavb");
	public static int[] y = new int[x.length()];
	
	public static void main(String[] args) {
	    int[] arr = new int[x.length()];
	    int[] arr2 = new int[x.length()];

	    int z = 0;
	    
	    for (int i = 0; i < x.length(); i++) {
	    	arr2[i] = Character.toLowerCase(x.charAt(i) - 'a' + 1);
	    	int g = (Character.toLowerCase(x.charAt(i))- 'a' + 1);
	        while (g%4 != 0 ) {
	        	g+=26;
	        }
	        arr[i] = g;
	        
	    }
	    System.out.println(Arrays.toString(arr));
	    System.out.println(Arrays.toString(arr2));
	    
	    
	    y = arr;
	    for (int k = 0; k < y.length; k++) {
	    	y[k] = y[k]/4;
	    }
	    
	    System.out.println(Arrays.toString(y));
	    
	    
	  /*  char[] z1 = new char[y.length];
	    for (int k = 0; k < z1.length; k++) {
	    	z1[k] = (char)(y[k] + 64);
	    }
	    
	    System.out.println(Arrays.toString(z1));*/
	}

}
