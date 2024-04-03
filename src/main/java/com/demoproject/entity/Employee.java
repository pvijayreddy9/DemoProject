package com.demoproject.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.demoproject.dto.EmployeeDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
	@Column(name = "emp_Id")
    private Long empId;
    
	@Column(name = "name")
    private String name;
	
    @ManyToOne
	@JoinColumn(name = "departmentId_fk")
    private Department departmentId;
	
	@Column(name = "salary")
    private int salary;
	
		
	public Employee() {
		super();
		
	}
	
	
	public Employee(Long empId, String name, Department departmentId, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.departmentId = departmentId;
		this.salary = salary;
	}


	public Employee(EmployeeDto empdto) {
		super();
		this.empId = empdto.getEmpId();
		this.name = empdto.getName();
		this.departmentId = empdto.getDepartmentId();
		this.salary = empdto.getSalary();
	}


	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee {"
				+ "empId : " + empId + 
				", name : " + name + 
				", departmentId : {"+
				"departmentId : " + departmentId.getDepartmentId() + 
				", departmentName : " + departmentId.getDepartmentName() + 
						"}"+
				", salary : " + salary
				+ "}";
	}
	
	public static List<EmployeeDto> convertToDto(List<Employee> empList){
		List<EmployeeDto> empListDto = new ArrayList<>();		
		ObjectMapper objMapper = new ObjectMapper();
        for (Employee employee : empList) {
			empListDto.add(objMapper.convertValue(employee, EmployeeDto.class));
		}
        return empListDto;
		
	}
	
//	public static void main(String[] args) throws JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		Employee employee = new Employee();
//		Department dep = new Department();
//		employee.setDepartmentId(dep);
//        // Convert the Java object to JSON string
//        String jsonString = objectMapper.writeValueAsString(employee);
//        System.out.println("JSON representation of the object:");
//        System.out.println(jsonString);
//	}
	
	
	
	
	
}
