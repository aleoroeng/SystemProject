import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/services/user.service';
import { User } from '../model/User';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  constructor(private userService: UserService) { }


  firstName = "";
  lastName = "";
  contactNumber !: number;
  emailId = "";
  address = "";
  businessJustification = "";
  status = "pending";
  
  ngOnInit(): void {
  }

  addUser() {
    let userProvided = new User(this.firstName, this.lastName, this.contactNumber, this.emailId, this.address, this.businessJustification, this.status, new Date());

    if(this.firstName !== "", this.lastName != "", this.contactNumber != 0, this.emailId != "", this.address != "", this.businessJustification != ""){
      this.userService.addUser(userProvided).subscribe(res => {
        console.log(res);
        alert("Request sent");
      });
    }else{
      alert("Fill out all fields");
    }
    
  }
}
