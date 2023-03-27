package eighthTask;

interface IteratorInter {
    boolean hasNext();
    Object next();
}
class Collection {
    public int num[] = {1 , 2, 3};
    public IteratorInter getIterator() {
        return new NumbersIterator();
    }
    private class NumbersIterator implements IteratorInter {
        int ind;
        public boolean hasNext() {
            if(ind < num.length) return true;
            return false;
        }
        public Object next() {
            if(this.hasNext()) return num[ind++];
            return null;
        }
    }
}

public class Iterator{//тест
    public static void main(String[] args) {
        Collection numbers = new Collection();
        IteratorInter iterator = numbers.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}