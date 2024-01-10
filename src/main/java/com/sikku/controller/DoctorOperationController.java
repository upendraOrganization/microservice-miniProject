package com.sikku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sikku.model.Doctor;
import com.sikku.services.IDoctoerMgmtService;

@RestController
@RequestMapping("/doctor")
public class DoctorOperationController {

	@Autowired
	private IDoctoerMgmtService service;

	@PostMapping("/register")
	public ResponseEntity<String> registerDoctor(@RequestBody Doctor doctor) {

		try {
			String registerDoctor = service.registerDoctor(doctor);
			return new ResponseEntity<String>(registerDoctor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in Doctor registration", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/list")
	public ResponseEntity<?> listAllDoctor() {

		try {
			List<Doctor> allDoctor = (List<Doctor>) service.getAllDoctor();
			return new ResponseEntity<List<Doctor>>(allDoctor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in getting grecords", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> getDoctorById(@PathVariable Integer id) {

		try {
			Doctor doctor = service.getDoctorById(id);
			return new ResponseEntity<Doctor>(doctor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateDoctor(@RequestBody Doctor doctor) {

		try {
			String updateDoctor = service.updateDoctor(doctor);
			return new ResponseEntity<String>(updateDoctor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable Integer id) {

		try {
			String deleteDoctorById = service.deleteDoctorById(id);
			return new ResponseEntity<String>(deleteDoctorById, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
