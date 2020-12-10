import { Component, OnInit, ViewChild, ɵisDefaultChangeDetectionStrategy } from '@angular/core';
import { ShopBridgeService } from '../shop-bridge.service';
import { AddProductComponent } from './add-product/add-product.component';
import { DisplayProductComponent } from './display-product/display-product.component';

@Component({
  selector: 'app-shopbridge',
  templateUrl: './shopbridge.component.html',
  styleUrls: ['./shopbridge.component.css']
})
export class ShopbridgeComponent implements OnInit {
  @ViewChild('displayProduct') displayProductComp: DisplayProductComponent;
  @ViewChild('addProduct') addProductComp: AddProductComponent;
  ngOnInit(): void {

  }

  addNewProductToDisplay(eventData){
    let productDetails = eventData.data;
    let isUpdate = eventData.update;
    if(isUpdate){
      let product = this.displayProductComp.users.filter(element => element.productId == productDetails.productId)[0];
      product.name = productDetails.name;
      product.description = productDetails.description;
      product.price = productDetails.price
    }
    else
      this.displayProductComp.users.push(productDetails);
  }

  editProduct(productDetails){
    this.addProductComp.productDetails.patchValue({
      productId: productDetails.productId,
      name: productDetails.name,
      description: productDetails.description,
      price: productDetails.price
    })
  }
}
