package sixthTask.fabric;

public class Fabric {

    public Transport createTransport(FabricEnums type){
        return switch (type) {
            case AIRPLANE -> new Airplane("some model");
            case CAR -> new Car("some model");
            default -> null;
        };
    }



}
