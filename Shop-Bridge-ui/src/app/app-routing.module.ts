import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShopbridgeComponent } from './shopbridge/shopbridge.component';

const routes: Routes = [

  {path:"", component:ShopbridgeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
