import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShopbridgeComponent } from './shopbridge/shopbridge.component';
import { ShopBridgeService } from './shop-bridge.service';
import { HttpClientModule } from '@angular/common/http'; 
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddProductComponent } from './shopbridge/add-product/add-product.component';
import { DisplayProductComponent } from './shopbridge/display-product/display-product.component';

@NgModule({
  declarations: [
    AppComponent,
    ShopbridgeComponent,
    AddProductComponent,
    DisplayProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ShopBridgeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
