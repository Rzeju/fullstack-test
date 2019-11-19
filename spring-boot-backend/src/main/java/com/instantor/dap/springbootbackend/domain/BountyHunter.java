package com.instantor.dap.springbootbackend.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BountyHunter {

    //data base id simulator
    private static Long idGenerator = 1L;

    private Long hunterId;
    private String firstName;
    private String secondName;
    private Long hunterPower;
    //Use to generate power for Hunter
    private static Random powerGenerator = new Random();
    //Upper Range for power value
    private static Long powerUpperBoundary = 1000000L;
    //List of all earned bounties
    private List<BountyTarget> listOfBounties = new ArrayList<>();
    //data base bounties list simulator - storing all earned bounties for Hunter
    private static transient List<BountyHunter> listOfBountyHunters = new ArrayList<>();

    public BountyHunter(String firstName, String secondName) {
        this.hunterId = idGenerator;
        this.firstName = firstName;
        this.secondName = secondName;
        this.hunterPower = (long) (powerGenerator.nextDouble() * powerUpperBoundary);

        idGenerator++;
    }

    public static BountyHunter getHunterById(Long hunterId) {
        BountyHunter result = null;
        for (BountyHunter hunter : listOfBountyHunters) {
            if (hunter.hunterId.equals(hunterId)) {
                result = hunter;
            }
        }
        return result;
    }

    public List<BountyTarget> getListOfBounties() {
        return listOfBounties;
    }

    public static List<BountyHunter> getListOfBountyHunters() {
        return listOfBountyHunters;
    }

    public Long getHunterPower() {
        return hunterPower;
    }

    public Long getHunterPocketValue() {
        Long pocketValue = 0L;
        for (BountyTarget bountie : listOfBounties) {
            pocketValue = pocketValue + bountie.getBountyAmount();
        }
        return pocketValue;
    }

    @Override
    public String toString() {
        return "BountyHunter{" +
                "hunterId=" + hunterId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", hunterPower=" + hunterPower +
                '}';
    }

    public static Long getIdGenerator() {
        return idGenerator;
    }

    public Long getHunterId() {
        return hunterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public static Random getPowerGenerator() {
        return powerGenerator;
    }

    public static Long getPowerUpperBoundary() {
        return powerUpperBoundary;
    }
}


