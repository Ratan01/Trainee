package com.example.Trainee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Trainee.entity.Trainee;
import com.example.Trainee.exception.TraineeIdNotFoundException;
import com.example.Trainee.exception.TraineeNameNotFoundException;
import com.example.Trainee.repository.TraineeRepository;

import java.util.*;


@Service("traineeServ")
public class TraineeService { 
	@Autowired
	private TraineeRepository traineeRepo;
	
	public List<Trainee> getAllTrainees() {
		return traineeRepo.findAll();
	}
	
	public Trainee getTraineesById(int id) {
		Optional<Trainee> op=traineeRepo.findById(id);
		if(op.isPresent())
		   return op.get();
		else
			 throw new TraineeIdNotFoundException("No Trainee found for this id: "+id);
	}
	
	public Trainee getTraineesByName(String name) {
		Optional<Trainee> op=traineeRepo.findByTraineeName(name);
		if(op.isPresent())
			return op.get();
		else
			throw new TraineeNameNotFoundException("No Trainee found for this name: "+name);
	}
	
	public String addTrainees(Trainee name) {
		traineeRepo.save(name);
		return "Inserted Successfully!!!";
	}
	
	public String deleteTraineesById(int TrId) {
		Optional<Trainee> op=traineeRepo.findById(TrId);
		if(op.isPresent()) {
			traineeRepo.deleteById(TrId);
			return "Deleted Successfully!!!";
		}
		else
			 throw new TraineeIdNotFoundException("No Trainee found for this id: "+TrId);
	}
		
	public String updateTrainees(Trainee e) {
		traineeRepo.save(e);
		return "Updated Successfully!!!";
	}

}
