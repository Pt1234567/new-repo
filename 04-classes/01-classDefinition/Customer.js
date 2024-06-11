var customer = /** @class */ (function () {
    function customer(theFirst, theLast) {
        this.firstName = theFirst;
        this.lastName = theLast;
    }
    return customer;
}());
var mycustomer = new customer("Prashant", "Tripathi");
console.log(mycustomer.firstName);
console.log(mycustomer.lastName);
