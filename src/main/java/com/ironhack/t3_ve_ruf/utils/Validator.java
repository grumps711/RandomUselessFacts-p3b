package com.ironhack.t3_ve_ruf.utils;

import static com.ironhack.t3_ve_ruf.utils.ConsoleInteraction.getStringInput;
import static com.ironhack.t3_ve_ruf.utils.ConsoleInteraction.printInRed;

public class Validator {

    public static Long askForANumber(String question, String errorMessage){
        Long id=null;
        boolean correct=false;
        do {
            System.out.println(question);
            try {
                id = Long.parseLong(getStringInput());
                correct=true;
            } catch (NumberFormatException e) {
                printInRed(errorMessage);
                System.out.println("\n");
            }
        }while (!correct);
        return id;
    }


}
