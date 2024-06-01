import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../models/Products';

@Injectable({
  providedIn: 'root'
})
export class ImageServiceService {

  //private URL_BASE = 'http://localhost:8081';
  private URL_BASE = 'https://image-prediction-5c9c7c859bf2.herokuapp.com';
  constructor(private http: HttpClient) { }

  analizarImagen(file: File):Observable<any>{

    const formData = new FormData();
    formData.append('file', file);

    const headers = new HttpHeaders();
    headers.append('Content-Type', 'multipart/form-data');

    return this.http.post<any>(`${this.URL_BASE}/images/analizar-img`, formData);
  }

  predictionImage(file: File):Observable<any>{

    const formData = new FormData();
    formData.append('file', file);

    const headers = new HttpHeaders();
    headers.append('Content-Type', 'multipart/form-data');

    return this.http.post<any>(`${this.URL_BASE}/images/prediction-img`, formData);
  }

  getProduct(code: string):Observable<Producto>{
    return this.http.get<Producto>(`${this.URL_BASE}/images/find-by-code/${code}"`);
  }

}
