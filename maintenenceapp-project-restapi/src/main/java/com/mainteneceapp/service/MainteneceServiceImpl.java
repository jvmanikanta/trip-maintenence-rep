package com.mainteneceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mainteneceapp.exceptions.MaintenenceNotFoundException;
import com.mainteneceapp.model.Maintenence;
import com.mainteneceapp.model.Task;
import com.mainteneceapp.repo.IMaintenenceRepo;
@Service
public class MainteneceServiceImpl implements IMaintenenceService {

	@Autowired
	IMaintenenceRepo maintenenceRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String BASEURL="http://localhost:8082/task-service";
	
	@Override
	public List<Maintenence> getAllMaintenences() {
		return maintenenceRepo.findAll();
	}

	@Override
	public Maintenence getById(int projectId) throws MaintenenceNotFoundException {
		return maintenenceRepo.findById(projectId)
				.orElseThrow(() -> new MaintenenceNotFoundException("Maintenence Not Found"));
	}

	@Override
	public Maintenence getMaintenencesByName(String name) {
		return maintenenceRepo.findByMaintenenceName(name);
	}

	@Override
	public Maintenence addMaintenence(Maintenence maintenence) {
		return maintenenceRepo.save(maintenence);
	}

	@Override
	public Maintenence updateMaintenence(Maintenence maintenence) {
		return maintenenceRepo.save(maintenence);
	}

	@Override
	public void deleteMaintenence(int maintenenceId) {
		maintenenceRepo.deleteById(maintenenceId);
	}
	
	
	public ResponseEntity<Task> getTaskById(int taskId) {
		String url = BASEURL + "/task/" + taskId; 
		return restTemplate.getForEntity(url, Task.class);
	}

	@Override
	public ResponseEntity<List> getAllTasks() {
		String url = BASEURL + "/task";
		return restTemplate.getForEntity(url, List.class);
	}

	@Override
	public ResponseEntity<String> assignTask(int maintenenceId, int taskId) {
		String url = BASEURL + "/task/assigntask/maintenenceId/"+maintenenceId+"/taskId/"+taskId;
		return restTemplate.getForEntity(url, String.class);
	}

	@Override
	public void assignMaintenenceToTrip(int tripId, int maintenenceId) {
		maintenenceRepo.assignMaintenenceToTrip(tripId, maintenenceId);
	}
	
}
