
class main{



public static void main(String[] args) {
   
    solve();

}

public static void solve(){
    // System.out.println(mazePathPre( 0,0,2,2,""));
    // System.out.println(mazePathJumps( 0,0,3,3,""));
    // System.out.println(compassMove(0, 0, new boolean[4][4],""));

    // ****************RAJNEEESH SIR NEW IDEA *************
    int [][]plugin={{0,1},{1,0},{0,-1},{-1,0}};
    String moves[]={"R","D","L","T"};
    System.out.println(compassMoveNew(0,0,new boolean[4][4],moves,plugin,""));

}



public static int mazePathJumps( int i ,int j ,int dr ,int dc,String psf){
   
    
    if(i==dr-1 && j==dc-1)
    {
        System.out.println(psf);
        return 1;
    }
    // down

    int count=0;

    for(int jump=1; j+jump<dc ;jump++)
         count+=mazePathJumps( i, j+jump,dr,dc ,psf+"r"+jump+"");
        // rightt
    for(int jump=1; j+jump<dc && i+jump <dr ;jump++)
       count+=mazePathJumps( i+jump, j+jump,dr,dc, psf+"d"+jump+"");
        // diag
    for(int jump=1;  i+jump <dr ;jump++)
        count+=mazePathJumps( i+jump, j,dr,dc, psf+"b"+jump+"");
    
    return count;
}



public static int mazePath( int i ,int j ,int dr ,int dc,String psf){
    if(i==dr && j==dc)
    {
        System.out.println(psf);
        return 1;
    }
    if(i>dr || j >dc)
        return 0;
    // down
    int pathsright=mazePath( i, j+1,dr,dc ,psf+"r");
    // rightt
    int pathsdiag=mazePath( i+1, j+1,dr,dc, psf+"d");
    // diag
    int pathsbottom=mazePath( i+1, j,dr,dc, psf+"b");
    return pathsbottom+pathsdiag+pathsright;



}

public static int mazePathPre( int i ,int j ,int dr ,int dc,String psf){
   
    int count=0;
    if(i==dr-1 && j==dc-1)
    {
        System.out.println(psf);
        return 1;
    }
    // down
    if(j+1<=dc) count+=mazePathPre( i, j+1,dr,dc ,psf+"r");
    // rightt
    if(i+1<=dr) count+=mazePathPre( i+1, j+1,dr,dc, psf+"d");
    // diag
    if(j+1<=dc&& i+1<=dr) count+=mazePathPre( i+1, j,dr,dc, psf+"b");
    return count;



}

public static int compassMove(int i, int j ,boolean dp[][],String psf){

    int n=dp.length;
    int m=dp[0].length;
    int count=0;
    if(i==n-1&& j==m-1){

        System.out.println(psf);
        return 1;
    }
    if(dp[i][j]==false){

        dp[i][j]=true;
        if(i+1<n)
        {
            count+= compassMove(i+1,j,dp,psf+"D");
        }if(j+1<m ){
            count+=compassMove(i,j+1,dp,psf+"R");
        }if(j-1>=0  ){
            count+=compassMove(i,j-1,dp,psf+"L");
        }if(i-1>=0){
            count+=compassMove(i-1,j,dp,psf+"T");
        }

        dp[i][j]=false;
    }
    return count;
}


public static int compassMoveNew(int i,int j,boolean visited[][],String move[],int plugins[][],String psf){

    if(i==visited.length-1 && j==visited[0].length-1){
        System.out.println(psf);
        return 1;
    }
    if(!(i>=0 && j>=0 && i<visited.length && j<visited[0].length))
        return 0;
    int count=0;
    if(visited[i][j]==false){

        visited[i][j]=true;
        for(int x=0;x<plugins.length;x++){
            count+=compassMoveNew(i+plugins[x][0], j+plugins[x][1], visited, move, plugins, psf+move[x]);
        }
        visited[i][j]=false;
    }   

    return count;
}

}