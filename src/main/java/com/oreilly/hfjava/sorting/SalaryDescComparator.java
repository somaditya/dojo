package com.oreilly.hfjava.sorting;

import java.util.Comparator;

public class SalaryDescComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getSalary().subtract(o1.getSalary()).intValue();
    }
}
