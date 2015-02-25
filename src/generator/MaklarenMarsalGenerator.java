package generator;

import java.util.ArrayList;
import java.util.List;

public class MaklarenMarsalGenerator {
    private CongruousGenerator generatorX;
    private CongruousGenerator generatorY;
    private List<Integer> matrixV;
    private List<Integer> resultMatrix;
    private int sizeOfMatrixV;
    private int countOfElements;

    public MaklarenMarsalGenerator(int k,CongruousGenerator g1,CongruousGenerator g2) {
        sizeOfMatrixV = k;
        generatorX = g1;
        generatorY = g2;
        matrixV = new ArrayList<Integer>(sizeOfMatrixV);
        resultMatrix = new ArrayList<Integer>();
    }

    public void init(){
        if(generatorX.getValues().isEmpty()){
            generatorX.generate();
        }
        if(generatorY.getValues().isEmpty()){
            generatorY.generate();
        }
        List<Integer> list = generatorX.getValues();
        int temp = 0;
        for(int i = 0; i< sizeOfMatrixV;i++){
            temp = list.get(i);
            matrixV.add(temp);
            resultMatrix.add(temp);
        }
    }
    public void generate(){
        init();
        int j;
        int Xi;
        int Yi;
        int m = generatorY.getM();
        List<Integer> listX = generatorX.getValues();
        List<Integer> listY = generatorY.getValues();
        for(int i = 0; i <countOfElements;i++){
            Xi = listX.get(i);
            Yi = listY.get(i);
            j = (sizeOfMatrixV*Yi/m);
            resultMatrix.add(j,matrixV.get(j));
            matrixV.add(j,Xi);
        }
    }

    public void print(){
        System.out.println("Parameters of MaklarenMarsal generator");

        System.out.println("Generated values");
        System.out.println("***************************************************************");
        for(int a:resultMatrix){
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("***************************************************************");
        System.out.println();
    }


    public int getCountOfElements() {
        return countOfElements;
    }

    public void setCountOfElements(int countOfElements) {
        this.countOfElements = countOfElements;
    }

    public List<Integer> getResultMatrix() {
        return resultMatrix;
    }

    public void setResultMatrix(List<Integer> resultMatrix) {
        this.resultMatrix = resultMatrix;
    }

    public CongruousGenerator getGeneratorX() {
        return generatorX;
    }

    public void setGeneratorX(CongruousGenerator generatorX) {
        this.generatorX = generatorX;
    }

    public CongruousGenerator getGeneratorY() {
        return generatorY;
    }

    public void setGeneratorY(CongruousGenerator generatorY) {
        this.generatorY = generatorY;
    }

    public List<Integer> getMatrixV() {
        return matrixV;
    }

    public void setMatrixV(List<Integer> matrixV) {
        this.matrixV = matrixV;
    }

    public int getSizeOfMatrixV() {
        return sizeOfMatrixV;
    }

    public void setSizeOfMatrixV(int sizeOfMatrixV) {
        this.sizeOfMatrixV = sizeOfMatrixV;
    }
}
