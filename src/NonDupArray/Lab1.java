package NonDupArray;//Non-Duplicate Array

public class Lab1 {

    public static void main(String[] args) {
        Non_Dup_Arr n=new Non_Dup_Arr(10);
        n.insert(4);
        n.insert(8);
        n.insert(9);
        n.insert(6);
        n.insert(7);
        n.insert(87);
        n.insert(47);
        n.insert(75);
        n.insert(76);
        n.insert(74);
        n.display();
    }

}
class Non_Dup_Arr{
    //first define array and elements that are already in array;
    private long[] arr;
    private int arrEl;

    //now we have to initialize that values by using constructor. this is cons. that haven't return type;
    public Non_Dup_Arr(int max){
        this.arr=new long[max];
        this.arrEl=0;
    }

    //now we have to find the value that we going to insert are alredy in array or not;
    public boolean find(long sKey){
        //we have to go around array and search;
        for(int i=0;i<this.arrEl;i++){
            if(this.arr[i]==sKey){
                return true;
            }
        }
        return false;
    }

    public void insert(long value){
        //first we have to check array is full or not;
        if(this.arrEl==arr.length){
            System.out.print("Array is full");
            return;
        }
        //first we have to check our entered valuew is alrady in array.So call find();
        if(find(value)){
            System.out.println("Value duplicated");
        }
        else{
            //when this status false that mean we can insert value;
            this.arr[this.arrEl]=value;
            this.arrEl++;
            System.out.println("Value inserted");
        }
    }

    //when we want to delete element, we have to shift others to the front
    public boolean delete(long value){
        for(int i=0;i<this.arrEl;i++){
            //first check our expected value is in array or not;
            if(this.arr[i]==value){
                //when it equal to the value, then we have to shift other values to the front;
                for(int j=i;j<this.arrEl-1;j++){
                    //now shift values;
                    this.arr[j]=this.arr[j+1];
                }
                this.arrEl--;
                System.out.println("Value Deleted");
                return true;
            }
        }
        System.out.println("Value not found");
        return false;
    }

    public void display(){
        for(int i=0;i<this.arrEl;i++){
            System.out.print(this.arr[i]+" ");

        }
        System.out.print("");
    }
}
