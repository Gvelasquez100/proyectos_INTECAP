import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Producto } from '../models/Products';

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  showButton: boolean = false;
  private myShoppingCart: Producto[] =[];


  private myCart = new BehaviorSubject<Producto[]>([]);

  myCart$ = this.myCart.asObservable();

  constructor() {
  }

  addProduct(product: Producto){
    this.myShoppingCart.push(product);
    this.myCart.next(this.myShoppingCart);
  }

  getShoppingCart(): Observable<Producto[]>{
    return this.myCart.asObservable();
  }

  getTotal(){
    return this.myShoppingCart.reduce((sum, item)=> sum + item.precio.valueOf(), 0);
  }
}
