import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ListaCreditoService } from './shared/lista-credito.service';

@Component({
  standalone: true,
  imports:[CommonModule, BrowserModule],
  providers: [ListaCreditoService],
  selector: 'app-lista-credito',
  templateUrl: './lista-credito.component.html',
  styleUrls: ['./lista-credito.component.css']
})
export class ListaCreditoComponent implements OnInit {

  constructor(private listaService: ListaCreditoService){

  }

  ngOnInit(){
    this.listaService.getCreditos().subscribe((r) => {
      console.log(r);
    },
  e =>  console.log(e))
  }

}
