package sixthTask;

import sixthTask.builder.Collector;
import sixthTask.builder.IphoneBuilder;
import sixthTask.builder.PhoneBuilder;
import sixthTask.fabric.Fabric;
import sixthTask.fabric.FabricEnums;
import sixthTask.fabric.Transport;

public class Main {
    public static void main(String[] args) {
        // fabric
        Fabric fabric = new Fabric();
        Transport transport = fabric.createTransport(FabricEnums.AIRPLANE);
        System.out.println(transport.getClass());

        // builder
        PhoneBuilder IphoneBuilder = new IphoneBuilder();
        Collector phoneCollector = new Collector(IphoneBuilder);
        phoneCollector.CollectPhone();


    }
}
