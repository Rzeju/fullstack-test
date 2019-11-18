package com.instantor.dap.springbootbackend.services;

public interface StarWarsCharacterService {

    String getWelcomeMessage();

    String getVaderDescription();

    void createBountyHunter(String firstName, String secondName);

    String startMission(Long hunterId, Long targetId, Long targetPower);
}
