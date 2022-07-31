package graph_revision;

import java.util.PriorityQueue;
import java.util.Arrays;

public class test {
        public static class Pair{
            int csf;
            int vtx;
            
            @Override
            public int compareTo(Pair x){
                return this.csf- x.csf;
            }
            Pair(int x , int y ){
                vtx =  x; 
                csf= y ;
            }
        }
        static int moves[][]= { {0,1},{0,-1},{-1,0},{1,0}};
        static int directions[]= { 'R' , 'L' , 'U' , 'D'};
        public int solve(int n, int m, String[] C) {
        
            PriorityQueue<Pair>mem =new PriorityQueue<>();     
            int vis[]= new int[n*m];
            Arrays.fill(vis,-1);
            mem.add( new Pair(0,0));
            while(mem.size() >  0 ){
                Pair top = mem.remove();
                int x= top.vtx/m;
                int y =  top.vtx%m;
                for(int dir = 0 ; dir<4;dir++){
                    int i  = x  + moves[i][0];
                    int j = y  + moves[i][1];
                    int myCost = directions[i]==C[i].charAt(j) ? 0 : 1;
                    if(i>=0 && j>=0 && i <n && j < m && (vis[i*m+j]==-1 ||  top.csf+myCost< vis[i][j] ) ){
                        
                    }
                }

            }


        }
    

}

