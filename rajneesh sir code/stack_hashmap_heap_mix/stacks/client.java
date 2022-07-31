public class client {
    public static void main(String[] args) throws Exception{
        
        queue mem = new queue();
        for(int i=1;i<=5;i++) mem.add(i);
       System.out.println(mem.remove());
       mem.add(1);
       System.out.println(mem);
       mem.add(1);
       System.out.println(mem);

    }
    // public static void stack_example(){
    //     stack st=  new stack();

    //     for(int i=1;i<=5;i++)st.push(i);
    //     System.out.println(st);
    //     System.out.println(st.pop());
    //     System.out.println(st);
    //     System.out.println(st.pop());    
    //     System.out.println(st);
    //     System.out.println(st.pop());
    //     System.out.println(st);
    //     System.out.println(st.pop());
    //     System.out.println(st);
    //     System.out.println(st.pop());
    //     System.out.println(st);
    //     System.out.println("--"+ st.size());
    //     // System.out.println(st.pop());
        
    //     // System.out.println(st.size());
    //     // for(int i=1;i<=5;i++)st.push(i);
    //     // System.out.println(st);
    
    // }
}
