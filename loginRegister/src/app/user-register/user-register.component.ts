import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRegisterService } from '../services/user-register.service';
import { User } from '../model/User.model';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {
  form: FormGroup;
  user: any;
  Users: User[];
  constructor(private fb: FormBuilder, private router: Router, private userService: UserRegisterService) { }

  ngOnInit() {
    this.createForm();
  }
  createForm() {
    this.form = this.fb.group({
      idUser: [],
      username: [""],
      password: ["", [Validators.required, Validators.minLength(4)]],
      email: ["", [Validators.required, Validators.pattern("^[a-zA-Z0-9-]+$")]],
      phone: [null, Validators.required],
      country: [null, Validators.required],
      city: [null, Validators.required]
    });
  }

  registerUser() {
    console.log(this.form.value);
    this.user = {
      idUser: this.form.value.idUser,
      name: this.form.value.username,
      password: this.form.value.password,
      email: this.form.value.email,
      phones: [{
        contrycode: this.form.value.country,
        citycode: this.form.value.city,
        number: this.form.value.phone

      }]

    }
    console.log(this.user);
    if (this.form.value.idUser === null) {
      this.userService.userRegister(this.user)
        .subscribe((usr: any) => {
          console.log(usr);

          this.Users = usr;
           Swal.fire("User created");
          this.resetFormulario();
        });
    }
  }

  resetFormulario() {
    this.form.reset({
      idUser:null,
      name:null,
        password:null,
      email:null,
        phones:null,
      contrycode:null,
        citycode:null,
      number:null
  });
  }
}