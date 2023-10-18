package org.acme.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) throws UnknownHostException {
        //Creating a MongoDB client
        MongoClient mongo = new MongoClient("localhost", 27017);

        //List databases
        List<String> dbs = mongo.getDatabaseNames();
        System.out.println(dbs);

        //Connecting to a specific database
        DB db = mongo.getDB("test");

        Set<String> collections = db.getCollectionNames();
        System.out.println(collections);
    }
}
