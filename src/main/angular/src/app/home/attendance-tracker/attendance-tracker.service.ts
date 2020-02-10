import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AttendanceTrackerService {

  constructor(private http: HttpClient) { }


  public getTimeInside (empId) {
    return this.http.get('http://localhost:8080/api/v1/attendance/timeInside/'+empId,
                        {responseType: 'text'});
  }

  public getCurrentInStatus (empId) {
    return this.http.get('http://localhost:8080/api/v1/attendance/empStatus/'+empId,
                        {responseType: 'text'});
  }

  
  public updateAttendance(attRecord) {
    return this.http.post('http://localhost:8080/api/v1/attendance/update'
                          ,attRecord
                          ,{responseType: 'text'});
  }


}
