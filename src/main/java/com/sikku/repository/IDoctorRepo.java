package com.sikku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sikku.model.Doctor;

@Repository
public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {

}
