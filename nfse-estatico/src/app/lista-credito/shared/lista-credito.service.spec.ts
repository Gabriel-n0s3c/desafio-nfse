import { TestBed } from '@angular/core/testing';
import { ListaCreditoService } from './lista-credito.service';


describe('ListaCreditoService', () => {
  let service: ListaCreditoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListaCreditoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
