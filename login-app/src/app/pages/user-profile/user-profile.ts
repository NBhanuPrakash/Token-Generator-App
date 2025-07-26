import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { UserDetails } from '../../model/UserDetails';
import { Loginservice } from '../../sevice/loginservice';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.html',
  styleUrls: ['./user-profile.scss'],
})
export class UserProfile implements OnInit {
  userDetails!: UserDetails | undefined;

  constructor(
    private loginservice: Loginservice,
    private toast: ToastrService,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginservice.getUserDetails().subscribe({
      next: (data) => {
        this.userDetails = data;
        this.cdr.detectChanges();
      },
      error: (err)=>{
        console.log(err);
      }
    });
  }
}
