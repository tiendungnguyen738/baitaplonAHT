package aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aht.entity.AhtTraining;


public interface TrainingRepository extends JpaRepository<AhtTraining, Long>{

}
