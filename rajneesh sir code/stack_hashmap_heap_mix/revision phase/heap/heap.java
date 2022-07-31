import java.util.ArrayList;
public class heap {
    
    private ArrayList<Integer>hp;
    private boolean isMax;
    
    heap(int arr[] ,boolean b){
        initialize(b);
        for(int ele : arr) hp.add(ele);
        buildHeap();
    }
    private void initialize( boolean x){
        hp= new ArrayList<>();
        isMax=x;
    }
    public int size() {  return hp.size();
    }
    public boolean isEmpty(){
        return hp.size()==0;
    }
    private void buildHeap(){
        
        for(int i=hp.size()-1;i>=0;i--){
            // System.out.println(hp);    
            downHeapify(i);
        
        }
    }
    public int compareTo(int i ,int j ){

        int val = hp.get(i)-hp.get(j);
        if(isMax) return val ;
        else  return -1*val;
    }
    private void swap(int i , int j ){
        int temp=hp.get(i);
        hp.set(i,hp.get(j));
        hp.set(j ,temp);
    }
    private  void downHeapify( int pi ){

        int lci = (pi<<1)+1;
        int rci = (pi<<1)+2;
        int max = pi;

        if(lci < hp.size() && compareTo( lci ,max ) >= 0) max = lci;
        if(rci < hp.size() && compareTo( rci ,max ) > 0) max = rci; 

        if(max!=pi) {
            swap(pi, max) ;
            downHeapify(max);
        }
    }
    @Override
    public String toString(){
        StringBuffer bf = new StringBuffer();
        bf.append("[ ");
        for(int ele : hp ){
            bf.append(ele+" , ");
        }
        bf.append(" ] ");
        return bf.toString();
    }
    private void upHeapify(int ci) {
        int pi = ci/2;
        if(compareTo( ci ,pi) > 0){
            swap(ci,pi);
            upHeapify(pi);
        }
        
    }


    public void add(int val ) {

        hp.add(val);
        upHeapify(hp.size()-1 ); 

    }
    
    public int poll( ) throws Exception {
    
        if(hp.size()==0)
        {
            throw new Exception("NullPointerException");
        }
        int top= hp.get(0);
        swap(0 ,  hp.size()-1);
        hp.remove(hp.size()-1);
        downHeapify(0);
        return top;
    }
    public int peek() throws Exception{

        if(hp.size()==0 )
            throw new Exception("NullPointerException");

        int val = hp.get(0);
        return val;

    }
    

}
