import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../admin/service/product.service';
import {Observable} from 'rxjs';
import {ProductModel} from '../../admin/model/product.model';
import {ShoppingCartModel} from '../model/shoppingcart.model';
import {ShoppingcartService} from '../service/shoppingcart.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  search = 'all';
  cart: ShoppingCartModel = new ShoppingCartModel();

  constructor(private productService: ProductService,
              private cartService: ShoppingcartService) {
  }

  listOfItems: Observable<ProductModel[]>;

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
    this.cart = new ShoppingCartModel();
    this.cart.customerId = 10;
    this.cart.itemId = item.itemId;
    this.cart.totalCount = 1;
    this.cart.totalPrice = item.price;
    this.cartService.addItem(this.cart);
  }
}
