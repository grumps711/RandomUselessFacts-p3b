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

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("randomfact")
@RequiredArgsConstructor
public class FactController {

    private final FactRepository factRepository;
    private final FactProxy factProxy;
    private final FactService factService;

    //   #2     Fetch a random fact from the public API
    @GetMapping
    FactDTO randomFact(){
        return factProxy.getOne();
    }

   //    #3     Fetch favorite facts
    @GetMapping("/view-favorites")
    public List<Fact> getAllFacts() {
        return factService.findAll();
    }

//       #4     Save favorite fact
    @PostMapping("/save-favorite")
    @ResponseStatus(HttpStatus.CREATED)//pone el codigo 201 si es  OK
    public FactDTO createFact (@RequestBody @Valid FactDTO factDTO) {
        return factService.createFact(factDTO);
    }

//      #5      Delete favorite fact
    @DeleteMapping("/delete-favorite/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFact(@PathVariable("id") Long id){
        factService.deleteFact(id);
    }

    //    #6      Replace favorite
    @PutMapping("/replace-favorite/{id}")
    public Fact updateFact(@PathVariable("id") Long id, @RequestBody Fact fact){
        return factService.updateFact(id, fact);
    }

    //    #7       Edit favorite
    @PatchMapping("/edit-favorite/{id}")
    public Fact updateParams(@PathVariable Long id,
                                     @RequestParam Optional<String> text,
                                     @RequestParam Optional<String> source,
                                     @RequestParam Optional<String> sourceUrl,
                                     @RequestParam Optional<String> language,
                                     @RequestParam Optional<String> permalink){
        return factService.updateParams(id, text, source, sourceUrl, language, permalink);
    }
}
