import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ListaCreditoService } from './shared/lista-credito.service';
import { ButtonModule } from 'primeng/button';
import { FormsModule } from '@angular/forms';
import { TableModule } from 'primeng/table';
import { SelectButtonModule } from 'primeng/selectbutton';
import { DialogModule } from 'primeng/dialog';
import { MessageService } from 'primeng/api';
import { RespostaConsultaCreditoModel } from './shared/reposta-consulta-credito.model';

const [TIPO_CONSULTA_NFSE, TIPO_CONSULTA_CREDITO] = [1, 2];

@Component({
  standalone: true,
  imports: [
    CommonModule,
    ButtonModule,
    FormsModule,
    TableModule,
    SelectButtonModule,
    DialogModule,
  ],
  providers: [ListaCreditoService],
  selector: 'app-lista-credito',
  templateUrl: './lista-credito.component.html',
  styleUrls: ['./lista-credito.component.css'],
})
export class ListaCreditoComponent implements OnInit {
  public readonly TAMANHO_MINIMO = 6;
  public numero!: number;
  public creditos: Array<RespostaConsultaCreditoModel> = [];
  public stateOptions: any[] = [
    { label: 'NFS-e', value: TIPO_CONSULTA_NFSE },
    { label: 'Crédito', value: TIPO_CONSULTA_CREDITO },
  ];
  public tipoConsulta = TIPO_CONSULTA_NFSE;
  public mostrarAjuda = false;

  constructor(
    private listaService: ListaCreditoService,
    private messageService: MessageService
  ) {}

  ngOnInit() {}

  public pesquisar() {
    if (this.retornaNumeroConsultaValido()) {
      const numeroConsulta = this.numero.toString();
      this.tipoConsulta === TIPO_CONSULTA_NFSE
        ? this.buscarPeloNumeroNFSe(numeroConsulta)
        : this.buscarPeloNumeroCredito(numeroConsulta);
    } else {
      this.mostrarMensagem(
        'warn',
        'Número inválido',
        'O número informado não é válido. Por favor, insira números válidos.'
      );
    }
  }

  private retornaNumeroConsultaValido(): boolean {
    const numeroStr = this.numero?.toString();

    if (!numeroStr || numeroStr.trim().length === 0) {
      return false;
    }

    const numeroValido = /^\d+$/.test(numeroStr);

    const comprimentoValido = numeroStr.length >= this.TAMANHO_MINIMO;

    return numeroValido && comprimentoValido;
  }

  public limparCampos() {
    this.numero = null as any;
    this.creditos = [];
  }

  private buscarPeloNumeroNFSe(numero: string): void {
    this.listaService.buscarPeloNumeroNFSe(numero).subscribe({
      next: (data) => this.tratarRespostaConsulta(data),
      error: (error) => this.tratarErro(error),
    });
  }

  private buscarPeloNumeroCredito(numero: string): void {
    this.listaService.buscarPeloNumeroCredito(numero).subscribe({
      next: (data) => this.tratarRespostaConsulta(data),
      error: (error) => this.tratarErro(error),
    });
  }
  private tratarRespostaConsulta(
    response: RespostaConsultaCreditoModel | RespostaConsultaCreditoModel[]
  ): void {
    if (!response || (Array.isArray(response) && response.length === 0)) {
      this.mostrarMensagem(
        'error',
        'Nenhum resultado encontrado',
        'Não foi encontrado nenhum registro para o número informado.'
      );
      return;
    }
    
    this.creditos = [];

    if (Array.isArray(response)) {
      this.creditos = response;
    } else {
      this.creditos.push(response);
    }
  }

  private mostrarMensagem(severity: string, summary: string, detail: string) {
    this.messageService.add({ severity, summary, detail });
  }

  private tratarErro(erro: any) {
    this.messageService.add({
      severity: 'error',
      summary: 'Erro',
      detail: erro,
    });
  }

  public exibirAjuda() {
    this.mostrarAjuda = true;
  }
}
