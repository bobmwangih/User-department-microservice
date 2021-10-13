package com.bob.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bob.department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
