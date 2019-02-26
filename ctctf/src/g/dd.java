package g;

import java.util.Arrays;

public class dd {

	public static void main(String[] args) {
		String x = "abcdefghijklmnopqrstuvwxyz";
		int[] arr = new int[x.length()];
		char[] arr2 = new char[x.length()];

				for (int i = 0; i < x.length(); i++) {
			    	arr[i] = Character.toLowerCase(x.charAt(i) - 'a');
			    	arr2[i] = (char) Character.toLowerCase(x.charAt(i));
			        
			    }
			    System.out.println(Arrays.toString(arr));
			    for (int i = 0; i < x.length(); i++) {
			    	arr[i] = arr[i]*4;
			    	
			        
			    }
			    System.out.println(Arrays.toString(arr));
			    for (int i = 0; i < x.length(); i++) {
			    	arr[i] = arr[i]+15;
			    	
			        
			    }
			    System.out.println(Arrays.toString(arr));
			    for (int i = 0; i < x.length(); i++) {
			    	arr[i] = arr[i]%27;
			    	
			        
			    }
			    System.out.println(Arrays.toString(arr));

			    char[] v = new char[x.length()];
			    for (int i = 0; i < x.length(); i++) {
			    	v[i] = (char) (arr[i] + 65);
			    	
			        
			    }
			    System.out.println(Arrays.toString(v));
			    
			    for (int i = 0; i < x.length(); i++) {
			    	v[i] = (char) (Character.toLowerCase(v[i]));
			    	
			        
			    }
			    System.out.println(Arrays.toString(v));
			    System.out.println(Arrays.toString(arr2));
			    
			    String k = "ifpmluglesecdlqp_rclfrseljpkq";
			    String p = "";
			    
			    for (int i = 0; i < k.length(); i++) {
			    	int temp = 0;
			    	for (int j = 0; j < v.length; j++) {
			    		
			    		if (k.charAt(i) == v[j]) {
			    			temp = j;
			    		}
			    	}
			    	p += arr2[temp];
			    }
			    System.out.println(p);
			    System.out.println(k);

	}

}
