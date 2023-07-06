package LinkedList;

public class Lab5 {

    public static void main(String args[]) {
        LinkList l=new LinkList();
        l.insertFirst(13);
        l.insertFirst(24);
        l.insertFirst(9);
        l.insertFirst(31);
        l.displayList();
        Node findNode=l.find(1);
        findNode.displayNode();
        l.delete(2);
        l.displayList();

    }
}
class Node {
    int data;
    Node next;

    Node(int item) {
        this.data=item;
        this.next=null;
    }
    void displayNode() {
        System.out.println("data "+this.data);
    }
}

class LinkList {

    private Node head;

    public void LinkList() {
        head = null;
    }

    public boolean isEmpty() {
        //when head is null,then linklist is empty;
        return (head==null);
    }

    public void insertFirst(int i) {
        //first we have to call the node class;
        Node newNode=new Node(i);
        newNode.next=head; //here we assign a head pointer;
        head=newNode; //now head is in here;
    }

    public Node deleteFirst() {
        //first have to see whether the link list is empty;
        if(isEmpty()){
            System.out.println("List is empty");
            return null;
        }

        Node temp=this.head; //assign the expected dlted vlue to the temp.vrible;
        this.head=this.head.next;
        temp.next=null;
        return temp;

    }

    public void displayList() {
        if(isEmpty()){
            System.out.println("List is empty");
        }
        else{
            //now we have to store head node in vriable;
            Node current=this.head;
            while(current!=null){
                current.displayNode();
                current=current.next;
            }
            System.out.println();
        }
    }

    public Node find(int key) {
        //To find expected vlue,we have to go from head;
        Node current=head;
        int count=1;
        while(current!=null){
            if(count==key){
                return current;
            }
            current=current.next;
            count++;
        }
        System.out.println("Key value out of linklist");
        return null;
    }

    public void delete(int key) {
        Node current,pre; //declare vribles for curnt node and previous node;
        //these both initially assign to the head;
        current=this.head;
        pre=this.head;
        int count=1;

        while(current!= null){
            if(count==key){
                if(key==1){
                    head=head.next;
                }
                else{
                    pre.next=current.next;
                }
                return;
            }
            pre=current;
            current=current.next;
            count++;
        }
        System.out.println("Item not availble");
    }
}
