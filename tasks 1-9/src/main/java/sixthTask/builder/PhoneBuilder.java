package sixthTask.builder;

public interface PhoneBuilder {
    PhoneBuilder buildBattery();
    PhoneBuilder buildCorpus();
    PhoneBuilder buildDisplay();
    Phone build();
}
