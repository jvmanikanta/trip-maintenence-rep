package com.mainteneceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainteneceapp.model.Maintenence;
import com.mainteneceapp.repo.IMaintenenceRepo;
@Service
public class MainteneceServiceImpl implements IMaintenenceService {

	@Autowired
	IMaintenenceRepo maintenenceRepo;
	
	@Override
	public List<Maintenence> getAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maintenence getById(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Maintenence> getProjectsByName(String name) {
		// TODO Auto-generated method stub
		return null;
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

}
