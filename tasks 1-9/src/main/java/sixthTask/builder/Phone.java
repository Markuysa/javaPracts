package sixthTask.builder;

public class Phone {
    private String battery;
    private String display;
    private String corpus;

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }

    public String getBattery() {
        return battery;
    }

    public String getDisplay() {
        return display;
    }

    public String getCorpus() {
        return corpus;
    }

    public Phone(String battery, String display, String corpus) {
        this.battery = battery;
        this.display = display;
        this.corpus = corpus;
    }

}
