package generator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MaklarenMarsalGenerator implements Generator {
    private CongruousGenerator generatorX;
    private CongruousGenerator generatorY;
    private List<Integer> matrixV;
    private List<Integer> resultList;
    private int sizeOfMatrixV;
    private String fileName;

    public MaklarenMarsalGenerator(int k,CongruousGenerator g1,CongruousGenerator g2) {
        sizeOfMatrixV = k;
        generatorX = g1;
        generatorY = g2;
        matrixV = new ArrayList<>(sizeOfMatrixV);
        resultList = new ArrayList<>();
        StringBuilder str = new StringBuilder("MaklarenMarsalGenerator");
        str.append(generatorX.getModule());
        str.append(".txt");
        fileName = new String(str);
    }

    public void init(){
        if(generatorX.getValues().isEmpty()){
            generatorX.generate();
        }
        if(generatorY.getValues().isEmpty()){
            generatorY.generate();
        }
        List<Integer> list = generatorX.getValues();
        int temp;
        for(int i = 0; i< sizeOfMatrixV;i++){
            temp = list.get(i);
            matrixV.add(temp);
            resultList.add(temp);
        }
    }

    @Override
    public void generate(){
        init();
        int j;
        int Xi;
        int Yi;
        int m = generatorY.getModule();
        List<Integer> listX = generatorX.getValues();
        List<Integer> listY = generatorY.getValues();
        for(int i = 0; i <listX.size();i++){
            Xi = listX.get(i);
            Yi = listY.get(i);
            j = (sizeOfMatrixV*Yi/m);
            resultList.add(j, matrixV.get(j));
            matrixV.add(j,Xi);
        }
    }

    @Override
    public void print(){
        System.out.println("MaklarenMarsal generator");
        System.out.println("Generated values in "+fileName);
        System.out.println();

        try(FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter writer= new PrintWriter(fileWriter)){

            for(int i=0;i<resultList.size();i++){
                writer.println("Z"+i+" = "+resultList.get(i));
            }
        }catch (IOException e){
            System.out.print(e.getMessage());
        }
    }

    @Override
    public int getModule() {
        return generatorX.getModule();
    }

    @Override
    public List<Integer> getValues() {
        return resultList;
    }
}
