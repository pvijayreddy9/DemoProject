package com.demoproject.dto;

import com.demoproject.entity.Department;

public class DepartmentDto {

	private int departmentId;
	
	private String departmentName;

	
//	public DepartmentDto(DepartmentDto dep) {
//		this.departmentId = dep.getDepartmentId();
//		this.departmentName = dep.getDepartmentName();
//	}

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

	@Override
	public String toString() {
		return "DepartmentDto {departmentId : " + departmentId + ", departmentName : " + departmentName + "}";
	}
	
	
}
