import { Component, OnInit } from '@angular/core';
import { ManageEmployeeService } from './manage-employee.service';

@Component({
  selector: 'app-manage-employee',
  templateUrl: './manage-employee.component.html',
  styleUrls: ['./manage-employee.component.scss']
})
export class ManageEmployeeComponent implements OnInit {

  constructor(private empSvc: ManageEmployeeService) { }
 
  public empList;
  public newEmp = {emailId:'', empName:''};

  ngOnInit(): void {
      this.refreshEmployeeList();
  }

  public refreshEmployeeList(){
    this.empSvc.getAllEmployees().subscribe(empList => {
      this.empList = empList;
    })
  }
  public addEmployee() {
    // this.empList.push(this.newEmp);
     // console.log(this.newEmp);
    this.empSvc.addNewEmployee(this.newEmp).subscribe(res=>{
        this.refreshEmployeeList();
    });
    this.newEmp = {emailId:'', empName:''};
  }
  public removeEmployee(empId: string ) {
    this.empSvc.removeEmployee(empId).subscribe(res=>{
      this.refreshEmployeeList();
  });
  }

}
