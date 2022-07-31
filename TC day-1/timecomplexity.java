// import java.io.*;
import java.util.*;
 public class timecomplexity {
    

    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        // int n = scn.nextInt();
        int arr[]={5,4,3,2,1,9,7,6,8,6};
        // bubblesort(arr);
        // selectionsort(arr);
        // insertionsort(arr);
        arr=mergeSort(arr, 0, arr.length-1);

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"  ");

    }

    public static void bubblesort(int arr[]){
        int len=arr.length;

        for(int i=0;i<len-1;i++){
            
            for(int j=0;j<len-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int swap=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=swap;
                }
            }
        }
        


       
    }

    public static void selectionsort(int arr[]){
        int len =arr.length;
        for(int i=0;i<len-1;i++){
            int min=i;
            for(int j=i+1;j<len;j++){
                if( arr[j] < arr[min])
                    min=j;
            }
            
            int swap=arr[i];
            arr[i]=arr[min];
            arr[min]=swap;

        }
    }

    public static void insertionsort(int arr[]){
        int n= arr.length;
        for(int i=1;i<n;i++){
            for(int j=i;j>=1;j--){
                if(arr[j] < arr[j-1])
                {
                    int swap=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=swap;
                }else{
                    break;
                }
            }

        }


    }

    public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        //write your code here
        int size=a.length+b.length;
        int ans[]= new int[size];
        int pta=0;
        int ptb=0;
        for(int i=0;i<size;i++){
            
            if(pta>=a.length)
            {
                // System.out.println(pta+" " +ptb);
                while(ptb<b.length){
                    ans[i]=b[ptb];
                    ptb++;
                    i++;
                }
            }else if(ptb>=b.length){
                // System.out.println("b exceeded : "+ptb+"  "+pta);
                while(pta<a.length){
                    // System.out.println("putting : "+a[pta]+" at "+i);
                    ans[i]=a[pta];
                    pta++;
                    i++;
                }
                
            }else{
                if(a[pta] < b[ptb]){
                    ans[i]=a[pta];
                    pta++;
                    
                }else{
                    ans[i]=b[ptb];
                    ptb++;
                }
                
            }
        }
        
        return ans;
      }

    public static int[] mergeSort(int arr[] ,int low ,int high){
        if(low==high){

            int temp[]= new int[1];
            temp[0]=arr[low];
            return temp;
        }
        // System.out.println(low+"  "+high);
        int mid=(low+high)/2;
        int left[]=mergeSort(arr, low, mid);
        int right[]=mergeSort(arr , mid+1,high);
        return mergeTwoSortedArrays(left, right);
    }

    public static void partition(int arr[]){

       
    }

}