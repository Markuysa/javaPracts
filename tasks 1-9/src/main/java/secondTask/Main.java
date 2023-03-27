package secondTask;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();

        humans.add(new Human(10,"andrey","petrov", LocalDate.of(2013,4,6),54));
        humans.add(new Human(123,"andrey","alexeev", LocalDate.of(2011,4,6),40));
        humans.add(new Human(13,"sergey","petrov", LocalDate.of(2010,4,6),54));
        humans.add(new Human(14,"pakal","alexeev", LocalDate.of(2009,4,6),40));

        Stream<Human> stream = humans.stream();

        Stream newstream = stream.sorted((h1, h2)->{
            return h1.lastName.charAt(h1.firstName.length()-1) - h2.lastName.charAt(h2.firstName.length()-1);
        });
        newstream.forEach(h->{System.out.println(h.toString());});
        System.out.println("\n");
        Stream<Human> stream2 = humans.stream();
        Stream newstream2 = stream2.filter(human -> {
            return human.age > human.weight;
        });

        Stream<Human> stream3 = humans.stream();
        newstream2.forEach(h->{System.out.println(h.toString());});
        System.out.println("\n");
        Stream newStream3 = stream3.sorted((h1,h2)->{
            return h1.birthDate.compareTo(h2.birthDate);
        });
        newStream3.forEach(h->{System.out.println(h.toString());});
        Stream<Human> stream4 = humans.stream();
        int newStream4 = stream4.mapToInt(h->h.age).reduce(1, (a, b) ->  a * b);
        System.out.println(newStream4);


    }

}
