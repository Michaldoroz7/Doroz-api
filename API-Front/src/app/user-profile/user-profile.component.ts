import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription, map } from 'rxjs';
import { Resource } from '../model/resource.model';
import { User } from '../model/user';
import { ResourceService } from '../service/resource.service';
import { UserService } from '../service/user.service';



@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit, OnDestroy {

  userId: number = null;
  private sub: Subscription;
  user: User = null;
  resources: Resource[] = null;

  constructor(
    private activatedRoute: ActivatedRoute,
    private userService: UserService,
    private resourceService: ResourceService
  ) {}

  ngOnInit(): void {
    this.sub = this.activatedRoute.params.subscribe(params => {
      this.userId = parseInt(params['id']);
      this.resourceService.findUserMaterials(this.userId).subscribe(data => {
        this.resources = data;
      })
      this.userService.findOne(this.userId).pipe(
        map((user:User) => this.user = user)
      ).subscribe()
    })
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }
}
