import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { ToastModule } from 'primeng/toast';
import { HttpClientModule } from '@angular/common/http';
import { ListaCreditoComponent } from './lista-credito/lista-credito.component';
import { MessageService } from 'primeng/api';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        ListaCreditoComponent,
        HttpClientModule,
        ToastModule
      ],
      providers:[MessageService],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance; 
    expect(app).toBeTruthy();
  });

  it(`should have as title 'nfse-estatico'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('nfse-estatico');
  });

});
