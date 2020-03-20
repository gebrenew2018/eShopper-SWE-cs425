import {Injectable} from '@angular/core';
import {ProductModel} from '../model/product.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {catchError, map} from 'rxjs/operators';
import {ShoppingCartModel} from '../../main/model/shoppingcart.model';
import {CustomerModel} from '../../auth/model/Customer.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = 'http://localhost:8080/api/items';
  private readonly productlistUrl: string = '/list';

  constructor(private httpClient: HttpClient) {
  }

  getAllproducts(search): Observable<any> {
    const endpointUrl = `${this.baseUrl}/${this.productlistUrl}/${search}`;
    console.log(endpointUrl);
    return this.httpClient.get<ProductModel[]>(endpointUrl);
  }

  saveProduct(productModel: any) {
    return this.httpClient.post<ProductModel>(this.baseUrl, productModel);
  }

  deleteProduct(itemId: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/delete-item/${itemId}`, {responseType: 'text'});
    // console.log(itemId);
    // const endpointUrl = `${this.baseUrl}/${itemId}`;
    // return this.httpClient.delete<boolean>(endpointUrl);
  }
}
