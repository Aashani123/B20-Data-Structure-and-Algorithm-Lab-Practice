package Stack;

public class Lab6{
    public static void main(String[] args) throws MyStackEmptyException{
        StackArray sa = new StackArray(7);
        sa.push(2);
        sa.push(9);
        sa.push(3);
        sa.push(4);
        sa.push(15);
        sa.display();
        int x;
        try{
            x = sa.pop();
            x = sa.pop();
            x = sa.pop();
            x = sa.pop();
            x = sa.pop();
            x = sa.pop();
        }catch (MyStackEmptyException e){
            System.out.println("Error: " + e);
        }
        sa.display();
        Lab6 l = new Lab6();
        l.conversion(356778934);
    }

    public void conversion(int no){
        int temp = no;
        int count = 0;
        while(temp != 0) {
            temp = temp / 2;
            count++;
        }
        StackArray sa = new StackArray(count);
        temp = no;
        while(temp != 0) {
            int x = temp % 2;
            sa.push(x);
            temp = temp / 2;
        }

        while (!sa.isEmpty()){
            int x;
            try{
                x = sa.pop();
                System.out.print(x);
            }catch (MyStackEmptyException e){
                System.out.println(e);
            }
        }
        System.out.println(" ");
    }
}

class StackArray {
    private int maxSize; //size of stack array
    private int[] stackData;
    private int top; //top of stack
    // -------------------------------------------------------------------------

    public StackArray(int s) {
        this.maxSize = s;
        this.stackData = new int[s];
        this.top = -1;
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }

    public void push(int item) {
        if (isFull()){
            System.out.println("Stack is full, cannot push.");

        }else{
            this.stackData[this.top+1]=item;
            this.top++;
        }

    }

    public int pop() throws MyStackEmptyException{
        if(isEmpty()){
            throw new MyStackEmptyException("Stack is empty, cannot pop");
        } else{
            return this.stackData[top--];
        }
    }

    public int peek() throws MyStackEmptyException{
        if(isEmpty()){
            throw new MyStackEmptyException("Stack is empty, cannot peek");
        } else{
            return this.stackData[top];
        }
    }

    public void display() {
        if(isEmpty()){
            System.out.println("Stack is empty, nothing to display.");
        }
        for(int i=0; i<=this.top; i++){
            System.out.print(this.stackData[i] + " ");
        }
        System.out.println();
    }
} //end class StackArray

class MyStackEmptyException extends Exception{
    MyStackEmptyException(String msg){
        super(msg);
    }
}





//----------------------------This is the Number Convert to Binary Stack--------------------------------------------------------


//public class StackWithConversion {
//    public static void main(String[] args) throws Exception {
//        Stacks s = new Stacks(6);
//        s.push(4);
//        s.push(54);
//        s.push(42);
//        s.push(41);
//        s.push(244);
//        s.push(64);
//        s.display();
//        int x;
//        try {
//            x = s.pop();
//            x = s.peek();
//            x=s.peek();
//            s.display();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        s.display();
//
//        StackWithConversion st=new StackWithConversion();
//        st.conversion(50);
//    }
//
//    public static void conversion(int no){//this no is our enterd value;
//        int temp;
//        int count=0;
//        temp=no; //bcz we have to get no vlue to the dividing moduling;
//
//        //first have to identify size of the binary number;
//        while(temp!=0){
//            temp=temp/2;
//            count++;
//        }
//        //now we have to call to the Stacks class;
//        Stacks s=new Stacks(count);
//        temp=no;
//        //now we have to push moduling values;
//        while(temp!=0){
//            int x; //this use to store modulling vlues;
//            x=temp%2;
//            //we have to push x vlue to the stack;
//            s.push(x);
//            temp=temp/2;
//        }
//
//        //now have to pop that stack vlues;
//        while(!s.isEmpty()){
//            int x;
//            try{
//                x=s.pop();
//                System.out.print(x);
//            }catch(Exception e){
//                System.out.println(e);
//            }
//        }
//        System.out.println(" ");
//    }
//}
//
//
//
//class Stacks {
//    private int maxSize; //size of stack array
//    private int[] stackData;
//    private int top; //top of stack
//    //-------------------------------------------------------------------------
//    public Stacks(int s) {
//        this.stackData=new int[s];
//        this.maxSize=s;
//        this.top=-1;
//    }
//    public boolean isEmpty() {
//        if(this.top==-1){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//    public boolean isFull() {
//        if(this.top==maxSize-1){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//    public void push(int item) {
//        if(isFull()){
//            System.out.println("Stack is full");
//        }
//        else{
//            this.stackData[top+1]=item;
//            this.top++;
//        }
//    }
//    public int pop() throws Exception {
//        if(isEmpty()){
//            throw new Exception("Stack is empty");
//        }
//        else{
//            return this.stackData[top--];
//        }
//    }
//    public int peek() throws Exception{
//        if(isEmpty()){
//            throw new Exception("Stack is empty");
//        }
//        else{
//            int newTop=pop();
//            push(newTop);
//            return newTop;
//        }
//    }
//    public void display() {
//        if(isEmpty()){
//            System.out.println("Stack is empty");
//        }
//        else{
//            for(int i=0;i<=this.top;i++){
//                System.out.print(this.stackData[i]+" ");
//            }
//            System.out.println();
//        }
//    }
//} //end class StackArray
