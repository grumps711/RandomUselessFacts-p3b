package com.ironhack.t3_ve_ruf.controller;

import com.ironhack.t3_ve_ruf.dto.FactDTO;
import com.ironhack.t3_ve_ruf.model.Fact;
import com.ironhack.t3_ve_ruf.proxy.FactProxy;
import com.ironhack.t3_ve_ruf.repository.FactRepository;
import com.ironhack.t3_ve_ruf.service.FactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("randomfact")
@RequiredArgsConstructor
public class FactController {

    private final FactRepository factRepository;
    private final FactProxy factProxy;
    private final FactService factService;

    @GetMapping
    FactDTO randomFact(){
        return factProxy.getOne();
    }
//
//    //    View favorites
//    @GetMapping
//    public List<Game> getAllGames () {
//        return gameService.findAll();
//    }
//
//    //    Save favorite
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)//pone el codigo 201 si es  OK
//    public FactDTO createFact (@RequestBody @Valid FactDTO fact) {
//        return factService.createFact(fact);
//    }
//
}
