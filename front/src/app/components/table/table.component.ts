import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/services/user.service';

export interface User {
  id: number;
  name: string;
  nif: number;
}

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit{

  //userService: UserService;

  users = []; 
  displayedColumns = ["id","name","nif",];



  constructor(private userService: UserService) {
  this.userService.list().subscribe(u => { this.users = u })
  }

  ngOnInit(): void {
  }



}
