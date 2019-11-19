package com.instantor.dap.springbootbackend.services;

import com.instantor.dap.springbootbackend.domain.BountyHunter;
import com.instantor.dap.springbootbackend.services.Utils.ListResponseWrapper;
import com.instantor.dap.springbootbackend.services.Utils.StringResponseWrapper;

public interface StarWarsCharacterService {

    StringResponseWrapper getWelcomeMessage();

    StringResponseWrapper getVaderDescription();

    StringResponseWrapper getBountyHunterPocket(Long hunterId);

    ListResponseWrapper getBountyHuntersList();

    ListResponseWrapper getBountyTargetList();

    BountyHunter createBountyHunter(String firstName, String secondName);

    StringResponseWrapper startMission(Long hunterId, Long targetId);

}
