package com.example.javaBackendPractice;
import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Enumeration;

public class User {

    public static class CreateUser {
        public CreateUser(Hashtable<String, Document> userInfo) {
            MongoClient mc = new MongoClient();
            MongoDatabase database = mc.getDatabase("JavaBackendPractice");
            String Username = String.valueOf(userInfo.keys());
            database.createCollection(Username);
            database.getCollection(Username).insertOne(userInfo.elements().nextElement());
        }
    }
        public class EditUser {
            public EditUser(String Username, Document newInfo) {

            }
        }
        public class ShowUser{
                public ShowUser(String Username, Document newInfo) {

                }
            }
        }
