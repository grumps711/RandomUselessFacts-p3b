package com.ironhack.t3_ve_ruf.utils;

import java.util.Scanner;

public class ConsoleInteraction {

    private static final Scanner sc = new Scanner(System.in);

    public static String getStringInput() {
        return sc.nextLine();
    }


    public static void printWithColor(String text, String color) {
        System.out.println(color + text + ConsoleColors.RESET);
    }

    public static void printInRed(String message){
        System.out.println(ConsoleColors.RED+message+ ConsoleColors.RESET);
    }



}