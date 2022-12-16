package com.ironhack.t3_ve_ruf.service;

import com.ironhack.t3_ve_ruf.dto.FactDTO;
import com.ironhack.t3_ve_ruf.exception.FactNotFoundException;
import com.ironhack.t3_ve_ruf.model.Fact;
import com.ironhack.t3_ve_ruf.repository.FactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

//    Delete Favorite Fact in Database
    public void deleteFact(Long id) {
        factRepository.deleteById(id);
    }

//    Replace entirely Favorite Fact in Database
    public Fact updateFact(Long id, Fact fact) {
        var factToUpdate = findFactById(id);
        factToUpdate.setText(fact.getText());
        factToUpdate.setSource(fact.getSource());
        factToUpdate.setSourceUrl(fact.getSourceUrl());
        factToUpdate.setLanguage(fact.getLanguage());
        factToUpdate.setPermalink(fact.getPermalink());
        return factRepository.save(factToUpdate);
    }

    private Fact findFactById(Long id) {
        return factRepository.findById(id).orElseThrow(() -> new FactNotFoundException(id));
    }

//     Edit Favorite Fact in Database
    public Fact updateParams(Long id, Optional<String> text, Optional<String> source, Optional<String> sourceUrl, Optional<String> language, Optional<String> permalink) {
        var factToUpdate = findFactById(id);
        text.ifPresent(factToUpdate::setText);
        source.ifPresent(factToUpdate::setSource);
        sourceUrl.ifPresent(factToUpdate::setSourceUrl);
        language.ifPresent(factToUpdate::setLanguage);
        permalink.ifPresent(factToUpdate::setPermalink);
        return factRepository.save(factToUpdate);
    }
}
