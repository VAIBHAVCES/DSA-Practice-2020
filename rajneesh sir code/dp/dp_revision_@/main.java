import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            String str = scn.nextLine();
            // System.out.println(cpss(str));
            
            System.out.println(lpss(str));
    }
    public static int lpss(Strin str ){
        int n = str.length() ,ans= 0;
        boolean dp[][]= new boolean[n][n];
        for(int diag=0;diag<n;diag++){

            for(int i=0,j=i+diag;i<n&&j<n;i++,j++){
                if(diag==0){
                    dp[i][j]=true;
                }else if(str.charAt(i)==str.charAt(j)){
                    if(diag==1) dp[i][j]=true;
                    else dp[i][j]= dp[i+1][j-1]==true;
                }

                if(dp[i][j])
                    ans=Math.max(ans, i-j+1);
            }
        }
        return ans;
    
    
    }
    public static int cpss(String str) {
        int n = str.length(), ans = 0;
        boolean dp[][] = new boolean[n][n];
        for (int diag = 0; diag < n; diag++) {
            for (int i = 0, j = i + diag; i < n && j < n; i++, j++) {
                if (diag == 0) {
                    dp[i][j] = true;
                } else if (str.charAt(i) == str.charAt(j)) {
                    if (diag == 1) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1] == true;
                }
                if (dp[i][j])
                    ans++;
            }
        }
        return ans;
    }



}