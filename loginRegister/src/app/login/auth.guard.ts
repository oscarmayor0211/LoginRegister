import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    // Obtén el token JWT almacenado en el almacenamiento local o en una cookie
    const token = localStorage.getItem('token');

    if (token) {
      // El token JWT está presente, el usuario está autenticado
      return true;
    } else {
      // El token JWT no está presente, redirige a la página de inicio de sesión
      this.router.navigate(['/login']);
      return false;
    }
  }
}
