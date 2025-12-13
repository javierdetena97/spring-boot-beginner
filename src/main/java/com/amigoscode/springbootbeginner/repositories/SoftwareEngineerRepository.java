package com.amigoscode.springbootbeginner.repositories;

import com.amigoscode.springbootbeginner.models.SoftwareEngineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareEngineerRepository extends JpaRepository<SoftwareEngineer, Integer> {
}
