import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ManageEmployeeComponent } from './home/manage-employee/manage-employee.component';
import { AttendanceTrackerComponent } from './home/attendance-tracker/attendance-tracker.component';
import { FormsModule } from '@angular/forms';
import { ReportsComponent } from './home/reports/reports.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ManageEmployeeComponent,
    AttendanceTrackerComponent,
    ReportsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
