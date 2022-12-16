package com.ironhack.t3_ve_ruf.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.t3_ve_ruf.controller.FactController;
import com.ironhack.t3_ve_ruf.dto.FactDTO;
import com.ironhack.t3_ve_ruf.model.Fact;
import com.ironhack.t3_ve_ruf.proxy.FactProxy;
import com.ironhack.t3_ve_ruf.service.FactService;
import com.ironhack.t3_ve_ruf.utils.ConsoleColors;
import com.ironhack.t3_ve_ruf.utils.ConsoleInteracction;
import com.ironhack.t3_ve_ruf.utils.TerminalTools;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@Data
@RequiredArgsConstructor
public class Menu {
private final FactService factService;
private final FactController factController;
private final FactProxy factProxy;


    public void startApp() {

        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
//        System.out.println(ConsoleColors.BLUE_BACKGROUND + "Aquí empieza tu app" + ConsoleColors.RESET);

        showMenu();
    }

    private void showMenu() {
        var input = "";
        var sc = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();

        while (!input.equalsIgnoreCase("EXIT")) {

            System.out.println(TerminalTools.ANSI_RESET);
            System.out.println("\n" +
                    "██████╗  █████╗ ███╗   ██╗██████╗  ██████╗ ███╗   ███╗    ██╗   ██╗███████╗███████╗██╗     ███████╗███████╗███████╗    ███████╗ █████╗  ██████╗████████╗███████╗\n" +
                    "██╔══██╗██╔══██╗████╗  ██║██╔══██╗██╔═══██╗████╗ ████║    ██║   ██║██╔════╝██╔════╝██║     ██╔════╝██╔════╝██╔════╝    ██╔════╝██╔══██╗██╔════╝╚══██╔══╝██╔════╝\n" +
                    "██████╔╝███████║██╔██╗ ██║██║  ██║██║   ██║██╔████╔██║    ██║   ██║███████╗█████╗  ██║     █████╗  ███████╗███████╗    █████╗  ███████║██║        ██║   ███████╗\n" +
                    "██╔══██╗██╔══██║██║╚██╗██║██║  ██║██║   ██║██║╚██╔╝██║    ██║   ██║╚════██║██╔══╝  ██║     ██╔══╝  ╚════██║╚════██║    ██╔══╝  ██╔══██║██║        ██║   ╚════██║\n" +
                    "██║  ██║██║  ██║██║ ╚████║██████╔╝╚██████╔╝██║ ╚═╝ ██║    ╚██████╔╝███████║███████╗███████╗███████╗███████║███████║    ██║     ██║  ██║╚██████╗   ██║   ███████║\n" +
                    "╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝  ╚═════╝ ╚═╝     ╚═╝     ╚═════╝ ╚══════╝╚══════╝╚══════╝╚══════╝╚══════╝╚══════╝    ╚═╝     ╚═╝  ╚═╝ ╚═════╝   ╚═╝   ╚══════╝\n" +
                    "                                                                                                                                                                \n");
            System.out.println("""
                            1) Show a random fact
                            2) Show your favorite facts
                            3) Add a favorite fact
                            4) Delete a favorite fact
                            5) Replace a favorite fact
                            6) Edit a favorite fact
                           
                            
                            EXIT  To quit the program
                                        
                    """);

            input = sc.nextLine();

            if (input.equalsIgnoreCase("1")) {

                String option = "";
                    while(!option.equalsIgnoreCase("back")) {
                        System.out.println(TerminalTools.ANSI_RESET);
                        System.out.println("\n");
                        System.out.println("----Random Useless Fact----");
                        System.out.println("\n");
                        var randomPresentFact = factProxy.getOne();
                        getFactDTOPretty(randomPresentFact);
                        System.out.println("\n");
                        System.out.println("1) Save this fact to your favorites");
                        System.out.println("2) Show another random fact");
                        System.out.println("Type BACK to go back to menu\n");
                        option = sc.nextLine();

                        if (option.equalsIgnoreCase("1")) {
                            factController.createFact(randomPresentFact);
                            System.out.println("This fact has been saved to your favorites! :)");
                            System.out.println("\n");
                            System.out.println("1) Show another random fact");
                            System.out.println("Type BACK to go back to menu\n");
                            option = sc.nextLine();
                        }
                    }

            } else if (input.equalsIgnoreCase("2")) {
                System.out.println(TerminalTools.ANSI_RESET);
                System.out.println("----Showing your favorite saved facts----");

                List<Fact> factList= factController.getAllFacts();

                if (factList.size()==0){
                   System.out.println("\n");
                   System.out.println("You don't have any favorites yet :(");
                   System.out.println("\n");
               }

                for (int i = 0; i < factList.size(); i++) {
                    getFactPretty(factList.get(i));
                    System.out.println("\n");
                }

            } else if (input.equalsIgnoreCase("3")) {
                System.out.println(TerminalTools.ANSI_RESET);
                System.out.println("----Add now your favorite fact----\n");
                System.out.println("Type now your fact");
                String text = sc.nextLine();

                System.out.println("Now type the source (if you know)");
                String source = sc.nextLine();

                System.out.println("Now type the source URL (if you know)");
                String sourceUrl = sc.nextLine();

                System.out.println("Now type the language");
                String language = sc.nextLine();

                System.out.println("Now type the permalink (if you know)");
                String permalink = sc.nextLine();

                var factToSave = new FactDTO(text,source,sourceUrl,language,permalink);

                factController.createFact(factToSave);
                System.out.println("your fact has now been saved!");

            } else if (input.equalsIgnoreCase("4")) {
                System.out.println(TerminalTools.ANSI_RESET);
                System.out.println("you want to delete a fact, what is the ID of the fact?");
                Long id = Long.valueOf(sc.nextLine());

                factController.deleteFact(id);
                System.out.println("Fact with id " + id + " has been deleted!");
            } else if (input.equalsIgnoreCase("5")) {
                System.out.println(TerminalTools.ANSI_RESET);
                System.out.println("Replace a favorite fact! please type the id of the fact:");
                Long id = Long.valueOf(sc.nextLine());

                System.out.println("type now your replaceable new fact");
                String text = sc.nextLine();

                System.out.println("Now type the source (if you know)");
                String source = sc.nextLine();

                System.out.println("Now type the source URL (if you know)");
                String sourceUrl = sc.nextLine();

                System.out.println("Now type the language");
                String language = sc.nextLine();

                System.out.println("Now type the permalink (if you know)");
                String permalink = sc.nextLine();

                var factUpdated = new Fact(text,source,sourceUrl,language,permalink);

                factController.updateFact(id,factUpdated);
            } else if (input.equalsIgnoreCase("6")) {
                System.out.println(TerminalTools.ANSI_RESET);
                System.out.println("You are now editing a fact:\n");

                System.out.println("please type the id of the fact:");
                Long id = Long.valueOf(sc.nextLine());

                System.out.println("Now please type your new value or leave blank");
                System.out.println("Fact text:");
                String text = sc.nextLine();

                System.out.println("Source:");
                String source = sc.nextLine();

                System.out.println("Source URL:");
                String sourceUrl = sc.nextLine();

                System.out.println("Language:");
                String language = sc.nextLine();

                System.out.println("Permalink:");
                String permalink = sc.nextLine();

                factController.updateParams(id, text.describeConstable(), source.describeConstable(), sourceUrl.describeConstable(), language.describeConstable(), permalink.describeConstable());

                System.out.println("Parameters have been edited!");
            }
        }
        System.exit(0);

        //var dto = new FactDTO(new FactService());
    }


    public void getFactDTOPretty(FactDTO factDTO){
        System.out.println("Text: " + factDTO.getText());
        System.out.println("Source: " + factDTO.getSource());
        System.out.println("Source URL: " + factDTO.getSourceUrl());
        System.out.println("Language: " + factDTO.getLanguage());
        System.out.println("Permalink: " + factDTO.getPermalink());
    }

    public void getFactPretty(Fact fact){
        System.out.println("Id: " + fact.getId());
        System.out.println("Text: " + fact.getText());
        System.out.println("Source: " + fact.getSource());
        System.out.println("Source URL: " + fact.getSourceUrl());
        System.out.println("Language: " + fact.getLanguage());
        System.out.println("Permalink: " + fact.getPermalink());
    }

}
