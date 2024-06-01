import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/Products';
import { ImageServiceService } from 'src/app/services/image-service.service';
import { StoreService } from 'src/app/services/store.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-dialog-image-prediction',
  templateUrl: './dialog-image-prediction.component.html',
  styleUrls: ['./dialog-image-prediction.component.scss']
})
export class DialogImagePredictionComponent implements OnInit{

  constructor(private svcImages: ImageServiceService, private storeService: StoreService ){}

  ngOnInit(): void {

  }

  products: any[] = [];
  imagenSeleccionada: string | ArrayBuffer | null = null;
  seleccionoImg: boolean = false;
  resultadoAnalisis!: any;
  file!: File;
  total =0;
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

  onFileSelected(event: any): void {
    const file: File = event.target.files[0];

    if (file) {
      this.seleccionoImg = true;
      const reader = new FileReader();

      reader.onload = (e) => {
        this.imagenSeleccionada = e.target?.result as string | ArrayBuffer | null;
      };

      reader.readAsDataURL(file);
    }
    this.file = file;
    //console.log(file)
  }

  analizarImg(){

    this.svcImages.predictionImage(this.file).subscribe(data => {

      this.products = data;
      if(this.products.length <= 0){
       Swal.fire({
        icon: 'warning',
        title: 'Oops...',
        text: 'No se encontraron productos'
      }
      )}
    }, error => {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Error al analizar la imagen',
      })
      console.log(error)
    })
  }

  onAddToShoppingCart(product: Producto){
    this.storeService.addProduct(product);
    //console.log(product);
    this.total = this.storeService.getTotal();

  }

  toggleProductDetail(){
    this.showProductDetail = !this.showProductDetail;
  }

  statusDetail: 'loading' | 'success' | 'error' | 'init' = 'init';

  onShowDetail(id:string){
    /*this.statusDetail = 'loading';
    this.svcImages.getProduct(id)
    .subscribe(data => {
      this.toggleProductDetail();
      this.productChosen = data;
      this.statusDetail = 'success';
        }, response => {
          console.log(response);
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: response,
            footer: '<a href="">Why do I have this issue?</a>'
          })
          this.statusDetail = 'error';
        }
    }
    )*/
  }

}
