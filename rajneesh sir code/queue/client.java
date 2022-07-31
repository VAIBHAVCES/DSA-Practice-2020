
public class client {
    
public static void main(String[] args) throws Exception {
    queue st= new queue();
    for(int i=10;i<20;i++){
        st.add(i);

    }
    System.out.println(st);
    System.out.println(st.size());
}

}