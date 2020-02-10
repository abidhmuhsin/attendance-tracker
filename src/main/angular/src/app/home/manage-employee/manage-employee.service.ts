import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ManageEmployeeService {

  constructor(private http: HttpClient) { }


  public getAllEmployees (): Observable<Object[]> {
    return this.http.get<Object[]>('http://localhost:8080/api/v1/emp/all');
  }

  public addNewEmployee (newEmp): Observable<Object> {
    return this.http.post('http://localhost:8080/api/v1/emp/add',
                                    newEmp);
  }

  public removeEmployee (empId): Observable<Object> {
    return this.http.delete('http://localhost:8080/api/v1/emp/remove/' + empId);
  }


}
