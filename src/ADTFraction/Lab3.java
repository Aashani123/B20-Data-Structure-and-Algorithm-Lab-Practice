package ADTFraction;

public class Lab3 {

    public static void main(String args[]) {
        ADTFraction a=new ADTFraction();
        a.display();
        ADTFraction assign=new ADTFraction(2,5);
        ADTFraction plusx=new ADTFraction(4,3);
        ADTFraction whole = plusx.plus(assign);
        whole.display();
        ADTFraction ti=assign.times(10);
        ti.refine();
        ti.display();

    }
}
class ADTFraction {
    private int n; //numerator
    private int d; //denomenator
    //---------------------------------------------------
    public ADTFraction() {//default constructor.Whjen we don't insert any value to the n and d automaticlly add these values;
        this.n=0;
        this.d=1; //bcz denomintr not equal to the 1;
    }
//---------------------------------------------------

    public ADTFraction(int a, int b) {//parameter constructor. when we insert values to the d and n;
        if(b!=0){
            this.d=b;
            this.n=a;
        }
        else{
            this.d=1;
            this.n=0;
            System.out.println("Assigning default values bcz given deno. is 0");
        }
    }
    //---------------------------------------------------
    public void set(int a, int b) {//set numerator and denomenator;
        if(b!=0){
            this.d=b;
            this.n=a;
        }
        else{
            System.out.println("Deno. can't be 0");
        }
    }
    //---------------------------------------------------
    public ADTFraction plus(ADTFraction x) {//add two fractions.we can use ADTFraction as return type bcz our output is also return fraction and x is also in that. this act as recursive function;
        int num,den;
        num=((this.d*x.n)+(this.n*x.d));
        den=(this.d*x.d);

        //we can define answer as ADTFraction object;
        ADTFraction answer=new ADTFraction(num,den);
        return answer;
    }
//---------------------------------------------------

    public ADTFraction times(int a) {//multiply fraction by a number
        int num,den;
        num=this.n*a;
        den=this.d;
        ADTFraction answer=new ADTFraction(num,den);
        return answer;
    }
    //---------------------------------------------------

    public ADTFraction times(ADTFraction x) {//multiply two fractions
        int num,den;
        num=this.n*x.n;
        den=this.d*x.d;
        ADTFraction answer=new ADTFraction(num,den);
        return answer;
    }

    //---------------------------------------------------
    public ADTFraction reciprocal() {//reciprocal of a fraction
        return new ADTFraction(this.d,this.n);
    }
    //---------------------------------------------------
    public float value() {//numerical value of a fraction
        return (float)this.n/this.d;

    }

    //---------------------------------------------------
    public void display() {//display the fraction in the format n/d
        System.out.println("Fraction: "+ this.n + "/" + this.d);
    }
//---------------------------------------------------

    public void refine() {//set the instance to its minimum fraction
        //For instance, if this fraction is 12/30, change it to 2/5. e kiynne anthim bgy wenknn bedn ek;
        int min;
        if(n<d){
            min=n;
        }
        else{
            min=d;
        }
        //now have to divide the n,d values from min and find the least fraction;
        for(int i=min;i>=2;i--){
            if((n%i==0) && (d%i==0)){
                n=n/i;
                d=d/i;
            }
        }
    }
}