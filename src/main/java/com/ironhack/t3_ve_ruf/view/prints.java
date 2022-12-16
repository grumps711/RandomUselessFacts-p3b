package com.ironhack.t3_ve_ruf.view;

import com.ironhack.t3_ve_ruf.utils.ConsoleColors;

public class prints {

    public static void title(String color){
          String title= """
                 
                    ██████╗  █████╗ ███╗   ██╗██████╗  ██████╗ ███╗   ███╗    ██╗   ██╗███████╗███████╗██╗     ███████╗███████╗███████╗    ███████╗ █████╗  ██████╗████████╗███████╗
                    ██╔══██╗██╔══██╗████╗  ██║██╔══██╗██╔═══██╗████╗ ████║    ██║   ██║██╔════╝██╔════╝██║     ██╔════╝██╔════╝██╔════╝    ██╔════╝██╔══██╗██╔════╝╚══██╔══╝██╔════╝
                    ██████╔╝███████║██╔██╗ ██║██║  ██║██║   ██║██╔████╔██║    ██║   ██║███████╗█████╗  ██║     █████╗  ███████╗███████╗    █████╗  ███████║██║        ██║   ███████╗
                    ██╔══██╗██╔══██║██║╚██╗██║██║  ██║██║   ██║██║╚██╔╝██║    ██║   ██║╚════██║██╔══╝  ██║     ██╔══╝  ╚════██║╚════██║    ██╔══╝  ██╔══██║██║        ██║   ╚════██║
                    ██║  ██║██║  ██║██║ ╚████║██████╔╝╚██████╔╝██║ ╚═╝ ██║    ╚██████╔╝███████║███████╗███████╗███████╗███████║███████║    ██║     ██║  ██║╚██████╗   ██║   ███████║
                    ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝  ╚═════╝ ╚═╝     ╚═╝     ╚═════╝ ╚══════╝╚══════╝╚══════╝╚══════╝╚══════╝╚══════╝    ╚═╝     ╚═╝  ╚═╝ ╚═════╝   ╚═╝   ╚══════╝
                    """;

          System.out.println(color+title+ConsoleColors.RESET);
    }

    public static void menuOptions(String color){

        String menu= """
-                                                        ┌─────────────────────────────────────┐
                                                         │   1) Show a random fact             │█
                                                         │   2) Show your favorite facts       │█
                                                         │   3) Add a favorite fact            │█
                                                         │   4) Delete a favorite fact         │█
                                                         │   5) Replace a favorite fact        │█
                                                         │   6) Edit a favorite fact           │█
                                                         │                                     │█
                                                         │                                     │█
                                                         │   EXIT  To quit the program         │█
                                                         └─────────────────────────────────────┘█
                                                            █████████████████████████████████████""";
        System.out.println(color + menu+ConsoleColors.RESET);

    }
}
