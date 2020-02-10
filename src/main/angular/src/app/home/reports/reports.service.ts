import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReportsService {

  constructor(private http: HttpClient) { }

  

  public getCurrentlyActiveEmployeesInside (): Observable<Object[]>  {
    return this.http.get<Object[]>('http://localhost:8080/api/v1/attendance/activeNow');
  }
  
  public getTimeInsideReport():Observable<Object[]>  {
    return this.http.get<Object[]>('http://localhost:8080/api/v1/attendance/timeInside/all');
  }

}
