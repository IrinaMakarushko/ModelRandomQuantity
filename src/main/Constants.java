package main;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public int count = 1530;

    public int aCongruous1 = 4;
    public int cCongruous1 = 16;
    public int mCongruous1 = 480 ;
    public int x0Congruous1 = 1 ;

    public int aCongruous2 = 3;
    public int cCongruous2 = 10;
    public int mCongruous2 = 1029;
    public int x0Congruous2 = 1;

    public int k = 64;

    public List<Integer> multitude01;
    public List<Integer> multitude012;
    public List<Integer> multitude0123;

    public Constants(){
        multitude01 = new ArrayList<>();
        multitude01.add(0);
        multitude01.add(1);

        multitude012 = new ArrayList<>();
        multitude012.add(0);
        multitude012.add(1);
        multitude012.add(2);

        multitude0123 = new ArrayList<>();
        multitude0123.add(0);
        multitude0123.add(1);
        multitude0123.add(2);
        multitude0123.add(3);
    }
}
