import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { User } from "../model/User.model";
import { LoginService } from "../services/login.service";
@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  hasSubmitted: boolean = false;
  users : User[];
  constructor(private fb: FormBuilder, private router: Router, private loginService: LoginService) {}

  
  ngOnInit() {
    this.createForm();
  }

  createForm() {
    this.form = this.fb.group({
      username: [
        "",
        [Validators.required, Validators.pattern("^[a-zA-Z0-9-]+$")],
      ],
      password: ["", [Validators.required, Validators.minLength(4)]],
    });
  }

  get username() {
    return this.form.get("username");
  }
  get password() {
    return this.form.get("password");
  }

  logueo(){
    console.log(this.form);
    if (this.form.value.username != null) {
      this.loginService.login(this.form.value).subscribe((user : any) =>{
        console.log(user);
        
        this.users = user;
      }, error  => console.error(error.message)
      );
  }
}
}
