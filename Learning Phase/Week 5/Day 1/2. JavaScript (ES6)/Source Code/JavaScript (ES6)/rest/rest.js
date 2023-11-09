function myFunction(...options) {
  return options;
}
var fn = myFunction("a", "b", "c"); // ["a", "b", "c"]
console.log(fn);

function checkSubstrings(string, ...keys) {
  for (var key of keys) {
    if (string.indexOf(key) === -1) {
      return false;
    }
  }
  return true;
}
console.log(checkSubstrings("this is a string", "is", "this")); // true
