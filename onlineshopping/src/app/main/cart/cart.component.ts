import {Component, OnInit} from '@angular/core';
import {ShoppingCartModel} from '../model/shoppingcart.model';
import {ProductService} from '../../admin/service/product.service';
import {ShoppingcartService} from '../service/shoppingcart.service';
import {Observable} from 'rxjs';
import {ProductModel} from '../../admin/model/product.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  search = 10;
  cart: ShoppingCartModel = new ShoppingCartModel();

  constructor(private productService: ProductService,
              private cartService: ShoppingcartService,
              private router: Router) {
  }

  listOfItems: Observable<ProductModel[]>;

  ngOnInit(): void {
    this.getListOfItems();
  }

  getListOfItems() {
    this.cartService.getAllproducts(this.search)
      .subscribe(result => {
        this.listOfItems = result;
        console.log(this.listOfItems);
        console.log(result);
      });
  }

  removeItem(item) {
  }

  checkout() {
    localStorage.setItem('services_assigned', JSON.stringify(this.listOfItems));
    this.router.navigate(['/order']);
  }
}
