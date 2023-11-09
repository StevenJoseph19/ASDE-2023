var thing = ["Table", "Chair", "Fan"];
var [a, b, c] = thing;

console.log(a); // Output: Table
console.log(b); //Output: Chair
console.log(c); //Output: Fan

var planets = ["Mercury", "Earth", "Venus", "Mars", "Pluto", "Saturn"];
var [first, , third, ...others] = planets;

console.log(first); //Output: Mercury
console.log(third); //Output: Venus
console.log(others); //Output: ["Mars", "Pluto", "Saturn"]

let person = {
  firstName: "John",
  lastName: "Doe",
};

let { firstName, lastName } = person;

console.log(firstName); // 'John'
console.log(lastName); // 'Doe'

let display = ({ firstName, lastName }) =>
  console.log(`${firstName} ${lastName}`);

display(person);
