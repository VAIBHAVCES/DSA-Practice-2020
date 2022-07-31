
public class queue {


    int que[];
    int si;
    int ei;
    int max_size;
    int size;
    
    queue(){
        initialize(5);
    }
    private void initialize(int n ){
        que= new int[n];
        si=0;
        ei=0;
        max_size=n;
        size=0;
    }
    public int size(){
        return this.size;
    }
    public void add(int x ) throws Exception{
        if(size==max_size){
            throw new Exception("MAX_LIMIT REACHED");
        }
        ei=ei%max_size;
        que[ei]=x;
        ei++;
        size++;

    }
    
    public int remove(  ) throws Exception{
        
        if(size==0){
            throw new Exception("ALREADY_EMPTY_ARRAY");
        }
        si=si%this.max_size;
        int val= que[si];
        que[si]=-1;
        si++;
        size--;
        return val;
        
        
    }
    @Override
    public String toString(){
     
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++){
                sb.append(que[(si+i)%max_size]+" , ");
        }
        return sb.toString();
    }

}
