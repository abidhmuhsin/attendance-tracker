import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AttendanceTrackerComponent } from './attendance-tracker.component';

describe('AttendanceTrackerComponent', () => {
  let component: AttendanceTrackerComponent;
  let fixture: ComponentFixture<AttendanceTrackerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AttendanceTrackerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AttendanceTrackerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
