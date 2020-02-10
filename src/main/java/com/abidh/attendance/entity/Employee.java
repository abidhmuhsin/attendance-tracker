package com.abidh.attendance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "employees")
public class Employee {
	

	@TableGenerator(name = "EmpId_Gen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VAL", pkColumnValue = "EmpId_Gen", initialValue = 110, allocationSize = 10000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "EmpId_Gen")
	private Long empId;
	private String empName;
	private String emailId;
	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	


	@Override
	public String toString() {
		return "User [id=" + empId + ", uname=" + empName + "]";
	}

	
}