import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ShopBridgeService } from 'src/app/shop-bridge.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  productDetails: FormGroup;
  @Output() savedProduct = new EventEmitter<any>();
  constructor(private fb: FormBuilder, private shopBridgeService: ShopBridgeService) { }

  ngOnInit(): void {
    this.productDetails = this.fb.group({
      productId: [''],
      name : ['', Validators.required],
      description : [''],
      price : ['', Validators.required]
    });
  }

  onSubmit(){
    let isUpdate = this.productDetails.controls.productId.value != '';
    let productDetails = {
      productId :this.productDetails.controls.productId.value,
      name : this.productDetails.controls.name.value,

      description : this.productDetails.controls.description.value,
      price : this.productDetails.controls.price.value
    }
    this.shopBridgeService.saveProduct(productDetails).subscribe(
      response =>{

        this.savedProduct.emit( {update: isUpdate, data: response['obj']});
        //alert("Data Saved Successfully");
      }
    );
  }

}
