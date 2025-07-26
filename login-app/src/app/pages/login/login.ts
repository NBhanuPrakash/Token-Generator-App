import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Loginservice } from '../../sevice/loginservice';
import { UserRegisters } from '../../model/UserRegisters';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule, CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.scss',
})
export class Login {
  userRegister: UserRegisters = {
    userName: '',
    password: '',
    roles: 'ROLE_USER',
  };
  isLogin = true;

  constructor(
    private login: Loginservice,
    private toaster: ToastrService,
    private router: Router
  ) {}

  onLoginSubmit(form: NgForm) {
    if (form.valid) {
      console.log('Login:', form.value);
      this.userRegister.userName = form.value.email;
      this.userRegister.password = form.value.password;
      this.login.getLogin(this.userRegister).subscribe({
        next: (data: { token: string }) => {
          console.log(data);
          if (data.token) {
            localStorage.setItem('authToken', data.token);
            this.toaster.success('Sucessfully Loged In!!', 'Sucess');
            this.router.navigateByUrl('/user'); 
          }
        },
        error: (err: any) => {
          console.log(err);
          this.toaster.error('User Details are not correct', 'Error');
        },
      });
      form.reset();
    }
  }

  onRegisterSubmit(form: NgForm) {
    if (form.valid) {
      console.log('Register:', form.value);
      this.userRegister.userName = form.value.email;
      this.userRegister.password = form.value.password;
      this.login.getSubmitRegisterData(this.userRegister).subscribe({
        next: (data: any) => {
          this.toaster.success('Registered successfully!!!', 'Success');
        },
        error: (err: any) => {
          this.toaster.error('Registration failed', 'Error');
        },
      });

      form.reset();
    }
  }

  // ngOnInit(){
  //   this.login.getdata().subscribe(data=>{
  //     console.log(data);
  //   })
  // }
}
