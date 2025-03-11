import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';
import { ListaCreditoService } from './lista-credito.service';
import { RespostaConsultaCreditoModel } from './reposta-consulta-credito.model';

describe('ListaCreditoService', () => {
  let service: ListaCreditoService;
  let httpMock: HttpTestingController;
  const apiUrl = 'http://localhost:8080/api/creditos';

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ListaCreditoService],
    });

    service = TestBed.inject(ListaCreditoService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('deve listar creditos pelo numero NFSe', () => {
    const obj1 = new RespostaConsultaCreditoModel();
    obj1.numeroNfse = '123456';
    obj1.valorDeducao = 1000;

    const obj2 = new RespostaConsultaCreditoModel();
    obj2.numeroNfse = '123456';
    obj2.valorDeducao = 2000;

    const mockResponse: Array<RespostaConsultaCreditoModel> = [obj1, obj2];

    service.buscarPeloNumeroNFSe('123').subscribe((creditos) => {
      expect(creditos.length).toBe(2);
      expect(creditos).toEqual(mockResponse);
    });

    const request = httpMock.expectOne(`${apiUrl}/123`);
    expect(request.request.method).toBe('GET');
    request.flush(mockResponse);
  });

  it('deve listar creditos pelo numero crédito', () => {
    const mockResponse = new RespostaConsultaCreditoModel();
    mockResponse.numeroCredito = '12345';
    mockResponse.valorDeducao = 1000;

    service.buscarPeloNumeroCredito('12345').subscribe((credito) => {
      expect(credito.numeroCredito).toBe('12345');
      expect(credito.valorDeducao).toBe(1000);
    });

    const request = httpMock.expectOne(`${apiUrl}/credito/12345`);
    expect(request.request.method).toBe('GET');
    request.flush(mockResponse);
  });
});
