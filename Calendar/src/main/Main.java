package main;

import model.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(20, 05, 2022);
        System.out.println(date.getDateShortForm());
        System.out.println(date.getDateLongForm());
    }
}
