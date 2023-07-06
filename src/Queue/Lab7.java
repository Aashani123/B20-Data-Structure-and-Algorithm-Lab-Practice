package Queue;

import java.sql.SQLOutput;

public class Lab7 {
    public static void main(String[] args) {
        QueueArray q=new QueueArray(7);
        q.enqueue(7);
        q.enqueue(47);
        q.enqueue(71);
        q.enqueue(72);
        q.enqueue(75);
        q.enqueue(57);
        q.display();
        try{
            q.dequeue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        q.display();

    }


}
class QueueArray{
    private int maxSize;
    private int[] queArray;
    private int front; //ending
    private int rear; //starting position
    private int nItems; //no. of items that are in queue;

    public QueueArray(int s){
        this.rear=-1;
        this.front=0;
        this.maxSize=s;
        this.queArray=new int[s];
        this.nItems=0;
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - // ...
    //when array is full we can insert new elements to the front nodes. So queue is act as circular queue;
    // Then rear going to the 0th position;
    public boolean isEmpty(){
        if(nItems==0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(nItems==maxSize){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){ //it shows how many elements in the array;
        return this.nItems;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (rear == maxSize - 1) {
            this.rear = 0;
        } else {
            this.rear++;}

        this.queArray[rear] = value;
        nItems++;
        System.out.println("value inserted");
    }

    public int dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("can't dequeue");
        }
        int temp=this.queArray[front];
        if(this.front==this.maxSize-1){
            this.front=0;
        }
        else {
            this.front++;
        }
        this.nItems--;
        System.out.println("item removed");
        return temp;
    }

    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("can't peek,array is empty");
        }

        return this.queArray[front];
    }


    public void display(){
        int i=this.front;
        while(i!=rear) {
            System.out.print(this.queArray[i]+" ");
            if (i == maxSize - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        System.out.print(this.queArray[this.rear]+" ");
    }
}
