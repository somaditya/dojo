package com.oreilly.hfjava.sorting;

import java.math.BigDecimal;

public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String dept;
    private BigDecimal salary;

    public Employee(int id, String name, String dept, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) o;

        return this.id == other.getId() &&
                this.name.equals(other.getName()) &&
                this.dept.equals(other.getDept()) &&
                this.salary.equals(other.getSalary());
    }

    public String toString() {
        return "(Id: " + id + ", Name: " + name + ", Dept: " + dept + ", Salary: " + salary + ")";
    }

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.getName());
    }
}
