var accessModifer = /** @class */ (function () {
    function accessModifer(_firstName, _lastName) {
        this._firstName = _firstName;
        this._lastName = _lastName;
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
