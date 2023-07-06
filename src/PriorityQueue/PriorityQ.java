package PriorityQueue;

public class PriorityQ{
    public static void main(String[] args) {
        priorityQueue pq=new priorityQueue();
        pq.enqueue(7,21,"Ashani","Kalawana");
        pq.enqueue(72,51,"Dhanuka","Kalawana");
        pq.enqueue(7,21,"Nehasni","Kalawana");
        pq.enqueue(7,21,"Sneha","Kalawana");
        pq.enqueue(7,21,"Ashi","Kalawana");
        pq.display();
        try{
            pq.dequeue();
            pq.display();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
//in this code lowest numbers has higher pririty;
class Patient{
    int patientNo;
    int age;
    String patientName;
    String address;
    Patient next;   //define who is the next pation;


    public Patient(int patientNo,int age,String patientName,String address){ //initialize the vlues;
        this.patientName=patientName;
        this.patientNo=patientNo;
        this.address=address;
        this.age=age;
        this.next=null;
    }
}
class priorityQueue {
    private Patient head;
    private Patient tail;
    public void enqueue(int patientNo, int age, String patientName, String address) {
        Patient newPation=new Patient(patientNo,age,patientName,address);
        Patient current=this.head;
        Patient previous=this.head;
        if(head==null){
            head=newPation;
            tail=newPation;
            return;
        }
        while(current!=null){
            if(patientNo<current.patientNo){
                if(current==head){
                    newPation.next=head;
                    head=newPation;
                    tail=head;
                    return;
                }
                previous.next=newPation;
                newPation.next=current;
                return;
            }
            previous=current;
            current=current.next;
            if(current==null){
                previous.next=newPation;
                tail=newPation;
                return;
            }
        }

    }
    public String dequeue() throws Exception {
        if(head==null){
            throw new Exception("Queue is empty");
        }
        String patientName=head.patientName;
        head=head.next;
        //head null nm tail null;
        if(head==null){
            tail=null;
        }
        return patientName;
    }
    public String peek() throws Exception {
        if(head==null){
            throw new Exception("Queue is empty");
        }
        return head.patientName;
    }
    public void display() {
        Patient current=head;
        while (current!=null){
            System.out.print(current.patientName+ " ");
            current=current.next;
        }
        System.out.println();
    }
}