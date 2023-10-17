var userCount = function(){

	var count = db.Users.count();

	var entry = {_id: Date() , n : count};

	db.UserCountHistory.insertOne(entry);

	print("\nToday's User Count: " + entry.n);
};

userCount();