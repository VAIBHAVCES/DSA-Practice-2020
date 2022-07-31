public class stacks{
    private int st[];
    private int size;
    private int maxSize; 
    private int tos;

    public stacks(int n){
        this.setVal(n);
    }
    public stacks(){
        this.setVal(10);
    }
    private void setVal(int n){
        this.st= new int[n];
        this.size=0;
        this.maxSize=n;
        this.tos=0;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public int size(){
        return  this.size;
    }
    private void push_(int val){
        this.size++;
        this.st[this.tos++]=val;
    }
    public void push(int val) throws Exception{
        if(this.size==this.maxSize)
            throw new Exception("Max CapacityOfStack");
        
        // System.out.println("adding element at"+this.tos+" "+this.size);
        push_(val);
 
    }
    public int maxCapacity(){
        return this.maxSize;
    }

    @Override
    public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            for(int i=0;i<this.tos;i++){
                sb.append(this.st[i]);
                sb.append(" ,");
            }
            sb.append(" ] ");
        return sb.toString();
    }
    private int top_(){
        return this.st[this.tos - 1];
    }
    public int top() throws Exception{
        if(this.size==0){
            throw new Exception("StackIsEmpty");
        }
        return top_();

    }
    public  int pop() throws Exception{
        if(this.size==0){
            throw new Exception("StackIsEmpty");
        }
        int ans=top_();
        this.tos--;
        this.st[this.tos] = 0;
        this.size--;
        return ans;
    }
    
}