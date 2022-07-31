import java.util.*;
import java.io.*;
public class main {
    
    public static class Node{
        int data=0;
        ArrayList<Node>childs= new ArrayList<>();
        Node(int data){
            this.data=data;
        }
    }

    public static Node constructGenericTree(int arr[]){
        Stack<Node>st = new Stack<>();
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=-1){
                st.push(new Node(arr[i]));
            }else {
                Node top=st.pop();
                st.peek().childs.add(top);
            }
        }
        return st.peek();

    }
    public static Node constructGT(){
        int arr[]={10,20,50,-1,60,-1,-1,30,70,-1,80,120,-1,130,-1,-1,90,-1,-1,40,100
        ,-1,110,-1,-1,-1};
        Node root=constructGenericTree(arr);
        return root;
    }
    // public static int[]diameter(Node root){
        
    //     // height   diameter
    //     int my[]={0,0};
    //     int max1=-1;max2=-1;
    //     int maxd=0;
    //     for(int i=0;i<root.childs.size();i++){
            
    //         int temp[]=diameter(root.childs.get(i));
    //         if(max1<temp[0]){
    //             max2=max1;
    //             max1=temp[0];
    //         }
    //         maxd=Math.max(maxd,tem[1]);
    //     }
    //     my[0]=Math.max(max1,max2)+1;
    //     my[1]=Math.max(max2-max1+1,maxd);
    //     return my;
    // }


    public static void printzigzag(int lvl,Node root){

        // System.out.println(root.data);
        String childs="";
        if(lvl%2==0){
            for(int i=root.childs.size()-1;i>=0;i--){
               childs+=root.childs.get(i).data+" ";

            }
            System.out.println(childs);
            for(int i=0;i<root.childs.size();i++){
                printzigzag(lvl+1,root.childs.get(i));

            }
        }else{
            
            for(int i=0;i<root.childs.size();i++){
               childs+=root.childs.get(i).data+" ";
            }
            System.out.println(childs);
            for(int i=root.childs.size()-1;i>=0;i--){
                printzigzag(lvl+1,root.childs.get(i));
             }
             
        }
    }
    public static void displayPre(Node root ){

        // if(root==null)
        
        String childs="";
        for(int i=0;i<root.childs.size();i++){
            childs+=root.childs.get(i).data+" ,";
           
        }
       
        System.out.println(root.data+" ->"+childs);
        for(int i=0;i<root.childs.size();i++){
            displayPre(root.childs.get(i));
        }



    }

    public static int height=0;
    public static int size=0;
    public static int max=Integer.MIN_VALUE;
    public static void  setMax(Node root){

        max=Math.max(root.data,max);
        for(Node child: root.childs)
        {
            setMax(child);
        }
        
    }
    public static void printUtils(int lvl,Node root){
        height=Math.max(lvl,height);
        size++;
        for(Node node:root.childs){
            
            printUtils(lvl+1,root);
        } 
        return ;
    }
    
    public static boolean getPath(Node root, int i, ArrayList<Node>path){
        
        if(root.data==i){
            path.add(root);
            return true;
        }
        for(Node x: root.childs){
            path.add(x);
            if(getPath(x,i,path))  return true;
            path.remove(path.size()-1);
        }
        return false;
    }
    public static void LCA(Node root,int i , int j){
        ArrayList<Node>path1=new ArrayList<>();
        ArrayList<Node>path2=new ArrayList<>();
        getPath(root,i,path1);
        getPath(root,j,path2);
        int x=0;
        while(x<path1.size() && x<path2.size() ){

            if(path1.get(x).data!=path2.get(x).data){
                break;
            }
        }
        System.out.println("LCA Is : "+path1.get(i).data);
        
    }

    public static Node setLeafs(Node root){
        if(root==null)
            return null;
        if(root.right==null && root.left==null)
            return root;
        Node left=setLeafs(root.right);
        Node right=setLeafs(root.left);
        if(right!=null && left!=null)
        {    right.left=left;
            left.right=right;
        }
        Node ans= left==null? right: left;
        return ans;
    }

    public static void main(String args[]){
        Node root=constructGT();
        displayPre(root);
        // printUtils(0,root);
        System.out.println("height "+height+" size : "+size);
        // printzigzag(0,root);
        LCA(root,30,80);
        // make(root);

    }
}