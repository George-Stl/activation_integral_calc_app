package com.activation.integral.app.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElementRepository extends JpaRepository<ElementEntity, Long> {
    Optional<ElementEntity> findByName(String name);
}
