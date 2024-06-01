import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Producto } from 'src/app/models/Products';
import { StoreService } from 'src/app/services/store.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.scss']
})
export class ProductoComponent implements OnInit {

  @Input('myProduct') product: any = {
    codigoProducto: '',
    nombreProducto: '',
    descripcion: '',
    especificaciones: '',
    precio: 0,
    existencias: 0,
    img: '',
    fechaCreacion: '',
    fechaModificacion: '',
    usuarioCreacion: '',
    usuarioModificacion: '',
    categoria: 0
  }

  @Input() showButton!: boolean;

  @Output() addedProduct = new EventEmitter<any>();
  @Output() showProduct = new EventEmitter<string>();

  //

  constructor(private storeService: StoreService) { }
  //showButton!: boolean;
  ngOnInit(): void {
    //this.showButton = this.storeService.showButton;
  }

  onAddToCart(){
    this.addedProduct.emit(this.product);
    console.log(this.product);
  }

  onShowDetail(){
    this.showProduct.emit(this.product.codigoProducto);
  }
}
