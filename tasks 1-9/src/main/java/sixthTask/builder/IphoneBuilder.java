package sixthTask.builder;

public class IphoneBuilder implements PhoneBuilder{


    private String battery;
    private String corpus;
    private String display;

    public IphoneBuilder() {
        super();
    }

    @Override
    public PhoneBuilder buildBattery() {
        System.out.println("Iphone battery built");
        this.battery = "Iphone battery";
        return this;
    }

    @Override
    public PhoneBuilder buildCorpus() {
        System.out.println("Iphone corpus built");
        this.corpus = "Iphone battery";
        return this;
    }

    @Override
    public PhoneBuilder buildDisplay() {
        System.out.println("Iphone display built");
        this.display = "Iphone display";
        return this;
    }

    @Override
    public Phone build() {
        System.out.println("Iphone built");
        return new Phone(battery,display,corpus);
    }
}
