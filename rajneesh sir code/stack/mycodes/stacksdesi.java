public class stacksdesi {
    
    private int st[];
    private int size;
    private int tos;
    private int maxC;
    
    stacksdesi(int n){
        initialize(n);
    }
    stacksdesi(){
        initialize(10);
    }
    public int maxCapacity(){
        return this.maxC;
    }
    
    protected void initialize(int n){
        st= new int[n];
        this.maxC=n;
        this.tos=0;
        this.size=0;

    }
    protected void pushp(int val){
        this.st[tos]=val;
        this.tos++;
        this.size++;
    }

    public void push(int val) throws Exception{
        if(this.size==this.maxC)
            throw new Exception("ARRAY FULL");
        pushp(val);
        
        }
        protected int  popp(){
            this.tos--;
            this.size--;
        int temp=this.st[this.tos];
       
        return temp;
    }
    public int pop() throws Exception{
        if(this.size==0)
            throw new Exception("STACK IS ALREADY EMPTY");
        return popp();

    }
    public boolean isEmpty(){
        return this.size==0;
    }
    
    public int size(){
        return this.size;

    }

    public String toString(){
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<this.size;i++){
            sb.append(this.st[i]+"  , ");
        }
        return sb.toString();

    }

    public void display(){
        System.out.println(this.st);
    }
}
