import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogImagePredictionComponent } from './dialog-image-prediction.component';

describe('DialogImagePredictionComponent', () => {
  let component: DialogImagePredictionComponent;
  let fixture: ComponentFixture<DialogImagePredictionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DialogImagePredictionComponent]
    });
    fixture = TestBed.createComponent(DialogImagePredictionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
