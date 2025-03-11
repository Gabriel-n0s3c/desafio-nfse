import { ComponentFixture, fakeAsync, TestBed, tick } from '@angular/core/testing';
import { ListaCreditoComponent } from './lista-credito.component';
import { ListaCreditoService } from './shared/lista-credito.service';
import { MessageService } from 'primeng/api';
import { of, throwError } from 'rxjs';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { RespostaConsultaCreditoModel } from './shared/reposta-consulta-credito.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ButtonModule } from 'primeng/button';
import { DialogModule } from 'primeng/dialog';
import { SelectButtonModule } from 'primeng/selectbutton';
import { TableModule } from 'primeng/table';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('ListaCreditoComponent', () => {
  let component: ListaCreditoComponent;
  let fixture: ComponentFixture<ListaCreditoComponent>;
  let listaCreditoService: ListaCreditoService;
  let messageService: MessageService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        CommonModule,  // Use CommonModule para fornecer as diretivas básicas
        ButtonModule,
        FormsModule,
        TableModule,
        SelectButtonModule,
        HttpClientTestingModule,
        DialogModule,
        ListaCreditoComponent ],
      providers: [
        ListaCreditoService,
        MessageService
      ],
    }).compileComponents();

    
    fixture = TestBed.createComponent(ListaCreditoComponent);
    listaCreditoService = TestBed.inject(ListaCreditoService);
    messageService = TestBed.inject(MessageService);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('deve acionar o pesquisar e mostrar mensagem de numero invalido', () => {
    spyOn(messageService, 'add');  
    component.numero = 123;
    component.pesquisar();  
    expect(messageService.add).toHaveBeenCalledWith({
      severity: 'warn',
      summary: 'Número inválido',
      detail: 'O número informado não é válido. Por favor, insira números válidos.'
    });
  });
  
  it('exibirAjuda deve ser true', () => {
    component.exibirAjuda();
    expect(component.mostrarAjuda).toBeTrue();
  });
});