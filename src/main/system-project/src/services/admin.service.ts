import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/model/User';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  getCurrentAdmin(): Observable<string> {

    return this.http.get(environment.adminControllerUrl + '/current', { responseType: 'text' });
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(environment.adminControllerUrl + '/users');
  }

  logout(): Observable<void> {
    return this.http.get<void>(environment.adminControllerUrl + '/logout');
  }

  update(user: User): Observable<User> {
    return this.http.post<User>(environment.adminControllerUrl + '/update', user);
  }
}
