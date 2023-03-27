package seventhTask;


interface Airplane {
    void start();
    void stop();
}
class Engine implements Airplane {
    public void start() {
        System.out.println("Запустить двигатель");
    }
    public void stop() {
        System.out.println("Остановить двигатель");
    }
}
class AirStarter implements Airplane {
    public void start() {
        System.out.println("Запустить самолет");
    }
    public void stop() {
        System.out.println("Остановить самолет");
    }
}
class Stabilizer implements Airplane {
    public void start() {
        System.out.println("Запустить стабилизатор");
    }
    public void stop() {
        System.out.println("Остановить сабилизатор");
    }
}
class Facade {
    private Stabilizer stabilizer;
    private Engine engine;

    private AirStarter airStarter;

    public Facade() {
        stabilizer = new Stabilizer();
        engine = new Engine();
        airStarter = new AirStarter();
    }
    public void startCar() {
        stabilizer.start();
        engine.start();
        airStarter.start();
    }
    public void stoptCar() {
        stabilizer.stop();
        engine.stop();
        airStarter.stop();
    }
}

public class FacadePattern {//тест
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.startCar();
        System.out.println();
        facade.stoptCar();
    }
}