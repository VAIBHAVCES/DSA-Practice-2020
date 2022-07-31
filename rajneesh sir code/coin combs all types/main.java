

// import javax.sound.midi.SysexMessage;

class main{

    public static void main(String[] args) {
        solve();
    }
    
    public static void solve(){
            int coins[]={2,3,5,7};
            int tar=10;
            // System.out.println(ccinfiniteComb(coins, tar, 0, ""));
            // ans for above is 5 

            // System.out.println(ccinfinitePermut(coins, tar, 0, ""));
            // ans for above one is 16 

            // System.out.println(ccsingleComb(coins, tar, 0, ""));
            // ans will be 2

            System.out.println(ccsinglePermut(coins, tar, 0, ""));
            // ans is 8 combinations 

            //  System.out.println(ccsingleComb_subseq(coins, tar, 0, ""));
            // ans is 2 

            // System.out.println(ccsinglePermut_subseq(coins, tar, 0, ""));
             // ans is 8 combinations 
            // ========================QUEEN'S PROBLEM REVISION ============
            int n=4;
            boolean box [][] = new boolean[n][n];
            int tnq=4;


            //  System.out.println(queenPermut(0,tnq,box,""));
            //  expected outputs to be 1820
            
            // System.out.println(queenComb(0,tnq,box,""));
            // ans is 1820

            //   System.out.println(nQueensPemut(0,tnq,box,"")); 
            
            //   System.out.println(nQueensUsingCombs(0,tnq,box,"")); 

            System.out.println(nQueensTraversingRowsOnly(0,tnq,box,"")); 
              
              
            // System.out.println(queenPermut(0,3,new boolean[6],""));

             // System.out.println(queenComb2d(0,6,"",0,3));
    }
    public static int ccinfiniteComb(int arr[],int tar, int idx ,String ans){

        if(tar==0)
        {
            System.out.println(ans);
            return 1;

        }

        int count=0;
        for(int i =idx;i<arr.length;i++){
            if(tar-arr[i]>=0)
                count+=ccinfiniteComb(arr, tar-arr[i], i, ans+arr[i]);
        }
        return count;
    }
    public static int ccinfinitePermut(int arr[],int tar,int idx,String ans){

        if(tar==0)
        {
            System.out.println(ans);
            return 1;
        }
        int count=0;
      for(int i=0;i<arr.length;i++){
        if(tar-arr[i]>=0)
            count+=  ccinfinitePermut(arr,tar-arr[i],0,ans+arr[i]);
      }
      return count;
    }
    public static int ccsingleComb(int arr[],int tar,int idx,String ans){

    
    if(tar==0){
        System.out.println(ans);
        return 1;
    }
      int count=0;
      for(int i=idx;i<arr.length;i++){
          if(tar-arr[i]>=0)
                count+= ccsingleComb(arr, tar-arr[i], i+1, ans+arr[i]);

      } 
      return count;
    }   
    public static int ccsinglePermut(int arr[],int tar,int idx,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;

        }

        int count=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]>=0){
                int temp=arr[i];
                arr[i]=-1*arr[i];
                if(tar-temp>=0)
                count+=ccsinglePermut(arr, tar-temp, i, ans+temp);
                arr[i]=-1*arr[i];
            }
        }

        return count;
    }
    public static int ccsingleComb_subseq(int arr[],int tar,int idx,String ans){
        
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        if(idx==arr.length)
            return 0;
        
        
        int count=0;
        if( tar-arr[idx]>=0){
            count+=ccsingleComb_subseq(arr, tar-arr[idx], idx+1, ans+arr[idx]);
        }
        count+=ccsingleComb_subseq(arr, tar, idx+1, ans);
        return count;
    }   
    public static int ccsinglePermut_subseq(int arr[],int tar,int idx,String ans){
   
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        if(idx==arr.length){
            return 0;
        }

        int count=0;
        int temp=arr[idx];
        if(arr[idx]>=0 && tar-temp>=0){
            arr[idx]=-1*arr[idx];
            if(tar-temp>=0){
                count+=ccsinglePermut_subseq(arr, tar-temp, 0, ans+temp);
                arr[idx]=-1*arr[idx];
            }
        }
        count+=ccsinglePermut_subseq(arr, tar, idx+1, ans);
        return count;
    }
    
     // ************************queen's probelem*****************
    
    public static int queenComb(int idx, int tnq , boolean[][]box, String asf ){
        
        if(tnq==0){
            System.out.println(asf);
            return 1;
        }

        int count=0;
        int n=box.length;
        int m=box[0].length;

        for(int i=idx;i<n*m;i++){
            int r = i / m;
            int c = i % m; 
            count+=queenComb(i+1,tnq-1,box,asf + "(" + r + ", " + c + ") ");
        }

        return count;
    }
    
    public static int queenPermut( int idx , int tq,boolean box[][] , String asf){

        if(tq==0){
            System.out.println(asf);
            return 1;
        }
        int n=box.length;
        int count=0;
        for(int i=0;i<n*n;i++){
            int x=i/n;
            int y=i%n;
            if(!box[x][y]){
                box[x][y]=true;
                count+=queenPermut(i, tq-1, box, asf+"b"+"("+x+" , "+y +") "+"q"+tq+" ");
                box[x][y]=false;

            }
        
            
        }
        return count;

    }

    public static int nQueensPemut( int idx , int tq,boolean box[][] , String asf){

        if(tq==0){
            System.out.println(asf);
            return 1;
        }
        int n=box.length;
        int count=0;
        for(int i=0;i<n*n;i++){
            int x=i/n;
            int y=i%n;
            if(!box[x][y] && isSafe(box, x, y)){
                box[x][y]=true;
                count+=nQueensPemut(i, tq-1, box, asf+"b"+"("+x+" , "+y +") "+"q"+tq+" ");
                box[x][y]=false;

            }
        
            
        }
        return count;

    }
    
    public static int nQueensUsingCombs( int idx , int tnq,boolean box[][] , String asf){
        
        if(tnq==0){
            System.out.println(asf);
            return 1;
        }

        int count=0;
        int n=box.length;
        int m=box[0].length;

        for(int i=idx;i<n*m;i++){
            int r = i / m;
            int c = i % m; 
            if(box[r][c]==false && isSafe(box, r, c)==true){
                box[r][c]=true;
                count+=nQueensUsingCombs(i+1,tnq-1,box,asf + "(" + r + ", " + c + ") ");
                box[r][c]=false;
            }
        }

        return count;
    }

    public static int nQueensTraversingRowsOnly(int row, int tnq, boolean box[][],String asf){

        if(tnq==0){
            System.out.println(asf);
            return 1;
        }
        int count=0;
        for(int i=0;i<box.length;i++){

            if(isSafe(box, row, i)){
                box[row][i]=true;
                count+=nQueensTraversingRowsOnly(row+1,tnq-1,box,asf+"b"+"("+row+" , "+i+") "+"q"+tnq);
                box[row][i]=false;
            }
        }
        return count;
    }
    public static boolean isSafe(boolean box[][], int row, int col){

        int dirc[][]={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        int n= box.length;
        for(int d[]:dirc){

            for(int i=1;i<box.length;i++){
                int x=row+i*d[0];
                int y=col+i*d[1];
                if(x>=0&& y>=0&& x<n && y <n &&box[x][y]==true)
                    return false;
            }
            
        }
        return true;
    }
}
