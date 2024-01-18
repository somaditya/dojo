package edu.gatech.cs1331.hw04;

public class Pond {
    public static void main(String[] args) {
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6);
        Frog anyName = new Frog("Any Name", 10, 10);

        Fly oneMass = new Fly(1, 3);
        Fly sixMass = new Fly(6);
        Fly flyAny = new Fly(10, 10);

        Frog.setSpecies("1331 Frogs");

        System.out.println(peepo);

        peepo.eat(sixMass);

        System.out.println(sixMass);

        peepo.grow(8);

        peepo.eat(sixMass);

        System.out.println(sixMass);

        System.out.println(peepo);

        System.out.println(anyName);

        peepaw.grow(4);

        System.out.println(peepaw);

        System.out.println(pepe);
    }
}
