public class queue{

    private int size;
    private int[] qu;
    private int maxSize;
    private int head;
    private int tail;
    queue(int n ){
        setVal(n);
    }
    queue(){
        setVal(10);
    }
    public void setVal(int n ){
        this.size=0;
        this.qu=new int[n];
        this.maxSize=n;
        this.head=0;
        this.tail=0;
    }
    public int size(){
        return this.size;
    }

    public void add(int val) throws Exception{
        
        if(this.size==maxSize){
            throw new Exception("queue filled exception");
        }
        this.head=this.head%this.maxSize;
        this.qu[this.head++]=val;
        this.size++;

    }
    public int remove() throws Exception{
        if(this.size==0)
            throw new Exception("empty queue exception");
        
        this.tail=this.tail%this.maxSize;
        int store=this.qu[this.tail];
        this.tail++;
        this.size--;
        return store;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" [ ");
        for(int i=0;i<size;i++){
            int idx=(i+this.head)%this.maxSize;
            sb.append(this.qu[idx]);
            sb.append(" , ");
        }
        sb.append(" ] ");
        return sb.toString();
    }

}