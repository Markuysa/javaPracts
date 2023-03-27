package seventhTask;

interface Signal {
    void send();
}
class RealSignal implements Signal {
    private String signal;
    public RealSignal(String file){
        this.signal = file;
        setSignal(file);
    }
    private void setSignal(String file){
        System.out.println("Загрузка " + signal+"...");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    public void send() {
        System.out.println("Отправка " + signal+"...");
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class ProxySignal implements Signal {
    private String proxySignal;
    private RealSignal realSignal;
    public ProxySignal(String signal){
        this.proxySignal = signal;
    }
    public void send() {
        if(realSignal == null){
            realSignal = new RealSignal(proxySignal);
        }
        realSignal.send();
    }
}

public class ProxyPattern {//тест
    public static void main(String[] args) {
        Signal signal = new ProxySignal("WARNING");
        signal.send();
        signal.send();
    }
}
