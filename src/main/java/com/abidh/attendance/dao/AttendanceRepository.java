package com.abidh.attendance.dao;

import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abidh.attendance.entity.Attendance;
import com.abidh.attendance.entity.Employee;


@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

	  @Query("select rec from #{#entityName} rec where rec.empId = ?1 AND rec.date = CURRENT_DATE AND rec.exitTime IS NULL" )
	  List<Attendance> getTodaysEmpStatus(String empId);
	  
	  @Query("select e from Employee e where e.empId IN"
	  		+ "(select rec.empId from #{#entityName} rec where rec.date = CURRENT_DATE AND rec.exitTime IS NULL )")
	  List<Employee> getEmployeesInsideCurrently();
	  
	  @Query("select SUM(DATEDIFF(SECOND,rec.entryTime,rec.exitTime)) from #{#entityName} rec"
	  		+ " where rec.empId = ?1  GROUP BY rec.empId")
	  Long getTotalTimeSpentByEmp(String empId);
	  
	  @Query("select  rec.empId,emp.empName, SUM(DATEDIFF(SECOND,rec.entryTime,rec.exitTime)) from #{#entityName} rec"
	  			+ " JOIN Employee emp ON (rec.empId = emp.empId AND rec.exitTime IS NOT NULL)"
		  		+ " GROUP BY rec.empId")
	  List<Object>  getTotalTimeSpentByAllEmployees();
	
	  
	  /*update query throwing exception due to below issue.. not fixed due to shortage of time
	   * https://github.com/spring-projects/spring-boot/issues/3576
	   * */
	  @Modifying
	  @Query("update  #{#entityName} rec set rec.entryTime = ?1 where rec.empId = ?2 AND rec.date = CURRENT_DATE")
	  int updateEntryTime(Time entryTime, String empId);
	  
	  @Modifying
	  @Query("update  #{#entityName} rec set rec.exitTime = ?1 where rec.empId = ?2 AND rec.date = CURRENT_DATE")
	  int updateExitTime(Time exitTime, String empId);
	  
}