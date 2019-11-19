package com.instantor.dap.springbootbackend.controllers;

import com.instantor.dap.springbootbackend.domain.BountyHunter;
import com.instantor.dap.springbootbackend.domain.BountyTarget;
import com.instantor.dap.springbootbackend.services.StarWarsCharacterService;
import com.instantor.dap.springbootbackend.services.Utils.ListResponseWrapper;
import com.instantor.dap.springbootbackend.services.Utils.StringResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/sw/character")
public class StarWarsCharacterController {
    /**
     * @return character from Star Wars
     */

    private StarWarsCharacterService starWarsCharacterService;

    @Autowired
    public StarWarsCharacterController(StarWarsCharacterService starWarsCharacterService) {
        this.starWarsCharacterService = starWarsCharacterService;
    }

    @GetMapping(value="/introduction", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringResponseWrapper> getWelcomeMessage() {
        return new ResponseEntity<>(starWarsCharacterService.getWelcomeMessage(), HttpStatus.OK);
    }

    @GetMapping(value="/description", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringResponseWrapper> getCharacterDescription() {
        return new ResponseEntity<>(starWarsCharacterService.getVaderDescription(), HttpStatus.OK);
    }

    @GetMapping(value="/hunterValue/{hunterId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringResponseWrapper> getBountyHunterPocket(@PathVariable Long hunterId) {
        return new ResponseEntity<>(starWarsCharacterService.getBountyHunterPocket(hunterId), HttpStatus.OK);
    }

    @GetMapping(value="/hunters", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListResponseWrapper> getBountyHuntersList() {
        return new ResponseEntity<>(starWarsCharacterService.getBountyHuntersList(), HttpStatus.OK);
    }

    @GetMapping(value="/targets", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListResponseWrapper> getBountyTargetsList() {
        return new ResponseEntity<>(starWarsCharacterService.getBountyTargetList(), HttpStatus.OK);
    }

    @PostMapping(value="/createHunter", consumes = MediaType.APPLICATION_JSON_VALUE , produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BountyHunter> createBountyHunter(@RequestBody BountyHunter hunter) {
        BountyHunter.getListOfBountyHunters().add(hunter);
        return new ResponseEntity<>(hunter, HttpStatus.OK);
    }

    @PostMapping(value="/createBounty", consumes = MediaType.APPLICATION_JSON_VALUE , produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BountyTarget> createBountyHunter(@RequestBody BountyTarget target) {
        BountyTarget.getBountiesList().add(target);
        return new ResponseEntity<>(target, HttpStatus.OK);
    }

    @GetMapping(value="/startMission/{hunterId}/{targetId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringResponseWrapper> startBountyMission(@PathVariable Long hunterId, @PathVariable Long targetId) {
        return new ResponseEntity<>(starWarsCharacterService.startMission(hunterId, targetId), HttpStatus.OK);
    }


}
