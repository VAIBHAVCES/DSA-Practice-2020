
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;

public class directAcyclicGraph {
    
    public static void print1d(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }
    
    static int N=7;
    static ArrayList<Integer>graph[]= new ArrayList[N];

    public static void  addEdge(int u, int v){
        graph[u].add(v);
       
    }
    public static void constructGraph(){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        addEdge(0,1);
        addEdge(0,3);
        // addEdge(0,6,5);
        addEdge(1,2);
        addEdge(1,4);
        addEdge(2,3);
        // addEdge(2, 5,8);
        addEdge(4,5);
        addEdge(5,6);
        addEdge(4,6);
        // addEdge(6,4);

        // addEdge(0,6,1);
        // addEdge(2,5,1);
    }
    public static void display(){
        StringBuilder ans= new StringBuilder();  
        for(int i=0;i<graph.length;i++){
            
            ans.append( i+"  = > ");
            for(int e :  graph[i]){

                ans.append(e+" ,");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }  
   public static int[]  buildIncoming(){
        int inc[]= new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int e: graph[i]){
                inc[e]++;
            }
        }
        return inc;
   }
    public static void KahnsTopology(){

        int incoming[]=buildIncoming();
        // print1d(incoming);
        ArrayDeque<Integer>zeros= new ArrayDeque<>();
        for(int i=0; i< incoming.length;i++){
            if(incoming[i]==0)  zeros.addLast(i);
        }
        ArrayDeque<Integer>ans= new ArrayDeque<>();
        while(zeros.size() > 0){

            int top = zeros.removeFirst();
            ans.add(top);
            for(int i=0;i<graph[top].size();i++){
                int x= graph[top].get(i);
                incoming[x]--;
                if(incoming[x]==0)
                    zeros.addLast(x);
            }
        }
        if(ans.size()==graph.length){
            System.out.println(ans);
        }else{
            System.out.println("cycle detected not possible to topify");
        }

         
    }
    
    public static boolean isCycle(int src, int vis[] , ArrayList<Integer>ans){
        if(vis[src]==1)
            return false;

        vis[src]=0;
        // System.o
        // System.out.println("moving to src : "+src);
        for(int i=0;i<graph[src].size() ;i++){
            int x= graph[src].get(i);
            if(vis[x]==0)
                return true;
            else if(vis[x]==-1)
                isCycle(x, vis, ans);
                // System.out.println("child")
        }
        ans.add(src);
        vis[src]=1;
        return false;
    }
    
    public static void ToplogyAndCycleUsingDFS(){

        ArrayList<Integer>topology=new ArrayList<Integer>();
        int vis[]= new int[graph.length];
        Arrays.fill(vis,-1);
        for(int i=0;i<graph.length;i++){
                if(isCycle(i,vis,topology )){
                    System.out.println("cyclce detected Topological sort not possible ");
                    return ;
                }
        }
        System.out.println(topology);

    }



    public static void main(String args[]){

        constructGraph();
        display();
        // KahnsTopology();
        ToplogyAndCycleUsingDFS();
    }
    
}
