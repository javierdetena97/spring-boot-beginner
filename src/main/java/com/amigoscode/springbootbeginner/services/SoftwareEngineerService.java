package com.amigoscode.springbootbeginner.services;

import com.amigoscode.springbootbeginner.models.SoftwareEngineer;
import com.amigoscode.springbootbeginner.repositories.SoftwareEngineerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;
    private final AiService aiService;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository, AiService aiService) {
        this.softwareEngineerRepository = softwareEngineerRepository;
        this.aiService = aiService;
    }

    public List<SoftwareEngineer> getAll() {
        return softwareEngineerRepository.findAll();
    }

    public SoftwareEngineer getById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + "not found"));
    }

    public void add(SoftwareEngineer softwareEngineer) {
        String prompt = """
                Based on the programming tech stack %s that %s has given
                Provide a full learning path and recommendations for this person.
                """.formatted(
                softwareEngineer.getTechStack(),
                softwareEngineer.getName()
        );
        String chatResponse = aiService.chat(prompt);
        softwareEngineer.setLearningPathRecommendation(chatResponse);
        softwareEngineerRepository.save(softwareEngineer);
    }

    public void update(Integer id, SoftwareEngineer updatedEngineer) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + "not found"));
        softwareEngineer.setName(updatedEngineer.getName());
        softwareEngineer.setTechStack(updatedEngineer.getTechStack());
        softwareEngineerRepository.save(softwareEngineer);
    }

    public void delete(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (!exists) throw new IllegalStateException(id + "not found");
        softwareEngineerRepository.deleteById(id);
    }

}
