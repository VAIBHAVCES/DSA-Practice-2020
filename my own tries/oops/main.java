/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class main {

    public static boolean compare(int x1 , int x2){
        
    }
	public static void main (String[] args) {
		//code
	    Scanner scn = new Scanner(System.in);
	    int tc = scn.nextInt();
	    
	    while(tc-- > 0){
	        // int n = scn.nextInt();
    	    // int k = scn.nextInt();
    	    // int arr[] = new int[n];
    	    // for(int i=0;i<n;i++){
    	    //     arr[i]=scn.nextInt();
            // }    
            int arr[] = {-5 ,8, -1 , 4 ,2 ,4 ,12}; int k = -5;
    	    System.out.println(longestsawsk(arr,k));
	        
	    }
	    
	    
	}
	public static int longestsawsk(int arr[] , int k ){
	    
	    int si =0 ,ei=0 , val = k , n = arr.length , len = 0;
	    while(ei < n )
	    {
	    
	        System.out.println(si+" "+ei);
	        if(val !=0 ) val-= arr[ei++];   
	        
	        while(val==0){
	            len = Math.max(len , ei-si);
	            val+=arr[si++];
	        }
	        
	    }
	    return len;
	    
	}
}