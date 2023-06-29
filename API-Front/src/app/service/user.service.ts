import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { Observable, map } from 'rxjs';

@Injectable()
export class UserService {

  private usersUrl: string;
  private userReturn: string;


  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/api/clients';
    this.userReturn = 'http://localhost:8080/api/clients/';
  }

  findOne(id: number): Observable<User> {
    return this.http.get(this.userReturn + id).pipe(
      map((user: User) => user)
    );
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl + '/');
  }

  public save(formdata: FormData) {
    return this.http.post<User>(this.usersUrl, formdata);
  }
}

