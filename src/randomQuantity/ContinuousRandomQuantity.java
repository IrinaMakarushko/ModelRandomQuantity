package randomQuantity;


import generator.Generator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ContinuousRandomQuantity {
    private Generator generator;
    private List<Double> values;
    private String fileName;

    public ContinuousRandomQuantity(Generator g){
        generator = g;
        values = new ArrayList<>();
        StringBuilder str = new StringBuilder("continuousRandomQuantity");
        str.append(generator.getModule());
        str.append(".txt");
        fileName = new String(str);
    }

    public void modelRandomQuantity(){
        if(generator!=null){
            List<Integer> list = generator.getValues();
            int module = generator.getModule();
            for(int a:list){
                values.add((double)a/module);
            }
        }
    }

    public void printResult(){
        System.out.println("Continuous random quantity. Generated values in "+fileName);
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

    public List<Double> getValues() {
        return values;
    }

    public double calculateElementaryMoment(int rank){
        return (double)1/(rank+1);
    }

    public double calculateCentralMoment(int rank){
        double result;
        result = Math.pow(0.5,rank+1)-Math.pow(-0.5,rank+1);
        result/=rank+1;
        return result;
    }

}
