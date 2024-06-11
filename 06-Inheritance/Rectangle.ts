import {Shape} from './Shape';

export class Rectangle extends Shape{



      constructor(_X:number,_Y:number,private _length:number,private _width:number){
            super(_X,_Y);
      }

      public get width(): number {
            return this._width;
      }
      public set width(value: number) {
            this._width = value;
      }

      public get length(): number {
            return this._length;
      }
      public set length(value: number) {
            this._length = value;
      }
     
      getInfo():string{
            return super.getInfo()+ `, width=${this._width}, length=${this._length}`;
      }
      
}