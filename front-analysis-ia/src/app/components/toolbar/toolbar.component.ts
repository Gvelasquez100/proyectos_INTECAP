import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogImagePredictionComponent } from '../dialogs/dialog-image-prediction/dialog-image-prediction.component';
import { StoreService } from 'src/app/services/store.service';
import { DialogCarritoComponent } from '../dialogs/dialog-carrito/dialog-carrito.component';
import { Producto } from 'src/app/models/Products';
import { ImageServiceService } from 'src/app/services/image-service.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit{

  constructor(public dialog: MatDialog, private storeService: StoreService, private svcImages: ImageServiceService ) { }

  ngOnInit(): void {
    this.storeService.myCart$.subscribe(products =>{
      this.counter = products.length;
      });
  }
  //constructor(private sesionService: AuthService, private router: Router) {
  //}
  position: string = 'right';
  activeMenu = false;
  counter = 0;
  dialogAbierto = false;
  dialogAbiertoCart = false;
  title: string = 'Carrito de compras';
  logOut(){
 /*   this.sesionService.logOut();
    this.router.navigateByUrl('');*/
  }

  toggleMenu(){
    this.activeMenu = !this.activeMenu;
  }


  openDialog() {
    // Verifica si el diálogo ya está abierto
    if (!this.dialogAbierto) {
      // Abre el diálogo
      const dialogRef = this.dialog.open(DialogImagePredictionComponent, {
        width: '100%',
        height: '85%',
        hasBackdrop: false
      });

      // Actualiza el estado del diálogo
      this.dialogAbierto = true;

      // Escucha el evento de cierre del diálogo para actualizar el estado
      dialogRef.afterClosed().subscribe(() => {
        this.dialogAbierto = false;
      });
    }
  }
  //user = this.sesionService.getNombre();

 /* openCart(){
    if(!this.dialogAbiertoCart){
      const dialogRef = this.dialog.open(DialogCarritoComponent, {
        width: '100%',
        height: '85%',
        hasBackdrop: false
      });
      this.dialogAbiertoCart = true;
      dialogRef.afterClosed().subscribe(() => {
        this.dialogAbiertoCart = false;
      });
    }
  }*/

  toggleProductDetail(){
    this.showProductDetail = !this.showProductDetail;
  }


  showProductDetail = false;

  productChosen: Producto = {
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

  statusDetail: 'loading' | 'success' | 'error' | 'init' = 'init';
  productsCart: Producto[] = [];
  emptyCart = true;
  total = 0;

  openCart(){
    this.storeService.showButton = true;
    this.emptyCart = true;
    this.statusDetail = 'loading';
    this.storeService.getShoppingCart()
    .subscribe(data => {
      this.toggleProductDetail();
      this.productsCart = data;
      if(this.productsCart.length>0){this.emptyCart = false;}
      this.total = this.storeService.getTotal();
      console.log(this.productsCart);

    }
    )
  }

  onClearCart(){}

  onCheckout(){}
}
