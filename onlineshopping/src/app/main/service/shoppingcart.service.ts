import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ShoppingCartModel} from '../model/shoppingcart.model';
import {Observable} from 'rxjs';
import {ProductModel} from '../../admin/model/product.model';


@Injectable({
  providedIn: 'root'
})
export class ShoppingcartService {
  private baseUrl = 'http://localhost:8080/api/cart';
  private readonly productlistUrl: string = '/list';

  constructor(private httpClient: HttpClient) {
  }

  getAllproducts(search): Observable<any> {
    const endpointUrl = `${this.baseUrl}/${this.productlistUrl}/${search}`;
    console.log(endpointUrl);
    return this.httpClient.get<ProductModel[]>(endpointUrl);
  }

  addItem(productModel: any) {
    console.log(productModel, this.baseUrl);
    return this.httpClient.post<ProductModel>(this.baseUrl, productModel);
  }
  //
  // deleteProduct(itemId: number): Observable<any> {
  //   return this.httpClient.delete(`${this.baseUrl}/delete-item/${itemId}`, {responseType: 'text'});
  //   // console.log(itemId);
  //   // const endpointUrl = `${this.baseUrl}/${itemId}`;
  //   // return this.httpClient.delete<boolean>(endpointUrl);
  // }
}
