package org.example.firstTask;

import java.util.function.Predicate;

public class Implemented implements Predicate<Student> {

    @Override
    public boolean test(Student student) {
        return student.getScore() == 100;
    }

    @Override
    public Predicate<Student> and(Predicate<? super Student> other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate<Student> negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate<Student> or(Predicate<? super Student> other) {
        return Predicate.super.or(other);
    }
}
