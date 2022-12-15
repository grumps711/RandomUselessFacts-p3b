package com.ironhack.t3_ve_ruf.repository;

import com.ironhack.t3_ve_ruf.model.Fact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactRepository extends JpaRepository<Fact,Long> {
}
