package com.bob.department.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bob.department.entity.Department;
import com.bob.department.exceptions.DepartmentNotFoundException;
import com.bob.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("Inside the saveDepartment of DepartmentService");
		return departmentRepository.save(department);
	}

	public ResponseEntity<Department> findDepartmentById(Long departMentId) {
		log.info("inside findDepartmentById of the DepartmentService");
		Department department = departmentRepository.findById(departMentId)
				.orElseThrow(() -> new DepartmentNotFoundException("Department with ID :" + departMentId + " doesnt exist"));
		return ResponseEntity.ok(department);
	}
	
	
}
