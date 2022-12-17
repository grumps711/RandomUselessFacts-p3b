package com.ironhack.t3_ve_ruf.menu;

import com.ironhack.t3_ve_ruf.controller.FactController;
import com.ironhack.t3_ve_ruf.dto.FactDTO;
import com.ironhack.t3_ve_ruf.exception.FactNotFoundException;
import com.ironhack.t3_ve_ruf.model.Fact;
import com.ironhack.t3_ve_ruf.proxy.FactProxy;
import com.ironhack.t3_ve_ruf.service.FactService;
import com.ironhack.t3_ve_ruf.utils.Validator;
import com.ironhack.t3_ve_ruf.view.prints;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


import static com.ironhack.t3_ve_ruf.utils.ConsoleColors.*;
import static com.ironhack.t3_ve_ruf.utils.ConsoleInteraction.getStringInput;
import static com.ironhack.t3_ve_ruf.utils.ConsoleInteraction.printInRed;
import static com.ironhack.t3_ve_ruf.utils.TerminalTools.cleanScreen;


@Component
@Data
@RequiredArgsConstructor
public class Menu {
private final FactService factService;
private final FactController factController;
private final FactProxy factProxy;


    public void showMenu() {
        var input = "";

        cleanScreen();
        prints.title(BLUE_BOLD);
        while (!input.equalsIgnoreCase("EXIT")) {
            prints.menuOptions(YELLOW);
            input = getStringInput();

            if (input.equalsIgnoreCase("1")) {
                String option = "";
                    while(!option.equalsIgnoreCase("back")) {
                        cleanScreen();
                        System.out.println("\n----Random Useless Fact----\n");

                        FactDTO randomPresentFact = null;

//                        if(!option.equalsIgnoreCase("0")) {
//                            randomPresentFact = factProxy.getOne();
//                        }

                        do{
                            randomPresentFact = factProxy.getOne();
                        }while(option.equalsIgnoreCase("0") && randomPresentFact.getLanguage().equalsIgnoreCase("de"));

                        getFactDTOPretty(randomPresentFact);

                        if (randomPresentFact.getLanguage().equalsIgnoreCase("de")){
                            System.out.println(BLACK_BACKGROUND +"Das ist Deutsch. Hast du es verstanden?"+RESET);
                            printInRed("🤣🤣 That's German. Did you understand it?"+RESET);
                            System.out.println();
                            System.out.println("0) Show a random fact in english please");
                        }
                        System.out.println("1) Save this fact to your favorites");
                        System.out.println("2) Show another random fact");
                        System.out.println("Type BACK to go back to menu\n");
                        option = getStringInput();

                        if (option.equals("1")) {
                            factController.createFact(randomPresentFact);
                            System.out.println("This fact has been saved to your favorites! :)");
                            System.out.println("\n");
                            System.out.println("1) Show another random fact");
                            System.out.println("Type BACK to go back to menu\n");
                            option = getStringInput();
                        }
                    }

            } else if (input.equals("2")) {
                cleanScreen();
                System.out.println("----Showing your favorite saved facts----");

                //Creates a list with all database facts
                List<Fact> factList= factController.getAllFacts();

                if (factList.size()==0){
                   System.out.println("\nYou don't have any favorites yet :(\n");
               }

                //Prints in a fancy way all the facts in the database
                for (int i = 0; i < factList.size(); i++) {
                    getFactPretty(factList.get(i));
                    System.out.println("\n");
                }

            } else if (input.equalsIgnoreCase("3")) {
                cleanScreen();
                System.out.println("----Add now your favorite fact----\n");

                System.out.println("Type now your fact");
                String text = getStringInput();

                System.out.println("Now type the source (if you know)");
                String source = getStringInput();

                System.out.println("Now type the source URL (if you know)");
                String sourceUrl = getStringInput();

                System.out.println("Now type the language");
                String language = getStringInput();

                System.out.println("Now type the permalink (if you know)");
                String permalink = getStringInput();

                var factToSave = new FactDTO(text,source,sourceUrl,language,permalink);

                factController.createFact(factToSave);
                System.out.println("your fact has now been saved!");

            } else if (input.equals("4")) {
                cleanScreen();
                Long id= Validator.askForANumber("you want to delete a fact, what is the ID of the fact?",
                                                "Please enter a valid number");
                try {
                    var findFactToDelete = factService.findFactById(id);
                    factController.deleteFact(id);
                    System.out.println("Fact with id " + id + " has been deleted!");
                }catch (FactNotFoundException e){
                    printInRed(e.getMessage());
                }

            } else if (input.equalsIgnoreCase("5")) {
                cleanScreen();
                Long id= Validator.askForANumber("Replace a favorite fact! please type the id of the fact:",
                        "Please enter a valid number");

                try {
                    var findFactToDelete = factService.findFactById(id);

                }catch (FactNotFoundException e){
                    printInRed(e.getMessage());
                    continue;
                }

                System.out.println("type now your replaceable new fact");
                String text = getStringInput();

                System.out.println("Now type the source (if you know)");
                String source = getStringInput();

                System.out.println("Now type the source URL (if you know)");
                String sourceUrl = getStringInput();

                System.out.println("Now type the language");
                String language = getStringInput();

                System.out.println("Now type the permalink (if you know)");
                String permalink = getStringInput();

                var factUpdated = new Fact(text,source,sourceUrl,language,permalink);

                factController.updateFact(id,factUpdated);

            } else if (input.equalsIgnoreCase("6")) {
                cleanScreen();
                System.out.println("You are now editing a fact:\n");
                System.out.println("Now please type your new value or leave blank");

                Long id= Validator.askForANumber("\"please type the id of the fact:\"",
                        "Please enter a valid number");

                try {
                    var findFactToDelete = factService.findFactById(id);

                }catch (FactNotFoundException e){
                    printInRed(e.getMessage());
                    continue;
                }

                System.out.println("Fact text:");
                String inputText = getStringInput();

                Optional<String> text;

                if(inputText.equals("")){
                    text = Optional.empty();
                }

                text = Optional.of(inputText);

                System.out.println("Source:");
                Optional<String> source = Optional.ofNullable(getStringInput());

                System.out.println("Source URL:");
                Optional<String> sourceUrl = Optional.ofNullable(getStringInput());

                System.out.println("Language:");
                Optional<String> language = Optional.ofNullable(getStringInput());

                System.out.println("Permalink:");
                Optional<String> permalink = Optional.ofNullable(getStringInput());

                factController.updateParams(id, text, source, sourceUrl, language, permalink);

                System.out.println("Parameters have been edited!");
            }
        }
        System.exit(0);
    }

    public void getFactDTOPretty(FactDTO factDTO){
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("Text: " + factDTO.getText());
        System.out.println("Source: " + factDTO.getSource());
        System.out.println("Source URL: " + factDTO.getSourceUrl());
        System.out.println("Language: " + factDTO.getLanguage());
        System.out.println("Permalink: " + factDTO.getPermalink());
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
    }

    public void getFactPretty(Fact fact){
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        System.out.println("Id: " + fact.getId());
        System.out.println("Text: " + fact.getText());
        System.out.println("Source: " + fact.getSource());
        System.out.println("Source URL: " + fact.getSourceUrl());
        System.out.println("Language: " + fact.getLanguage());
        System.out.println("Permalink: " + fact.getPermalink());
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
    }
}
