import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
name : String;
  constructor() { }

  ngOnInit() {
    this.name = localStorage.getItem('name');
    console.log(name);
    
  }

}
