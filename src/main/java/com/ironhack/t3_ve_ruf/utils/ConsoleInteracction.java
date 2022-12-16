package com.ironhack.t3_ve_ruf.utils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ConsoleInteracction {

    private static final Scanner sc = new Scanner(System.in);

    public static String getStringInput() {
        return sc.nextLine();
    }


    public static void printWithColor(String text, String color) {
        System.out.println(color + text + ConsoleColors.RESET);
    }




}