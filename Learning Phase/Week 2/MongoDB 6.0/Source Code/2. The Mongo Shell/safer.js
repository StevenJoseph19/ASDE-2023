
/*
DB.prototype.dropDatabase = function() {
	print("Don't do it man!");
};

db.dropDatabase = DB.prototype.dropDatabase;
*/

db.__proto__.dropDatabase = () => console.log("Don't do it man!") 