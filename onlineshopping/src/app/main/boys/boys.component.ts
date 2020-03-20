import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {ProductModel} from '../../admin/model/product.model';
import {ProductService} from '../../admin/service/product.service';

@Component({
  selector: 'app-boys',
  templateUrl: './boys.component.html',
  styleUrls: ['./boys.component.css']
})
export class BoysComponent implements OnInit {

  search: 'boys';
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
