import java.util.ArrayList;
import java.util.LinkedList;
class main{

    public static class Edge{
        int v;
        int w;
        Edge(int v , int w){
            this.v=v;
            this.w=w;
        }

    }
    static int N=7;
    static ArrayList<Edge>graph[]= new ArrayList[N];
   
    public static void BFS_03(int src , boolean vis[]){


        LinkedList<Integer>mem = new LinkedList<>();
        mem.add(src);
        vis[src]=true;
        while(mem.size() > 0){

            int top= mem.removeFirst();
            System.out.print(top+" ");
            for(Edge e :  graph[top]){
                // System.out.println("childs of top are : "+e.v);
                if(vis[e.v]==false){
                    vis[e.v]=true;
                    mem.addLast(e.v);
                }
            }    
            // System.out.println(mem);
            
        }
    }
    public static void BFS_02(int src ,boolean vis[]){

        LinkedList<Integer>mem = new LinkedList<>();
        mem.addLast(src);
        
        int size=1;
        while(mem.size()  > 0 ){
        
                while(size-- > 0){
                        int top=mem.removeFirst();
                        if(vis[top]){
                            continue;
                        }
                        vis[top]=true;
                        for(Edge e : graph[top]){
                            if(vis[e.v]==false){
                                mem.addLast(e.v);
                                System.out.print(e.v+" ");
            
                            }
            
                        }
                        

                }
                System.out.println();
                size=mem.size();
                

            }

        }
    public static void BFS_01(int src , boolean vis[]){

        LinkedList<Integer>mem= new LinkedList<>();
        System.out.println(src);
        mem.addLast(src);
        while(mem.size()>0){
            int top=mem.removeFirst();
            if(vis[top]){
                // System.out.println("cycle detected : " +top);
                continue;
            }
            vis[top]=true;
           

            // **************in this region we are not checking if node present or not 
            //  we are simply checking for childs
            for(Edge e : graph[top]){
                if(vis[e.v]==false){
                    mem.addLast(e.v);
                    System.out.print(e.v+" ");

                }

            }
            System.out.println();
        }
        
    }
    public static void  addEdge(int u, int v , int w){
        graph[u].add( new Edge(v,w));
        graph[v].add( new Edge(u,w));
    }
    public static void constructGraph(){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        addEdge(0,1,10);
        addEdge(0,3,10);
        // addEdge(0,6,5);
        addEdge(1,2,10);
        addEdge(1,4,7);
        addEdge(2,3,40);
        // addEdge(2, 5,8);
        addEdge(4,5,2);
        addEdge(5,6,3);
        addEdge(4,6,8);

        // addEdge(0,6,1);
        // addEdge(2,5,1);
    }
    public static void removeEdge(int u , int v ){
        graph[u].remove(findEdge(u, v));
        graph[v].remove(findEdge(v,u));
    }
    public static int findEdge(int u , int v ){
        int idx=-1;
        for(int i=0;i<graph[u].size();i++){
            Edge e = graph[u].get(i);
            if(e.v==v){
                idx=i;
                break;
            }

        }
        return idx;
    }
    public static void display(){
        StringBuilder ans= new StringBuilder();  
        for(int i=0;i<graph.length;i++){
            
            ans.append( i+"  = > ");
            for(Edge e :  graph[i]){

                ans.append("("+ e.v+" / "+e.w+ " )  ,");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }  
    public static void removeVtx(int u ){

        while(graph[u].size()> 0){    
            int i = graph[u].size()-1;
            Edge e = graph[u].get(i); 
            System.out.println(" about to remove : "+u+" from  "+e.v);
            removeEdge(e.v, u);
            System.out.println(i+"  "+graph[u].size());
            // graph[u].remove(i);  
            
        }
    }
    public static boolean hasPath(int src, int dest , boolean vis[]){
        if(src==dest)
            return true;
        vis[src]=true;
        boolean ans=false;
        for(Edge e: graph[src])
        {
            if(vis[e.v]==false)
                ans=ans || hasPath(e.v,dest,vis);
            // if(ans) return ans;
        }
        vis[src]=false;
        return ans;
    }
    public static int printPaths(int src, int dest , boolean vis[] , String path){
        if(src==dest){
            System.out.println(path+src);
            return 1;
        }
        vis[src]=true;
       int count=0;
        for(Edge e: graph[src])
        {
            if(vis[e.v]==false)
                count+= printPaths(e.v,dest,vis, path+src);
            // if(ans) return ans;
        }
        vis[src]=false;
        return count;
    }    
    public static void hamiltonian_cycle(int src , int dest , int osrc  , boolean vis[], String path , int count){


        if(count==graph.length-1){

            int idx=findEdge(src,osrc);
            if(idx!=-1)
                System.out.println("Hamiltonian cycle: "+path+src);
            else
                System.out.println("Hamilt   path : "+ path); 
        }
     

        vis[src]=true;
        for(Edge e :  graph[src]){
            if(!vis[e.v])
                hamiltonian_cycle(e.v, dest, osrc, vis, path+src,count+1);
        }
        vis[src]=false;

    }
    public static int dfs_marker(int src , boolean vis[]){

        vis[src]=true;
        int count=0;
        for(Edge e : graph[src]){

            if(!vis[e.v]){
                count+=dfs_marker(e.v,vis);
            }

        }
        return count;

    }
    public static int getComponents( ){

        boolean vis[]=  new boolean[N];
        int count=0;
        for(int i=0;i<N;i++){
            if(!vis[i]){
                count++;
                dfs_marker(i,vis);
            }
        }
        return count;

    }
    public static void main(String args[]){
        constructGraph();
        // removeEdge(3,4 );
        // removeEdge(3,4 );
       display();
        //hamiltonian_cycle(0, 6, 0, new boolean[graph.length], "" ,0);
        // removeVtx(2);
        // display();
            
        // System.out.println(getComponents());
        //    System.out.println( hasPath(3,4, new boolean[graph.length]));
        //    System.out.println( printPaths(0,6, new boolean[graph.length] , ""));

        // BFS_01(0, new boolean[graph.length]);
        // BFS_02(0, new boolean[graph.length]);
        BFS_03(0, new boolean[graph.length]);
    }

}