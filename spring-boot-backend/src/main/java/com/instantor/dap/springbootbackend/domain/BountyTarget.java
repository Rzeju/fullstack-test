package com.instantor.dap.springbootbackend.domain;

import java.util.ArrayList;
import java.util.List;

public class BountyTarget {

    //data base id simulator
    private static Long idGenerator = 1L;

    private Long targetId;

    private String targetName;
    private Long targetPower;
    private Long bountyAmount;

    //data base bounties list simulator - available bounties to take
    private static List<BountyTarget> bountiesList = new ArrayList<>();

    public BountyTarget(String targetName, Long targetPower, Long bountyAmount) {
        this.targetId = idGenerator;
        this.targetName = targetName;
        this.targetPower = targetPower;
        this.bountyAmount = bountyAmount;

        idGenerator++;
    }

    public static BountyTarget getTargetById(Long targetId) {
        BountyTarget result = null;
        for (BountyTarget target : bountiesList) {
            if (target.targetId.equals(targetId)) {
                result = target;
            }
        }
        return result;
    }

    public Long getBountyAmount() {
        return bountyAmount;
    }
}
