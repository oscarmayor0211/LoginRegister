import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { User } from "../model/User.model";
import { LoginService } from "../services/login.service";
import Swal from 'sweetalert2';
@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  hasSubmitted: boolean = false;
  users: User[];
  constructor(private fb: FormBuilder, private router: Router, private loginService: LoginService) { }


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

  logueo() {
      this.loginService.login(this.form.value).subscribe((user: any) => {
        this.users = user;
        const jwtToken = user.token;
        const name = user.name;
        // Almacena el token en el almacenamiento local o en una cookie, por ejemplo.
        localStorage.setItem('token', jwtToken);
        localStorage.setItem('user',JSON.stringify(this.users));
                // Realiza cualquier redirección o acción necesaria después del inicio de sesión.

        this.router.navigate(['home/user']);
      }, error => {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: error.error.message,
        })
      }

      );
    
  }
}
