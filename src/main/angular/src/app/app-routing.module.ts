import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ManageEmployeeComponent } from './home/manage-employee/manage-employee.component';
import { AttendanceTrackerComponent } from './home/attendance-tracker/attendance-tracker.component';
import { ReportsComponent } from './home/reports/reports.component';


const routes: Routes =
  [{ path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home',
    component: HomeComponent,
    children: [
      { path: 'tracker', component: AttendanceTrackerComponent },
      { path: 'tracker/:empId', component: AttendanceTrackerComponent },
      { path: 'reports', component: ReportsComponent },
      { path: 'employees', component: ManageEmployeeComponent }
    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
