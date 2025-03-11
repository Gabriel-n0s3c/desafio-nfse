import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ListaCreditoService {
  private apiUrl = 'http://localhost:8080/api/creditos';
  constructor(private http: HttpClient) {}

  getCreditos(numeroNfse: string = "7891011"): Observable<any> {
    return this.http.get(`${this.apiUrl}/${numeroNfse}`);
  }
}
