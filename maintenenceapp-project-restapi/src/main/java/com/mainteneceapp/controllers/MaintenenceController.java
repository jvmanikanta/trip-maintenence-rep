package com.mainteneceapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainteneceapp.model.Maintenence;
import com.mainteneceapp.model.Task;
import com.mainteneceapp.service.IMaintenenceService;

@RestController
@RequestMapping("/maintenence-service")
public class MaintenenceController {

	@Autowired
	IMaintenenceService maintenenceService;
	
	@PostMapping("/maintenence")
	public ResponseEntity<Maintenence> addMaintenence(@RequestBody Maintenence maintenence) {
		return ResponseEntity.ok(maintenenceService.addMaintenence(maintenence));
	}
	
	@PutMapping("/maintenence")
	public Maintenence updateMaintenence(@RequestBody Maintenence maintenence) {
		return maintenenceService.updateMaintenence(maintenence);
	}
	
	@DeleteMapping("/maintenence/maintenenceId/{maintenenceId}")
	public void deleteMaintenence(@PathVariable("maintenenceId") int maintenenceId) {
		maintenenceService.deleteMaintenence(maintenenceId);
	}
	
	@GetMapping("/maintenence/maintenenceId/{maintenenceId}")
	public ResponseEntity<Maintenence> getById(@PathVariable("maintenenceId")int maintenenceId) {
		return ResponseEntity.ok(maintenenceService.getById(maintenenceId));
	}
	
	@GetMapping("/maintenence")
	public ResponseEntity<List> viewAllMaintenence(){
		return ResponseEntity.ok(maintenenceService.getAllMaintenences());
	} 
	
	@GetMapping("/maintenence/task/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable("taskId")int taskId){
		return maintenenceService.getTaskById(taskId);
	}
	
	@GetMapping("/maintenence/task")
	public ResponseEntity<List> viewAllTasks(){
		return maintenenceService.getAllTasks();
	}
	@GetMapping("maintenence/task/assign/maintenenceId/{maintenenceId}/taskId/{taskId}")
	public ResponseEntity<String> assignTask(@PathVariable("maintenenceId")int maintenenceId, @PathVariable("taskId")int taskId){
		return maintenenceService.assignTask(maintenenceId, taskId);
	}
	@GetMapping("maintenence/task/assigntrip/tripId/{tripId}/maintenenceId/{maintenenceId}")
	public ResponseEntity<String> assignMaintenenceToTrip(@PathVariable("tripId")int tripId, @PathVariable("maintenenceId")int maintenenceId){
		maintenenceService.assignMaintenenceToTrip(tripId, maintenenceId);
		return ResponseEntity.ok("updated");
	}
}
