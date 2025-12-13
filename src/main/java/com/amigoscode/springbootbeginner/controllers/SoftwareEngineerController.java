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
    public List<SoftwareEngineer> getAll() {
        return softwareEngineerService.getAll();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getById(@PathVariable Integer id) {
        return softwareEngineerService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.add(softwareEngineer);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.update(id, softwareEngineer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        softwareEngineerService.delete(id);
    }

}
