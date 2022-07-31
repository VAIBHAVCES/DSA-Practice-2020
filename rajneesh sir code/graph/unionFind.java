public class unionFind {
    

    static int N;

    static int presi[]= new int[N];
    static int size[]= new int[N];
    public static int myParent(int u ){

        if(presi[u]==u) return u;
        return presi[u]=myParent(presi[u]);
    }

    public static void merge(int p1 ,int p2){

        if(size[p1] < size[p2]){
            presi[p1]=p2;
            size[p2]+=size[p1];
        }else{
            presi[p2]=p1;
            size[p1]+=size[p2];
        }
    }
    public static void unionFind(int graph[][]){
        N= graph.length;

        for(int i=0;i<graph.length;i++){
            presi[i]=i;
        }
        for(int arr[]: graph){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            int p1= myParent(u);
            int p2 =myParent(v);
            // *********dhyaan rkhiye ye optional hota hai aise merge karna
            // hame size karnek ki jaroorat nahi hai 
            merge(p1,p2);
        }



    }
}
