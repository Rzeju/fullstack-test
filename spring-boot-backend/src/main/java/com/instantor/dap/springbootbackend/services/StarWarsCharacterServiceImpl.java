package com.instantor.dap.springbootbackend.services;

import com.instantor.dap.springbootbackend.domain.BountyHunter;
import com.instantor.dap.springbootbackend.domain.BountyTarget;
import com.instantor.dap.springbootbackend.services.Utils.ListResponseWrapper;
import com.instantor.dap.springbootbackend.services.Utils.StarWarsCharacterConst;
import com.instantor.dap.springbootbackend.services.Utils.StringResponseWrapper;
import org.springframework.stereotype.Service;

@Service
public class StarWarsCharacterServiceImpl implements StarWarsCharacterService {

    @Override
    public StringResponseWrapper getWelcomeMessage() {
        return new StringResponseWrapper(StarWarsCharacterConst.vaderWelcome);
    }

    @Override
    public StringResponseWrapper getVaderDescription() {
        return new StringResponseWrapper(StarWarsCharacterConst.vaderDescription);
    }

    @Override
    public StringResponseWrapper getBountyHunterPocket(Long hunterId) {
        BountyHunter hunter = BountyHunter.getHunterById(hunterId);
        return new StringResponseWrapper(hunter.getHunterPocketValue().toString());
    }

    @Override
    public BountyHunter createBountyHunter(String firstName, String secondName) {
        BountyHunter hunter = new BountyHunter(firstName, secondName);
        BountyHunter.getListOfBountyHunters().add(hunter);
        return hunter;
    }

    @Override
    public ListResponseWrapper getBountyHuntersList() {
        return new ListResponseWrapper(BountyHunter.getListOfBountyHunters());
    }

    @Override
    public ListResponseWrapper getBountyTargetList() {
        return new ListResponseWrapper(BountyTarget.getBountiesList());
    }

    @Override
    public StringResponseWrapper startMission(Long hunterId, Long targetId) {
        BountyHunter hunter = BountyHunter.getHunterById(hunterId);
        BountyTarget target = BountyTarget.getTargetById(targetId);
        String missionMessage;
        if (target != null && hunter != null) {
            if (hunter.getHunterPower() > target.getTargetPower()) {
                missionMessage = "Mission successful! You have earned your bounty Hunter.";
                hunter.getListOfBounties().add(target);
            } else {
                missionMessage = "You're lost. It's a shame Soldier!";
            }
        } else {
            missionMessage = "There is no such target with id:" + targetId;
        }
        return new StringResponseWrapper(missionMessage);
    }
}
