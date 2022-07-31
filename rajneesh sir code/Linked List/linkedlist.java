
public  class linkedlist{

    private  class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    
    private Node head=null;
    private Node tail=null;
    private int size=0;
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        
            return this.size==0;
    }
    public int getFirst() throws Exception{
        if(this.size()==0){
            throw new Exception("EmptyList");
        }
        return this.head.data;
    }


    public int getLast() throws Exception{
        if(this.size==0)
            throw new Exception("EmptyList");
        return this.tail.data;
    }
    private void addFirstNode(Node data){

        
        if(this.size==0){
            this.tail=data;
        }
        data.next=head;
        head=data;
        this.size++;
    }
    public void addFirst(int data){
        Node node= new Node(data);
        addFirstNode(node);
    }
    
    private void addLastNode(Node data ){
       
        if(this.size==0){
            this.head=data;
            this.tail=data;
            this.size++;
            return ;
        }
        this.tail.next=data;
        this.tail=data;
        this.size++;

    }
    public void addLast(int data){
        Node node= new Node(data);
        addLastNode(node);
    }
    public void display(){
        Node temp=this.head;
        while(temp!=null){
            System.out.print(temp.data+" - > " );
            temp=temp.next;
        }
        System.out.println("size is : "+this.size);
    }
    public Node removeFirstNode(){
       
        if(this.size==1){
            Node rem= this.head;
            this.head=null;
            this.tail=null;

            return rem;
        }
        else{
            Node rem= this.head;
            this.head=this.head.next;
            rem.next=null;
            return rem;
        }
    }
    public int  removeFirst()throws Exception{
        
        if(this.size==0){
            throw new Exception("Empty Linked list");
        }
       Node rem= removeFirstNode();
       this.size--;
        return rem.data;
    }
    public int removeAt (int idx)throws Exception{
        if(idx<0 || idx>=this.size )
            throw new Exception("Null pointer exception");
        Node rem=removeAtNode(idx);
        return rem.data;
    }

    public Node removeAtNode(int idx)
    {
        if(idx==0){
            return removeFirstNode();
        }else if(idx==this.size-1){
            return removeLastNode();

        }else{
                Node rem=getNodeAt(idx-1);
                Node temp= rem.next;
                rem.next=rem.next.next;
                this.size--;
                return temp;


        }
    }
    public Node removeLastNode(){
        if(this.size==1){
            Node rem = this.head;
            this.head=null;
            this.tail=null;
            this.size--;
            return rem;
        }
        Node temp = getNodeAt(this.size-2);
        Node rem=temp.next;
        temp.next=null;
        this.tail=temp;
        this.size--;
        return rem;
        
    }
    public Node getNodeAt(int idx){
        Node temp= this.head;
        while(idx-->0){
            temp=temp.next;
        }
        return temp;


    }
    public int  removeLast()throws Exception{

        if(this.size==0)
            throw new Exception("EmptyLinkedList");
        Node rem=removeLastNode();
        return rem.data;
    }
//   ************************SOLVING LEET PROBLEMS;
    public void segregateOddEve(){
        Node even=new Node(-1);
        Node eh=even;
        Node odd=new Node(-1);
        Node oh=odd;
        Node itr= this.head;
        while(itr!=null){

            if(itr.data%2==0){
                    Node temp=itr;
                    itr=itr.next;
                    temp.next=null;
                    even.next=temp;
                    even=even.next;
                    // System.out.println("added " +even.data+" in even "+itr.data);
            }else{
                    Node temp=itr;
                    itr=itr.next;
                    temp.next=null;
                    odd.next=temp;
                    odd=odd.next;
                    // System.out.println("added " +odd.data+" in odd "+itr.data);
            }
            
           
        }
        oh=oh.next;
            even.next=oh;
            eh=eh.next;
        display2(eh);
        // display2(oh);

        return ;
       
        
    }
    public void reverseLL(){
        Node itr=this.head;
        Node prev=null;

        while(itr!=null){
            Node curr= itr;
            itr=itr.next;
            curr.next=prev;
            prev=curr;
        }
        this.head=prev;
        
    }
    public void display2(Node node){
        Node temp=node;
        while(temp!=null){
            System.out.print(temp.data+" " );
            temp=temp.next;
        }
        System.out.println( );
    }
    public int midNode(){
        Node head=this.head;
        Node temp1=head;
        Node temp2=head;
        
        while(temp2!=null &&  temp2.next!=null){
            temp1=temp1.next;
            temp2=temp2.next.next;
        }
        return temp1.data;
    }



}

