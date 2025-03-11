import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RespostaConsultaCreditoModel } from './reposta-consulta-credito.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ListaCreditoService {
  private apiUrl = environment.apiUrl; 

  constructor(private http: HttpClient) {}

  buscarPeloNumeroNFSe(numeroNfse: string): Observable<Array<RespostaConsultaCreditoModel>> {
    return this.http.get<Array<RespostaConsultaCreditoModel>>(`${this.apiUrl}/creditos/${numeroNfse}`);
  }

  buscarPeloNumeroCredito(numeroCredito: string): Observable<RespostaConsultaCreditoModel> {
    return this.http.get<RespostaConsultaCreditoModel>(`${this.apiUrl}/creditos/credito/${numeroCredito}`);
  }
}
