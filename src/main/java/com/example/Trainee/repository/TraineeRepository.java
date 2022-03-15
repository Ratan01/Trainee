package com.example.Trainee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Trainee.entity.Trainee;


import java.util.*;


@Repository("traineeRepo")
public interface TraineeRepository extends JpaRepository<Trainee, Integer>{

	Optional<Trainee> findByTraineeName(String name);

}
