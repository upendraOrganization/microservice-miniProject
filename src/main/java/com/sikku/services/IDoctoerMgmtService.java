package com.sikku.services;

import com.sikku.model.Doctor;

public interface IDoctoerMgmtService {
	
	String registerDoctor(Doctor doctor);
	Iterable<Doctor> getAllDoctor();
	Doctor getDoctorById(Integer id);
	String updateDoctor(Doctor doctor);
	String deleteDoctorById(Integer docId);

}
