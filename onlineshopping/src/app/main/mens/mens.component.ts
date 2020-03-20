import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../admin/service/product.service';
import {ProductModel} from '../../admin/model/product.model';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-mens',
  templateUrl: './mens.component.html',
  styleUrls: ['./mens.component.css']
})
export class MensComponent implements OnInit {
  search: 'mens';
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
