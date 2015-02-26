package main;

import generator.CongruousGenerator;
import generator.MaklarenMarsalGenerator;
import randomQuantity.ContinuousRandomQuantity;
import randomQuantity.DiscreteRandomQuantity;

public class Main {
    public static void main(String[] args) {
        Constants constants = new Constants();
        CongruousGenerator generator1 = new CongruousGenerator(constants.aCongruous1,constants.cCongruous1,
                constants.mCongruous1,constants.x0Congruous1,constants.count);
        generator1.generate();
        generator1.print();

        CongruousGenerator generator2 = new CongruousGenerator(constants.aCongruous2,constants.cCongruous2,
                constants.mCongruous2,constants.x0Congruous2,constants.count);
        generator2.generate();
        generator2.print();

        MaklarenMarsalGenerator maklarenMarsalGenerator1 = new MaklarenMarsalGenerator(constants.k,generator1,generator2);
        maklarenMarsalGenerator1.generate();
        maklarenMarsalGenerator1.print();

        ContinuousRandomQuantity continuousRQ = new ContinuousRandomQuantity(generator1);
        continuousRQ.modelRandomQuantity();
        continuousRQ.printResult();

        DiscreteRandomQuantity discreteRQ = new DiscreteRandomQuantity(continuousRQ,constants.multitude012);
        discreteRQ.modelRandomQuantity();
        discreteRQ.printResult();

        System.out.println("Discrete central = "+discreteRQ.calculateCentralMoment(1)+" start = "+discreteRQ.calculateElementaryMoment(1));

        System.out.println("Continuous central = "+continuousRQ.calculateCentralMoment(2)+" start = "+continuousRQ.calculateElementaryMoment(2));
    }

}
