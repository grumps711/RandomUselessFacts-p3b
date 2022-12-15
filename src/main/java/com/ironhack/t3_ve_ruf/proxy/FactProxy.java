package com.ironhack.t3_ve_ruf.proxy;

import com.ironhack.t3_ve_ruf.dto.FactDTO;
import com.ironhack.t3_ve_ruf.model.Fact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="fact", url ="https://uselessfacts.jsph.pl/random.json")
public interface FactProxy {

    @GetMapping
    FactDTO getOne();
}