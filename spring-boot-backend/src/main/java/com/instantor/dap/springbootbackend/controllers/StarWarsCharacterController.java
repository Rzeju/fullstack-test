package com.instantor.dap.springbootbackend.controllers;

import com.instantor.dap.springbootbackend.services.StarWarsCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/sw/character")
public class StarWarsCharacterController {
    /**
     * @return character from Star Wars
     */
    @Autowired
    StarWarsCharacterService starWarsCharacterService;

    @GetMapping("/introduction")
    public String getWelcomeMessage() {
        return starWarsCharacterService.getWelcomeMessage();
    }

    @GetMapping("/description")
    public String getCharacterDescription() {
        return starWarsCharacterService.getVaderDescription();
    }
}
