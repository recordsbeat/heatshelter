package com.rayandharrison.heatshelter.domain.shelter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShelterRepository extends CrudRepository<String,Shelter> {
    Optional<Shelter> findByLegaldongNm(String legaldongNm);
}
