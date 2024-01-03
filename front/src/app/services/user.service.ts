import { Injectable } from '@angular/core';
import { User } from '../components/table/table.component';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs';


@Injectable({
  providedIn: 'root'
})

export class UserService {

  constructor(public httpClient: HttpClient) {
  }
  
  private readonly API = 'http://localhost:8080';

  list() {
    return this.httpClient.get<any>('http://localhost:8080')

  }

  post(user: User) {
    const url = `${this.API}`;
    return this.httpClient.post(url, user);
  }


}


