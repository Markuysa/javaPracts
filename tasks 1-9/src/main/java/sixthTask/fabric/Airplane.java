package sixthTask.fabric;

public class Airplane extends Transport{

    private String model;

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public Airplane(String model) {
        this.model = model;
    }
}
