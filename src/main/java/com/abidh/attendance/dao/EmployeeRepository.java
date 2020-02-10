package com.abidh.attendance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abidh.attendance.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}