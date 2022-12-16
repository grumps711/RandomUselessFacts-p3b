package com.ironhack.t3_ve_ruf.menu;

import com.ironhack.t3_ve_ruf.controller.FactController;
import com.ironhack.t3_ve_ruf.dto.FactDTO;
import com.ironhack.t3_ve_ruf.proxy.FactProxy;
import com.ironhack.t3_ve_ruf.service.FactService;
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






    public void startApp(){

        System.out.println("Aquí empieza tu app");



        System.out.println(factProxy.getOne());

        //var dto = new FactDTO(new FactService());


    }
}
