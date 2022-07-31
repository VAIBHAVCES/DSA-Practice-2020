import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Stack;
import java.util.ArrayDeque;
import java.lang.StringBuilder;


public class dag{
    


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
    
    // GRAPHS TYPES  : - 
    // GRAPH TYPE -1 
    public static void graph1(){

        initialize();
        addEdge(0,1,10);
        addEdge(1,3,40);
        addEdge(3,2,30);
        addEdge(2,0,10);
        addEdge(2,4,10);
        addEdge(4,5,40);
        addEdge(5,6,10);    
        addEdge(6,4,40);
        // addEdge(6,2,40);

    }
    public static void graph2(){

        initialize();
        addEdge(0,1,4);
        addEdge(0,7,8);
        addEdge(1,7,11);
        addEdge(1,2,8);
        addEdge(7,8,7);
        addEdge(7,6,1);
        addEdge(2,8,2);
        addEdge(8,6,6);    
        addEdge(2,3,7);    
        addEdge(2,5,4);    
        addEdge(6,5,2);    
        addEdge(3,5,14);       
        addEdge(3,4,9);
        addEdge(5,4,10);


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
        graph[u].remove(uEdge);
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
  public static void topological_sort_rec( Stack<Integer>st, int src ,boolean vis[] ){

        vis[src]=true;
        for(Edge e:  graph[src] ){
            if(!vis[e.v]){
                topological_sort_rec(st,e.v,vis);
            }   
        }
        st.push(src);

    }
    public static void topological_sort_stack(){

        boolean vis[] = new boolean[graph.length];
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topological_sort_rec(st,i,vis);
            }
        }
        while(st.size() >  0 ){
                System.out.println("- "+st.pop());
        }

    }
    // *****************************************************
    // ******************** UNION AND FIND ALGORTIHM********
    // *****************************************************

    public static int myParent(int  parent[]  , int p){
        if(parent[p]==p) return parent[p];
        else return parent[p]=myParent(parent,parent[p]);
    }
    
    public static void mergeNodes(int parent[] , int weight[] ,int p1 , int p2 ){
        
        for(int i=0; i<parent.length;i++){
            System.out.print(parent[i]+" ");
        }
        System.out.println("parent: "+p1+" : child :"+p2);
        if(weight[p1] >= weight[p2]){
            // if p1 has high weight p1 will be parent and p2 will be child
            // hence put p1  in parent of p2 
            parent[p2]=p1;
            weight[p1]+=weight[p2];
        }else{
            parent[p1]=p2;
            weight[p2]+=weight[p1];
        }
    }
    public static void unionFind(){
        int parent[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            parent[i]=i;
        }
        int weight[]=  new int[graph.length];
        Arrays.fill(weight,1);

        for(int i=0; i< graph.length;i++){
            
            for(Edge e :graph[i]){
                // u -> i  , v-> e.v
                int parentOfU= myParent(parent, i);
                int parentOfV= myParent(parent, e.v);
                // System.out.println("analyzing : "+i+": "+parentOfU+" ," +e.v+" : "+parentOfV);

                // if you want to do cycle detection
                if(parentOfU==parentOfV){
                    System.out.println("Cycle detection : "+i+" "+e.v);
                }
                if(parentOfU!=parentOfV){
                    mergeNodes(parent,weight,parentOfU,parentOfV);
                } 
            }
        }

        // COMPONENET DETECTION
        int components=0; 
        for(int i=0; i<parent.length;i++){
            if(parent[i]==i){
                components++;
                // System.out.println("no of nodes in this component : "+weight[i]);
            }
        }
        System.out.println(components);
    
        for(int i=0; i<parent.length;i++){
            System.out.print(weight[i]+" ");
        }
    }

    // *****************************************************
    // ******************** PRIMS ALLGORITHMS ********
    // *****************************************************

    public static class primsPair implements Comparable<primsPair>{
        int vtx ;
        int par;
        int weight;
        primsPair(int vtx , int par , int weight){
            this.vtx= vtx;
            this.par = par;
            this.weight = weight; 
        }
        @Override
        public int compareTo(primsPair p) {
            return this.weight-p.weight;

        }   
 }

 public static void prims(){
     ArrayList<primsPair>primsGraph[] = new ArrayList[graph.length];
     boolean vis[]= new boolean[graph.length];
     for(int i=0;i<graph.length;i++)
     primsGraph[i]= new ArrayList<>();
     
     // BFS SIMILAR CODE 
     PriorityQueue<primsPair>mem =  new PriorityQueue<>();
     mem.add(new primsPair( 0, -1, 0 ));
     while(mem.size() > 0 ){

        primsPair top = mem.remove();
        // cycle  check 
        if(vis[top.vtx]) continue;
        
        // mark
        vis[top.vtx]=true;
        if(top.par!=-1 ){
            primsGraph[top.vtx].add(new primsPair(top.par , top.vtx, top.weight));
            primsGraph[top.par].add(new primsPair(top.vtx, top.par ,  top.weight));
        }

        // add neighbours
        for(Edge e:  graph[top.vtx]){
            if(!vis[e.v]){
                mem.add(new primsPair(e.v,top.vtx,e.w));
            }
        }


     }

     for(int i=0 ; i<primsGraph.length;i++){
        System.out.print(i+" : ");
        for(primsPair p : primsGraph[i]){
            System.out.print("("+p.vtx +" , "+p.weight+" ) ,");
        }
        System.out.println();

     }


    
}

public static void prims02(){
    // yaha par rajneesh sir ne kaha tha ki we can use dis array to 
    // avoid use of boolean vis array par aisa nahi ho rha dry run ke vakht
    // output mei kuch galti aa jaati hai agar mai try karta hoo boolean vis ko 
    // avoid karne ki 

    System.out.println("prims 02 : ");
    ArrayList<primsPair>primsGraph[] = new ArrayList[graph.length];
    boolean vis[]= new boolean[graph.length];
    int dis[] = new int[graph.length];

    Arrays.fill(dis,(int)1e9);
    for(int i=0;i<graph.length;i++)
    primsGraph[i]= new ArrayList<>();
    dis[0]=0;
    // BFS SIMILAR CODE 
    PriorityQueue<primsPair>mem =  new PriorityQueue<>();
    mem.add(new primsPair( 0, -1, 0 ));
    while(mem.size() > 0 ){

       primsPair top = mem.remove();
       System.out.println(top.vtx+" "+top.par+" "+top.weight);
       // cycle  check 
        // if(vis[top.vtx]) continue;
        if(top.weight  > dis[top.vtx]) continue;
       
       // mark
       vis[top.vtx]=true;
       if(top.par!=-1 ){
           primsGraph[top.vtx].add(new primsPair(top.par , top.vtx, top.weight));
           primsGraph[top.par].add(new primsPair(top.vtx, top.par ,  top.weight));
       }

       // add neighbours
       for(Edge e:  graph[top.vtx]){
           if( !vis[e.v] && dis[e.v] > e.w){
               dis[e.v]=e.w;
                mem.add(new primsPair(e.v,top.vtx,e.w));
           }
       }


    }

    for(int i=0 ; i<primsGraph.length;i++){
       System.out.print(i+" : ");
       for(primsPair p : primsGraph[i]){
           System.out.print("("+p.vtx +" , "+p.weight+" ) ,");
       }
       System.out.println();

    }
    for(int ele : dis){
        System.out.print(
            ele+" "
        );
    }


   
}


// *****************************************************
    // ******************** DIJKSTRA ********
    // *****************************************************

public static class dijPair implements Comparable<dijPair>{
        int vtx ;
        int par;
        int weight;
        int wsf;
        dijPair(int vtx , int par , int weight,int wsf){
            this.vtx= vtx;
            this.par = par;
            this.weight = weight; 
            this.wsf= wsf;
        }
        @Override
        public int compareTo(dijPair p) {
            return this.wsf-p.wsf;
        }   
 }

 public static void dijkstra(int src ){
    ArrayList<dijPair>dijGraph[] = new ArrayList[graph.length];
    boolean vis[]= new boolean[graph.length];
    int min_dist[] = new int[graph.length];

    Arrays.fill(min_dist,(int)1e9);
    for(int i=0;i<graph.length;i++)
        dijGraph[i]= new ArrayList<>();
    
    min_dist[src]=0;
    // BFS SIMILAR CODE 
    PriorityQueue<dijPair>mem =  new PriorityQueue<>();
    mem.add(new dijPair( src, -1, 0 , 0));
    while(mem.size() > 0 ){

       dijPair top = mem.remove();
       System.out.println(top.vtx+" "+top.par+" "+top.weight);
       // cycle  check 
        // if(vis[top.vtx]) continue;
        if(top.weight  > min_dist[top.vtx]) continue;
       
       // mark
       vis[top.vtx]=true;
       if(top.par!=-1 ){
            dijGraph[top.vtx].add(new dijPair(top.par , top.vtx, top.weight , top.wsf ));
            dijGraph[top.par].add(new dijPair(top.vtx, top.par ,  top.weight , top.wsf ));
       }

       // add neighbours
       for(Edge e:  graph[top.vtx]){
           if( !vis[e.v] && top.wsf +e.w  <  min_dist[e.v]){
               min_dist[e.v]=top.wsf +e.w  ;
                mem.add(new dijPair(e.v,top.vtx,e.w , top.wsf+e.w));
           }
       }


    }

    for(int i=0 ; i<dijGraph.length;i++){
       System.out.print(i+" : ");
       for(dijPair p : dijGraph[i]){
           System.out.print("("+p.vtx +" , "+p.weight+" ) ,");
       }
       System.out.println();

    }
    for(int ele : min_dist){
        System.out.print(
            ele+" "
        );
    }


   
}
  
// *****************************************************
// ******************** KOSARAJU'S ALGORITH OF STRONG CONNECTED COMPONENET********
// *****************************************************

public static void depthAndMark(boolean vis[] , int src , ArrayDeque<Integer>mem, StringBuilder sb){
            
        vis[src]=true;
        sb.append(src+ " , " );
        for(Edge e:  graph[src] ){
            if(!vis[e.v]){
                depthAndMark(vis, e.v , mem ,sb );
                
            }
        }
        mem.addLast(src);

}
public static void kosaraju(){


    int n = graph.length;
    ArrayList<Edge>transposeGraph[]= new ArrayList[n];
    for(int i=0;i<n;i++){
        transposeGraph[i]=new ArrayList<>();
    }
        ArrayDeque<Integer>mem = new ArrayDeque<>();
        boolean vis[]= new boolean[n];
        for(int i=0;i< n;i++){
            if(!vis[i]){
                    depthAndMark(vis, i , mem ,  new StringBuilder()) ;
                    
            }
        }
        System.out.println(mem);
        // reverse the graph
        for(int i=0;i<n;i++){
            for(Edge e: graph[i]){  
                    transposeGraph[e.v].add(new Edge(i,e.w));
            }
        }
        dag.graph= transposeGraph;
        // building a string to see all componenets
        vis= new boolean[n];
        StringBuilder sb = new StringBuilder();
        while(mem.size() > 0 ){
            int top = mem.removeLast();
            if(!vis[top]){
                depthAndMark(vis, top,mem, sb);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());

}





// ************************************ QUESTIONS *************
 //LEETCODE 1061
 public static int char_parent(int par[] , int p){
        if(par[p]==p)   return p; 
        else return par[p]=char_parent(par, par[p]);
 }
 public static String smallest_equivalent_string(String a , String b , String s){

    int par[]= new int[26];

    for(int i=0;i<par.length;i++){
        par[i]=i;
    }
    for(int i=0 ;i<a.length();i++){
        if(a.charAt(i)!=b.charAt(i)){
            int p1 = char_parent(par , a.charAt(i)-'a');
            int p2 = char_parent(par , b.charAt(i)-'a');
            if(p1!=p2){
                if(p1 < p2){
                    par[p2]=p1;
                }else{
                    par[p1]=p2;
                }
            }

        }
    }
    StringBuilder sb = new StringBuilder();

    for(int i=0;i<s.length();i++){
        int x = char_parent(par,s.charAt(i)-'a');
        sb.append(  (char)(x+'a') );
    }
    return sb.toString();



 }
 // LEETCODE 301 
 public static int parent301(int parent[] ,int p ){
    if(parent[p]==p)  return p;
    else return parent[p]=parent301(parent, parent[p]);
}
static int dir[][]=new int[][]{{-1,0} , {0,-1} ,{0,1},{1,0}};
//leetcode 1168

public static int leet1168(int n, int wells[] , int pipes[][]){

        ArrayList<int[]>mem = new ArrayList<>();
        for(int ele[]:pipes) mem.add(ele);
        for(int i=0;i<wells.length;i++){
            mem.add(new int[]{0,i+1,wells[i]});
        }
        Collections.sort(mem , (a,b)->{
            return a[2]-b[2];
        });
        int parent[]= new int[n+1];
        for(int i=0;i<parent.length;i++) parent[i]=i;
        int ans = 0 ;
        for(int ele[] : mem ){
            int p1 = myParent(parent,ele[0]);
            int p2 = myParent(parent,ele[1]);
            if(p1!=p2){
                parent[p1]=p2;
                ans+= ele[2];
            }
        }
        return ans; 
    }


public  static List<Integer> leetcode301(int n , int m , int positions[][] ){

       int par[]= new int[n*m],count = 0;
       Arrays.fill(par,-1);
       List<Integer>ans =  new ArrayList<>();

       for(int pos[]: positions){
           
           int idx = pos[0]*m+pos[1];
           if(par[idx]==-1 ) {
               par[idx]=idx;
               count++;
               for(int moves[] : dir){
                   int x = pos[0]+moves[0];
                   int y = pos[1]+moves[1];
                   if(x>=0 && y>=0 && x<n&&y<m &&par[x*m+y]!=-1){
                       int p1 = parent301(par,x*m+y);
                       if(p1!=idx){
                           par[p1]=idx;
                           count--;
                       }
                   }
                   
               }
           }
           ans.add(count);
       }
           
       return ans;
   }
 public static void questions(){
     //leetcode 1061
    //  String a = "leetcode" ,b = "programs" ,s = "sourcecode";
    //  String ans = smallest_equivalent_string(a,b,s);
    //     System.out.println(ans);
    //leetcode 301 - NUMBER OF ISLANDS - II
    // int  n= 3 , m = 3; 
    // int positions[][]=new int[][]{{0,0},{0,1},{1,2},{1,2}};
    // System.out.println(leetcode301(n,m,positions));
    // LEETCODE 1168
    // int n = 3;
    // int wells[]= new int[]{1,2,2};
    // int pipes[][]= new int[][]{{1,2,1},{2,3,1}};
    // System.out.println(leet1168(n,wells,pipes));
    // GFG MIN COST TO VISIST ALL CITIES
    minCostCities();


    }

// ******************gfg min cost to connect all CITIES
public static int primsAlgoMinCost(int arr[][]){

    // ArrayDeque<int[]>= new ArrayDeque<>();
    // mem.top()[0] -  vtx 
    // mem.top()[1] - par 
    // mem.top()[2] - weight
    PriorityQueue<int[]>mem=new PriorityQueue<>( (a,b)->{
        return a[2]-b[2];
    }) ; 
    mem.add(new int[] { 0 , -1, 0});
    int ans =0 ;
    boolean vis[]= new boolean[arr.length];
    int  nn = 1;
    while(mem.size() > 0){
        int top[]= mem.remove();
        if(vis[top[0]]){
            continue;
        }
        ans+=top[2];
        vis[top[0]]=true;
        nn++;
        for(int i = top[0]+1 ; i < arr[0].length ;i++){
            if(arr[top[0]][i] >0 && !vis[i] ){
                mem.add(new int[]{i,top[0], arr[top[0]][i] });
            }
        }
    }
    return ans;

}



public static void minCostCities(){

    int arr[][]= {{0, 1, 1, 100, 0, 0},
    {1, 0, 1, 0, 0, 0},
    {1, 1, 0, 0, 0, 0},
    {100, 0, 0, 0, 2, 2},
    {0, 0, 0, 2, 0, 2},
    {0, 0, 0, 2, 2, 0}};
    System.out.println(primsAlgoMinCost(arr));


}


 public static void main(String[] args) {
      
        initialize();
        // graph1();

        // display();
        // unionFind();
        questions();
        // topological_sort_stack();        
        // removeEdge(5, 4);
        // removeEdge( 4 , 6);
        // prims();
        // prims02();
        // dijkstra(6);
        // kosaraju();


    }
}