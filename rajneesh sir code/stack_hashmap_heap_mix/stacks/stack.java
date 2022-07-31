public class stack {
    
    int st[];
    int ei;

    stack(){
        initalize(5);
    }
    private  void initalize(int n){
        st= new int[n];
        System.out.println("initiated "+n+" "+st.length);
        
        ei=0;
    }
    private void handleOverflow(){

        int copy[]= new int[2*this.size()];
        for(int i=0;i<this.size() ;i++){
            copy[i]=st[i];
        }
        this.st=copy;

    } 
    public void push(int x ) throws Exception{
        // System.out.println("pushing L "+x+" "+this.size());
        if(ei==st.length){
            // throw new Exception("LIMIT_REACHED");
            handleOverflow();
        }
        st[ei]=x;
        ei++;

    }

    public int pop() throws Exception{
        if(ei==0){
            throw new Exception("EMPTY_ARRAY_EXCEPTION");
        }
        ei--;
        int resp= st[ei];
        return resp;
    }
    public String toString(){
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<st.length && i<ei ;i++){
            sb.append(st[i]+" , ");
        }
        return sb.toString();
    }


    public int size(){
        return this.ei;

    }
    public boolean isEmpty(){
        return this.size()==0;
    }


}
