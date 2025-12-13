package com.amigoscode.springbootbeginner.services;

import com.amigoscode.springbootbeginner.models.SoftwareEngineer;
import com.amigoscode.springbootbeginner.repositories.SoftwareEngineerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public SoftwareEngineer getEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + "not found"));
    }

    public void addEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public void updateEngineer(Integer id, SoftwareEngineer updatedEngineer) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + "not found"));
        softwareEngineer.setName(updatedEngineer.getName());
        softwareEngineer.setTechStack(updatedEngineer.getTechStack());
        softwareEngineerRepository.save(softwareEngineer);
    }

    public void deleteEngineer(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (!exists) throw new IllegalStateException(id + "not found");
        softwareEngineerRepository.deleteById(id);
    }

}
