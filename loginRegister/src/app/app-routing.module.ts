import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserRegisterComponent } from './user-register/user-register.component';
import { LoginComponent } from './login/login.component';
import { EditRegisterComponent } from './edit-register/edit-register.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [  { path: '', redirectTo: '/login', pathMatch: 'full' },
{ path: 'login', component: LoginComponent   },
{ path: 'home', component: HomeComponent   },
{ path: 'user/register', component: UserRegisterComponent  },
{ path: 'user/edit/:id', component:  EditRegisterComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
