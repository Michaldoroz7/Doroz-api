import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/user';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  user: User;
  addUser: FormGroup;

  constructor(
      private formBuilder: FormBuilder,
        private userService: UserService) {
    this.user = new User();
    this.addUser = this.formBuilder.group({
      login: '',
      title: '',
      password: '',
      email: '',
      phoneNumber: '',
      description: '',
      profilePicture: ''
    })
  }

  onSubmit() {
    const userData = new FormData();
    userData.append('login', this.addUser.get('login').value)
    userData.append('title', this.addUser.get('title').value)
    userData.append('password', this.addUser.get('password').value)
    userData.append('email', this.addUser.get('email').value)
    userData.append('phoneNumber', this.addUser.get('phoneNumber').value)
    userData.append('description', this.addUser.get('description').value)
    userData.append('profilePicture', this.addUser.get('profilePicture').value)
    this.userService.save(userData).subscribe({
      next: (response) => console.log(response),
      error: (error) => console.log(error),
    });
    this.addUser.reset();
  }
}
