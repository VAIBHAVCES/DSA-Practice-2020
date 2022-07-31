
public class oops {
    
    public static void  swap(person p1 , person p2){

        person temp = p1;
        p1=p2;
        p2=temp;
    }

    
    public static void  swap2(person p1 , person p2){

        int tage=p1.roll;
        p1.roll= p2.roll;
        p2.roll= tage;

        
        String tname=p1.name;
        p1.name= p2.name;
        p2.name= tname;
    }

    public static void  swap3(person p1 , person p2){

        int tage=p1.roll;
        p1.roll= p2.roll;
        p2.roll= tage;
        
        p2=new person();
        String tname=p1.name;
        p1.name= p2.name;
        p2.name= tname;
        p1 =new person();
    }
    public static void main(String[] args) {
        
      person p1= new person(2,"Satish");
      person p2 = new person(3, "Sumeet");
      System.out.println(p1.name+ " "+p1.roll);
      System.out.println(p2.name+ " "+p2.roll);
    // //   swap(p1,p2);
    // swap2(p1, p2);
    swap3(p1, p2);
      System.out.println(p1.name+ " "+p1.roll);
      System.out.println(p2.name+ " "+p2.roll);

        
    }
}
