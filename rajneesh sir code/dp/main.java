public class main{


    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
    public static void print2d(int arr[][]){
        for(int x[] :arr){
            print(x);
        }
    }

    public static int printwaysHV(int sr , int sc , int tr ,int tc, String asf){

        if(sr> tr || sc >tc){
            return 0;
        }
        if(sr==tr && sc==tc){
            System.out.println(asf);
            return 1;
        }

        return printwaysHV(sr,sc+1,tr,tc,asf+"R")+printwaysHV(sr+1,sc,tr,tc,asf+"D");
    }

    public static int printwaysHVD(int sr , int sc , int tr ,int tc, String asf){

        if(sr> tr || sc >tc){
            return 0;
        }
        if(sr==tr && sc==tc){
            System.out.println(asf);
            return 1;
        }

        return printwaysHVD(sr,sc+1,tr,tc,asf+"H")+printwaysHVD(sr+1,sc,tr,tc,asf+"V")+printwaysHVD(sr+1,sc+1,tr,tc,asf+"D");
    }
    public static int printwaysHVDjumpInt(int sr , int sc , int tr ,int tc, String asf){

        if(sr==tr && sc==tc){
            System.out.println(asf);
            return 1;
        }
        int ans=0;
        for(int i=1; i<Math.max(tr,tc);i++){
           
            if(sc+i<=tc)
                ans+=printwaysHVDjumpInt(sr,sc+i,tr,tc,asf+"H"+i);
            if(sr+i<=tr)
                ans+=printwaysHVDjumpInt(sr+i,sc,tr,tc,asf+"V"+i);
            if(sr+i<=tr && sc+i<=tc)
                ans+=printwaysHVDjumpInt(sr+i,sc+i,tr,tc,asf+"D"+i);
        }
        return ans;
        
       
    }

    public static int fib(int n ){
        if(n==0 || n==1)
            return n;

        return fib(n-1)+fib(n-2);
    }
    public static void solve(){
        // System.out.println(fib(10));
        // System.out.println(printwaysHV(0,0,2,2,""));
        // int n=10;
        // System.out.println(printwaysHVD(0,0,2,2,""));
        // System.out.println(printwaysHVDjumpInt(0,0,3,3,""));
        // System.out.println(diceFaceToTarget(0,n,""));
        // int dp[]= new int[n+1];
        // System.out.println(diceFaceToTargetdp(0,n,dp));
        // int arr[]={2,5,8,3};
        // System.out.println(diceFaceToTargettab(0, n, dp));
        // System.out.println(dicetype2(arr));
        // ************GOLDMINE RECURSIVE 
        int mat[][] = {{10, 33, 13, 15},
                    {22, 21, 4, 1},
                    {5, 0, 2, 3},
                    {0, 6, 14, 2}};

        int dp[][]= new int[mat.length][mat[0].length];
        // int ans=Integer.MIN_VALUE;
        // for(int i=0;i<mat.length;i++){
        //     ans=Math.max(goldmineRec(i,0,mat),ans);
        // }
        
        // System.out.println(ans);
        //**************MEMOIZATOIN */ 
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<mat.length;i++){
            ans=Math.max(goldminemem(i,0,mat,dp),ans);
        }
        System.out.println(ans);
        print2d(dp);
        // print(dp);
    }
    public static int goldmineRec(int sr , int sc , int arr[][] ){

            
            int ans=0;
            // right - up
            if(sr-1 >0 && sc+1 <arr[0].length){
                ans=Math.max(goldmineRec(sr-1,sc+1,arr),ans);
            }
            // right - same lane
            if(sc+1<  arr[0].length){
                ans=Math.max(goldmineRec(sr,sc+1,arr),ans);
            }
            // right down
            if(sr+1<arr.length && sc+1<arr[0].length){
                ans=Math.max(goldmineRec(sr+1,sc+1,arr),ans);
            }
            return ans+arr[sr][sc];
    }
    
    public static int goldminemem(int sr, int sc , int arr[][] , int dp[][]){

               
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        int ans=0;
        // right - up
        if(sr-1 >0 && sc+1 <arr[0].length){
            ans=Math.max(goldminemem(sr-1,sc+1,arr,dp),ans);
        }
        // right - same lane
        if(sc+1<  arr[0].length){
            ans=Math.max(goldminemem(sr,sc+1,arr,dp),ans);
        }
        // right down
        if(sr+1<arr.length && sc+1<arr[0].length){
            ans=Math.max(goldminemem(sr+1,sc+1,arr,dp),ans);
        }
        return dp[sr][sc]=ans+arr[sr][sc];

    }
    
    public static  int  diceFaceToTargettab(int si , int ei , int dp[]){

        dp[ei]=1;
        for(int i=ei-1;i>=0;i--){
            
            int temp=0;
            for(int jump=1;jump<=6;jump++){
                if(jump+i <dp.length)
                    temp+=dp[jump+i];
            }
            dp[i]=temp;
        }
        return dp[0];

    }
    public static int diceFaceToTargetdp(int si , int ei , int dp[]){
        if(si > ei)
            return 0;
        if(si==ei)
            dp[si]=1;

        int ans=0;
        if(dp[si]!=0)
            return dp[si];

        for(int i=1;i<=6;i++){
            ans+=diceFaceToTargetdp(si+i,ei,dp);

        }
        return dp[si]=ans;

    }
    public static int diceFaceToTarget(int si , int ei, String asf){

        if(si >ei )
            return 0;
        if(si==ei){
            System.out.println(asf);
            return 1;
        }
        int ans=0;
        for(int i=1;i<=6;i++){
            if(si+i<=ei){
                ans+=diceFaceToTarget(si+i,ei,asf+i);
            }
        }
        return ans;
    }
    public static void main(String args[]){
        
        solve();

    }
}