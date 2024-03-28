package com.demoproject.entity;

import com.demoproject.dto.DepartmentDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Department")
public class Department {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
	@Column(name = "departmentId")
	private int departmentId;
	
	@Column(name = "department_name")
	private String departmentName;

	
	
	public Department() {
		super();
		
	}
	

	public Department(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}


	public Department(DepartmentDto depDto) {
		super();
		this.departmentId = depDto.getDepartmentId();
		this.departmentName = depDto.getDepartmentName();
	}


	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}


	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
