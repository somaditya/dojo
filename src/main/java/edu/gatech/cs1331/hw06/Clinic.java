package edu.gatech.cs1331.hw06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Clinic {
    private File patienFile;
    private int day;

    public Clinic(File file) {
        patienFile = file;
        day = 1;
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    public String nextDay(File f) throws FileNotFoundException {
        day++;

        String out = "";

        Scanner fileScan = new Scanner(f);
        Scanner input = new Scanner(System.in);
        String line = null;

        while (fileScan.hasNextLine()) {
            line = fileScan.nextLine();
            String[] pInfo = line.split(",");
            String name = pInfo[0];
            String species = pInfo[1];
            String stat = pInfo[2];
            String timeIn = pInfo[3];

            if (!(species.equals("Dog") || species.equals("Cat"))) {
                throw new InvalidPetException();
            }

            System.out.printf("Consultation for %s the %s at %s.\n",
                    name, species, timeIn);

            double health = 0;
            int painLevel = 0;
            boolean validHealth = false;
            boolean validPain = false;

            while (!validHealth) {
                System.out.printf("What is the health of %s?\n", name);

                if (input.hasNextDouble()) {
                    health = input.nextDouble();
                    validHealth = true;
                } else {
                    input.nextLine();
                    System.out.println("Please enter a number");
                }
            }

            while (!validPain) {
                System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n",
                        name);

                if (input.hasNextInt()) {
                    painLevel = input.nextInt();
                    validPain = true;
                } else {
                    input.nextLine();
                    System.out.println("Please enter a number");
                }
            }

            Pet petPatient;

            switch (species) {
                case "Dog":
                    petPatient = new Dog(name, health, painLevel, Double.parseDouble(stat));
                    break;
                case "Cat":
                    petPatient = new Cat(name, health, painLevel, Integer.parseInt(stat));
                    break;
                default:
                    throw new InvalidPetException();
            }

            health = petPatient.getHealth();
            painLevel = petPatient.getPainLevel();
            petPatient.speak();

            int tTime = petPatient.treat();
            String timeOut = addTime(timeIn, tTime);
            out += String.format("%s,%s,%s,Day %d,%s,%s,%s,%d\n",
                    name,
                    species,
                    stat,
                    day,
                    timeIn,
                    timeOut,
                    String.valueOf(health),
                    painLevel);
        }

        fileScan.close();
        input.close();
        return out.trim();
    }

    public String nextDay(String filename) throws FileNotFoundException {
        return nextDay(new File(filename));
    }

    public boolean addToFile(String patientInfo) {
        Scanner fileScan = null;
        PrintWriter filePrint = null;
        String strOut = "";

        try {
            fileScan = new Scanner(patienFile);

            boolean newPatient = true;
            int delim1 = patientInfo.indexOf(",");
            String name = patientInfo.substring(0, delim1);

            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                if (line.startsWith(name)) {
                    newPatient = false;
                    int currDelim = delim1;

                    for (int i = 2; i <= 3; i++) {
                        int nextDelim = patientInfo.indexOf(",", currDelim + 1);
                        currDelim = nextDelim;
                    }
                    line += patientInfo.substring(currDelim);
                }

                strOut += (line + "\n");
            }

            if (newPatient) {
                strOut += patientInfo;
            }

            fileScan.close();
            filePrint = new PrintWriter(patienFile);
            filePrint.print(strOut);

            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (fileScan != null) {
                fileScan.close();
            }

            if (filePrint != null) {
                filePrint.close();
            }
        }
    }

    private static String addTime(String timeIn, int tTime) {
        int hrs = Integer.parseInt(timeIn.substring(0, 2));
        int min = Integer.parseInt(timeIn.substring(2));
        int hrOut = hrs + (int) ((min + tTime) / 60);
        int minOut = (min + tTime) % 60;

        String output = "";
        output += (hrOut < 10) ? ("0" + hrOut) : hrOut;
        output += (minOut < 10) ? ("0" + minOut) : minOut;

        return output;
    }
}
