package OrderedArray;

public class Lab2 {

    public static void main(String args[]) {
        OrdArray a=new OrdArray(10);
        a.insert(5);
        a.insert(45);
        a.insert(54);
        a.insert(59);
        a.insert(415);
        a.insert(25);
        a.insert(56);
        a.display();
        a.delete(5);
        a.display();
        int index=a.find(59);
        System.out.println(" can be found in "+index);
    }
}
class OrdArray{
    private long[] arr;
    private int nEl;

    //build constructor;
    public OrdArray(int max){
        this.arr=new long[max];
        this.nEl=0;
    }
    public int size(){
        return arr.length;
    }

    public int find(long sKey){
        for(int i=0;i<this.nEl;i++){
            if(arr[i]==sKey){
                return i;
            }
        }
        return -1;
    }

    public void insert(long value){
        //first have to check array is full;
        if(this.nEl==size()){
            System.out.println("Array is full");
            return;
        }
        //have to check where we have to place inserted value;
        for(int i=0;i<this.nEl;i++){
            if(arr[i]>value){
                for(int j=this.nEl;j>i;j--)
                {
                    arr[j]=arr[j-1];
                }
                //now can be insert our value to the expected place
                arr[i]=value;
                this.nEl++; //increment no of element from 1.;
                return;
            }
        }
        //we have to add values manually;
        arr[nEl]=value;
        nEl++;
    }

    public boolean delete(long value){
        boolean st=false;

        //search whether the array is emptey or not;
        if(this.nEl==0){
            System.out.println("Array is empty");
        }
        else{
            for(int i=0;i<nEl;i++){
                if(arr[i]==value){
                    for(int j=i;j<nEl-1;j++){
                        arr[j]=arr[j+1];
                    }
                    nEl--;
                    i--;
                    st= true;
                }
            }
        }
        return st;
    }

    void display(){
        if(nEl==0){System.out.println("Array is empty");
            return;
        }

        for(int i=0;i<nEl;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
