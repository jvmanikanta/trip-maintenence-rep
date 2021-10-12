package com.mainteneceapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mainteneceapp.exceptions.MaintenenceNotFoundException;
import com.mainteneceapp.model.Maintenence;
import com.mainteneceapp.model.Task;

public interface IMaintenenceService {
	
	public Maintenence addMaintenence(Maintenence maintenece);
	public Maintenence updateMaintenence(Maintenence maintenence) throws MaintenenceNotFoundException;
	public void deleteMaintenence(int maintenenceId) throws MaintenenceNotFoundException;
	
	public List<Maintenence> getAllMaintenences();
	public Maintenence getById(int projectId) throws MaintenenceNotFoundException;
	public Maintenence getMaintenencesByName(String name) throws MaintenenceNotFoundException;
	
	public ResponseEntity<Task> getTaskById(int taskId);
	public ResponseEntity<List> getAllTasks(); 
	public ResponseEntity<String> assignTask(int maintenenceId, int taskId);
	
	public void assignMaintenenceToTrip(int tripId, int maintenenceId);
}
