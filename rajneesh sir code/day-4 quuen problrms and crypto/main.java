import java.util.*; 

// Recursive implementation of 
// word break problem in java 
public class main 
{ 

	// set to hold dictionary values 
	private static Set<String> dictionary = new HashSet<>(); 
	
	public static void main(String []args) 
	{ 
		
		// array of strings to be added in dictionary set. 
		// String temp_dictionary[] = {"mobile","samsung","sam","sung", 
		// 					"man","mango","icecream","and", 
		// 					"go","i","like","ice","cream"}; 
							

        // gfgWordBreak(temp_dictionary);
        solve();
        
		
    } 

    public static void solve(){
        int[][] board = {{3, 0, 0, 6, 0, 0, 0, 9, 2},  
                         {5, 2, 0, 0, 0, 0, 4, 0, 8},  
                         {0, 8, 7, 0, 0, 0, 0, 3, 1},  
                         {0, 0, 3, 0, 1, 0, 0, 8, 0},  
                         {9, 0, 0, 8, 6, 3, 0, 0, 5},  
                         {0, 5, 0, 0, 9, 0, 6, 0, 0},  
                         {1, 3, 0, 0, 0, 0, 2, 5, 0},  
                         {0, 0, 0, 0, 0, 0, 0, 7, 4},  
                         {0, 0, 5, 2, 0, 6, 3, 0, 0}};  
        // ArrayList<Integer>zeros= locOfzeros(board);
        // System.out.println(fillsudoku(board, 0, zeros));
        int row[]=new int[9];
        int col[]=new int[9];
        int comp[][]= new int[3][3];
        bitSudokuMarkers(row, col, comp, board);
        for(int i=0;i<9;i++){
            System.out.println("rows "+row[i]+" col "+col[i]);
        }
        sudokuFromBits(board,row,col,comp,0);
        // System.out.println( makeOntoOff( 11,4));

    }
    public static int makeOntoOff(int num,int k){
        int x=1;
        num=~num;
        x=(x<<(k-1));
        num=(num|x);
        num=~num;
        return num;

    }
    public static int makeOfftoOnn(int num,int k){
        int x=1;

        x=x<<k;
        num=num|x;
      
        return num;

    }
    public static void gfgWordBreak(String temp_dictionary[] ){

        for (String temp :temp_dictionary) 
        
        { 
            dictionary.add(temp); 
        } 
        System.out.println(wordBreak("ilikesamsung")); 
        System.out.println(wordBreak("iiiiiiii")); 
        System.out.println(wordBreak("")); 
        System.out.println(wordBreak("ilikelikeimangoiii")); 
        System.out.println(wordBreak("samsungandmango")); 
        System.out.println(wordBreak("samsungandmangok")); 

    }
    public static boolean wordBreak(String str){

        if(str.length()==0)
        {
            return true;
        }
        boolean ans=false;
        for(int i=0;i<str.length();i++){

            String sub=str.substring(0,i+1);
            if(dictionary.contains(sub)){

                boolean resp=wordBreak(str.substring(i+1,str.length()));
                // System.out.println("respomse for : "+str.substring(i+1,str.length())+" is "+resp);
                ans=ans || resp;
            }
        }
        return ans;

    }
    public static void display(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }

            System.out.println();
        }
        System.out.println("\n");
        System.out.println("\n");
    }
    public static boolean check(String st1, String st2 , int st1arr[],int st2arr[], String tar){
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<st1.length();i++){
            char ch=st1.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch)!=st1arr[i]){
                    return false;
                }
            }else{
                map.put(ch, st1arr[i]);
            }
        }
        for(int i=0;i<st2.length();i++){
            char ch=st2.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch)!=st2arr[i]){
                    return false;
                }
            }else{
                map.put(ch, st2arr[i]);
            }
        }

       int ptr1=st1arr.length-1;
       int ptr2=st2arr.length-1;
       int carry=0;
       while(ptr1 >0 && ptr2>0){
        int dig1,dig2;
        if(ptr1<0){
            dig1=0;
        }else{
            dig1=st1arr[ptr1];
        }
            

       }
return false;
    }
    public static  boolean validOrNot(int num ,int grid[][], int x, int y ){

        int n=grid.length;
    
        
        // checking in the row
        for(int i=0;i<n;i++){
                if(grid[i][y]==num){
                    return false;
                }
        }
        // column check
        for(int j=0;j<n;j++){
            if( j!=y && grid[x][j]==num){
                return false;
            }

        }
        // *************you can do either this 
        // int sr=(x/3);
        // sr=sr*3;
        // int er=(x/3);
        // er=(er+1)*3;
        // int sc=(y/3);
        // sc=sc*3;
        // int ec=(y/3);
        // ec=(ec+1)*3;

        // for(int i=sr;i<er;i++){
        //     for(int j=sc;j<ec;j++){
        //         if(grid[i][j]==num){
        //             return false;
        //         }
        //     }
        // }
        // *********************or thi s 
        x=(x/3)*3;
        y=(y/3)*3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i+x][j+y]==num){
                    return false;
                }
            }
        }
        return true;

    }
    public static int fillsudoku(int board[][],int vidx , ArrayList<Integer>zeros){


        if(vidx==zeros.size()){
            display(board);
            return 1;
        }

        int count=0;
        int loc=zeros.get(vidx);
        int x=loc/9;
        int y=loc%9;
        for(int i=1;i<=9;i++){

            if(validOrNot(i,board,x,y)){

            board[x][y]=i;
            count+=fillsudoku(board, vidx+1, zeros);
            board[x][y]=0;
            }
        }
        return count;

    }
    public static ArrayList<Integer> locOfzeros(int grid[][]){
        ArrayList<Integer>zeros=new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==0){
                    zeros.add(i*9+j);
                }
            }
        }
        return zeros;

    }
    
    public static int  sudokuFromBits(int board[][] ,int row[],int col[],int comp[][],int idx){

        int x=idx/9;
        int y=idx%9;
        // System.out.println("at index "+x+" "+y);

        if(idx==81){
            display(board);
            return 1;
        }
        if(board[x][y]!=0){
            return sudokuFromBits(board, row, col, comp, idx+1);
        }
        int count=0;
        // System.out.println("posiition "+x+" "+y +"  is faluty ");
        for(int i=1;i<=9;i++){
            int checker=1;
            checker=(checker<<i);
            // System.out.println("place "+i);
            if( (row[x] & checker)==0 && ( col[y]&checker)==0 &&  (comp[x/3][y/3]&checker)==0){
               
                row[x]^=checker;
                col[y]^=checker;
                comp[x/3][y/3]^=checker;
                board[x][y]=i;
                // display(board);
                count+=sudokuFromBits(board,row,col,comp,idx+1);
                board[x][y]=0;
                row[x]^=checker;
                col[y]^=checker;
                comp[x/3][y/3]^=checker;
            }
        }
        return count;
    }

    public static void bitSudokuMarkers(int row[],int col[], int comp[][],int board[][]){

        for(int i=0;i<row.length;i++){
            int x=0;
            for(int j=0;j<9;j++){
                int temp=board[i][j];
                if(temp!=0){
                    int make=1;
                    make=(make<<temp);
                    x=(x|make);
                }
            }
            row[i]=x;
        }

        for(int j=0;j<col.length;j++){
            int x= 0;
            for(int i=0;i<9;i++){
                int temp=board[i][j];
                if(temp!=0){
                    int make=1;
                    make=(make<<temp);
                    x=(x|make);
                }
            }
            col[j]=x;
        }


        for(int itr=0;itr<9;itr++)
        {
                int sx=(itr/3)*3;
                int sy=(itr%3)*3;
                int x=0;
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        int temp=board[sx+i][sy+j];
                        if(temp!=0){
                            int make=1;
                            make=(make<<temp);
                            x=(x|temp);
                        }
                    }
                }
                comp[sx/3][sy/3]=x;
        }
    
    // for(int i=0;i<9;i++){
    //     for(int j=0;j<9;j++){
    //         if(board[i][j]!=0){
    //             int mask=1;
    //             mask=(mask<<board[i][j]);
    //             row[i]^=mask;
    //             col[j]^=mask;
    //             comp[i/3][j/3]^=mask;
    //         }
    //     }
    // }

}

}

    