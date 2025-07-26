import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { UserProfile } from './pages/user-profile/user-profile';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: Login },
  { path: 'user', component: UserProfile },
  { path: '**', redirectTo: 'login' }
];
