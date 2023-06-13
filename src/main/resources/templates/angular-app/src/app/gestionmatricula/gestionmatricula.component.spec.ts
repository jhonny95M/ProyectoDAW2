import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionmatriculaComponent } from './gestionmatricula.component';

describe('GestionmatriculaComponent', () => {
  let component: GestionmatriculaComponent;
  let fixture: ComponentFixture<GestionmatriculaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GestionmatriculaComponent]
    });
    fixture = TestBed.createComponent(GestionmatriculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
