import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainComponent} from './main/main/main.component';
import {MensComponent} from './main/mens/mens.component';
import {WomensComponent} from './main/womens/womens.component';
import {BoysComponent} from './main/boys/boys.component';
import {GirlsComponent} from './main/girls/girls.component';
import {BrandsComponent} from './main/brands/brands.component';
import {LoginComponent} from './auth/login/login.component';
import {OrderComponent} from './main/order/order.component';
import {CartComponent} from './main/cart/cart.component';
import {ProductComponent} from './main/product/product.component';
import {CustomerComponent} from './admin/customer/customer.component';
import {AdminMenuComponent} from './admin/admin-menu/admin-menu.component';
import {ProductListComponent} from './admin/product/product-list/product-list.component';
import {NewItemComponent} from './admin/product/new-item.component';
import {SignupComponent} from './auth/signup/signup.component';


const routes: Routes = [
  {path: 'main', component: MainComponent},
  {path: 'product', component: ProductComponent},
  {path: 'mens', component: MensComponent},
  {path: 'womens', component: WomensComponent},
  {path: 'boys', component: BoysComponent},
  {path: 'girls', component: GirlsComponent},
  {path: 'brands', component: BrandsComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: SignupComponent},
  {path: 'order', component: OrderComponent},
  {path: 'cart', component: CartComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'admin-menu', component: AdminMenuComponent},
  {path: 'products/list', component: ProductListComponent},
  {path: 'products/new', component: NewItemComponent},
  {path: 'main',  redirectTo: '/',  pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
