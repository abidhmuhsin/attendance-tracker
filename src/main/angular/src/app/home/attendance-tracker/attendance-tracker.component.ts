import { Component, OnInit } from '@angular/core';
import { AttendanceTrackerService } from './attendance-tracker.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-attendance-tracker',
  templateUrl: './attendance-tracker.component.html',
  styleUrls: ['./attendance-tracker.component.scss']
})
export class AttendanceTrackerComponent implements OnInit {

  constructor(public attSvc: AttendanceTrackerService,
    private activatedRoute: ActivatedRoute) {
    this.activatedRoute.params.subscribe(params => {
      console.log('RouteParams in attendance tracker -', params);
        if(params.empId) {
          this.empId = params.empId;
          this.getDetails()
        } 
    });
  }

  public empId = '';
  public officeHoursSpent = '';  
  public isEmployeePresentInside = ''

  ngOnInit(): void {
  }

  public getDetails() {
    this.attSvc.getTimeInside(this.empId).subscribe(res => {
      console.log(res)
      this.officeHoursSpent = res + '';
    });
    this.attSvc.getCurrentInStatus(this.empId).subscribe(res => {
      console.log(res)
      this.isEmployeePresentInside= res + '';
    });
    
  }

  public updateEntryTime(time){
    if(this.empId === '') {
      alert('enter empid')
    }
    else this.attSvc
    .updateAttendance({entryTime:time, empId:this.empId})
    .subscribe();;
  }

  public updateExitTime(time){
    if(this.empId === '') {
      alert('enter empid')
    }
    else this.attSvc
    .updateAttendance({exitTime:time, empId:this.empId})
    .subscribe();;
  }


}
