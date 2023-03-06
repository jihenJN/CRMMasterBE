import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { IProduct, NewProduct } from '../product.model';

/**
 * A partial Type with required key is used as form input.
 */
type PartialWithRequiredKeyOf<T extends { id: unknown }> = Partial<Omit<T, 'id'>> & { id: T['id'] };

/**
 * Type for createFormGroup and resetForm argument.
 * It accepts IProduct for edit and NewProductFormGroupInput for create.
 */
type ProductFormGroupInput = IProduct | PartialWithRequiredKeyOf<NewProduct>;

type ProductFormDefaults = Pick<NewProduct, 'id' | 'favorite'>;

type ProductFormGroupContent = {
  id: FormControl<IProduct['id'] | NewProduct['id']>;
  name: FormControl<IProduct['name']>;
  price: FormControl<IProduct['price']>;
  photo: FormControl<IProduct['photo']>;
  photoContentType: FormControl<IProduct['photoContentType']>;
  favorite: FormControl<IProduct['favorite']>;
  description: FormControl<IProduct['description']>;
  stars: FormControl<IProduct['stars']>;
  supplier: FormControl<IProduct['supplier']>;
};

export type ProductFormGroup = FormGroup<ProductFormGroupContent>;

@Injectable({ providedIn: 'root' })
export class ProductFormService {
  createProductFormGroup(product: ProductFormGroupInput = { id: null }): ProductFormGroup {
    const productRawValue = {
      ...this.getFormDefaults(),
      ...product,
    };
    return new FormGroup<ProductFormGroupContent>({
      id: new FormControl(
        { value: productRawValue.id, disabled: true },
        {
          nonNullable: true,
          validators: [Validators.required],
        }
      ),
      name: new FormControl(productRawValue.name),
      price: new FormControl(productRawValue.price),
      photo: new FormControl(productRawValue.photo),
      photoContentType: new FormControl(productRawValue.photoContentType),
      favorite: new FormControl(productRawValue.favorite),
      description: new FormControl(productRawValue.description),
      stars: new FormControl(productRawValue.stars),
      supplier: new FormControl(productRawValue.supplier),
    });
  }

  getProduct(form: ProductFormGroup): IProduct | NewProduct {
    return form.getRawValue() as IProduct | NewProduct;
  }

  resetForm(form: ProductFormGroup, product: ProductFormGroupInput): void {
    const productRawValue = { ...this.getFormDefaults(), ...product };
    form.reset(
      {
        ...productRawValue,
        id: { value: productRawValue.id, disabled: true },
      } as any /* cast to workaround https://github.com/angular/angular/issues/46458 */
    );
  }

  private getFormDefaults(): ProductFormDefaults {
    return {
      id: null,
      favorite: false,
    };
  }
}
