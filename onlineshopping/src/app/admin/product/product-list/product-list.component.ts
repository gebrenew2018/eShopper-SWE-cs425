import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Observable} from 'rxjs';
import {ProductModel} from '../../model/product.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  listOfItems: Observable<ProductModel[]>;
  private deleted = false;

  constructor(private productService: ProductService,
              private router: Router
  ) {
  }

  ngOnInit(): void {
    this.getListOfItems();

  }

  getListOfItems() {
    console.log('list of items');
    this.productService.getAllproducts('all')
      .subscribe(result => {
        this.listOfItems = result;
        console.log(this.listOfItems);
      });
  }

  displayItemForm() {
    this.router.navigate(['products/new']);
  }

  deleteItem(itemId: any) {
    console.log(itemId);
    // @ts-ignore
    this.deleted = this.productService.deleteProduct(itemId);
    if (this.deleted) {
      this.router.navigate(['/products/list']);
    } else {
      this.router.navigate(['/products/new']);
    }
  }

  updateItem(itemId: any) {

  }
}
