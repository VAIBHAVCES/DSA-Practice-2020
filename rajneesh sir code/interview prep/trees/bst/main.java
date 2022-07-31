public class main {
    
    public static int binarySearch (int toFind , int arr[] ){

        int si=0 ,ei =arr.length;        
        while(si < ei ){
            
            int mid= (si+ei)>>1;
            // System.out.println(mid);
            if(arr[mid]==toFind){
                return mid;
            }else if(arr[mid]  > toFind ){
                ei=mid-1;
            }else if(arr[mid] <toFind){
                si = mid+1 ;
            }
    }
    return -1;

    } 
    public static int firstOccurence(int toFind ,int arr[]){
        int si=0, ei=arr.length-1;
        while(si  <ei ){
            int mid=(si+ei)>>1;
            System.out.println("check : " +si+" " +ei +" "+ mid);
            if(arr[mid]==toFind){

                if(mid-1>=0 && arr[mid-1]==toFind) ei=mid-1;
                else return mid; 

            }else if(arr[mid] > toFind) {
                ei=mid-1;

            }else if(arr[mid] < toFind){
                si=mid+1;
            }
        }
            return -1;
        }
    
   
    public static int findCorrectPosition(int si , int ei, int ins , int arr[] ){

        if(ei-si==1)
            return si;
        int mid =(si+ei)>>1;
        if(arr[mid] > ins){
                si=mid;
        }else if(arr[mid] < ins) {
                ei=mid;
        }else if(arr[mid] == ins) {
                if(mid-1>=0 && arr[mid-1]==ins){ ei =mid ; }
                else return mid;
        }
        return findCorrectPosition(si , ei , ins, arr);

    }
    public static void main (String  args[] ){
        int arr[]=  {1,1,1,2,2,2,2,2,2,3,3,3,3,4,4,4,5,6,10,11,15,17,21};
        // int arr[]= { 11} ;
        // *****DHYAAN RAKHE BINARY SEARCH MEI ENDING INDEX = ARR.LENGTH JATA HAI 
        System.out.println(binarySearch(  12, arr));
        System.out.println(firstOccurence( 4,arr));
        // System.out.println(findCorrectPosition(0,arr.length ,12,arr));
    
    }

}

