package main;

import generator.CongruousGenerator;
import generator.MaklarenMarsalGenerator;

public class Main {
    public static void main(String[] args) {
        CongruousGenerator generator1 = new CongruousGenerator(4,16,480,1,65);
        generator1.generate();
        generator1.print();

        CongruousGenerator generator2 = new CongruousGenerator(3,10,1029,1,65);
        generator2.generate();
        generator2.print();

        MaklarenMarsalGenerator maklarenMarsalGenerator1 = new MaklarenMarsalGenerator(64,generator1,generator2);
        maklarenMarsalGenerator1.generate();
        maklarenMarsalGenerator1.print();
    }

}
