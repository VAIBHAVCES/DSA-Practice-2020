import java.util.ArrayList;
import java.util.Stack;
import java.util.ArrayDeque;
public class graph_intro{


    public static class Edge{
        int v=0 ; 
        int w=0; 
        Edge(int v , int w){
            this.v = v;
            this.w= w;
        }
    
    }
  
    public static ArrayList<Edge>[]graph= new ArrayList[7];
    
    public static void initialize(){
        
        for(int i=0 ; i< graph.length ; i++){
            graph[i]= new ArrayList<>();
        }

    }
    public static void addEdge(int u , int v ,int  w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    } 
    public static void display(){
        StringBuffer bf= new StringBuffer();
        for(int i=0 ;i < graph.length;i++){
            bf.append(i +" - > ");
            for(int j=0;j<graph[i].size();j++){
                Edge e =graph[i].get(j);
                bf.append(" ("+e.v+", "+e.w +") ,");
            }
            bf.append("\n");
        }
        System.out.println(bf);
    }
    

    public static int findEdge(int u , int v ){
        int idx = -1;
        for(int i =0 ; i < graph[u].size(); i++){
            if(graph[u].get(i).v==v) {
                 idx =i;
                 break;
            }
        }
        return idx; 
    }
    public static void removeEdge(int u  , int v ){
        int uEdge = findEdge(u ,v);
        int vEdge = findEdge(v, u);
        graph[u].remove(uEdge);
        graph[v].remove(vEdge);
    }

    public static boolean hasPath( int u  ,  int v , boolean vis[]){
        if(u==v)
            return true;
        vis[u]=true;
        boolean res = false;
        for(int i=0 ;i < graph[u].size(); i++ ){
                Edge e = graph[u].get(i);
                if(!vis[e.v])
                    res = res || hasPath( e.v , v, vis);
        }
        return res;
    }

    public static int allPaths( int u  ,  int v , boolean vis[] , int wsf , String psf){
        if(u==v){
            System.out.println(psf+u+" @ "+wsf);
            return 1;
        }
        vis[u]=true;
        int res = 0;
        for(int i=0 ;i < graph[u].size(); i++ ){
                Edge e = graph[u].get(i);
                if(!vis[e.v])
                    res += allPaths( e.v , v, vis , wsf+e.w , psf+u);
        }
        vis[u]=false;
        return res;
    }
    public static class Pair{
        int w ; 
        String path ; 
        Pair( int w , String path ){
                this.w = w;
                this.path=  path ;
        }
    }
    public static Pair heaviestPath(int src , int dest  , boolean vis[]){

        if(src == dest){
            return new Pair(0 , src+"");
        }
        vis[src]=true;
        int max = -(int)1e8;
        String maxAns = "";
        for(int i =0 ; i < graph[src].size() ; i++ ){
            Edge e= graph[src].get(i);
            if(!vis[e.v]){
                Pair forw = heaviestPath(e.v, dest, vis);

                
                if(max < forw.w+e.w){
                    max = forw.w+e.w;
                    maxAns=src+forw.path;
                }
            }
        }
        vis[src]=false;
        return new Pair(max , maxAns);
        
    }
    public static int hamiltonianPath(int src , int osrc , int count ,  boolean vis[] , String psf){

        if(count == vis.length-1){
            int idx =findEdge(src, osrc);
            if(idx!=-1){
                System.out.println("hamiltonian cycle : "+psf+src+" with edge "+src+"-"+osrc);
            }else{
                System.out.println("hamiltonian path : "+psf+src);
            }
            return 1;

        }
        vis[src]=true;
        int sum=0;
        for(int i=0; i< graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!vis[e.v]){
                    sum+=hamiltonianPath(e.v, osrc ,count+1, vis, psf+src);
            }
        }
        vis[src]=false;
        return sum;
    }

    //********************* BFS */
    public static void bfs( ){
        ArrayDeque<Integer>mem  =  new ArrayDeque<>();
        boolean vis[]= new boolean[graph.length];
        mem.addLast(0);
        while(mem.size() > 0 ){
            int top = mem.removeFirst();
            System.out.print(top+" ");
        
            if(vis[top] ){
                System.out.println("\n cycle: at point "+top);
                continue;
            }
            vis[top]=true;
            for(Edge e :  graph[top]) {
                if(!vis[e.v] )
                    mem.addLast(e.v);
            }
        }
        
    }
    public static void bfs02(){

        ArrayDeque<Integer>mem = new ArrayDeque<>();
        boolean vis[]= new boolean[graph.length];
        mem.addLast(0);
        while(mem.size() > 0 ) {

            int  size= mem.size();
            while(size-- > 0){

                int top= mem.removeFirst();
                if(vis[top]){
                    continue;
                }
                System.out.print(top+" ");
                vis[top]=true;
                for(Edge e: graph[top]){
                    if(!vis[e.v]){
                        mem.add(e.v);
                    }
                }
            }
            System.out.println();        
        }

    }

    public void topological_sort_rec( Stack<Integer>mem, int src ){
        for(Edge e:  graph[src] ){

            if(!vis[e.v]){
                topological_sort_rec(mem,e.v);
            }
            
        }
        st.push(src);

    }
    public static void topological_sort(){

        boolean vis[] = new boolean[graph.length];
        Stack<Integer>mem = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(!vis[i]){
                topological_sort_rec(st,i);
            }
        }
        while(st.size() >  0 ){
                System.out.println(st.pop());
        }

    }

    public static void main(String[] args) {
        initialize();
        addEdge(0,3,10);
        addEdge(0,1,10);
        addEdge(1,2,40);
        // addEdge(2,4,10);
        addEdge(3,2,30);
        addEdge(3,5,40);
        addEdge(5,4,40);
        addEdge(5,6,10);    
        addEdge(4,6,40);

        display();
        // int tp = allPaths(0, 6, new boolean[7], 0, "");
        // System.out.println("before removal: " + hasPath(0, 6, new boolean[7]));
        // System.out.println("tottal paths  : "+tp);
        // //********* heaviestPath //
        // Pair p = heaviestPath(0, 6, new boolean[7]);
        // System.out.println("heaviest path "+p.path+" : "+p.w);
        // System.out.println("hamiltonian features : -"+hamiltonianPath(0, 0, 0, new boolean[7], ""));
        bfs02();

        // removeEdge(5, 4);
        // removeEdge( 4 , 6);
        // System.out.println("after removal: " + hasPath(5,4, new boolean[7]));

        // display();

    }
}