package com.bob.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bob.department.entity.Department;
import com.bob.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside saveDepartment method of tje DepartmentController");
		return departmentService.saveDepartment(department);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> findDepartmentById(@PathVariable("id") Long departMentId) {
		log.info("inside findDepartmentById of the DepartmentController");
		return departmentService.findDepartmentById(departMentId);
	}
}
