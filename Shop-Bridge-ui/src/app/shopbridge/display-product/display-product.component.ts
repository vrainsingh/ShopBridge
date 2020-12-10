import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ShopBridgeService } from 'src/app/shop-bridge.service';

@Component({
  selector: 'app-display-product',
  templateUrl: './display-product.component.html',
  styleUrls: ['./display-product.component.css']
})
export class DisplayProductComponent implements OnInit {
  users: any;
  @Output() editProduct = new EventEmitter<any>();
  constructor(private shopBridgeService: ShopBridgeService) { }

  ngOnInit() {
    let resp = this.shopBridgeService.getProducts();
    resp.subscribe((data) => this.users = data["obj"]);
  }

  public delteUser(id: number) {
    this.shopBridgeService.deleteProduct(id).subscribe(
      response => {
        if (response["statusCode"] == "200") {
          this.users = this.users.filter(element => element.productId != id);
        }
        else {
          //alert(response["message"]);
        }
      }
    );
  }

  editUser(id : number){
      this.editProduct.emit(this.users.filter(element=>element.productId == id)[0]);
  }


}
