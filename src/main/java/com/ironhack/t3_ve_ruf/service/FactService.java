package com.ironhack.t3_ve_ruf.service;

import com.ironhack.t3_ve_ruf.dto.FactDTO;
import com.ironhack.t3_ve_ruf.model.Fact;
import com.ironhack.t3_ve_ruf.repository.FactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FactService {


    private final FactRepository factRepository;

//    public FactDTO createFact(FactDTO fact) {
//        var factCreated = factRepository.save(Fact.fromDTO(fact));
//        return FactDTO.fromFact(factCreated)
//    }


//    public GameDTO createGame(GameDTO game) {
//        var gameCreated = gameRepository.save(Game.fromDTO(game));
//        return GameDTO.fromGame(gameCreated);
//    }
}
