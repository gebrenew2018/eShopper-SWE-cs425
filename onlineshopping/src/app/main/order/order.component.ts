import {Component, OnInit} from '@angular/core';
import {ProductModel} from '../../admin/model/product.model';
import {Observable} from 'rxjs';
import {OrderModel} from '../model/order.model';
import {FormGroup} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor(private router: Router) {
  }

  item: ProductModel[];
  total = 0.0;
  // today: new Date();
  // order: OrderModel = new OrderModel();
  order: FormGroup;

  ngOnInit(): void {
    this.item = JSON.parse(localStorage.getItem('services_assigned'));
    console.log(this.item);
    this.item.forEach((element) => {
      this.total += element.price;
    });
    console.log(this.total);
  }
  onSubmit(saveorder) {
    // this.order = new OrderModel();
    // this.order.orderDate = DateT;
    // this.order.category = this.Category.value;
    // this.order.price = this.Price.value;
    // this.save();
  }

  cancel() {
    this.router.navigate(['/product']);
  }
}
