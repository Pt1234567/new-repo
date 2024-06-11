"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Shape_1 = require("./Shape");
var Circle_1 = require("./Circle");
var Rectangle_1 = require("./Rectangle");
var mycircle = new Circle_1.Circle(5, 10, 20);
console.log(mycircle.getInfo());
var myShape = new Shape_1.Shape(10, 20);
console.log(myShape.getInfo());
var myRectangle = new Rectangle_1.Rectangle(0, 0, 3, 7);
console.log(myRectangle.getInfo());
//build an array of shapes
var theShapes = [];
theShapes.push(myShape);
theShapes.push(mycircle);
theShapes.push(myRectangle);
for (var _i = 0, theShapes_1 = theShapes; _i < theShapes_1.length; _i++) {
    var tempShape = theShapes_1[_i];
    console.log(tempShape.getInfo());
}
