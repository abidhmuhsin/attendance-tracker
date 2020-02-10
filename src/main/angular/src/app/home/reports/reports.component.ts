import { Component, OnInit } from '@angular/core';
import { ReportsService } from './reports.service';

import { map } from 'rxjs/operators';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.scss']
})
export class ReportsComponent implements OnInit {

  constructor(private reportSvc:ReportsService) { }

  public presentEmpList;
  public officeHoursReport;

  ngOnInit(): void {
  }

  
  public getCurrentlyActiveEmployeesInside() {
    this.reportSvc.getCurrentlyActiveEmployeesInside().subscribe(res => {
    //  console.log(res)
      this.presentEmpList= res;
    });
  }

  public getOfficeHoursReport() {
    // call backend and convert seconds to hours before saving to officeHoursReport 
    this.reportSvc.getTimeInsideReport()
    .subscribe(res => {
      console.log(res)
       res.map(rec => 
          {
          if(rec[2] && rec[2]>0){
          //  convert seconds to hours 
          rec[2] = rec[2]/(60*60);
          }
       });
      this.officeHoursReport= res;
    });
  }

}
