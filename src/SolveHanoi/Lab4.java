package SolveHanoi;

public class Lab4 {

    public static void main(String args[]) {
        Lab4 l=new Lab4();
        System.out.println(l.sumOf(5));
        System.out.println(l.mulOf(5));
        System.out.println(l.twoMul(5,2));
        System.out.println(l.fibo(8));
        l.solveHanoi(4, 'A','B', 'C');



    }

    int sumOf(int n){
        //this is recursive fun. for get summation of input;
        if(n==1){
            return 1;
        }
        else{
            return n+ sumOf(n-1);
        }
    }

    int mulOf(int n){
        //here we use this as recursive fun. for take multiplication of given input;
        if(n==1){
            return 1;
        }
        else{
            return n* mulOf(n-1);
        }
    }

    int twoMul(int m,int n){ //n*m; consider n is varying with constant m;
        if(n==1){
            return m;
        }
        else{
            return m+twoMul(m,n-1); //this mean,consider 5. when we give 5 and 2 in this bracket. 5 is m and 2 is n.
        }
    }

    int fibo(int n){
        //when w want to find fibonacci we have to add previous two elements together;
        if(n==0){
            return n;
        }
        if(n==1){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }

    //Solve Hanoi;
    public void solveHanoi(int n,char a,char b,char c){
        if(n==0){
            return;
        }
        else{
            solveHanoi(n-1,a,c,b);
            System.out.println("Move plate "+n+" from "+a+" to "+c);
            solveHanoi(n-1,b,a,c);

        }
    }
}

