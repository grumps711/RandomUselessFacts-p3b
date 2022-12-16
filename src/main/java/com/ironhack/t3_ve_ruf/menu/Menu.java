package com.ironhack.t3_ve_ruf.menu;

import com.ironhack.t3_ve_ruf.controller.FactController;
import com.ironhack.t3_ve_ruf.dto.FactDTO;
import com.ironhack.t3_ve_ruf.proxy.FactProxy;
import com.ironhack.t3_ve_ruf.service.FactService;
import com.ironhack.t3_ve_ruf.utils.ConsoleColors;
import com.ironhack.t3_ve_ruf.utils.ConsoleInteracction;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        System.out.println(ConsoleColors.BLUE_BACKGROUND + "Aquí empieza tu app" + ConsoleColors.RESET);

        showMenu();

        System.out.println(factProxy.getOne());

    }
        private void showMenu() {
            var input = "";
            while (!input.equalsIgnoreCase("EXIT")) {

                System.out.println(":::: Hello Task Manager ::::");

                System.out.println("""
                                -Show a Random Fact
                                -Add to Favorites
                                -Delete from Favorites
                                -Delete All
                                
                                EXIT  To quit the program
                                            
                        """);
                input = ConsoleInteracction.getStringInput();

                if (input.equalsIgnoreCase("Show a Random Fact")) {
                    System.out.println("Show a Random Fact");
                    //todo call the method
                } else if (input.equalsIgnoreCase("Add to Favorites")) {
                    System.out.println("Add to Favorites");
                    //todo call the method
                }
            }
            System.exit(0);


            //var dto = new FactDTO(new FactService());


    }
}
