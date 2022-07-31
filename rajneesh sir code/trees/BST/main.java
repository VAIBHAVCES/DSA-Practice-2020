import java.io.*;
import java.util.*;

import javax.swing.tree.TreeNode;
class main{

    public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data ){
            this.data=data;
        }
    
    }
public static void main(String args[]){

    solve();

    }
    public static Node constructBST(ArrayList<Integer>arr,int si,int ei){
        if(si>ei) return null;

        int mid=(si+ei)>>>1;
        Node root= new Node(arr.get(mid));
        root.left=constructBST(arr,si,mid-1);
        root.right=constructBST(arr,mid+1,ei);
        return root;
    }

    public static int size(Node root){
        return root==null? 0:size(root.left)+size(root.right)+1;
    }
    public static int height(Node root){
        return root==null? -1:Math.max(height(root.left),height(root.right))+1;
    }
    public static boolean find(Node root, int data){

        if(root==null){
            return false;
        }
        if(root.data==data){
            return true;
        }
        return find(root.left,data) || find(root.right,data);
        

    }
    static int idx=0;
    // public static  Node constructingPre(int arr[] , int st, int ed){

    //     if(idx>=arr.length || arr[idx] < st )
    //     Node node = new Node(arr[idx++]);
    //     node.left=constructingPre(arr,st
    // }
    public static void displayPre(Node node) {
        if (node == null)
            return;
        String left=node.left==null?".":node.left.data+"";
        String right=node.right==null?".":node.right.data+"";
        System.out.println(left+" <-  "+node.data+" -> "+right);
        displayPre(node.left);
        displayPre(node.right);
    }
    
    public static  int preIn=0;
    public static boolean inorderPreBtree(Node root,int data){

        if(root==null){
            return false;

        }
        boolean ld=inorderPreBtree(root.left,data);
        if(root.data==data){return true;}
        if(ld){return true;}
        preIn=root.data;
        boolean rd=inorderPreBtree(root.right,data);
        if(rd){return true;}

        return false;
    }
    
    public static class asp{ 
        int height=0;
        int size=0;
        boolean find=false;

        int ceil=Integer.MAX_VALUE;
        int floor=Integer.MIN_VALUE;

        Node succ=null,prev=null,predec=null;
        //class name is all solution pair
    }
    public static void makesolsbst(Node root, int data ,asp pair){
        System.out.println(root.data+" "+data);
        if(root==null)
            return;
        if(data<root.data)
            makesolsbst(root.left,data,pair);
            if(pair.predec==null && root.data==data){
                pair.predec=pair.prev;
            }
            if(pair.predec!=null &&pair.prev.data==data){
                pair.succ=root;
            }
            pair.prev=root;
            
        if(data>root.data)
            makesolsbst(root.right,data,pair);

    }
    public static void allsolutions(Node root){

        asp pair =  new asp();
        // makeSolution( root , 50,0,pair);
        makesolsbst(root,20,pair);
        System.out.println("succ "+pair.succ.data+" predecessor: " +pair.predec.data+" ceil : "+pair.ceil+" flloor "+pair.floor);
    }

    public static void iterativePreSucc(Node root,int data){

        Node curr=root;
        Node pred=null ,succ=null;
        while(curr!=null){

            if(data ==curr.data){

                if(curr.left!=null){
                    pred=curr.left;
                    while(pred.right!=null)    pred=pred.right;
                }

                if(curr.right!=null){
                    succ=curr.right;
                    while(succ.left!=null)    succ=succ.left;
                    
                }
                break;

            }else if (data> curr.data){
                pred=curr;
                curr=curr.right;

            }else if (data< curr.data){

                succ=curr;
                curr=curr.left;
            }
        }
        System.out.println("successor is "+succ.data+" and pred: "+pred.data); 

    }
    public static  Node minimumm(Node root ){

        Node temp=root;
        while(temp.left!=null){
            temp=temp.left;
        }
        return temp;
        
    }
    public  static Node  addNodeBST(Node root ,int data){

        if(root==null)
            return new Node(data);

        if(data>root.data){
               root.right= addNodeBST(root.right, data);
        }else if(data<root.data){
            root.left=addNodeBST(root.left, data);
        }
        return root;
    }

    public static Node removoNodeBST(Node root , int data ){
        
        if(root==null)  return null;

        if(data < root.data)
            root.left=removoNodeBST(root.left, data);
        else if(data > root.data)
            root.right=removoNodeBST(root.right, data);
        else{

            if(root.left==null || root.right==null)     return root.left!=null? root.left:root.right;
            Node min=minimumm(root.right);
            root.data=min.data;
            root.right=removoNodeBST(root, min.data);

        }
            return root;
    }

    public static void solve(){
        int temp[]={10,20,30,40,50,60};
        ArrayList<Integer>arr=new ArrayList<>();
        for(int ele:temp){
            arr.add(ele);
        }
        Node root= constructBST(arr,0,arr.size()-1);
        displayPre(root);
        // inorderPreBtree(root,60);
        
        // asp pair = new asp();
        // allsolutions(root);
        // iterativePreSucc(root,30);
        addNodeBST(root,47);
        // displayPre(root);
        // removoNodeBST(root, 47);
        // displayPre(root);
    }

}