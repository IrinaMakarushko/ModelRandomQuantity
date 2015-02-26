package generator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CongruousGenerator implements Generator{
    private int a;  //multiplier
    private int c;  //increase
    private int m;  //module
    private int x0; //start value
    private int n;  //count of elements
    private List<Integer> values;
    private String fileName;

    public CongruousGenerator(int a, int c, int m, int x0, int n) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.x0 = x0;
        this.n = n;
        this.values = new ArrayList<>();
        StringBuilder str = new StringBuilder("congruousGenerator");
        str.append(m);
        str.append(".txt");
        fileName = new String(str);
    }

    @Override
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

    @Override
    public void print(){
        System.out.println("Parameters of congruous generator");
        System.out.println("a = "+a+" c = "+c+" m = "+m+" x0 = "+x0);
        System.out.println("Generated values in "+fileName);
        System.out.println();

        try(FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter writer= new PrintWriter(fileWriter)){

            for(int i=0;i<values.size();i++){
                writer.println("Z"+i+" = "+values.get(i));
            }
        }catch (IOException e){
            System.out.print(e.getMessage());
        }
    }

    @Override
    public int getModule() {
        return m;
    }

    @Override
    public List<Integer> getValues() {
        return values;
    }
}
