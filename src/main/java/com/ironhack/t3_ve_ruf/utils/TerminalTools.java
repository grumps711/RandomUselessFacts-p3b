package com.ironhack.t3_ve_ruf.utils;

public class TerminalTools {
        // great documentation
        //https://www.lihaoyi.com/post/BuildyourownCommandLinewithANSIescapecodes.html
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_RED = "\u001b[31m";
        public static final String CURSOR_MIDDLE = "\033[1;10H";
        public static final String ANSI_GREEN = "\u001b[32m";
        public static final String ANSI_BLUE = "\u001b[34;1m";
        public static final String ANSI_YELLOW = "\u001b[33;1m";
        public static final String ANSI_BRIGHT_RED = "\u001b[31;1m";
        public static final String CLEAR_SCREEN = "\033[H\033[2J";
        public static final String ANSI_CYAN = "\u001b[36;1m";
        public static final String ANSI_MAGENTA = "\u001b[35;1m";

        public static void cleanScreen(){
                System.out.println(TerminalTools.ANSI_RESET);
        }

}


