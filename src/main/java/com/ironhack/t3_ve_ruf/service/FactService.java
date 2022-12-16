package com.ironhack.t3_ve_ruf.service;

import com.ironhack.t3_ve_ruf.dto.FactDTO;
import com.ironhack.t3_ve_ruf.model.Fact;
import com.ironhack.t3_ve_ruf.repository.FactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactService {


    private final FactRepository factRepository;

//    View all favorites from DataBase
    public List<Fact> findAll() {
        return factRepository.findAll();
    }

//    Save Favorite Fact in Database
   public FactDTO createFact(FactDTO fact) {
       var factCreated = factRepository.save(Fact.fromDTO(fact));
        return FactDTO.fromFact(factCreated);
    }

}
