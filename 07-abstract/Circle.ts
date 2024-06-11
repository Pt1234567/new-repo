import { Shape } from './Shape';

export class Circle extends Shape{
      calculateArea(): number {
            return Math.PI*this._radius*this._radius;
      }


      constructor(_X:number,_y:number ,private _radius:number){
            super(_X,_y);
      }
      public get radius(): number {
            return this._radius;
      }
      public set radius(value: number) {
            this._radius = value;
      }

      getInfo():string{
            return ` radius=${this._radius}`;
      }

}