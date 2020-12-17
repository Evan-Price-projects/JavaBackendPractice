package com.example.javaBackendPractice;
import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Enumeration;
public class CreateUser {
    public CreateUser(Hashtable<String, Document> userInfo){
        MongoClient mc = new MongoClient("localhost", 27017);
        MongoDatabase database = mc.getDatabase("JavaBackendPractice");
        String Username = String.valueOf(userInfo.keys());
        database.createCollection(Username);
            database.getCollection(Username).insertOne(userInfo.elements().nextElement());
    }
}
