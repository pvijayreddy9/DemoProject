package com.demoproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	
	
}
