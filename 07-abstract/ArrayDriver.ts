import { Shape } from './Shape';
import {Circle} from './Circle';
import {Rectangle} from './Rectangle';

let mycircle=new Circle(5,10,20);





let myRectangle=new Rectangle(0,0,3,7);


//build an array of shapes
let theShapes:Shape[]=[];

theShapes.push(mycircle);
theShapes.push(myRectangle);

for(let tempShape of theShapes){
    console.log(tempShape.getInfo());
    console.log(tempShape.calculateArea());
    console.log();
}


