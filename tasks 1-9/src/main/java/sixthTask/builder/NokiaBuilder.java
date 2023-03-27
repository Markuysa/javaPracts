package sixthTask.builder;

public class NokiaBuilder implements PhoneBuilder{

    private String battery;
    private String corpus;
    private String display;

    public NokiaBuilder() {
        super();
    }

    @Override
    public PhoneBuilder buildBattery() {
        System.out.println("Nokia battery built");
        this.battery = "Nokia battery";
        return this;
    }

    @Override
    public PhoneBuilder buildCorpus() {
        System.out.println("Nokia corpus built");
        this.corpus = "Nokia battery";
        return this;
    }

    @Override
    public PhoneBuilder buildDisplay() {
        System.out.println("Nokia display built");
        this.display = "Nokia display";
        return this;
    }

    @Override
    public Phone build() {
        System.out.println("Nokia battery built");
        return new Phone(battery,display,corpus);
    }
}
