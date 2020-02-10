package com.abidh.attendance.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "attendance")
public class Attendance {

	@TableGenerator(name = "Attendance_Gen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VAL", pkColumnValue = "Attendance_Gen", initialValue = 1000, allocationSize = 10000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Attendance_Gen")
	private int entryId;
	private String empId;
	private Date date;
	private Time entryTime;
	private Time exitTime;


	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Time entryTime) {
		this.entryTime = entryTime;
	}

	public Time getExitTime() {
		return exitTime;
	}

	public void setExitTime(Time exitTime) {
		this.exitTime = exitTime;
	}




	@Override
	public String toString() {
		String str = "";
		try {
			str = new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}