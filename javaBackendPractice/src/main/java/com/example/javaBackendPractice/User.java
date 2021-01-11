package com.example.javaBackendPractice;
import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Enumeration;

import org.bson.conversions.Bson;
import org.springframework.web.bind.annotation.*;

@RestController
public class User {
    private static MongoDatabase Connect(){
        try {
            MongoClient mc = new MongoClient("localhost", 27017);
            MongoCredential credential;
            credential
                    = MongoCredential
                    .createCredential(
                            "GUser", "mongoDb",
                            "password".toCharArray());//https://www.geeksforgeeks.org/mongodb-tutorial-in-java/
            System.out.println(
                    "Successfully Connected"
                            + " to the database");
            MongoDatabase database = mc.getDatabase("User");
            return database;
        }catch (Exception e){System.out.println(e);}
        return null;
    }
    @PostMapping("/user")
    public static void CreateUser(@RequestBody JavaBackendPracticeApplication.UserInfo userInfo) {
        try{
        MongoDatabase database = Connect();
        String Username = userInfo.getUsername();
        if (database.getCollection("Users") == null) {
            database.createCollection("Users");
        }
        MongoCollection mc = database.getCollection("Users");
        System.out.println("Create user:" + userInfo.getUsername());
        mc.insertOne(userInfo);
    }catch (Exception e){System.out.println(e); }}

    @PutMapping("/user/{_id}")
    public static void EditUser(@PathVariable("_id") String id, @RequestBody Document newInfo) {
        try{
            MongoDatabase database = Connect();
            if (database.getCollection("Users") == null) {
                System.out.println("Empty Database");
            }
            else{
                BsonDocument search = new BsonDocument();
                search.append("_id", new BsonString(id));
                //iterate over new info and update
                database.getCollection("Users").updateOne(search, newInfo);
                System.out.println("EDIT:" + database.getCollection("Users").listIndexes().toString());
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    @GetMapping("/user")
    public static void ShowUser(String Username, Document newInfo) {
        try{}
        catch(Exception e){
            System.out.println(e);
        }
    }
}

