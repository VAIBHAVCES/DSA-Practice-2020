public class main {
        


    public static void main(String[] args) throws Exception {
        int arr[] = new int[]{1,10,5,3,2,7,-1,0, 0 ,5,1,-555,6,17,13,19};
        // heap hp  = new heap(arr,true);
        // System.out.println(hp);
        // hp.poll();
        // System.out.println("after : "+hp);
        // int ans []= heapSort(arr);
        // for(int ele : ans){
        //     System.out.print(ele+" ,");
        // }
        
        heap_sort(arr,true);
         for(int ele : arr){
                System.out.print(ele+" ,");
            }


    }

    public static int compareTo(int ch , int ch2 ,int arr[] , boolean x ){

        // System.out.println()
        if(x ) return arr[ch]-arr[ch2];
        return arr[ch2]-arr[ch];
    }

    public static void downheapify(int idx, int arr[] , int n , boolean isMax){
        
        int lci  = 2*idx+1;
        int rci = 2*idx+2;
        int max = idx;
        if(lci  <= n  && compareTo(lci , max , arr, isMax) > 0) max = lci;
        if(rci <= n  && compareTo(rci , max ,arr , isMax ) > 0 ) max = rci ;
        if(max !=idx) {
            swap(arr , idx ,max );
            downheapify(max, arr , n , isMax);
        }

    }
    public static void  swap (int arr[]  , int x ,int y ){

        int temp =arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

    public static void heap_sort(int arr[] , boolean isMax )
    {
        int n =arr.length;
        for(int i=arr.length-1;i>=0;i--){
            downheapify(i,arr, n-1, isMax);
        }

        
        int ptr= n-1;
        while(ptr>=0){
            swap(arr, 0 ,  ptr );
            ptr--;
            downheapify(0, arr, ptr, isMax);
        }


    }
    // this function is using heap or priority (my own made );
    public static int[] heapSort(int arr[] ) throws Exception{
        heap hp  = new heap(arr,true);
        int n =arr.length-1;
        int ans[]= new int[n+1];
        while(hp.size() > 0 ){

           ans[n]= hp.poll();
            n--;
        }
        return ans;

    }

}
