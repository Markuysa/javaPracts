package sixthTask.builder;

public class Collector {

    private PhoneBuilder phoneBuilder;

    public Collector(PhoneBuilder phoneBuilder) {
        super();
        this.phoneBuilder=phoneBuilder;
    }
    public Phone CollectPhone(){
        return phoneBuilder.buildBattery().buildCorpus().buildDisplay().build();
    }

}
