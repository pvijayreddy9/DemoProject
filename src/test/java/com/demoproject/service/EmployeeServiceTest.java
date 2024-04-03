package com.demoproject.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demoproject.dao.EmployeeRepository;
import com.demoproject.entity.Department;
import com.demoproject.entity.Employee;
@SpringBootTest
class EmployeeServiceTest {
	@Autowired
	private EmployeeService empService;
	
	@MockBean
	private EmployeeRepository empRepo;
	
	@BeforeEach
	void setup() {
		Optional<Employee> employee = Optional.of(new Employee(103l,"abc",new Department(1, "Software developer"),89000));
		Mockito.when(empRepo.findById(103l)).thenReturn(employee);
	}
	
	@Test
	public void getEmployeeById_Success() {
		String empName = "abc";
		Employee emp = empService.findEmployeeById(103l);
		assertEquals(empName,emp.getName());
	}
	
}
