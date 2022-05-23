package de.dhbw.tim21.helloworld.repository;

import de.dhbw.tim21.helloworld.model.Pegel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Pegel, Long> {

    List<Pegel> findByKurs(String kurs);

    List<Pegel> findByVornameContaining(String vorname);
}
