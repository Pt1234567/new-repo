var accessModifer = /** @class */ (function () {
    function accessModifer(theFirst, theLast) {
        this._firstName = theFirst;
        this._lastName = theLast;
    }
    Object.defineProperty(accessModifer.prototype, "firstName", {
        get: function () {
            return this._firstName;
        },
        set: function (value) {
            this._firstName = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(accessModifer.prototype, "lastName", {
        get: function () {
            return this._lastName;
        },
        set: function (value) {
            this._lastName = value;
        },
        enumerable: false,
        configurable: true
    });
    return accessModifer;
}());
var accessModiferObj = new accessModifer("Prashant", "Tripathi");
console.log(accessModiferObj.firstName);
console.log(accessModiferObj.lastName);
