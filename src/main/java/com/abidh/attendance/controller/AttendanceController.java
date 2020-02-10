package com.abidh.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abidh.attendance.dao.AttendanceRepository;
import com.abidh.attendance.entity.Attendance;
import com.abidh.attendance.entity.Employee;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

	
    @Autowired
    private AttendanceRepository attendanceRepository;

    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
    

    @GetMapping("/empStatus/{empId}")
    public Boolean getTodaysEmpStatus(@PathVariable String empId) {
        return attendanceRepository.getTodaysEmpStatus(empId).size() == 1;
        // true - if employee inside office and not swiped out
        // false - if employe has swiped out
    }
    
    @GetMapping("/activeNow")
    public List<Employee>  getActiveEmployees() {
        return attendanceRepository.getEmployeesInsideCurrently();
        // list of employees who has swiped in and not swiped out today.. ie inside office
    }
    
    @GetMapping("/timeInside/{empId}")
    public String getTotalTimeSpentByEmp(@PathVariable String empId) {
    	Long inTime =attendanceRepository.getTotalTimeSpentByEmp(empId);
    	inTime = inTime!=null?inTime:0;
        return inTime/(60*60) + " Hours";
       
    }
    
    @GetMapping("/timeInside/all")
    public List<Object> getTotalTimeSpentByAllEmployees() {
    	return attendanceRepository.getTotalTimeSpentByAllEmployees();
    	// returns List of  {empID,empNAME,TotalLimeTillLastSwipeOut}       
    }
    
    @PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public String updateEntryExitTime(@RequestBody Attendance attRequest) {
    	System.out.println(attRequest);
    	int updated = 0;
    	String res = "Enter Valid Value";
    	if(attRequest.getEntryTime()!=null) {
    		updated = attendanceRepository.updateEntryTime(attRequest.getEntryTime(), attRequest.getEmpId());
    	}
    	if(attRequest.getExitTime()!=null) {
    		updated = attendanceRepository.updateEntryTime(attRequest.getExitTime(), attRequest.getEmpId());
    	}
    	if(updated>0) {
        	return "success";
    	}
    	else{
    		return res;// ;
    	}
    	//  UPDATE TODAYS ENTRY/EXIT TIME
    }
    

}

