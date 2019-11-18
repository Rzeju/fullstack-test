package com.instantor.dap.springbootbackend.services;

import com.instantor.dap.springbootbackend.domain.BountyHunter;
import com.instantor.dap.springbootbackend.domain.BountyTarget;
import org.springframework.stereotype.Service;

@Service
public class StarWarsCharacterServiceImpl implements StarWarsCharacterService {

    @Override
    public String getWelcomeMessage() {
        return StarWarsCharacterConst.vaderWelcome;
    }

    @Override
    public String getVaderDescription() {
        return StarWarsCharacterConst.vaderDescription;
    }

    @Override
    public void createBountyHunter(String firstName, String secondName) {
        BountyHunter hunter = new BountyHunter(firstName, secondName);
        BountyHunter.getListOfBountyHunters().add(hunter);
    }

    @Override
    public String startMission(Long hunterId, Long targetId, Long targetPower) {
        BountyHunter hunter = BountyHunter.getHunterById(hunterId);
        String missionMessage = "";
        if (hunter.getHunterPower() >= targetPower) {
            BountyTarget target = BountyTarget.getTargetById(targetId);
            if (target != null) {
                missionMessage = "Mission successful! You have earned your bounty Hunter.";
                hunter.getListOfBounties().add(target);
            } else{
                missionMessage = "There is no such target with id:" + targetId;
            }
        } else {
            missionMessage = "You're lost. It's a shame Soldier!";
        }
        return missionMessage;
    }
}
