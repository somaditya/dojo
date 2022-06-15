package com.oreilly.hfjava.autoboxing;

public class TestBox {
    private Integer i;
    private int j;

    void go() {
        j = i;

        System.out.println(j);
        System.out.println(i);
    }

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }
}
