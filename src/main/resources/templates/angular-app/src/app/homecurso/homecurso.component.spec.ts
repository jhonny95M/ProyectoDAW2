import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomecursoComponent } from './homecurso.component';

describe('HomecursoComponent', () => {
  let component: HomecursoComponent;
  let fixture: ComponentFixture<HomecursoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomecursoComponent]
    });
    fixture = TestBed.createComponent(HomecursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
