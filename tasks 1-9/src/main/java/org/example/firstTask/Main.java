package org.example.firstTask;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(10));
        students.add(new Student(20));

        students.add(new Student(30));

        students.add(new Student(100));


        Implemented implemented = new Implemented();
        boolean flag = true;
        for (int i=0;i<students.size();i++){
            if (!implemented.test(students.get(i))) {
                 flag = false;
            }else{
                flag = true;
            }
            }
            System.out.println(flag);
        }



}


