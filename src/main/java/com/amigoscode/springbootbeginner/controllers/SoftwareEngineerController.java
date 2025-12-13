package com.amigoscode.springbootbeginner.controllers;

import com.amigoscode.springbootbeginner.models.SoftwareEngineer;
import com.amigoscode.springbootbeginner.services.SoftwareEngineerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id) {
        return softwareEngineerService.getEngineerById(id);
    }

    @PostMapping
    public void addEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.addEngineer(softwareEngineer);
    }

    @PutMapping("{id}")
    public void updateEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.updateEngineer(id, softwareEngineer);
    }

    @DeleteMapping("{id}")
    public void deleteEngineer(@PathVariable Integer id) {
        softwareEngineerService.deleteEngineer(id);
    }

}
