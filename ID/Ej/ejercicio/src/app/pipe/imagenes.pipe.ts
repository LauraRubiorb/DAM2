import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes',
})
export class ImagenesPipe implements PipeTransform {
  transform(value: any, ...args: unknown[]): any {
    if (value.length > 0) {
      return value;
    } else {
      return 'https://www.queridodinero.com/wp-content/uploads/2018/11/Camisas-1024x684.jpg';
    }
  }
}
