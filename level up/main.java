/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class main {
	public static void main (String[] args) {
		//code\
		Scanner scn =  new Scanner(System.in);
		int tc = scn.nextInt();
		while(tc-->0){
		    
		    int n  =  scn.nextInt();
		    int arr[]=  new int[n];
		    for(int i=0;i<n;i++) arr[i] =  scn.nextInt();
		    int ans =  tabulation(arr);
		    System.out.println(ans);
		    
		    
		}
    }
    // APROACH - THIS SOLUTION HAS INTUTION THAT FROM PREVIOUS ELEMENTS WHAT I NEED IS THAT 
    // IF PARTICULARLY ITH ELEMENT IS COMBINED WITH PREVIOUS ELEMENT WITH A SIGN '>' THEN WHAT 
    // MAX LENGTH I CAN FORM AND WHEN ITH ELEMENT COMBINES WITH A SIGN OF '<' THEN WHAT MAX LENGTH
    // I CAN FORM SO THIS IS STORED IN DP[1][I] AND DP[0][I] RESPECTIVELY ;
    
    
	public static int tabulation(int arr[] ){
	    
	    int n =arr.length;
	    int dp[][]= new int[2][n];
	    dp[0][0]=1;
	    dp[1][0]=1;
	    int ans = 0;
	    for(int i=1;i<n;i++){
	        
	        for(int j=0;j<i;j++){
	            if(arr[j] < arr[i] ) dp[1][i]=Math.max(dp[0][j]+1 , dp[1][i]  );
	            else if(arr[j] > arr[i] ) dp[0][i]=Math.max(dp[0][i] , dp[1][j] +1 );
	        }
	        ans= Math.max(ans , Math.max(dp[0][i] , dp[1][i]) ) ;
        }
        

        for(int i=0;i<n;i++){
            System.out.println(i+" : "+dp[0][i]+" "+dp[1][i]) ;   
        }
	    return ans;
	    
	}
}