import { Component, OnInit } from '@angular/core';
import { User } from '../model/User.model';
import { Router } from '@angular/router';
import { UserRegisterService } from '../services/user-register.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
name : String;
users : User[];
  constructor(private router: Router, private userService: UserRegisterService) { }

  ngOnInit() {
    this.users = JSON.parse(localStorage.getItem('user'));
    this.name = this.users['name'];
  }


  updateUser(){
  console.log(this.users);
  this.router.navigate(['user/edit']);
  }

  logOut(){
    this.userService.logOut();
    this.router.navigate(['login']);
  }
}
