import java.util.*;
public class questions {
    public static void main(String[] args) {
        solve();

    }
    public static void solve(){
        // int arr[]={1,2,3,4,5,5,6,6,7,8,9,};
        int arr[]={5,4,2,7,8,1};
        // int arr[]={5,10,15,20,25};
        // int ans[]=nextGreater(arr, 0);
        // int ans[]=ngor(arr);
        // int ans[]=nsor(arr);
        int ans[]=nsol(arr);
        for(int i=0;i<ans.length;i++)
        System.out.println("ng for " +arr[i]+" is "+(ans[i]!=-1?arr[ans[i]] : -1)+" ");
    }
    public static int[] nextGreater(int arr[], int idx){

        Stack<Integer>st = new Stack<>();
        int ans[]= new int[arr.length];
        int i=0;
        st.push(i);
        for( i=1;i<arr.length;i++){
             {
                while(st.size() > 0 && arr[i] > arr[st.peek()]){
                    int top=st.pop();
                    ans[top]=i;
                }
                if(st.size()==0){
                    ans[i]=-1;
                }
               
            }
            st.push(i);
    
        }
        return ans;
    }

    public static int[] ngor(int arr[]){
        int ans[]= new int[arr.length];
        Stack<Integer>st = new Stack<>();
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()> 0 && arr[i] > arr[st.peek()]){
                int top=st.pop();
                ans[top]=i;
            }
            if(st.size()==0)
                ans[i]=-1;
            st.push(i);
        }
        return ans;
    } 

    // **********in my opinion worst case can be of 2 travesals
    public static int[] nsor(int arr[]){

        Stack<Integer>st = new Stack<>();
        st.push(0);
        int ans[]= new int[arr.length];
        for(int i=1;i<arr.length;i++)
        {
            while(st.size() >0 && arr[i] < arr[st.peek()]){
                ans[st.pop()]=i;
            }
            if(st.size()==0){
                ans[i]=-1;
            }
            st.push(i);
        }
        return ans;
    }

    public static int[] nsol(int arr[]){

        int n =arr.length;
        Stack<Integer>st = new Stack<>();
        st.push(n-1);
        int ans[]= new int[arr.length];
        for(int i=n-2;i>=0;i--)
        {
            while(st.size() >0 && arr[i] < arr[st.peek()]){
                ans[st.pop()]=i;
            }
            if(st.size()==0){
                ans[i]=-1;
            }
            st.push(i);
        }
        return ans;
    }

}