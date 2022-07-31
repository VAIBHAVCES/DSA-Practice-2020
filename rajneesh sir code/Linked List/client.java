import java.util.LinkedList;



import java.io.*;
import java.util.*;

public class client{
    public static void main (String[] args) {
        linkedlist ll1 = new linkedlist();
        ll1.addLast(20);
        ll1.addLast(30);
        ll1.addLast(40);
        ll1.addLast(50);
        ll1.addLast(60);
        ll1.display();
        ll1.reverseLL();
        System.out.println("mid point is : "+ll1.midNode());
        ll1.display();
    }
}

// Scanner scn = new Scanner(System.in);
//         linkedlist ll1 = new linkedlist();
//         int test=scn.nextInt();
//         while(test-- > 0){
//             int len=scn.nextInt();
            
//             while(len-->0){
                
//                 int temp= scn.nextInt();
//                 ll1.addLast(temp);
                
               
//             }
//             ll1.segregateOddEve();
//             // ll1.display();
            
//         }
// 3
// 7
// 17 15 8 9 2 4 6
// 4
// 1 3 5 7
// 1
// 7
// 8 12 10 5 4 1 6

