public class client {
    
public static void main(String args[]) throws Exception{

    int arr[]={10,2,5,4,20,50,35,40,39,6,15};
    prior_que pq= new prior_que(arr,true);
    // pq.sort();
    System.out.println("----- sorting :  "+pq);
    pq.add(23);
    pq.add(38);
    pq.add(17);
    pq.add(26);
    
    System.out.println("beofre sorting :  "+pq);

    pq.sort();
    System.out.println(pq);


}

}


