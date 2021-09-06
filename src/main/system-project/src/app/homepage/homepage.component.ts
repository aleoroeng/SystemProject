import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { AdminService } from 'src/services/admin.service';
import { User } from '../model/User';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private adminService: AdminService) { }

  currentAdminName = "";
  numberOfUsers = 0;
  allUsers: User[] = [];
  rejectedUsers: User[] = [];
  approvedUsers: User[] = [];
  nonPendingUsers: User[] = [];
  pendingUsers: User[] = [];
  selectedUser!: User;
  currentRequestsView = true;

  ngOnInit(): void {
    this.getCurrentAdmin();
    this.getAllUsers();
  }

  getCurrentAdmin(): void {
    this.adminService.getCurrentAdmin().subscribe(res => {
      this.currentAdminName = res;
      console.log(res);
    });
  }

  getAllUsers(): void {
    this.pendingUsers = [];
    this.nonPendingUsers = [];
    this.rejectedUsers = [];
    this.approvedUsers = [];

    this.adminService.getAllUsers().subscribe(res => {
      this.numberOfUsers = res.length;
      this.allUsers = res;

      this.allUsers.forEach(user => {
        let status = user.status;
        console.log(user);
        this.approvedUsers.push(user);
        if (status === 'approved') {
          this.approvedUsers.push(user);
          this.nonPendingUsers.push(user);
        } else if (status === 'rejected') {
          this.rejectedUsers.push(user);
          this.nonPendingUsers.push(user);
        } else {
          this.pendingUsers.push(user);
        }

      })

    });
  }

  approveUser(user: User): void {
    user.status = 'approved';
    this.adminService.update(user).subscribe(res => {
      this.getAllUsers();
    });
  }
  rejectUser(user: User): void {
    user.status = 'rejected';
    this.adminService.update(user).subscribe(res => {
      this.getAllUsers();
    });
  }
  logout(): void {
    this.adminService.logout().subscribe(res => { });
  }
}
