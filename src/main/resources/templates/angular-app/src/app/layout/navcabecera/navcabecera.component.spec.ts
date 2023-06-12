import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavcabeceraComponent } from './navcabecera.component';

describe('NavcabeceraComponent', () => {
  let component: NavcabeceraComponent;
  let fixture: ComponentFixture<NavcabeceraComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavcabeceraComponent]
    });
    fixture = TestBed.createComponent(NavcabeceraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
