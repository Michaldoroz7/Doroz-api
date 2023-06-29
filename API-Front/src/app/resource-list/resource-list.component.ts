import { Component } from '@angular/core';
import { Resource } from '../model/resource.model';
import { ResourceService } from '../service/resource.service';

@Component({
  selector: 'app-resource-list',
  templateUrl: './resource-list.component.html',
  styleUrls: ['./resource-list.component.css']
})
export class ResourceListComponent {

  resources: Resource[];

  constructor(private resourceService: ResourceService) {
  }

  ngOnInit() {
    this.resourceService.findAllMaterials().subscribe(data => {
      this.resources = data;
    });
  }
}
