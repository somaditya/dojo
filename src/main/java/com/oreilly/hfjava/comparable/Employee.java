package com.oreilly.hfjava.comparable;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
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
}
