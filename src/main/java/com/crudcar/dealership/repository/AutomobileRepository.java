package com.crudcar.dealership.repository;

import com.crudcar.dealership.entities.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomobileRepository extends JpaRepository<Automobile, Long> {
}
