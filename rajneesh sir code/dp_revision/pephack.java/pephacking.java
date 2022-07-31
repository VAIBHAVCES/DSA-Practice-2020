import java.io.*;
import java.util.*;

public class pephacking {
    
    static int weight[]= new int[]{ 1, 12 ,16};
    public static int moleculerWeight(String form ){
        
         int i=0;
        int ans = 0;
        if(form.length()==0)
                return 0;
        
        while(i <    form.length() ){
            // i th one is  charachter  -TRUE 
            char ch = form.charAt(i);
            // System.out.println("phase-1 "+i+" "+ch);
            if(ch>='A'  && ch <='Z'){
                
                //CHECK IF i+1 th is number -TRUE || ALSO CHECK IS IT IN RANGE OR NOT 
                if(i+1 < form.length()  &&  form.charAt(i+1) >='1'  && form.charAt(i+1)<='9'){
                    
                    int times=(int)form.charAt(i+1)-'0';
                    if(ch=='H') ans+=times*weight[0];
                    else if(ch=='C') ans+=times*weight[1];
                    else if(ch=='O') ans+=times* weight[2];
                //    System.out.println("found "+ch+" "+times);
                    i++;
                    
                }else if(i+1==form.length() || (form.charAt(i+1) >='A'  && form.charAt(i+1)<='Z')){
                      // ADD  ANS+= ITH CHAR WEIGHT *NUMBER 
                    // IF RANGE EXCEED OR NO NUMBER FOUND
                    if(ch=='H') ans+=weight[0];
                    else if(ch=='C') ans+=weight[1];
                    else if(ch=='O') ans+=weight[2];
                }    
            i++;
                
            }
                      
            
            
            // ELSE 
            
            
        }
        // System.out.println("form : "+form+" ans is  : "+ans); 
        return ans;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        String form = scn.nextLine();
        
//         HYDDROGEN , CARBON , OXYGEN
        
        int ans=0;
        int i=0;
        Stack<Character>mem=new Stack<>();
        while(i<  form.length()){
            // System.out.println(i);
            StringBuilder sub = new StringBuilder();
            char ch = form.charAt(i);
            if(ch !=')'){
                mem.push(ch);
            }else if(ch == ')'){
               
                StringBuilder sub2 = new StringBuilder();
                int  times_h=(int)(form.charAt(i+1)-'0');
                int times = i+1 <form.length()   ? times_h:1;
                // System.out.println("times S: " +times);
                
                while(mem.size() > 0  && mem.peek()!='('){
                    sub2.append(mem.pop());
                }
                mem.pop();
                ans+=(moleculerWeight(sub2.reverse().toString()))*times;
                // System.out.println(sub2.toString()+ "  is " +ans);
                
                
            }
            
            i++;
        }
        
       
            
            StringBuilder temp = new StringBuilder();
            while(mem.size() > 0){
                temp.append(mem.pop());
            }
            
            // System.out.println("phase3"+ ans);
            ans+=moleculerWeight(temp.reverse().toString());
            
    
       System.out.println(ans);
        
        
        
        
        
    }
}