package com.udacity.nd079.inheritance;

public class PersonTester {
    public static void main(String[] args) {
        Person p1 = new Person("pf", "pl");
        System.out.println(p1);

        Student s1 = new Student("Mike", "Thompson", "12345");
        System.out.println(s1);

        StudentEmployee se1 = new StudentEmployee("Jeff", "Sam", "4567", 20.5, "#12345");
        System.out.println(se1);
    }
}
