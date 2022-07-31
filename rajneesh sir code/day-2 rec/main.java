import java.util.*;
import java.io.*;
import java.lang.*;

class main {

    public static void main(String[] args) {
        solve();

    }

    public static void solve() {
        // printAll("ABA","");
        // printUniques("ABA", "");
// *****************NOKIA MOBIILE 3310
        String digits="103";
        String map[]={"|<>","[{}","abc","def","ghi","jkl",
        "mno","pqrs","tuv","wxyz","!@#","%&*"};

        List<String>ans= new ArrayList<>();
        phoneNumber(digits,ans,map,"",0);
        System.out.println(ans);

    }

    public static void substring(String qsf, String asf) {

        // System.out.println(qsf+" "+asf);
        if (qsf.length() == 0) {
            System.out.println(asf);
            return;
        }
        char zero = qsf.charAt(0);
        substring(qsf.substring(1, qsf.length()), asf + zero);
        substring(qsf.substring(1), asf);

    }

    public static void printAll(String qsf, String asf) {

        if (qsf.length() == 0) {
            System.out.println(asf);
            return;
        }

        // System.out.println(qsf+" "+asf);
        for (int i = 0; i < qsf.length(); i++) {
            printAll(qsf.substring(0, i) + qsf.substring(i + 1, qsf.length()), asf + qsf.charAt(i));
        }

    }

    public static void printUniques(String qsf, String asf) {

        if (qsf.length() == 0) {
            System.out.println(asf);
            return;
        }
        boolean dp[] = new boolean[26];
        for (int i = 0; i < qsf.length(); i++) {
            if (dp[qsf.charAt(i) - 'A'] == false) {
                printUniques(qsf.substring(0, i) + qsf.substring(i + 1, qsf.length()), asf + qsf.charAt(i));
                dp[qsf.charAt(i) - 'A'] = true;
            }
        }

    }


public static int phoneNumber(String digits,  List<String>ans ,String map[],String res,int idx){
        
    if(digits.length()==res.length())
    {
       ans.add(res);
        return 1;
    }
    int count=0;
    int d1=digits.charAt(idx)-'0';
    String sub=map[d1];
    for(int i=0;i<sub.length();i++){
        count+=phoneNumber(digits,ans,map,res+sub.charAt(i),idx+1);
    }

    if(idx+1<digits.length()){
        int d2=digits.charAt(idx+1)-'0';
        int di=d1*10+d2;
        if(di<=11){
            String subi=map[di];
            for(int i=0;i<subi.length();i++){
                count+=phoneNumber(digits,ans,map,res+subi.charAt(i),idx+1);
            }
        }



    }
     return count;
}
}