function myFunction() {
  for (var i in arguments) {
    console.log(arguments[i]);
  }
}
var params = [10, 15];
myFunction(5, ...params, 20, ...[25]); // 5 10 15 20 25

console.log(new Date(...[2016, 5, 6])); // Mon Jun 06 2016 00:00:00 GMT-0700 (Pacific Daylight Time)
