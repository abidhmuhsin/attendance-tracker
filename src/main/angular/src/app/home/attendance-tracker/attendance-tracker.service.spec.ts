import { TestBed } from '@angular/core/testing';

import { AttendanceTrackerService } from './attendance-tracker.service';

describe('AttendanceTrackerService', () => {
  let service: AttendanceTrackerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AttendanceTrackerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
