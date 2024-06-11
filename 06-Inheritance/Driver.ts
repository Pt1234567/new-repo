import { Shape } from './Shape';
import {Circle} from './Circle';
import {Rectangle} from './Rectangle';

let mycircle=new Circle(5,10,20);
console.log(mycircle.getInfo());

let myShape=new Shape(10,20);
console.log(myShape.getInfo());

let myRectangle=new Rectangle(0,0,3,7);
console.log(myRectangle.getInfo());


