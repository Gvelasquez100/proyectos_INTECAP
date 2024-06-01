import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ImageAnalysisComponent } from './components/image-analysis/image-analysis.component';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { ImagePredictionComponent } from './components/image-prediction/image-prediction.component';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatMenuModule} from '@angular/material/menu';
import { DialogImagePredictionComponent } from './components/dialogs/dialog-image-prediction/dialog-image-prediction.component';
import {MatDialogModule} from '@angular/material/dialog';
import { ImgComponent } from './components/products/img/img.component';
import { ProductoComponent } from './components/products/producto/producto.component';
import { DialogCarritoComponent } from './components/dialogs/dialog-carrito/dialog-carrito.component';
@NgModule({
  declarations: [
    AppComponent,
    ImageAnalysisComponent,
    ImagePredictionComponent,
    ToolbarComponent,
    DialogImagePredictionComponent,
    ImgComponent,
    ProductoComponent,
    DialogCarritoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatCardModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatMenuModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
