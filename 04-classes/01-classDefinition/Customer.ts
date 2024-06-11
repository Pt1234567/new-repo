class customer{
      firstName:string;
      lastName:string;

      constructor(theFirst:string,theLast:string){
          this.firstName=theFirst;
          this.lastName=theLast;
      }
}

let mycustomer=new customer("Prashant","Tripathi");
console.log(mycustomer.firstName);        
console.log(mycustomer.lastName);