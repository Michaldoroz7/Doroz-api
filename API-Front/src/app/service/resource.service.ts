import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Resource } from '../model/resource.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResourceService {

  private materialUrl;
  private specificUserMaterials;

  constructor(private http: HttpClient) {
    this.materialUrl = 'http://localhost:8080/api/resources/';
    this.specificUserMaterials = 'http://localhost:8080/api/resources/client/';
  }

  public findUserMaterials(clientId: number): Observable<Resource[]> {
    return this.http.get<Resource[]>(this.specificUserMaterials + clientId);
  }

  public findAllMaterials(): Observable<Resource[]> {
    return this.http.get<Resource[]>(this.materialUrl);
  }

  public save(formdata: FormData) {
    return this.http.post<Resource>(this.materialUrl, formdata);
  }
}
