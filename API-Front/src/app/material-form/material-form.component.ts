import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Resource } from '../model/resource.model';
import { User } from '../model/user';
import { ResourceService } from '../service/resource.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-material-form',
  templateUrl: './material-form.component.html',
  styleUrls: ['./material-form.component.css']
})
export class MaterialFormComponent implements OnInit {

  resource: Resource;
  addResource: FormGroup;
  users: User[];

  constructor(
      private userService: UserService,
      private formBuilder: FormBuilder,
        private resourceService: ResourceService ) {
    this.resource = new Resource();
    this.addResource = this.formBuilder.group({
      clientId: '',
      materialLink: '',
      materialName: '',
    })
  }

    ngOnInit(){
      this.userService.findAll().subscribe(data => {
        this.users = data;
      })
    }

    onSubmit() {
      const resourceData = new FormData();
      resourceData.append('clientId', this.addResource.get('clientId').value)
      resourceData.append('materialLink', this.addResource.get('materialLink').value)
      resourceData.append('materialName', this.addResource.get('materialName').value)
      this.resourceService.save(resourceData).subscribe({
        next: (response) => console.log(response),
        error: (error) => console.log(error),
      })
      this.addResource.reset();
    }
  }

