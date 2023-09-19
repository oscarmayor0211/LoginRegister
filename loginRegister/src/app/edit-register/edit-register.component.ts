import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../model/User.model';
import { UserRegisterService } from '../services/user-register.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-register',
  templateUrl: './edit-register.component.html',
  styleUrls: ['./edit-register.component.css']
})
export class EditRegisterComponent implements OnInit {
  form: FormGroup;
  users : User[];
  user:any;
  constructor(private fb: FormBuilder, private userService: UserRegisterService) { }

  ngOnInit() {
    this.users = JSON.parse(localStorage.getItem('user'));
    this.createForm();
  }
  createForm() {
    this.form = this.fb.group({
      idUser:[this.users['id']],
      username: [this.users['name']],
      password: [this.users['password'], [Validators.required, Validators.minLength(4)]],
      email: [this.users['email'],[Validators.required, Validators.pattern("^[a-zA-Z0-9-]+$")]],
      phone :[this.users['phones'][0]['number'], Validators.required],
      country:[this.users['phones'][0]['citycode'], Validators.required],
      city:[this.users['phones'][0]['contrycode'], Validators.required]
    });
  }

  updateService(){
    this.user = {
      idUser: this.form.value.idUser,
      name: this.form.value.username,
      password:this.form.value.password,
      email: this.form.value.email,
      phones:[ {
        contrycode: this.form.value.country,
        citycode: this.form.value.city,
        number: this.form.value.phone
      
      }]
    }
    this.userService.editRegister(this.user).subscribe((usr: any) =>{
      this.users = usr;
      Swal.fire("User Edited");

    })
  }
}
