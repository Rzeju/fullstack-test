package com.instantor.dap.springbootbackend.controller;

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
    @GetMapping("/introduction")
    public String getCharacter() {
        return StartWarsCharacterConst.vaderWelcome;
    }

    @GetMapping("/description")
    public String getCharacterDescription() {
        return StartWarsCharacterConst.vaderDescription;
    }
}
