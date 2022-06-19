package com.oreilly.hfjava.sorting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmployeeTest {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Jon Doe", "HR", new BigDecimal("50000")));
        employees.add(new Employee(2, "Mary Jane", "Fin", new BigDecimal("90000")));
        employees.add(new Employee(3, "Anne Marie", "IT", new BigDecimal("80000")));
        employees.add(new Employee(4, "Halsey", "IT", new BigDecimal("70000")));
        employees.add(new Employee(5, "Dua Lipa", "HR", new BigDecimal("60000")));

        System.out.println(employees);

        //Collections.sort(employees);
        //System.out.println(employees);

        //SalaryDescComparator salComp = new SalaryDescComparator();
        //employees.sort(salComp);
        //System.out.println(employees);

        employees.sort(Comparator.comparing(Employee::getDept));
        System.out.println(employees);
    }
}