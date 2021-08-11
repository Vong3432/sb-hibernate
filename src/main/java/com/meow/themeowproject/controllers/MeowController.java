package com.meow.themeowproject.controllers;

import com.meow.themeowproject.exceptions.ResourceNotFoundException;
import com.meow.themeowproject.models.Meow;
import com.meow.themeowproject.repositories.MeowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MeowController {

    // DI(?)
    @Autowired
    MeowRepository meowRepository;

    @GetMapping("/meows")
    public List<Meow> getMeows() {
        return meowRepository.findAll();
    }

    @GetMapping("/meows/{id}")
    public Meow getMeow(@PathVariable(value = "id") Long meowId) {
        return meowRepository.findById(meowId)
                .orElseThrow(() -> new ResourceNotFoundException("Meow", "id", meowId));
    }

    @PostMapping("/meows")
    public Meow create(@Valid @RequestBody Meow meow) {
        // will return bad request if meow name is not provided
        return meowRepository.save(meow);
    }

    @PutMapping("/meows/{id}")
    public Meow update(@Valid @RequestBody Meow newMeow, @PathVariable(value = "id") Long meowId) {
        Meow meow = meowRepository.findById(meowId)
                .orElseThrow(() -> new ResourceNotFoundException("Meow", "id", meowId));
        meow.setName(newMeow.getName());
        meow.setDescription(newMeow.getDescription());

        Meow updatedMeow = meowRepository.save(meow);
        return updatedMeow;
    }

    @DeleteMapping("/meows/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long meowId) {
        Meow meow = meowRepository.findById(meowId)
                .orElseThrow(() -> new ResourceNotFoundException("Meow", "id", meowId));
        meowRepository.deleteById(meowId);
        return ResponseEntity.ok().build();
    }
}
