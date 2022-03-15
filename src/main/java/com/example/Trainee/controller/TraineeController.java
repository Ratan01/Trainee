package com.example.Trainee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Trainee.entity.Trainee;
import com.example.Trainee.exception.TraineeNameNotFoundException;
import com.example.Trainee.respose.ResponseInfo;
import com.example.Trainee.services.TraineeService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class TraineeController {
	@Autowired
	private TraineeService traineeServ;
	
	@Operation(summary="detail of all the trainee")
	@GetMapping("/trainee")
	List<Trainee> getAllTrainee(){
		return traineeServ.getAllTrainees();
	}
	
	@GetMapping("/trainee/byId/{id}")
	//@ExceptionHandler(TraineeIdNotFoundException.class)
	Trainee getTraineeById(@PathVariable("id") int id)
	{
		return traineeServ.getTraineesById(id);
	}
	
	@GetMapping("/trainee/byName/{name}")
	Trainee getTraineeByName(@PathVariable("name") String name)throws TraineeNameNotFoundException {
		return traineeServ.getTraineesByName(name);
	}	
	
	/*@PostMapping("/trainee")
	String insertTrainee(@RequestBody Trainee name)
	{
		return traineeServ.addTrainees(name);
	}
	*/
	
	@PostMapping("/trainee")
    ResponseEntity<ResponseInfo> insertTrainee(@Valid @RequestBody Trainee name,HttpServletRequest request){
		String msg=traineeServ.addTrainees(name);
	    ResponseInfo rinfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
	    ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.CREATED);
	    return rentity;
	}
	
	/*
	@DeleteMapping("/trainee/byId/{id}")
	String deleteTrainee(@PathVariable("id") int id)
	{
		return traineeServ.deleteTraineesById(id);
	}
	*/
	
	@DeleteMapping("/trainees/byId/{id}")
	ResponseEntity<ResponseInfo> deleteTrainee(@Valid @PathVariable("id") int id, HttpServletRequest request){
		String msg=traineeServ.deleteTraineesById(id);
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
		return rentity;
	}
	
	/*
	@PutMapping("/trainee/update/")
	String updateTrainee(@RequestBody Trainee name)
	{
		return traineeServ.updateTrainees(name);
	}
	*/
	
	@PutMapping("/trainee")
	ResponseEntity<ResponseInfo> updateTrainee(@Valid @RequestBody Trainee name, HttpServletRequest request){
		String msg=traineeServ.updateTrainees(name);
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
		return rentity;
	}
	
}
