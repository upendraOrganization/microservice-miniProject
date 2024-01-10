package com.sikku.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sikku.errors.DoctorNotFoundException;
import com.sikku.model.Doctor;
import com.sikku.repository.IDoctorRepo;

@Service("doctorService")
public class DoctoerMgmtServiceImpl implements IDoctoerMgmtService {
	@Autowired
	private IDoctorRepo repo;

	@Override
	public String registerDoctor(Doctor doctor) {
		Doctor save = repo.save(doctor);
		return "Doctor is registered with id: " + save.getDocId();

	}

	@Override
	public Iterable<Doctor> getAllDoctor() {
		Sort sort = Sort.by(Direction.ASC, "docName");
		return repo.findAll(sort);
	}

	@Override
	public Doctor getDoctorById(Integer id) {
		Optional<Doctor> findById = repo.findById(id);
		return findById.orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + id));
	}

	@Override
	public String updateDoctor(Doctor doctor) {
		if (getDoctorById(doctor.getDocId()) != null) {
			repo.save(doctor);
		}
		return "Doctor updated having id: " + doctor.getDocId();
	}

	@Override
	public String deleteDoctorById(Integer docId) {
		if (getDoctorById(docId) != null) {
			repo.deleteById(docId);
		}
		return "Doctor deleted having id: " + docId;
	}

}
