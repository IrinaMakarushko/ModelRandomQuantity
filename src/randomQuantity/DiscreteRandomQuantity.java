package randomQuantity;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DiscreteRandomQuantity {
    private ContinuousRandomQuantity continuousRQ;
    private List<Integer> values;
    private List<Integer> multitude;
    private String fileName;

    public DiscreteRandomQuantity(ContinuousRandomQuantity g,List<Integer> m){
        continuousRQ = g;
        multitude = m;
        values = new ArrayList<>();
        StringBuilder str = new StringBuilder("DiscreteRandomQuantity");
        str.append(m.size());
        str.append(continuousRQ.getClass());
        str.append(".txt");
        fileName = new String(str);
    }

    public void modelRandomQuantity(){
        if(continuousRQ!=null){
            List<Double> list = continuousRQ.getValues();
            double probability = (double) 1/multitude.size();
            int temp;
            for(double a:list) {
                for(int j=0;j<multitude.size();j++){
                    temp = multitude.get(j);
                    if(a>=probability*j && a<(probability*(j+1))){
                        values.add(temp);
                        break;
                    }
                }
            }
        }
    }

    public void printResult(){
        System.out.println("Discrete random quantity. Generated values in "+fileName);
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


    public double calculateElementaryMoment(int rank){
        double result = 0;
        for(int a:multitude){
            result+=Math.pow(a,rank);
        }
        result/=multitude.size();
        return result;
    }

    public double calculateCentralMoment(int rank){
        double result = 0;
        double elementaryMoment = calculateElementaryMoment(1);
        for(int a:multitude){
            result+=Math.pow(a - elementaryMoment,rank);
        }
        result/=multitude.size();
        return result;
    }

}
