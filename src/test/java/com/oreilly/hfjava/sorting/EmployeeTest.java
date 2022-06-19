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

        //SalaryDescComparator salComp = new SalaryDescComparator();
        //employees.sort(salComp);

        //employees.sort((e1, e2) -> e1.getSalary().subtract(e2.getSalary()).intValue());
        //employees.sort(Comparator.comparing(Employee::getDept));

        //System.out.println(employees);

        List<Employee> result = employees.stream()
                .distinct()
                .filter(e -> e.getSalary().subtract(new BigDecimal("50000")).doubleValue() > 0.00)
                .limit(3)
                .skip(1)
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();

        System.out.println(result);
    }
}