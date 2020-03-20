import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {HeaderComponent} from './common/header/header.component';
import {MainComponent} from './main/main/main.component';
import {FooterComponent} from './common/footer/footer.component';
import {ProductComponent} from './main/product/product.component';
import {BrandsComponent} from './main/brands/brands.component';
import {NewArrivalsComponent} from './main/new-arrivals/new-arrivals.component';
import {MensComponent} from './main/mens/mens.component';
import {WomensComponent} from './main/womens/womens.component';
import {BoysComponent} from './main/boys/boys.component';
import {GirlsComponent} from './main/girls/girls.component';
import {ElectronicsComponent} from './main/electronics/electronics.component';
import {LoginComponent} from './auth/login/login.component';
import {OrderComponent} from './main/order/order.component';
import {ListComponent} from './main/order/list/list.component';
import {CartComponent} from './main/cart/cart.component';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {NewItemComponent} from './admin/product/new-item.component';
import {CustomerComponent} from './admin/customer/customer.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import {AdminMenuComponent} from './admin/admin-menu/admin-menu.component';
import {AdminNavComponent} from './admin/admin-menu/admin-nav/admin-nav.component';
import {ProductListComponent} from './admin/product/product-list/product-list.component';
import {MatTableModule} from '@angular/material/table';
import {HttpClientModule} from '@angular/common/http';
import {ToastrModule} from 'ngx-toastr';
import { SignupComponent } from './auth/signup/signup.component';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatListModule} from '@angular/material/list';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MainComponent,
    FooterComponent,
    ProductComponent,
    BrandsComponent,
    NewArrivalsComponent,
    MensComponent,
    WomensComponent,
    BoysComponent,
    GirlsComponent,
    ElectronicsComponent,
    LoginComponent,
    OrderComponent,
    ListComponent,
    CartComponent,
    NewItemComponent,
    CustomerComponent,
    AdminMenuComponent,
    AdminNavComponent,
    ProductListComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MatCardModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatTableModule,
    HttpClientModule,
    FormsModule,
    ToastrModule,
    MatGridListModule,
    MatListModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
