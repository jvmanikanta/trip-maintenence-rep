package com.mainteneceapp.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mainteneceapp.model.Maintenence;

@Repository
public interface IMaintenenceRepo extends JpaRepository<Maintenence, Integer> {

	public Maintenence findByMaintenenceName(String name);
	
	@Transactional
	@Modifying
	@Query(value="update maintenence set trip_id=?1 where maintenence_id=?2", nativeQuery=true) 
	void assignMaintenenceToTrip(int tripId, int maintenenceId);
}
