package com.demoproject.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demoproject.dto.EmployeeDto;
import com.demoproject.entity.Department;
import com.demoproject.entity.Employee;
import com.demoproject.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	@Autowired
	private EmployeeController empController;
	
	@Autowired
	ObjectMapper objMapper;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService empService;
	
	private EmployeeDto employee;
	
	@BeforeEach
	void setup() {
		Department dep = new Department();
		dep.setDepartmentId(1);
		employee = new EmployeeDto();
		employee.setName("abc");
		employee.setDepartmentId(dep);
		employee.setSalary(89000);
	}
	
	@Test
	public void saveEmployee_Success() throws Exception {
		Department dep = new Department();
		dep.setDepartmentId(1);
		EmployeeDto emp = new EmployeeDto();
		emp.setName("abc");
		emp.setDepartmentId(dep);
		emp.setSalary(89000);
		Mockito.when(empService.saveEmployee(emp)).thenReturn(employee);
		mockMvc.perform(MockMvcRequestBuilders.post("/saveemployee")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "  \"empId\": 103,\r\n"
						+ "  \"name\": \"abc\",\r\n"
						+ "  \"departmentId\": {\r\n"
						+ "    \"departmentId\": 1,\r\n"
						+ "    \"departmentName\": \"\"\r\n"
						+ "  },\r\n"
						+ "  \"salary\": 10000\r\n"
						+ "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
