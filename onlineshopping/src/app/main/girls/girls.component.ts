import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {ProductModel} from '../../admin/model/product.model';
import {ProductService} from '../../admin/service/product.service';

@Component({
  selector: 'app-girls',
  templateUrl: './girls.component.html',
  styleUrls: ['./girls.component.css']
})
export class GirlsComponent implements OnInit {


  search: 'girls';
  listOfItems: Observable<ProductModel[]>;

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getListOfItems();
  }

  getListOfItems() {
    console.log('list of items');
    this.productService.getAllproducts(this.search)
      .subscribe(result => {
        this.listOfItems = result;
        console.log(this.listOfItems);
      });
  }

  addToCart(item: ProductModel) {

  }
}
