import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShopBridgeService {

  constructor(private http:HttpClient) { }

  public saveProduct(productDetails){
    return this.http.post("http://localhost:8080/api/v1/products/", productDetails);
  }

  public getProducts(){
    return this.http.get("http://localhost:8080/api/v1/products/");
  }

  public getUserByEmail(email){
    return this.http.get("http://localhost:9090//findUser/"+email);
  }

  public deleteProduct(id){
    return this.http.delete("http://localhost:8080/api/v1/products/"+id);
  }
}
