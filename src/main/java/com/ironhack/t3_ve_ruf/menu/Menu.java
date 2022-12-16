package com.ironhack.t3_ve_ruf.menu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.t3_ve_ruf.controller.FactController;
import com.ironhack.t3_ve_ruf.dto.FactDTO;
import com.ironhack.t3_ve_ruf.model.Fact;
import com.ironhack.t3_ve_ruf.proxy.FactProxy;
import com.ironhack.t3_ve_ruf.service.FactService;

import com.ironhack.t3_ve_ruf.utils.TerminalTools;
import com.ironhack.t3_ve_ruf.view.prints;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

import static com.ironhack.t3_ve_ruf.utils.TerminalTools.cleanScreen;


@Component
@Data
@RequiredArgsConstructor
public class Menu {
private final FactService factService;
private final FactController factController;
private final FactProxy factProxy;


    public void startApp() {


        showMenu();
    }

    private void showMenu() {
        var input = "";
        var sc = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();



        cleanScreen();
        prints.title();

        while (!input.equalsIgnoreCase("EXIT")) {

            prints.menuOptions();


            input = sc.nextLine();

            if (input.equalsIgnoreCase("1")) {

                String option = "";
                    while(!option.equalsIgnoreCase("back")) {

                        cleanScreen();
                        System.out.println("\n----Random Useless Fact----\n");

                        var randomPresentFact = factProxy.getOne();
                        getFactDTOPretty(randomPresentFact);
                        System.out.println();
                        System.out.println("1) Save this fact to your favorites");
                        System.out.println("2) Show another random fact");
                        System.out.println("Type BACK to go back to menu\n");

                        option = sc.nextLine();

                        if (option.equals("1")) {
                            factController.createFact(randomPresentFact);
                            System.out.println("This fact has been saved to your favorites! :)");
                            System.out.println("\n");
                            System.out.println("1) Show another random fact");
                            System.out.println("Type BACK to go back to menu\n");

                            option = sc.nextLine();
                        }
                    }

            } else if (input.equals("2")) {
                cleanScreen();
                System.out.println("----Showing your favorite saved facts----");

                //Creates a list of all facts
                List<Fact> factList= factController.getAllFacts();

                //Prints the factList
                if (factList.size()==0){
                   System.out.println("\nYou don't have any favorites yet :(\n");
               }

                for (int i = 0; i < factList.size(); i++) {
                    getFactPretty(factList.get(i));
                    System.out.println("\n");
                }

            } else if (input.equalsIgnoreCase("3")) {
                cleanScreen();
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

            } else if (input.equals("4")) {
                cleanScreen();
                System.out.println("you want to delete a fact, what is the ID of the fact?");
                Long id = Long.valueOf(sc.nextLine());

                factController.deleteFact(id);
                System.out.println("Fact with id " + id + " has been deleted!");
            } else if (input.equalsIgnoreCase("5")) {
                cleanScreen();
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
                cleanScreen();
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
