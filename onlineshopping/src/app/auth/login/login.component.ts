import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, NgForm, Validator, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginform: FormGroup;
  url: string;
  error='';

  constructor(private activatedRoute: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder) {

  }


  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.loginform = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.UserName.value === 'admin' && this.PassWord.value === '123') {
      this.router.navigate(['/admin-menu']);
    } else {
      this.error = 'Bad username and password combination!';
      // this.router.navigate(['/products']);

    }
  }

  get UserName() {
    return this.loginform.get('username');
  }

  get PassWord() {
    return this.loginform.get('password');
  }
}
