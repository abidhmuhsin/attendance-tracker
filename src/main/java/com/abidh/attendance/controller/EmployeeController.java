package com.abidh.attendance.controller;

import com.abidh.attendance.dao.EmployeeRepository;
import com.abidh.attendance.entity.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeController {

	
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    @PostMapping("/add")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    
    
    @DeleteMapping("/remove/{id}")
    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId)
    throws Exception {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> new Exception("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map < String, Boolean > response = new HashMap< > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
//    
//   @ResponseBody
//   @RequestMapping(method = RequestMethod.GET, produces = "application/json")
//   public String demo() {
//
//       return "{\"hello\":\"world\"}";
//
//   }
//   
}

