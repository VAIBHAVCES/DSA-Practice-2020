import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
public class questions {

    public static int lengthoflongestsubstring(String s1) {
        int n = s1.length();
        int freq[]= new int[128];
        int si =0 , ei=0 ,len = -(int)1e8 , count =0 ;
        while(ei < n ){
            
            System.out.println("before else: "+ei+" : "+count );
            if(freq[s1.charAt(ei++)]++==0) {  count ++; }
            else{
                System.out.println("inside else: "+ei+" "+si);
                while(si < n  && freq[s1.charAt(ei)]!=0){
                    freq[s1.charAt(si++)]--;
                    count--;
                }
            }
            len = Math . max (count , len );
            
        }
        return len;
    }
    public static int leet340(String str , int k  ) {

        int freq[]= new int[128];
        int n = str.length();
        int count =0;
        // for(int i=0; i < n ;i++){
        //     if(freq[str.charAt(i)]++ == 0 ) count ++;
        // }

        int si =0 , ei =0 , len=-(int)1e7;
        for(int i=0;i< n ;i++){
            if(freq[str.charAt(ei++)]++ ==0 ) count++;
            while(count > k ){
                if(freq[str.charAt(si++)]--==1) count--;
            }
            len= Math.max(len , ei-si) ;
            
        }
        return len ; 

    }
    public static int llsscWrong(int arr[]){

        Arrays.sort(arr);
        int dp[] = new int[arr.length];
        dp[0]=1;
        int ans = 0;
        for(int i=1;i <arr.length;i++){
            dp[i]=1;
            if(arr[i]-arr[i-1]==1) dp[i]+=dp[i-1];
            ans = Math.max(ans, dp[i]);
        }
        return ans;

    }
    public static int largetSubarrayContigousSum(int arr[] ){

        int min = (int)1e8 , max = -(int)1e8 ,ans =0; 
        for(int i=0;i<arr.length ; i++){
            min = max = arr[i];
            for(int j=i+1; j <arr.length ;j++ ){
                max = Math.max(arr[j], max );
                min = Math.min(arr[j], min );
                if(max- min == j-i) ans= Math.max(ans ,max-min);
            }
        }
        return ans;
    }
    public static int countPairSumDivByK(int arr[] ,  int k ){

        int freq[]= new int[k];
        for(int ele: arr ) freq[ele%k]++;
        int ans=0;
        ans+=( freq[0] *( freq[0]-1))/2;
        for(int i=1; i<= (k%2==0 ?  k/2-1 :k/2) ; i++ ){
                ans+=  freq[i] * freq[k-i];
        } 
        if(k%2==0) ans+=(freq[k/2] * (freq[k/2]-1))/2;
        return ans;
     }
     public static int countPairSumDivByK2(int arr[] ,  int k ){

        int freq[]= new int[k];
        for(int ele: arr ) freq[ele%k]++;
        int ans=0;
        ans+=( freq[0] *( freq[0]-1))/2;
        for(int i=1; i<= (k%2==0 ?  k/2-1 :k/2) ; i++ ){
                ans+=  freq[i] * freq[k-i];
        } 
        if(k%2==0) ans+=(freq[k/2] * (freq[k-k/2]-1))/2;
        return ans;
     }

     public static boolean check_ap(int arr[] ){
         int n = arr.length;
         int  min=(int)1e8 ;
         int min2=(int)1e8; 
         HashSet<Integer>mem= new HashSet<>();
        
         for(int i=0 ;i <n;i++)  {
             
             int val = arr[i];
             System.out.println(arr[i]);
             if(val< min ){
                 min2 =min;
                 min =val;
             }else {
                 min2 =Math.min(min2,val);
             }
             mem.add(val);
             
         }
         System.out.println(min2+" "+min);
         return false;
     }
    
    public  static  void maxForKWindow(int[] arr, int n) {
    
        int si=0, ei=0 ;
        int ans[] = new int[arr.length];
        ArrayDeque<Integer>st = new ArrayDeque<>();
        while(ei < arr.length ){
            // System
            if(ei-si< n ){
                
                while(st.size()>0 && arr[st.peekLast()] < arr[ei] ){
                    st.removeLast();
                }
                st.addLast(ei++);
            }
            System.out.println(si+" "+ei+" " +st+" "+(ei<n));
            if(ei-si== n){
                ans[si]=arr[st.peekFirst()];
                // System.out.println(si+" : "+ans[si]);
                si++;
                while(st.size() > 0 && st.peekFirst() < si){
                    st.removeFirst();
                }
            }
            // System.out.println("in end: "+si);
        }
        for(int i=0; i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }

    }



    public static void problems(){
        //
        int  arr[] = {9, 7, 2, 4, 6, 8, 2, 1, 5};
        int k  =3;
        // System.out.println(check_ap(arr));


        // String str= "foregefegf" ;
        // // int ans=   leet340(str , 3);
        // int ans = lengthoflongestsubstring(str);
        // int arr[] ={1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        // int ans = largetSubarrayContigousSum(arr);

        // count pair sum divisible by k 
        // int arr[]=   {5, 9, 36, 74, 52, 31, 42};
        // int arr[]={2,3,11,12,10,6,9};
        // int arr[] = { 5,5,5,5,5,6,6,6,6,7,7,7,7,7,7,9,9,9,9,9,9,9,9,9};
        // int ans = countPairSumDivByK(arr,5);
        // int ans2= countPairSumDivByK(arr,5);
        
        // System.out.println(ans+" "+ans2);
        // print max for every k sized window 
        maxForKWindow(arr,k );


    }
    public static void main(String[] args) {
         problems ();
         
    }
}
