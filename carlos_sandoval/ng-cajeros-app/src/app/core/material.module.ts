import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatCardModule } from '@angular/material/card';
// import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
// import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
// import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';

import { MatInputModule } from '@angular/material/input';
import { MatGridListModule } from '@angular/material/grid-list';
// import { MatSelectModule } from '@angular/material/select';
import { FormsModule } from '@angular/forms';
// import { MatStepperModule } from '@angular/material/stepper';
// import { MatDatepickerModule } from '@angular/material/datepicker';
// import { MatNativeDateModule } from '@angular/material/core';
// import { MatPaginatorModule } from '@angular/material/paginator';
// import { MatDialogModule } from '@angular/material/dialog';
// import { MatAutocompleteModule } from '@angular/material/autocomplete';
// import { MatTooltipModule } from '@angular/material/tooltip';
// import { MatCheckboxModule } from '@angular/material/checkbox';
// import { MatMenuModule } from '@angular/material/menu';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatCardModule,
    // MatProgressSpinnerModule,
    // MatSidenavModule,
    MatToolbarModule,
    // MatListModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatGridListModule,
    // MatSelectModule,
    FormsModule,
    // MatStepperModule,
    // MatDatepickerModule,
    // MatNativeDateModule,
    // MatPaginatorModule,
    // MatAutocompleteModule,
    // MatTooltipModule,
    // MatCheckboxModule,
    // MatMenuModule,
    MatDividerModule,
  ],
  exports: [
    MatCardModule,
    // MatProgressSpinnerModule,
    // MatSidenavModule,
    MatToolbarModule,
    // MatListModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    MatInputModule,
    MatGridListModule,
    // MatSelectModule,
    FormsModule,
    // MatStepperModule,
    // MatDatepickerModule,
    // MatNativeDateModule,
    // MatPaginatorModule,
    // MatDialogModule,
    // MatAutocompleteModule,
    MatFormFieldModule,
    // MatTooltipModule,
    // MatCheckboxModule,
    // MatMenuModule,
    MatDividerModule,
  ],
})
export class CustomMaterialModule {}
