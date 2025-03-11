import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RespostaConsultaCreditoModel } from './reposta-consulta-credito.model';

@Injectable({
  providedIn: 'root'
})
export class ListaCreditoService {
  private apiUrl = 'http://localhost:8080/api/creditos';
  
  constructor(private http: HttpClient) {}

  buscarPeloNumeroNFSe(numeroNfse: string): Observable<Array<RespostaConsultaCreditoModel>> {
    return this.http.get<Array<RespostaConsultaCreditoModel>>(`${this.apiUrl}/${numeroNfse}`);
  }

  buscarPeloNumeroCredito(numeroCredito: string): Observable<RespostaConsultaCreditoModel> {
    return this.http.get<RespostaConsultaCreditoModel>(`${this.apiUrl}/credito/${numeroCredito}`);
  }
}
