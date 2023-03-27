package sixthTask.Prototype;


public class Prototype implements Cloneable {
    public void print() {
        System.out.println("New packing");
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}
