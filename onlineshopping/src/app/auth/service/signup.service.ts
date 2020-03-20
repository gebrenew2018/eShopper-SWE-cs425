import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CustomerModel} from '../model/Customer.model';

@Injectable({
  providedIn: 'root'
})
export class SignupService {
  private baseUrl = 'http://localhost:8080/api/customer';
  constructor(private httpClient: HttpClient) { }

  saveCustomer(customerModel: any) {
    return this.httpClient.post<CustomerModel>(this.baseUrl, customerModel);
  }
}
