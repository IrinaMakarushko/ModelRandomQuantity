package generator;

import java.util.ArrayList;
import java.util.List;

public class CongruousGenerator {
    private int a;  //multiplier
    private int c;  //increase
    private int m;  //module
    private int x0; //start value
    private int n;  //count of elements
    private List<Integer> values;

    public CongruousGenerator(int a, int c, int m, int x0, int n) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.x0 = x0;
        this.n = n;
        this.values = new ArrayList<Integer>();
    }

    public void generate(){
        int nextValue;
        int prevValue = x0;
        values.add(x0);
        for(int i = 0; i < n-1 ;i++){
            nextValue = (a*prevValue+c)%m;
            values.add(nextValue);
            prevValue = nextValue;
        }
    }

    public void print(){
        System.out.println("Parameters of congruous generator");
        System.out.println("a = "+a+" c = "+c+" m = "+m+" x0 = "+x0);
        System.out.println("Generated values");
        System.out.println("***************************************************************");
        for(int a:values){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("***************************************************************");
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
