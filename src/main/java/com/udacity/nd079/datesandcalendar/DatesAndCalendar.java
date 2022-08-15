package com.udacity.nd079.datesandcalendar;

import java.util.Calendar;
import java.util.Date;

public class DatesAndCalendar {

    public static void main(String[] args) {
        DatesAndCalendar.displayCurrentDate();
        DatesAndCalendar.displaySetDate();
    }

    public static void displayCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        Date date = new Date();
        calendar.setTime(date);
        System.out.println(calendar.getTime());
    }

    public static void displaySetDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2031, 02, 02);
        Date date = calendar.getTime();
        System.out.println(date);
    }
}
