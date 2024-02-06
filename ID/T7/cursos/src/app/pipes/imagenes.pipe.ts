import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes'
})
export class ImagenesPipe implements PipeTransform {

  transform(value: any, ...args: unknown[]): unknown {
    if(value.length>0){
        return value
    }else{
      return 'https://png.pngtree.com/png-clipart/20210907/ourmid/pngtree-test-paper-examination-student-subjects-png-image_3879178.jpg'
    }
    
    return null;
  }

}
