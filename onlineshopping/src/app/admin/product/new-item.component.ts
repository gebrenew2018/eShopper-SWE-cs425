import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ProductModel} from '../model/product.model';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-new-item',
  templateUrl: './new-item.component.html',
  styleUrls: ['./new-item.component.css']
})
export class NewItemComponent implements OnInit {
  itemForm: FormGroup;
  selectedFiles: FileList;
  currentFileUpload: File;
  product: ProductModel = new ProductModel();

  constructor(private router: Router, private fb: FormBuilder,
              private productService: ProductService) {
  }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.itemForm = this.fb.group({
      itemName: ['', Validators.required],
      price: ['', Validators.required],
      category: ['', Validators.required],
      collection: ['', Validators.required],
      itemImage: ['', Validators.required]
    });
  }

  onSubmit(saveproduct) {
    this.product = new ProductModel();
    this.product.itemName = this.ItemName.value;
    this.product.category = this.Category.value;
    this.product.price = this.Price.value;
    this.product.collectionType = this.Collection.value;
    this.product.itemImage = this.ItemImage.value;
    this.save();
  }

  save() {
    this.productService.saveProduct(this.product).subscribe(result => {
      if (result != null) {
        this.router.navigate(['/products/list']);
        // this.toaster.success('Successfully added to the database!', 'Success');
      } else {
        // this.toaster.error('Error occurred while saving!', 'Error!');
      }
    });
  }

  displayList() {
    console.log('Cancel Clicked...');
    // this.toaster.success('Opration cancelled!', 'Error!');
    this.router.navigate(['/products/list']);
  }

  addItem() {

  }

  selectFile($event: Event) {
    // this.selectedFiles = event.target.files[0];
  }

  get ItemName() {
    return this.itemForm.get('itemName');
  }

  get Price() {
    return this.itemForm.get('price');
  }

  get Category() {
    return this.itemForm.get('category');
  }

  get Collection() {
    return this.itemForm.get('collection');
  }

  get ItemImage() {
    return this.itemForm.get('itemImage');
  }

}
