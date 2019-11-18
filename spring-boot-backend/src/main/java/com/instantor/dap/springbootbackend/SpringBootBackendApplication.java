package com.instantor.dap.springbootbackend;

import com.instantor.dap.springbootbackend.domain.BountyHunter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBackendApplication {

    public static void main(String[] args) {

        //SpringApplication.run(SpringBootBackendApplication.class, args);

        BountyHunter hunter1 = new BountyHunter("Jajko", "Majko");
        BountyHunter hunter2 = new BountyHunter("Misza", "Kisza");
        BountyHunter hunter3 = new BountyHunter("Suka", "Kika");
        BountyHunter.getListOfBountyHunters().add(hunter1);
        BountyHunter.getListOfBountyHunters().add(hunter2);
        BountyHunter.getListOfBountyHunters().add(hunter3);

        System.out.println(hunter1);
        System.out.println(hunter2);
        System.out.println(hunter3);

        BountyHunter testHunter = BountyHunter.getHunterById(3L);
        System.out.println("testHunter");
        System.out.println(testHunter);
    }

}
