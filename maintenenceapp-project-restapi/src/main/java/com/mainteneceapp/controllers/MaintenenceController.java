package com.mainteneceapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainteneceapp.model.Maintenence;
import com.mainteneceapp.service.IMaintenenceService;

@RestController
@RequestMapping("/maintenence-service")
public class MaintenenceController {

	@Autowired
	IMaintenenceService maintenenceService;
	
	@PostMapping("/maintenence")
	public Maintenence addMaintenence(@RequestBody Maintenence maintenence) {
		return maintenenceService.addMaintenence(maintenence);
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
	public Maintenence getById(@PathVariable("maintenenceId")int maintenenceId) {
		return maintenenceService.getById(maintenenceId);
	}
	
	@GetMapping("/maintenence")
	public List<Maintenence> viewAllMaintenence(){
		return maintenenceService.getAllProjects();
	}
}
