package edu.gatech.cs1331.hw05;

public class Gameplay {

    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut suspiciousPerson = new RedAstronaut("Suspicious Person", 100, "expert");

        //1
        liam.sabotage(bob);
        System.out.println(bob);

        //2
        liam.freeze(suspiciousPerson);

        //3
        liam.freeze(albert);
        System.out.println(liam);
        System.out.println(albert);

        //4
        albert.emergencyMeeting();

        //5
        suspiciousPerson.emergencyMeeting();
        System.out.println(bob);
        System.out.println(heath);

        //6
        bob.emergencyMeeting();
        System.out.println(suspiciousPerson);

        //7
        heath.completeTask();
        System.out.println(heath);

        //8
        heath.completeTask();
        System.out.println(heath);

        //9
        heath.completeTask();

        //10
        liam.freeze(angel);
        System.out.println(angel);
        System.out.println(liam);

        //11
        for (int i = 0; i < 2; i++) {
            liam.sabotage(bob);
            System.out.println(bob);
        }

        //12
        liam.freeze(bob);
        System.out.println(bob);

        //13
        angel.emergencyMeeting();
        System.out.println(liam);

        //14
        for (int i = 0; i < 5; i++) {
            liam.sabotage(heath);
            System.out.println(heath);
        }

        //15
        liam.freeze(heath);
        System.out.println(heath);
    }
}