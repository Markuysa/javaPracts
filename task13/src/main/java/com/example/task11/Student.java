package com.example.task11;

public class Student {
    private String name;
    private String lastName;
    private String group;

    public Student(String name, String lastName, String group) {
        this.name = name;
        this.lastName = lastName;
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }
}
