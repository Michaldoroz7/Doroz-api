import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { ProjectDescriptionComponent } from './project-description/project-description.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ResourceListComponent } from './resource-list/resource-list.component';
import { MaterialFormComponent } from './material-form/material-form.component';
import { HomePageComponent } from './home-page/home-page.component';

const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent },
  { path: 'project-description', component: ProjectDescriptionComponent},
  { path: 'users/:id', component: UserProfileComponent},
  { path: 'resources', component: ResourceListComponent},
  { path: 'addresource', component: MaterialFormComponent},
  { path: 'home', component: HomePageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
