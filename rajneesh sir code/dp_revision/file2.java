
import java.util.Arrays;
public class file2 {

    //************** UTILITY FUNCTIONS    ******************  */
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
    public static void print3d(int arr[][][] ){
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j][0]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j][1]+" ");
            }
            System.out.println();
        }
    } 
    // *********************************************
    

    public static int lis(int arr[] )
    {
        int dp[]= new int[arr.length] ;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[j] <  arr[i])
                    max= Math.max(max, dp[j]);
            }
            dp[i]=max+1;
            ans= Math.max(ans, dp[i]);
        }
        print1d(dp);
        return ans;
    }
    public static int lds(int arr[] )
    {
        int dp[]= new int[arr.length] ;
        int ans = 0 ; 
        for(int i=arr.length-1;i>=0;i--){
            
            int max = 0;
            for(int j=i+1;j<arr.length;j++){

                if(arr[j] <   arr[i])
                    max= Math.max(max, dp[j]);
            }
            dp[i]=max+1;
            ans = Math.max(dp[i] ,ans) ;
        }
        // print1d(dp);
        return ans;
    }
    public static int bitonic_sub(int arr[] ){

        int lis[]  = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i])
                    max= Math.max(lis[j], max);
            }
            lis[i]=max+1;
        }
        print1d(lis);
        int lds[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int max = 0;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[i])
                    max= Math.max(lds[j], max);
            }
            lds[i]=max+1;
        }
        print1d(lds);
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            ans=Math.max(ans, lis[i]+lds[i]-1);
        }
        return ans;
    
    
    }
    public static int lds_02(int arr[] ){

        int dp[]= new int[arr.length] ;
        int ans=0;
        for(int i=arr.length-1;i>=0;i--){
            
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[j] <  arr[i])
                    max= Math.max(max, dp[j]);
            }
            dp[i]=max+1;
            ans= Math.max(ans, dp[i]);
        }
        print1d(dp);
        return ans;
    }
    public static int  pattern_V(int arr[] ){

        int n = arr.length;
        int lds_ltor[] = new int[n];
        for(int i=n-1;i>=0;i--){
            int max = 0;
            for(int j=i; j< arr.length; j++){
                if(arr[i] >  arr[j] )
                max= Math.max(max, lds_ltor[j]);
            }lds_ltor[i]=max+1;
        }

        int lds_rtol[]= new int[n];
        for(int i=0;i< arr.length;i++){
            int max =0;
            for(int j=0;j< i ;j++ ){
                if(arr[j] <  arr[i] ) max = Math.max(lds_rtol[j] , max);

            }lds_rtol[i]=max+1;

        }

        int final_ans = 0;
        for(int i=0;i<arr.length;i++){
            final_ans = Math.max(lds_ltor[i] + lds_rtol[i] -1 ,final_ans) ;

        }
        return final_ans;


    }
    public static void lis_questions(){

        // int arr[] = {-1,5,6,-1,4,-5,3,5,6,8,9}   ;
        
        int arr[] = { 5,10,15,1,17,19,20  };
        // int arr[] =  {80, 60, 30, 40, 20, 10};
        // int ans = lis(arr);
        // int ans = lds(arr);
        // int ans2= LDS_DP(arr);
        // int ans = lds_02(arr);
        // int ans = bitonic_sub(arr);
        int ans =pattern_V(arr);
        // System.out.println(ans);
    }
    

    public static int square_finder_rec(int i , int j , int arr[][] ){
        // System.out.println(i+" "+j);
        int n = arr.length;
        int m = arr[0].length;
        if(arr[i][j]==0)
            return 0 ;

        int min =Integer.MAX_VALUE;
        if(j+1 < m)
            min = Math.min ( min , square_finder_rec(i, j+1, arr) );
        if(i+1 < n)
            min = Math.min ( min , square_finder_rec(i+1, j, arr) );     
        if(i+1 < n && j+1 < m)
            min = Math.min ( min , square_finder_rec(i+1, j+1, arr) );
        return (min ==Integer.MAX_VALUE? 0: min )+ 1;

    }
    public static int sub_squares_rec(int arr[][] ) {

        int n = arr.length;
        int m = arr[0].length;

        int ans = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                    int temp = square_finder_rec(i,j,arr);
                    System.out.println("at idx : "+i+" "+j+" : "+temp);
                    ans  = Math.max ( ans , temp  );
            }
        }
        return ans;
    }
    public static void problems(){

        // int arr[][] = {{0, 1, 1, 0, 1},{1, 1, 0, 1, 0},  
        // {0, 1, 1, 1, 0}, 
        // {1, 1, 1, 1, 0}, 
        // {1, 1, 1, 1, 1}, 
        // {0, 0, 1, 0, 1}, 
        // {0, 0, 1, 0, 0}}; 
        // int arr[][]={ { 1,1 }, {1,1}};
        // int arr[][]= {{0 ,1 ,0 ,1 ,0 ,1},
        //               { 1, 0, 1, 0, 1 ,0} ,
        //               {0 ,1 ,1 ,1 ,1 ,0 },
        //               {0 ,0 ,1 ,1 ,1 ,0 },
        //               {1 ,1 ,1 ,1 ,1 ,1} };
        int arr[][]= {{0 ,0,0,0,0},
                      {0,1,1,1,1} ,
                      {0,1,1,1,1},
                      {0,1,1,1,1},
                      {0,1,1,1,1}};
        int ans = sub_squares_rec(arr);
        System.out.println(ans );
    }
    // ***************************************** CUT SET 
    public static class Pair{

        int val;
        String st;
        Pair(int x, String y ){
            val= x;
            st = y;
        }
    }

    // ************* matrix chain multiplication 
    public static int matrix_chain_rec(int arr[] , int lo, int hi ){

        if(lo+1==hi)
            return 0;
        int ans = Integer.MAX_VALUE; 
        for(int ul = lo+1; ul<hi ;ul++){
            ans = Math.min( ans , matrix_chain_rec(arr, lo , ul ) + matrix_chain_rec(arr, ul , hi) + arr[lo] *arr[ul] *arr[hi] );
        }
        return ans;
    }
    public static int matrix_chain_mem(int arr[] ,int lo , int hi , int dp[][] ){

        if(lo+1 == hi )
            dp[lo][hi]=0;

        if(dp[lo][hi]!=-1)
            return dp[lo][hi];

        int ans = Integer.MAX_VALUE;
        for(int ul = lo+1 ; ul < hi ; ul++)
        {
            ans = Math.min(ans , matrix_chain_mem(arr, lo, ul-1, dp)+ matrix_chain_mem(arr, ul,  hi, dp) +arr[lo]*arr[ul]*arr[hi]);
        }
        dp[lo][hi]=ans;
        return ans;
    }
    public static int matrix_chain_tab(int arr[] ){

        int n = arr.length;
        int dp[][]= new int[n][n];

        for(int gap= 1 ; gap < n;gap++){

            for(int i=0 , j =i+gap ; i<n && j<n ;i++ , j++){

                int min = Integer.MAX_VALUE;
                for(int temp = i+1 ; temp < j ; temp++ ){
                     min = Math.min(min , dp[i][temp]+dp[temp][j] +arr[i]*arr[temp]*arr[j] );
                }
                dp[i][j]=min==Integer.MAX_VALUE ? 0 : min;
            }
        }
        // print2d(dp);
        return dp[0][n-1];

    }
    
    //  evaluate expression made up of number , +  and *
    public static int eval(char op , int  x , int y ){
        if(op=='+') return x+ y;
        else if(op=='*') return x*y;
        else return -1;
    }
    public static int[] eval_rec(String exp , int lo , int hi ){
        if(lo==hi){
            return new int[]{Integer.parseInt(exp.charAt(lo)+""),Integer.parseInt(exp.charAt(lo)+"")};
        }
        int ans = Integer.MIN_VALUE;
        int  min_ans = Integer.MAX_VALUE;
        for(int i=lo+1 ; i <= hi ; i+=2 ){

                int left[] =eval_rec(exp ,lo , i-1 ); 
                int right []= eval_rec(exp , i+1 , hi );
                ans =Math.max( ans , eval(exp.charAt(i) , left[0], right[0]) );
                min_ans = Math.min(min_ans , eval(exp.charAt(i) , left[1], right[1]));
            
            }
            return new int[]{ans ,min_ans }; 
    }
    public static int [] eval_mem(String exp , int lo , int hi ,int dp[][][] ){

        if(lo==hi ){
            int dig = Integer.parseInt(exp.charAt(lo)+"");
            dp[lo][hi][0]=dp[lo][hi][1]=dig;
            return new int[]{dig,dig};
        }
        if(dp[lo][hi][0]!=-1 || dp[lo][hi][1]!=-1){
            return new int[]{dp[lo][hi][0],dp[lo][hi][1]};
        } 
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int ul = lo+1 ; ul <= hi ; ul+=2){
            int left[] = eval_mem(exp,lo,ul-1 ,dp);
            int right[] = eval_mem(exp , ul+1 ,hi , dp);
            max = Math.max( max , eval(exp.charAt(ul) ,  left[0] , right[0] ));
            min = Math.min( min , eval(exp.charAt(ul) ,  left[1] , right[1] ));
        }
         dp[lo][hi][0]=min;
         dp[lo][hi][1]=max;
        return new int[]{max,min };

    }
    public static int []eval_tab(String exp ){
        int n = exp.length();
        int max[][]= new int[n][n];
        for(int gap = 0 ; gap <n;gap+=2 ){

            for(int i=0 , j =i+gap ; i<n && j <n ;i+=2,j+=2){
                if(gap==0)  max[i][j]=Integer.parseInt(exp.charAt(i) + "");
                else {
                    int max_val =  Integer.MIN_VALUE;
                    for(int ul = i+1 ; ul <= j ; ul+=2)
                    {
                        max_val = Math.max(max_val,eval(exp.charAt(ul) ,max[i][ul-1] , max[ul+1][j]  ) );
                    }
                    max[i][j]=max_val;
                }
            }

        }

        int min[][]= new int[n][n];
        for(int gap = 0 ; gap <n;gap+=2 ){

            for(int i=0 , j =i+gap ; i<n && j <n ;i+=2,j+=2){
                if(gap==0)  min[i][j]=Integer.parseInt(exp.charAt(i) + "");
                else {
                    int min_val =  Integer.MAX_VALUE;
                    for(int ul = i+1 ; ul <= j ; ul+=2)
                    {
                        min_val = Math.min(min_val,eval(exp.charAt(ul) ,min[i][ul-1] , min[ul+1][j]  ) );
                    }
                    min[i][j]=min_val;
                }
            }

        }

        print2d(min);

            return new int[]{max[0][n-1] , min[0][n-1] };


    }
    
    // print bracket configuration of matrix chain multiplication
    public static Pair matrix_chain_rec_bracks(int arr[] , int lo, int hi ){

        if(lo+1==hi)
            return new Pair(0,(char)('A'+lo) +"");
        int ans = Integer.MAX_VALUE; 
        String myAns="";
        for(int ul = lo+1; ul<hi ;ul++){
            Pair left=  matrix_chain_rec_bracks(arr, lo , ul );
            Pair right = matrix_chain_rec_bracks(arr, ul , hi);
            int temp = left.val+ right.val + arr[lo] *arr[ul] *arr[hi] ;
            if( temp < ans ){
                ans = temp;
                myAns="("+left.st+right.st+")";

            }
        }
        return new Pair(ans, myAns);
    }
    public static Pair matrix_chain_tab_bracks(int arr[] ){

        int n = arr.length;
        int dp[][]= new int[n][n];
        String sdp[][]= new String[n][n];

        for(int gap= 1; gap < n;gap++){

            
            for(int i=0 , j =i+gap ; i<n && j<n ;i++ , j++){

                if(gap==1){
                    String baseCase=(char)('A'+i) +"";
                    sdp[i][j]=baseCase;
                    continue;
                }else{
                    int min = Integer.MAX_VALUE;
                    String myAns="";
                    for(int temp = i+1 ; temp < j ; temp++ ){
                
                        int ourAns= dp[i][temp]+dp[temp][j] +arr[i]*arr[temp]*arr[j];
                        if(ourAns < min ){
                            min = ourAns ;
                            myAns="("+sdp[i][temp] +sdp[temp][j] +")";
                        }
                        sdp[i][j]=myAns;
                    }
                    dp[i][j]=min==Integer.MAX_VALUE ? 0 : min;
                    
                }
            }
        }
        // print2d(dp);
        return new Pair( dp[0][n-1] , sdp[0][n-1] ) ;

    }
    // leetcode 312- hard     
    public static int burst_baloons_rec(int arr[] , int lo , int hi ){

        if(lo > hi)
            return 0;

        int lival= lo-1<0 ? 1 : arr[lo-1];
        int rival= hi+1>=arr.length ? 1 :arr[hi+1];
        int max_coins = Integer.MIN_VALUE;
        for(int cut = lo ; cut <= hi ; cut++){
            int left =burst_baloons_rec(arr, lo, cut-1);
            int right =  burst_baloons_rec(arr, cut +1, hi);
            int myAns= left+ lival*arr[cut]*rival + right ;
            max_coins = Math.max(max_coins , myAns);
        }
        return max_coins ;
    }
    public static int burst_baloons_mem(int arr[] , int lo , int hi ,int dp[][] ){

        if(lo > hi)
            return 0;
        if(dp[lo][hi]!=0)
            return dp[lo][hi];
        
        int lival= lo-1<0 ? 1 : arr[lo-1];
        int rival= hi+1>=arr.length ? 1 :arr[hi+1];
        int max_coins = Integer.MIN_VALUE;
        for(int cut = lo ; cut <= hi ; cut++){
            int left =burst_baloons_mem(arr, lo, cut-1 ,dp);
            int right =  burst_baloons_mem(arr, cut +1, hi ,dp);
            int myAns= left+ lival*arr[cut]*rival + right ;
            max_coins = Math.max(max_coins , myAns);
        }
        return dp[lo][hi]= max_coins ;
    }
    public static int burst_baloons_tab(int arr[] ){

        int n = arr.length;
        int dp[][]= new int[n][n];
        for(int gap =0 ; gap<n;gap++){

            for(int i=0 , j= i+gap ;i<n&& j<n;i++,j++){
                int lval = i-1>=0 ? arr[i-1] :1;
                int rval = j+1<n ? arr[j+1] :1;
                 
                if(gap==0){
                    dp[i][j]= lval*arr[i]*rval;
                    continue;
                }else{

                    int max_coins = Integer.MIN_VALUE;
                    for(int cut = i; cut <= j ; cut++){
                        int left =  i >cut-1 ?0 : dp[i][cut-1];
                        int right = cut+1 > j ?0 : dp[cut+1][j];
                        int myAns= left+ lval*arr[cut]*rval + right ;
                        max_coins = Math.max(max_coins , myAns);
                    }
                    dp[i][j]=max_coins;
                }
            }

        }

        // print2d(dp);
        return dp[0][n-1];
    }
    // stack box problem java 
    public static class box implements Comparable<box>{
        int w ; 
        int d ;
        int h;
        box(int a ,int b , int c ){
            h=a;
            w=b;
            d=c;
        }
        @Override
        public int compareTo(box temp ){
            int resp =this.d*this.h- temp.d*temp.h;
            return this.d*this.w- temp.d*temp.w;
        }

    }
    public static int stack_box(box arr[] ){

        box newarr[]= new box[arr.length*3];
        int j=-1;
        for(int i=0;i<arr.length;i++){
            newarr[++j]= new box(arr[i].h,arr[i].w,arr[i].d);
            newarr[++j]= new box(arr[i].d,arr[i].w,arr[i].h);
            newarr[++j]= new box(arr[i].w,arr[i].d,arr[i].h);
            // System.out.println("tets :"+newarr[i].h+" "+newarr[i].w+" "+newarr[i].d+" ");
        }
        Arrays.sort(newarr);

        for(int i=0;i<newarr.length;i++){
            // System.out.println("tets :"+newarr[i].h+" "+newarr[i].w+" "+newarr[i].d+" ");
        }
        int lis[]= new int[newarr.length]; 
        int full_ans= 0;
        lis[0]=newarr[0].h;
        for(int i=0;i<newarr.length;i++){
            
            int ans=0;
            for(int x=0;x<i;x++){
                // System.out.println("xth: "+x+" "+newarr[i].h+" : "+newarr[x].h+" "+ (newarr[i].h > newarr[x].h   && ans > lis[x] ));
                if(newarr[i].h > newarr[x].h && ans < lis[x]  && newarr[i].d >= newarr[x].d && newarr[i].w >= newarr[x].w )
                {
                    // System.out.println("    hola :"+lis[x]+" x :"+x);
                    ans =lis[x];
            
                }
            } lis[i]=ans+newarr[i].h;
             full_ans= Math.max(full_ans, lis[i]);
             System.out.println("newrr is : "+newarr[i].h+" , "+newarr[i].w+" , "+newarr[i].d +" and "+ lis[i]+" : i : "+i);

        }
        return full_ans;
    }

    // boolean paranthization problem gfg
    public static int eval_bools(boolean a , boolean b , char opt){
        if(opt=='|') return (a|b )==true ? 1 :0;
        else if(opt=='&')   return (a&b )==true ? 1 :0;
        else if(opt=='^')  return (a^b)==true ? 1 :0;;
         return 0; 
    }
    public static int[] bool_paranth_rec(boolean arr[] , char opt[] , int lo , int hi ){
        // 0th index means false and 1st index means true;
        if(lo==hi)
            return arr[lo]==true ? new int[]{0,1} : new int[]{1,0};
        // System.out.println(" at  "+lo+" , "+hi);
        int true_ways=0 ,false_ways =0 ;
        for(int cut = lo ; cut < hi ; cut++){

            int left[]= bool_paranth_rec(arr, opt, lo, cut);
            int right[] = bool_paranth_rec(arr, opt, cut+1, hi);
            int tw= left[0]*right[0]+left[1]*right[0]+left[0]*right[1]+left[1]*right[1];
            if(opt[cut]=='|'){
                true_ways+= tw-right[0]*left[0];
                false_ways+= right[0]*left[0];
            }else if(opt[cut]=='&'){
                true_ways+=right[1]*left[1];
                false_ways+=tw-right[1]*left[1];
            }else if(opt[cut]=='^'){
                true_ways += right[1]*left[0] + right[0]*left[1];
                false_ways += right[0]*left[0] + right[1]*left[1];
            }

        }
        
        return new int[]{false_ways,true_ways};


    }
	public static int[] bool_paranth_mem(String line , int lo ,int hi , int dp[][][]){
	    
	    if(lo==hi){
	        return dp[lo][hi]=line.charAt(lo)=='T' ? new int[]{0,1} : new int[]{1,0}; 
	    }
	    if(dp[lo][hi][0]!=0 && dp[lo][hi][1]!=0  ){
	        return  dp[lo][hi];
	    }
	    
	    int true_ways=0 , false_ways=0;
	    for(int cut = lo+1 ;cut< hi ; cut+=2){
	        
	        int left[] = bool_paranth_mem(line, lo, cut-1 ,dp );
	        int right[] = bool_paranth_mem(line, cut+1 , hi,dp );
	        int tw= left[0]*right[0]+left[1]*right[0]+left[0]*right[1]+left[1]*right[1];
            if(line.charAt(cut)=='|'){
                true_ways= true_ways%1003 + tw-right[0]*left[0];
                false_ways+= right[0]*left[0];
                
            }else if(line.charAt(cut)=='&'){
                true_ways+=right[1]*left[1];
                false_ways+=tw-right[1]*left[1];
                
            }else if(line.charAt(cut)=='^'){
                true_ways += right[1]*left[0] + right[0]*left[1];
                false_ways += right[0]*left[0] + right[1]*left[1];
            }

        }
         dp[lo][hi][0]=false_ways;
         dp[lo][hi][1]=true_ways;;
	    return dp[lo][hi];
	    
	}
	     

    public static void cut_type_problems_set(){

        // int arr[] = {10,30,5,60};
        // int arr[]  = {10, 20, 30}  ;
        // int arr[] = {40, 20, 30, 10, 30};
        // int arr[]= {10, 20, 30, 40, 30} ;
        // int ans =  matrix_chain_rec(arr , 0 , arr.length-1);
        // int dp[][]= new int[arr.length][arr.length];
        // System.out.println("recusrive ans :" +ans);
        // fill2d(dp, -1);
        // ans = matrix_chain_mem(arr, 0 , arr.length-1 ,dp );
        // // print2d(dp);
        // System.out.println("memoized ans : "+ans);
        // ans = matrix_chain_tab(arr);
        // System.out.println("tabulated ans : "+ans);
        // ******************* QUESTION -2 
        // String exp = "1+2*3+4*5";
        // // String exp = "4*7+2+3*6";
        // // String exp = "1*1+1+1*1";
        // int ans[] = eval_rec(exp, 0 ,exp.length()-1);
        // System.out.println("recusrive ans :- max " +ans[0]+" min : "+ans[1]);
        // int n= exp.length();
        // int dp[][][]= new int[n][n][2];
        // for(int sub[][] : dp) fill2d(sub,-1);
        // ans= eval_mem(exp , 0 , exp.length()-1, dp );
        // System.out.println("memoized  ans :- max " +ans[0]+" min : "+ans[1]);
        // // print3d(dp);   
        // ans = eval_tab(exp);
        // System.out.println("tabulated ans  : " +ans[0]+" min: "+ans[1]);
        //  Q-3 PRINT ANSWER STRING OF MCM -
        // Pair  p =matrix_chain_rec_bracks(arr, 0, arr.length-1);
        // System.out.println("min no of calclations: "+p.val + " and formation : "+p.st);
        //   p =matrix_chain_tab_bracks(arr);
        // System.out.println("min no of calclations in tabulation : "+p.val + " and formation : "+p.st);
        // ************************BURST BALLOONS 
        // int arr[] = {3,1,5,8,6};
        // // int arr[] ={8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5 };
        // int ans =burst_baloons_rec( arr, 0 ,arr.length-1);
        // System.out.println("burst balooons recusive : "+ans) ;
        // int dp[][]=  new int[arr.length][arr.length];
        // ans= burst_baloons_mem(arr, 0, arr.length-1,dp);
        // print2d(dp);
        // System.out.println("burst balooons memoized : "+ans) ;
        // ans = burst_baloons_tab(arr);    
        // System.out.println("burst balooons tabulated : "+ans) ;
        // STACK BOX PROBLEM GFG :--------------------------
        // box arr[]= new box[4];
        // arr[0]= new box(4,6,7);
        // arr[1]= new box(1,2,3);
        // arr[2]= new box(4,5,6);
        // arr[3]= new box(10,12,32);
        // int ans= stack_box(arr);
        // System.out.println("box stack length is : "+ans);
        //  BOOLEAN PARANTHIZATION
        // boolean arr[] = { true, true, false , true};
        // char opt[]= { '|', '&' , '^' };
        // int ans[] =bool_paranth_rec(arr,opt,0,arr.length-1 );
        String line= "T|T&F^T";
        int n = line.length();
        int ans[] = bool_paranth_mem(line, 0,  n-1, new int[n][n][2]);
        System.out.println("boolean paranth mem  : "+ans[1]);
        
    }

    
    public static void main (String args[ ]) {

        // lis_questions();
        // problems();
        cut_type_problems_set();
    }
}
