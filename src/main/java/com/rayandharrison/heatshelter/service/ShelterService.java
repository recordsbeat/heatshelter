package com.rayandharrison.heatshelter.service;

import com.rayandharrison.heatshelter.domain.shelter.Shelter;
import com.rayandharrison.heatshelter.domain.shelter.ShelterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Service
public class ShelterService {
    private final ShelterRepository shelterRepository;
    private final ApiCallService apiCallService;

    private Shelter getShelterFromApi(String search){
        return apiCallService.getShelter(search);
    }

    public Shelter findByLegaldongNm(String legaldongNm){
        return shelterRepository.findByLegaldongNm(legaldongNm)
                //call api get return
                .orElseGet((Supplier<? extends Shelter>) getShelterFromApi(legaldongNm));
    }

}
