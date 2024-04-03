package com.demoproject.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.demoproject.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository depRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setup() {
		Department department = new Department(1, "Software developer");
		entityManager.persist(department);
	}
	
	@Test
	public void testFindById() {
		Department dep = depRepo.findById(44l).get();
		assertEquals("Software developer", dep.getDepartmentName());
	}


}
