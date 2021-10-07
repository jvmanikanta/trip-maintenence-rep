package com.mainteneceapp.service;

import java.util.List;

import com.mainteneceapp.model.Maintenence;

public interface IMaintenenceService {
	
	public Maintenence addMaintenence(Maintenence maintenece);
	public Maintenence updateMaintenence(Maintenence maintenence);
	public void deleteMaintenence(int maintenenceId);
	public List<Maintenence> getAllProjects();
	public Maintenence getById(int projectId);
	public List<Maintenence> getProjectsByName(String name);
}
