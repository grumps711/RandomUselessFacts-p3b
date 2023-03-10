package com.ironhack.t3_ve_ruf.service;

import com.ironhack.t3_ve_ruf.dto.FactDTO;
import com.ironhack.t3_ve_ruf.exception.FactNotFoundException;
import com.ironhack.t3_ve_ruf.model.Fact;
import com.ironhack.t3_ve_ruf.repository.FactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ironhack.t3_ve_ruf.model.Fact.fromDTO;

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
        var factCreated = factRepository.save(fromDTO(fact));
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

    public Fact findFactById (Long id) throws FactNotFoundException {
        return factRepository.findById(id).orElseThrow(() -> new FactNotFoundException(id));
    }

    public Fact save(Fact fact) {
        return factRepository.save(fact);
    }



    //     Edit Favorite Fact in Database
    public Fact updateParams(Long id, Optional<String> text, Optional<String> source, Optional<String> sourceUrl, Optional<String> language, Optional<String> permalink) {
        var factToUpdate = findFactById(id);
        if (text.isPresent() && !text.get().isBlank()) {factToUpdate.setText(text.get());}
        if (source.isPresent() && !source.get().isBlank()) {factToUpdate.setSource(source.get());}
        if (sourceUrl.isPresent() && !sourceUrl.get().isBlank()) {factToUpdate.setSourceUrl(sourceUrl.get());}
        if (language.isPresent() && !language.get().isBlank()) {factToUpdate.setLanguage(language.get());}
        if (permalink.isPresent() && !permalink.get().isBlank()) {factToUpdate.setPermalink(permalink.get());}
        return factRepository.save(factToUpdate);
    }


    public void chooseLanguage(String optionLanguage) {

        if(optionLanguage.equalsIgnoreCase("1")){

        }


    }
}
