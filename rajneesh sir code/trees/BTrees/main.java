import java.util.Stack;
import java.util.*;
import java.io.*;

public class main {

    public static class Node {

        int data;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static class Pair {

        Node node;
        int st;

        Pair(Node node, int st) {
            this.node = node;
            this.st = st;
        }
    }

    static int idx = 0;

    public static Node construct(int arr[]) {

        if (idx == arr.length || arr[idx] == -1) {
            idx++;
            return null;
        }
        Node node = new Node(arr[idx++]);
        node.left = construct(arr);
        node.right = construct(arr);
        return node;
    }

    // **************BASIC BINARY TREE UTILITY FUNCTIONS**********
    public static Node constructStack(int arr[]) {

        int i = 0;
        Node root = new Node(arr[i]);
        Stack<Pair> st = new Stack<>();
        st.add(new Pair(root, 0));

        while (!st.isEmpty()) {
            Pair top = st.peek();
            int ts = top.st;
            if (ts == 0) {
                i++;
                top.st = 1;
                if (arr[i] != -1) {
                    Node child1 = new Node(arr[i]);
                    top.node.left = child1;
                    st.add(new Pair(child1, 0));
                }

            } else if (ts == 1) {
                i++;
                top.st = 2;
                if (arr[i] != -1) {
                    Node child1 = new Node(arr[i]);
                    top.node.right = child1;
                    st.add(new Pair(child1, 0));
                }
            } else {
                st.pop();
            }

        }
        return root;

    }

    public static void displayPre(Node node) {
        if (node == null)
            return;
        String left=node.left==null?".":node.left.data+"";
        String right=node.right==null?".":node.right.data+"";
        System.out.println(left+" <-  "+node.data+" -> "+right);
        displayPre(node.left);
        displayPre(node.right);
    }

    public static void displayPost(Node node) {

        if (node == null)
            return;

        displayPost(node.left);
        displayPost(node.right);
        System.out.println(node.data);
    }

    public static void displayLevel(Node node) {

        if (node == null)
            return;

        displayLevel(node.left);
        System.out.println(node.data);
        displayLevel(node.right);
    }

    public static int size(Node root) {

        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    public static int height(Node root) {

        // if you will return 0 it will give you height in terms of nodes else in terms
        // of edges
        if (root == null)
            return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // ****************BINARY TREE QUESTION TYPES ********
    public static int diameter(Node root) {
        if (root == null)
            return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);
        return Math.max(Math.max(right, left), height(root.left) + height(root.right) + 2);
    }

    public static int[] diameterPair(Node root) {
        if (root == null) {
            // (height,dia)
            int arr[] = { -1, 0 };
            return arr;
        }

        int left[] = diameterPair(root.left);
        int right[] = diameterPair(root.right);
        int mydia = Math.max(Math.max(left[1], right[1]), left[0] + right[0] + 2);
        int height = Math.max(left[0], right[0]) + 1;
        int temp[] = { height, mydia };
        return temp;
    }

    public static ArrayList<Integer> klnodesDown(Node node, int k) {

        if (node == null) {
            return new ArrayList<>();
        }
        if (k == 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(node.data);
            return temp;
        }
        ArrayList<Integer> ans = new ArrayList<>();

        ArrayList<Integer> left = klnodesDown(node.left, k - 1);
        ArrayList<Integer> right = klnodesDown(node.right, k - 1);
        for (int ele : left) {
            ans.add(ele);
        }
        for (int ele : right) {
            ans.add(ele);
        }
        return ans;

    }

    public static void levelorder(Node root) {

        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        while (que.size() != 0) {
            Node top = que.removeFirst();
            System.out.println(top.data);
            if (top.left != null) {
                que.addLast(top.left);

            }
            if (top.right != null) {
                que.addLast(top.right);

            }

        }

    }

    public static void levelorder02(Node root) {

        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {

                Node top = que.removeFirst();
                System.out.print(top.data + " ");
                if (top.left != null) {
                    que.addLast(top.left);

                }
                if (top.right != null) {
                    que.addLast(top.right);
                }
            }
            System.out.println();
        }

    }

    public static void levelReverse(Node root) {

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);

        while (st1.size() != 0 || st2.size() != 0) {
            // System.out.println("inside loop ");
            if (st1.size() != 0) {

                while (st1.size() != 0) {
                    Node top = st1.pop();
                    System.out.print(top.data + " ");
                    if (top.left != null)
                        st2.push(top.left);
                    if (top.right != null)
                        st2.push(top.right);
                }
                System.out.println();
            } else {
                while (st2.size() != 0) {
                    Node top = st2.pop();
                    System.out.print(top.data + " ");
                    if (top.right != null)
                        st1.push(top.right);
                    if (top.left != null)
                        st1.push(top.left);
                }
                System.out.println();
            }

        }

    }

    // ****************** REPAIR IT ****************
    public static void levelReverse02(Node root) {

        boolean side = true;
        LinkedList<Node> st = new LinkedList<>();
        st.addLast(root);
        while (st.size() != 0) {

            if (side == true) {
                int size = st.size();
                while (size-- > 0) {
                    Node top = st.removeFirst();
                    System.out.print(top.data + " ");
                    if (top.right != null)
                        st.addLast(top.right);
                    if (top.left != null)
                        st.addLast(top.left);

                }
                side = false;
                System.out.println();

            } else {
                int size = st.size();
                String str = "";
                while (size-- > 0) {
                    Node top = st.removeLast();
                    str = top.data + " " + str;
                    if (top.left != null)
                        st.addLast(top.left);
                    if (top.right != null)
                        st.addLast(top.right);

                }
                side = true;
                System.out.println(str);

            }

        }

    }

    // **************************************
    public static int[] width(Node root, int level, int minmax[]) {

        if (root == null) {
            return minmax;
        }
        minmax[0] = Math.min(level, minmax[0]);
        minmax[1] = Math.max(level, minmax[1]);
        width(root.left, level - 1, minmax);
        width(root.right, level + 1, minmax);
        return minmax;
    }

    public static void burnNodes(Node node , int time ,ArrayList<ArrayList<Integer>> ans){

        if(node==null)
            return ;
        if(time==ans.size()) 
            ans.add(new ArrayList<>());
        ans.get(time).add(node.data);
        burnNodes(node.left, time +1, ans);
        burnNodes(node.right, time +1, ans);
    }

    public static int burningTrees(Node node, int tar, ArrayList<ArrayList<Integer>> ans) {

        if(node==null)
            return -1;
        if(node.data == tar){
            burnNodes(node,0,ans);
            return 1;
        }
        
        int ld=burningTrees(node.left,tar,ans);
        if(ld==ans.size()) ans.add(new ArrayList<>());
        if(ld!=-1){
             ans.get(ld).add(node.data);
             burnNodes(node.right,ld+1,ans);
             return ld+1;
            }
        int rd=burningTrees(node.right,tar,ans);
        if(rd==ans.size()) ans.add(new ArrayList<>());
        if(rd!=-1){
            ans.get(rd).add(node.data);
            burnNodes(node.left,rd+1,ans);
            return rd+1;
       }
       return -1;
    }

    public static void  swapnodesVals(Node x , Node y){
        int temp=x.data;
        x.data=y.data;
        y.data=temp;
    }
    public static Node  prev=null;

    public static boolean recoverBST(Node node ){
        if(node==null)  return false;

        if(recoverBST(node.left))   return true;
        if(prev==null && prev.data>node.data)  prev=node;
        if(prev!=null && prev.data>node.data){
            swapnodesVals(prev,node);
            return true;
        }
        prev=node;
       
        if(recoverBST(node.right))  return true;
        return false;
    }

    public static int idxi=0;
    public static Node makeBSTFromPre(int arr[], int low , int hi){
        
        if(idxi>=arr.length )
            return null;
        if(arr[idxi] < low || arr[idxi] > hi)
            return null;
        int x=arr[idxi];
        Node temp = new Node(arr[idxi++]);
        temp.left=makeBSTFromPre(arr,low,x);
        temp.right=makeBSTFromPre(arr,x,hi);
        return temp;
    
    }

    public static Node makeBSTFromIn(int arr[],int low , int hi){

        if(  low >hi)
            return null;
        int mid=(low+hi)/2;
        Node root=new Node(arr[mid]);
        if(low==hi) return root;
        root.left=makeBSTFromIn(arr,low,mid-1);
        root.right=makeBSTFromIn(arr,mid+1,hi);
        return root;
    }   
   
    public static Node makeBSTFromPost(int arr[],int low, int hi){

        if(idxi<0 || arr[idxi]<low || arr[idxi] >hi){return null; }
        int x=arr[idxi];
        Node node = new Node(arr[idxi--]);
        node.right=makeBSTFromPost(arr,x,hi);
        node.left=makeBSTFromPost(arr,low,x);
        return node;

    }
    public static void treeBuilders(){
        // int preorder[]={};
        int []pre={50,30,10,40,80,70,90};
        int in[]={10,30,40,50,70,80,90};
        int post[]={ 1 ,7, 5 ,50, 40 ,10};

        // Node root=makeBSTFromPre(pre,Integer.MIN_VALUE,Integer.MAX_VALUE);
        // Node root=makeBSTFromIn(in,0,in.length-1);
        idxi=post.length-1;
        Node root= makeBSTFromPost(post,Integer.MIN_VALUE,Integer.MAX_VALUE);
        displayPre(root);
    }

    public static class pair2{
        Node node;
        boolean self;
        boolean left;
        boolean right;
        pair2(Node a,boolean b ,boolean c,boolean  d){
                node=a;
                self=b;
                left=c;
                right=d;
                
        }   
    }
    
    public static class pair3{
        Node node;
        boolean self;
        boolean left;
        boolean right;
        int height;
        int dia;
        pair3(Node a,boolean b ,boolean c,boolean  d,int e,int f){
                node=a;
                self=b;
                left=c;
                right=d;
                height=-1;
                dia=f;
        }   
    }
    
    public static void preorderTraversal(Node root){
        Stack<pair2>st= new Stack<>();
        st.push(new pair2(root,false,false,false));
        while(st.size()!=0){
            pair2 top= st.peek();
            if(!top.self) {
                top.self=true;
                String left=top.node.left==null?".":top.node.left.data+"";
                String right=top.node.right==null?".":top.node.right.data+"";
                System.out.println(left+" <-  "+top.node.data+" -> "+right);
            
            }
            else if(!top.left){
                top.left=true;
                if(top.node.left!=null)
                    st.push(new pair2(top.node.left,false,false,false));
            }else if(!top.right){
                top.right=true;
                if(top.node.right!=null)
                st.push(new pair2(top.node.right,false,false,false));
            }else {
                st.pop();
            }

        }

    }
   
  
    public static void iterativeTraversal(Node root){

        preorderTraversal(root);
    }
    
    public static Node predec=null;
    public static Node succ;
    public static boolean getPredecessor(Node root,int val){

        if(root==null)  return false;
        
        if(getPredecessor(root.left,val))   return true;
        
        if(predec!=null && predec.data==val){
            succ=root;
            return true;
        }

        predec=root;
        if(getPredecessor(root.right,val))  return true;
        return false;
    }
    public static void findPredecessor(Node root){
        // predec=root;
        getPredecessor( root,10);

        System.out.println("predec is for binary tree rule: "+succ.data);
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

    public static void makeSolution(Node root, int data , int level,asp pair){

        if(root==null)  return;
        // System.out.println("at point : "+root.data+" "+data+" " +(root.data==data) );
        pair.height=Math.max(level,pair.height);
        pair.size++;
        pair.find=pair.find||root.data==data;

        makeSolution(root.left,data,level+1,pair);
        if(root.data< data) pair.floor=Math.max(pair.floor,root.data);
        if(root.data>data)  pair.ceil=Math.min(pair.ceil,root.data);
        if(pair.predec==null && root.data==data  ){
            // System.out.println("point found");
            pair.predec=pair.prev;
        }
        if(pair.prev!=null && pair.prev.data==data){
            pair.succ=root;
        }
        pair.prev=root;
        makeSolution(root.right,data,level+1,pair);
    }
    
    public static void makesolsbst(Node root, int data ,asp pair){
        System.out.println(root.data+" "+data);
        if(root==null)
            return;
        if(data<root.data)
            makesolsbst(root.left,data,pair);
            if(pair.predec==null && root.data==data){
                pair.predec=prev;
            }
            if(pair.predec!=null &&prev.data==data){
                pair.succ=root;
            }
            pair.prev=root;
            
        if(data>root.data)
            makesolsbst(root.right,data,pair);

    }
    public static void somexternalselfquestions(Node node ){
        
        int ans[]=closestleaf(node ,1);
        // System.out.println("closestleaf :  "+(ans[1]+ans[0]));
        System.out.println("closest var: "+closest);
        
    }
    static int closest= Integer.MAX_VALUE;
    public static int[] closestleaf(Node root ,int tar){
        // System.out.println("pre : "+root.data);
        if(root.left==null && root.right==null){
            if(root.data==tar)
                return new int[]{0,0};
            // System.out.println("base case: "+root.data);
            return new int[]{0,-1};
        }
        int  left[]= new int[]{Integer.MAX_VALUE,-1};
        if(root.left!=null)
            left=closestleaf(root.left, tar);

        int  right[]= new int[]{Integer.MAX_VALUE,-1};
        if(root.right!=null)
          right=closestleaf(root.right, tar);

        int myans=Math.min(left[0],right[0])+1;
        if(root.data==tar){
            System.out.println("updation at l "+root.data+" :  "+myans);
            closest=Math.min(closest,myans);
            return new int[]{myans ,1 };
        }
        if(right[1]!=-1 || left[1]!=-1){
            System.out.println("updation at l "+root.data);
            int furth=right[1]!=-1?right[1]:left[1];
            closest=Math.min(closest,myans+furth);
            return new int[]{ myans ,furth+1};
        }
        return new int[]{myans,-1};


    }
    
    public static void allsolutions(Node root){

        asp pair =  new asp();
        // makeSolution( root , 50,0,pair);
        makesolsbst(root,20,pair);
        System.out.println("succ "+pair.succ.data+" predecessor: " +pair.predec.data+" ceil : "+pair.ceil+" flloor "+pair.floor);
    }

    // public static Node inordersucc=null;
    // public static boolean inordersuccessor(Node root ,int data){

    //     if(root==null)  return false;
    //     if(inordersuccessor(root.left,data))    return true;
    //     // **************** inorder area 
    //     if(root.data==data){    

    //         if(root.right!=null){
    //             Node temp=root.right;
    //             while(temp.left!=null){
    //                 temp=temp.left;
    //             }
    //             inordersucc=root;
    //         }else{
    //             Node temp=root;
    //             while(temp.parent!=null && temp.parent.data < temp.data){
    //                 temp=temp.parent;
    //             }
    //             inordersucc=root;
    //         }

    //     }

    //     if(inordersuccessor(root.right,data))   return true;
    //     return false;


    // }
    
    
    
    public static void main(String[] args) {

        // int arr[]=
        // {10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        // int arr[]={10,20,40,-1,-1,50,-1,-1,30,60,-1,-1,70,-1,-1};
        // int arr[] = { 10, 20, 40, -1, -1, 50, -1, -1, 30, 60, -1, -1, 70, -1, -1 };
        // int arr[]={12,13,-1,-1,10,14,21,-1,-1,24,-1,-1,15,22,-1,-1,23,-1,-1};
        // Node root=,construct(arr);
        int arr[]={1,2,6,-1,-1,7,-1,-1,3,4,8,11,13,-1,-1,-1,-1,-1,5,10,12,14,-1,-1,-1,-1,-1};
   
        Node root = construct(arr);
        // displayPre(root);
        // System.out.println(size(root));
        // System.out.println("height : " + height(root));
        // System.out.println("O(n^2) height : "+diameter(root));
        // System.out.println("height using dia: "+diameterPair(root)[1]);
        // System.out.println("hello ");
        // System.out.println(klnodesDown(root,2));
        // levelorder(root);
        // levelorder02(root);
        // levelReverse(root);
        // levelReverse02(root);
        // int minmax[]= width(root,0,new int[2]);
        // System.out.println("width of array is : "+( Math.abs(minmax[0])+minmax[1]));
        // ***********************DIFFERENT TYPE OF ARRAY VIEWS*********************
        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // burningTrees(root, 14, ans);
        // for(ArrayList<Integer> temp:ans){

        //     for(int ele : temp){
        //         System.out.print(ele+" ");
        //     }
        //     System.out.println();
        // }
        // treeBuilders();
        // iterativeTraversal(root);
        // findPredecessor(root);
        // *********************
        // allsolutions(root);
        // ***************question of leet not possible to test
        // inordersuccessor(root,20); 
       
        displayPre(root);
        somexternalselfquestions(root);
    }

}