package sixthTask.builder;

public class SamsungBuilder implements PhoneBuilder{

    private String battery;
    private String corpus;
    private String display;

    public SamsungBuilder() {
        super();
    }

    @Override
    public PhoneBuilder buildBattery() {
        System.out.println("Samsung battery built");
        this.battery = "Samsung battery";
        return this;
    }

    @Override
    public PhoneBuilder buildCorpus() {
        System.out.println("Samsung corpus built");
        this.corpus = "Samsung battery";
        return this;
    }

    @Override
    public PhoneBuilder buildDisplay() {
        System.out.println("Samsung display built");
        this.display = "Samsung display";
        return this;
    }

    @Override
    public Phone build() {
        System.out.println("Samsung built");
        return new Phone(battery,display,corpus);
    }
}
