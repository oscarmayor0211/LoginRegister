import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserRegisterComponent } from './user-register/user-register.component';
import { LoginComponent } from './login/login.component';
import { EditRegisterComponent } from './edit-register/edit-register.component';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './login/auth.guard';


const routes: Routes = [  { path: '', redirectTo: '/login', pathMatch: 'full' },
{ path: 'login', component: LoginComponent   },
{ path: 'home/user', component: HomeComponent  , canActivate: [AuthGuard] },
{ path: 'user/register', component: UserRegisterComponent  },
{ path: 'user/edit', component:  EditRegisterComponent, canActivate:[AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
