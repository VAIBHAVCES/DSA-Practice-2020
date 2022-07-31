public class dstacks extends stacksdesi{
    
    dstacks(int n){
        super(n);
    }
    dstacks(){
        super();
    }   
    

    @Override 
    public void push(int val) throws Exception{
        if(super.size()==super.maxCapacity())
        {
            
            int copy[]= new int[this.size()];
            int x=super.size()-1;
            while(super.size() != 0){
                // super.display();
                System.out.println(" max  "+super.size() );
                copy[x]=super.popp();
                x--;
            }
            initialize(2*copy.length);
            for(int i=0;i<copy.length;i++){
                super.pushp(copy[i]);
            }
            
        }
        super.pushp(val);
        
    }
    

}
