import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ProductModel} from '../../admin/model/product.model';
import {CustomerModel} from '../model/Customer.model';
import {SignupService} from '../service/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupForm: FormGroup;
  customer: CustomerModel = new CustomerModel();

  constructor(private router: Router,
              private signupService: SignupService,
              private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.initForm();
  }

  onSubmit(saveproduct) {
    this.customer = new CustomerModel();
    this.customer.firstName = this.FirstName.value;
    this.customer.middleName = this.MiddleName.value;
    this.customer.lastName = this.LastName.value;
    this.customer.phoneNumber = this.PhoneNumber.value;
    // this.customer.emailAddress = this.EmailAddress.value;
    // this.customer.password = this.Password.value;
    this.save();
  }
  save() {
    this.signupService.saveCustomer(this.customer).subscribe(result => {
      if (result != null) {
  }});
  }
  displayLogin() {
    this.router.navigate(['/login']);

  }

  initForm() {
    this.signupForm = this.fb.group({
      firstName: ['', Validators.required],
      middleName: [''],
      lastName: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      // emailAddress: ['', Validators.required],
      // password: [''],
      // cpassword: ['', Validators.required],
    });
  }

  get FirstName() {
    return this.signupForm.get('firstName');
  }

  get MiddleName() {
    return this.signupForm.get('middleName');
  }

  get LastName() {
    return this.signupForm.get('lastName');
  }

  get PhoneNumber() {
    return this.signupForm.get('phoneNumber');
  }

  get EmailAddress() {
    return this.signupForm.get('emailAddress');
  }

  get Password() {
    return this.signupForm.get('password');
  }

  get Cpassword() {
    return this.signupForm.get('cpassword');
  }


}
