import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserService } from './service/user.service';
import { ProjectDescriptionComponent } from './project-description/project-description.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { MatCardModule} from '@angular/material/card';
import { ResourceListComponent } from './resource-list/resource-list.component';
import { MaterialFormComponent } from './material-form/material-form.component';
import { HomePageComponent } from './home-page/home-page.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent,
    ProjectDescriptionComponent,
    UserProfileComponent,
    ResourceListComponent,
    MaterialFormComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatCardModule,
    ReactiveFormsModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
