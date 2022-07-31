import java.util.ArrayList;
import java.util.Arrays;

public class main {
    static int moves[][] = { { 1, 0 }, { 0, 1 }, { 1, 1 } };

    public static void print1d(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");

        }
        System.out.println();

    }

    public static void print2d(int arr[][]) {
        for (int sub[] : arr) {
            print1d(sub);
        }
    }

    public static void fill2d(int arr[][], int val) {

        for (int temp[] : arr) {
            Arrays.fill(temp, val);
        }
    }

    public static int mazePathvarJumps(int i, int j, int tr, int tc) {

        if (i == tr && j == tc) {
            return 1;
        }

        int count = 0;
        for (int x = 1; x < tr; x++) {

            for (int arr[] : moves) {

                if (i + arr[0] * x <= tr && j + arr[1] * x <= tc)
                    count += mazePathvarJumps(i + arr[0] * x, j + arr[1] * x, tr, tc);

            }
        }
        return count;

    }

    public static int mazePathvarJumpsmem(int i, int j, int tr, int tc, int dp[][]) {

        if (i == tr && j == tc) {
            return dp[tr][tc] = 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int count = 0;
        for (int x = 1; x < tr; x++) {

            for (int arr[] : moves) {

                if (i + arr[0] * x <= tr && j + arr[1] * x <= tc)
                    count += mazePathvarJumpsmem(i + arr[0] * x, j + arr[1] * x, tr, tc, dp);

            }
        }
        return dp[i][j] = count;

    }

    public static int boardJumps(int idx, int len, int dp[], String path) {

        if (idx == dp.length - 1) {
            // System.out.println(path);
            return dp[idx] = 1;
        }
        int count = 0;

        for (int i = dp.length - 1; i >= 0; i++) {
            if (idx + i < dp.length) {
                count += boardJumps(idx + i, len, dp, path + i);
            } else
                break;

        }

        return dp[idx] = count;

    }

    public static int boardJumpsTab(int idx, int len, int dp[]) {

        for (int i = dp.length - 1; i >= 0; i--) {

            if (i == dp.length - 1) {
                dp[i] = 1;
                continue;
            }
            int count = 0;
            for (int dice = 1; dice <= 6 && dice + i < dp.length; dice++)
                count += dp[dice + i];
            dp[i] = count;

        }

        return dp[0];

    }

    public static int longest_pal_subseq_mem(String x, int i, int j, int dp[][]) {
        // System.out.println("( "+i+" , "+" "+j );
        if (i >= j)
            return dp[i][j] = i > j ? 0 : 1;
        if (x.charAt(i) == x.charAt(j))
            return dp[i][j] = longest_pal_subseq_mem(x, i + 1, j - 1, dp) + 2;
        else
            return dp[i][j] = Math.max(longest_pal_subseq_mem(x, i + 1, j, dp),
                    longest_pal_subseq_mem(x, i, j - 1, dp));
    }

    public static int longest_pal_subseq_tab(String x, int dp[][]) {

        for (int gap = 0; gap < x.length(); gap++) {

            for (int i = 0, j = i + gap; i < x.length() && j < x.length(); i++, j++) {
                if (i == j) {
                    dp[i][j] = 1;

                } else if (x.charAt(i) == x.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    System.out.println(i + " " + j);
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }

            }
        }
        return dp[0][x.length() - 1];
    }

    public static int longest_common_subseq_mem(String x, String y, int i, int j, int dp[][]) {

        if (i < 0 || j < 0)
            return 0;
        // if()
        if (x.charAt(i) == y.charAt(j)) {
            return dp[i][j] = longest_common_subseq_mem(x, y, i - 1, j - 1, dp) + 1;
        }
        return dp[i][j] = Math.max(longest_common_subseq_mem(x, y, i - 1, j, dp),
                longest_common_subseq_mem(x, y, i, j - 1, dp));

    }

    public static int longest_common_subseq_tab(String x, String y, int dp[][]) {

        for (int a = x.length() - 1; a >= 0; a--) {
            for (int b = y.length() - 1; b >= 0; b--) {

                if (x.charAt(a) == y.charAt(b)) {
                    dp[a][b] = dp[a + 1][b + 1] + 1;
                } else {
                    dp[a][b] = Math.max(dp[a + 1][b], dp[a][b + 1]);
                }

            }
        }
        return dp[0][0];
    }

    public static int leet115(String s, String t, int x, int y, int dp[][]) {
        if (y == t.length())
            return dp[x][y] = 1;
        if (x == s.length())
            return dp[x][y] = 0;

        if (dp[x][y] != -1)
            return dp[x][y];
        int count = 0;
        if (s.charAt(x) == t.charAt(y)) {
            return dp[x][y] = leet115(s, t, x + 1, y + 1, dp) + leet115(s, t, x + 1, y, dp);
        }

        return dp[x][y] = leet115(s, t, x + 1, y, dp);

    }

    public static int leet115tab(String s, String t, int dp[][]) {

        for (int i = dp.length - 1; i >= 0; i--) {

            for (int j = dp[0].length - 1; j >= 0; j--) {

                if (j - 1 > 0 && i == dp.length - 1 && s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j - 1] = 1;

                } else if (j < t.length() && s.charAt(i - 1) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                }

            }
        }
        return dp[0][0];
    }

    public static int lcs_3strings(String x, String y, String z, int i, int j, int k, int dp[][][]) {

        if (i == x.length() || j == y.length() || k == z.length())
            return 0;
        if (dp[i][j][k] != 0)
            return dp[i][j][k];
        if (x.charAt(i) == y.charAt(j) && y.charAt(j) == z.charAt(k)) {
            return dp[i][j][k] = lcs_3strings(x, y, z, i + 1, j + 1, k + 1, dp) + 1;
        }
        int fi = lcs_3strings(x, y, z, i + 1, j, k, dp);
        int sec = lcs_3strings(x, y, z, i, j + 1, k, dp);
        int thi = lcs_3strings(x, y, z, i, j, k + 1, dp);
        return Math.max(fi, Math.max(sec, thi));

    }

    static int si = 0, ei = 0;

    public static void print_pal_str_from_dp(int dp[][], String x, char ans[], int i, int j) {
        System.out.println(i + "  " + j);
        if (i < 0 || j < 0 || i >= dp.length || j >= dp[0].length)
            return;
        if (dp[i][j] == 0) {
            ans[si] = x.charAt(i);
            return;
        }
        if (x.charAt(i) == x.charAt(j)) {
            ans[si++] = ans[ei--] = x.charAt(i);
            // asf+=x.charAt(i);
            print_pal_str_from_dp(dp, x, ans, i + 1, j - 1);
        } else {
            if (dp[i + 1][j] >= dp[i][j]) {
                print_pal_str_from_dp(dp, x, ans, i + 1, j);
            } else if (dp[i][j - 1] >= dp[i][j]) {
                print_pal_str_from_dp(dp, x, ans, i, j - 1);
            }
        }

    }

    public static int allSSaibjck(String x, int find, int i) {
        if (find > 2)
            return 0;

        if (i == x.length())
            return 1;

        char consta = 'a';
        char tf = (char) ((int) consta + find);
        if (x.charAt(i) == tf) {
            return allSSaibjck(x, find, i + 1) + allSSaibjck(x, find + 1, i + 1);
        }
        return allSSaibjck(x, find, i + 1);

    }

    public static int leet72(String a, String b, int i, int j, int count, int dp[][]) {
        // System.out.println(a.substring(i,a.length())+" ---
        // "+b.substring(j,b.length())+" ----"+count);
        // if(j==b.length())
        // return count;
        // if(i>=a.length() )
        // return Integer.MAX_VALUE;
        if (i == a.length()) {
            if (j == b.length())
                return dp[i][j] = count;

            return dp[i][j] = count + b.length() - j;
        }
        if (i < a.length() && j == b.length()) {
            return dp[i][j] = leet72(a, b, i + 1, j, count + 1, dp);
        }
        // if(j==b.length() && i!=a.length())
        // return leet72(a, b, i+1, j, count, dp)
        if (dp[i][j] != -1)
            return dp[i][j];
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = leet72(a, b, i + 1, j + 1, count, dp);
        }
        return dp[i][j] = Math.min(leet72(a, b, i + 1, j + 1, count + 1, dp),
                Math.min(leet72(a, b, i + 1, j, count + 1, dp), leet72(a, b, i, j + 1, count + 1, dp)));

    }

    public static int leet72_meth2(String a, String b, int i, int j, int count, int dp[][]) {
        // System.out.println(a.substring(i,a.length())+" ---
        // "+b.substring(j,b.length())+" ----"+count);
        // S
        // if(i==0 || j==0){
        // if(i==0 && j==0)
        // return count;
        // if(i==0)
        // return j+count;
        // if(j==0)
        // return i+count;
        // }

        if (i == 0 || j == 0)
            return dp[i][j] = i != 0 ? i : j;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (a.charAt(i - 1) == b.charAt(j - 1))
            return dp[i][j] = leet72_meth2(a, b, i - 1, j - 1, count, dp);

        int insert_ = leet72_meth2(a, b, i, j - 1, count + 1, dp);
        int del_ = leet72_meth2(a, b, i - 1, j, count + 1, dp);
        int updt_ = leet72_meth2(a, b, i - 1, j - 1, count + 1, dp);
        dp[i][j] = Math.min(insert_, Math.min(updt_, del_)) + 1;
        System.out.println(i + " , " + j);
        return dp[i][j];
    }

    public static int leet72_tab(String a, String b) {
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < dp[0].length; i++) {

            for (int j = 0; j < dp.length; j++) {
                // System.out.println(" "+i+" "+j+" "+dp.length+" dp[0] "+dp[0].length);
                if (i == 0)
                    dp[j][i] = j;
                else if (j == 0)
                    dp[j][i] = i;
                else if (a.charAt(j - 1) == b.charAt(i - 1)) {
                    dp[j][i] = dp[j - 1][i - 1];
                } else {
                    dp[j][i] = Math.min(dp[j - 1][i], Math.min(dp[j - 1][i - 1], dp[j][i - 1])) + 1;
                }

            }

        }

        // print2d(dp);
        return dp[a.length()][b.length()];

    }
    public static int linear_eq_tab(int arr[] , int consta ){

        int dp[][]= new int[arr.length+1][consta+1];
        Arrays.fill(dp[arr.length] , 0 );
        dp[arr.length][0]=1;

        for(int i=dp.length-2;i>=0;i--){
            for(int j=0;j<=consta;j++){

                int sol=0;
                for(int x=j;x>=0;x-=arr[i]){
                    sol+=dp[i+1][x];
                }
                dp[i][j]=sol;
            }
        }

        print2d(dp);
        return dp[0][dp[0].length-1];


    }
  
    public static String removeContinuousStars(String b) {
        StringBuilder sb = new StringBuilder();
        char prev = b.charAt(0);
        sb.append(prev);
        for (int i = 1; i < b.length(); i++) {
            char curr = b.charAt(i);
            if (curr == '*' && prev == '*') {
                continue;
            } else {
                prev = curr;
                sb.append(curr);
            }

        }
        return sb.toString();

    }

    public static boolean leet_44(String a, String b, int i, int j, int dp[][]) {
        // System.out.println(i+" , " +j);
        // System.out.println(i+ " " +j);
        if (i == 0 && j == 0) {
            dp[i][j] = 1;
            return true;
        }
        if (i == 0 && j != 0) {
            if (i == 0 && j == 1 && b.charAt(j - 1) == '*') {
                dp[i][j] = 1;
                return true;
            }

            dp[i][j] = 0;
            return false;
        }
        if (i != 0 && j == 0) {
            dp[i][j] = 0;
            return false;
        }

        if (dp[i][j] != -1)
            return dp[i][j] == 1 ? true : false;

        char ath = a.charAt(i - 1);
        char bth = b.charAt(j - 1);

        if (bth >= 'a' && bth <= 'z') {
            if (ath == bth) {
                boolean resp = leet_44(a, b, i - 1, j - 1, dp);
                dp[i][j] = resp ? 1 : 0;
                return resp;
            } else {
                dp[i][j] = 0;
                return false;
            }
        } else if (bth == '*') {
            boolean ans = false;
            for (int x = i; x >= 0; x--) {
                if (!ans)
                    ans = ans || leet_44(a, b, x, j - 1, dp);
                else
                    break;
                // System.out.println(" ans point "+ans);
            }
            dp[i][j] = ans ? 1 : 0;
            return ans;

        } else {
            boolean ans = leet_44(a, b, i - 1, j - 1, dp);
            dp[i][j] = ans ? 1 : 0;
            return ans;
        }
        // return false;
    }

    public static int leet_91_decode(String x, int idx, int dp[]) {
        if (idx == 0)
            return dp[idx] = 1;
        if (dp[idx] != -1)
            return dp[idx];

        int ans = 0;
        if (idx - 2 >= 0) {
            int num = Integer.parseInt(x.substring(idx - 1, idx + 1));
            if (num >= 0 && num <= 26) {

                int resp = leet_91_decode(x, idx - 2, dp);
                dp[idx - 2] = resp;
                ans += resp;
            }
        }
        if (idx - 1 >= 0 && x.charAt(idx - 1) >= '1' && x.charAt(idx - 1) <= '9') {
            int resp = leet_91_decode(x, idx - 1, dp);
            ans += resp;
        }

        return dp[idx] = ans;
    }

    public static int leet_91_tab(String x) {
        int dp[] = new int[x.length() + 1];
        dp[dp.length - 1] = 1;
        for (int i = dp.length - 2; i >= 0; i--) {

            if (x.charAt(i) >= '1' && x.charAt(i) <= '9')
                dp[i] += dp[i + 1];
            if (i + 2 < dp.length) {
                int num = Integer.parseInt(x.substring(i, i + 2));
                if (num >= 10 && num <= 26)
                    dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    public static void stringsetquestions() {
        // ***********leet 91 decode ways
        String x = "226";
        int dp[] = new int[x.length() + 1];
        Arrays.fill(dp, -1);
        // int ans =leet_91_decode(x,x.length(),dp);
        int ans = leet_91_tab(x);
        System.out.println(ans);
        print1d(dp);
        // ********************

        // String x ="geekeeks";
        // int n = x.length();
        // int dp[][]= new int[n][n];
        // int seqs=longest_pal_subseq_mem( x, 0 , n-1,dp);
        // System.out.println(seqs);
        // char ans[]= new char[seqs];
        // si =0 ;
        // ei=ans.length-1;
        // print_pal_str_from_dp(dp,x,ans,0,dp[0].length-1);
        // for(char c :ans) System.out.print("-"+c+"-");
        // System.out.println(longest_pal_subseq_tab( x,dp));
        // print2d(dp);

        // String x ="dbagg";
        // String y= "bag";
        // int dp[][]= new int[x.length()+1][y.length()+1];
        // System.out.println( "ans is : "+ longest_common_subseq_mem( x , y
        // ,x.length()-1 , y.length()-1,dp));
        // System.out.println(longest_common_subseq_tab(x,y,dp));
        // print2d(dp);

        // int dp[][]= new int[x.length()+1][y.length()+1];
        // for(int arr[] : dp) Arrays.fill(arr,-1);
        // // System.out.println(leet115(x, y, 0,0,dp));
        // System.out.println(leet115tab(x, y,dp));

        // String x1= "rabbbit";
        // String x2= "rabbit";
        // int dp[][]=new int[x1.length()+1][x2.length()+1];
        // fill2d(dp, -1);
        // System.out.println(leet115(x1,x2,0,0,dp));

        // print2d(dp);
        // String str1 = "abcd1e2" ,
        // str2 = "bc12ea" ,
        // str3 = "bd1ea";

        // int dp[][][]= new int[str1.length()][str2.length()][str3.length()];
        // System.out.println(lcs_3strings(str1,str2,str3,0,0,0,dp));
        // ************SUBSEQUENCES OF FORM Ai,Bj,Ck
        // String x = "abcabc";
        // System.out.println(allSSaibjck( x, 0,0));
        // ***************** LEETCODE - 72 - *******
        // String a ="horse" , b = "ros";
        // String a ="intention" , b = "execution";
        // String a ="a" , word2 = "ab";
        // String a ="sea" , b = "eat";
        // int dp[][]= new int[a.length()+1][b.length()+1];
        // fill2d(dp, -1);
        // System.out.println(leet72(a, word2,0,0,0,dp));
        // System.out.println(leet72_meth2(a, b,a.length(),b.length(),0,dp));

        // print2d(dp);
        // System.out.println(leet72_tab(a, b));
        // ****************** LEETCODE -44 WILCARD MATCHING
        // String a= "acdcb" , b="a*c?*b";
        // b=removeContinuousStars(b);
        // int dp[][]= new int[a.length()+1][b.length()+1];
        // fill2d(dp, -1);
        // System.out.println(leet_44(a,b,a.length(),b.length(),dp));
        // System.out.println(b);

    }

    public static int no_of_sols(int coeff[], int consta, int idx, int esf) {

        if (consta == esf) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i <= consta; i++) {
            if (idx + 1 < coeff.length)
                count += no_of_sols(coeff, consta, idx + 1, esf + coeff[idx] * i);
        }
        return count;
    }

    public static int no_of_sols_02(int coeff[], int consta, int idx, int esf) {

        if (consta == esf) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i <= consta; i++) {
            if (idx + 1 < coeff.length)
                count += no_of_sols_02(coeff, consta, idx + 1, esf + coeff[idx] * i);
        }
        return count;
    }

    // public static int LIS(int arr[]){
    // int dp[]= new int[arr.length];
    // dp[0]=1;
    // for(int i=1;i<arr.length;i++){
    // int min=0;
    // for(int j=i;j>=0;j--){
    // if(arr[j] < arr[i] )
    // }
    // }

    // }
    public static int linear_equt_rec(int arr[], int consta, int idx) {

        if (idx == arr.length) {
            if (consta == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int sol = 0;
        for (int i = 0; i <= consta / arr[idx]; i++) {
            sol += linear_equt_rec(arr, consta - i * arr[idx], idx + 1);
        }
        return sol;

    }

    public static int linear_eq_mem(int arr[], int consta, int idx, int dp[][]) {

        if (consta == 0) {
            return dp[idx][consta] = 1;
        }
        if (idx >= arr.length && consta != 0) {
            return dp[idx][consta] = 0;
        }
        if (dp[idx][consta] != -1)
            return dp[idx][consta];
        int sol = 0;
        for (int val = 0; val <= consta / arr[idx]; val++) {
            if (consta - arr[idx] * val >= 0) {
                sol += linear_eq_mem(arr, consta - arr[idx] * val, idx + 1, dp);
            }

        }
        return dp[idx][consta] = sol;
    }

    public static int coin_change_perm(int arr[], int tar) {

        int dp[] = new int[tar + 1];
        dp[0] = 1;
        for (int vari = 0; vari <= tar; vari++) {

            for (int ele : arr) {
                if (vari - ele >= 0) {
                    dp[vari] += dp[vari - ele];
                }
            }

        }
        print1d(dp);
        return dp[tar];

    }

    public static void coinchangesetquestions() {

        // ***********GFG LINEAR EQUATION SOLUTIONS
        int coeff[] = { 1, 2, 3 }, consta = 6;
        int ans = linear_equt_rec(coeff, consta, 0);
        int dp[][] = new int[coeff.length + 1][consta + 1];
        fill2d(dp, -1);
        int ans_mem = linear_eq_mem(coeff, consta, 0, dp);
        print2d(dp);
        int ans_tab = linear_eq_tab(coeff,consta);
    
        System.out.println("rec ans : " + ans + " , mem ans :  " + ans_mem+ " tabulated ans : "+ans_tab);
	
        // System.out.println("rec ans : " + ans + " , mem ans :  " + ans_mem);

        // int coeff[] = new int[] { 2, 3, 5, 7 };
        // int constant = 10;
        // // System.out.println(no_of_sols(coeff, constant, 0, 0));
        // System.out.println(coin_change_perm(coeff,10));
    }

    // public static void sequencetypequestions() {

    // int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 10 };
    // LIS(arr);

    // }

    public static void main(String[] args) {

        // boolean maze[][]= new boolean[5][5];
        // System.out.println( mazePathvarJumps(0,0,5,5) );
        // int dp[][]=new int[6][6];
        // System.out.println( mazePathvarJumpsmem(0,0,5,5, dp ));
        // print2d(dp);
        // ***********************BOARD JUMMPS
        // int dp[]= new int[11];
        // // System.out.println(boardJumps(0 , dp.length, dp , " "));
        // System.out.println(boardJumpsTab(0 , dp.length, dp ));
        // print1d(dp);
        // stringsetquestions();
        coinchangesetquestions();
        

    }

}
