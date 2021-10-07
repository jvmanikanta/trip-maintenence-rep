package com.mainteneceapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainteneceapp.model.Maintenence;

@Repository
public interface IMaintenenceRepo extends JpaRepository<Maintenence, Integer> {

}
