package com.gcp.db.services;

import com.gcp.db.services.bigtable.BigtableService;
import com.gcp.db.services.firestore.FirestoreService;
import com.gcp.db.services.model.User;
import com.gcp.db.services.sql.CloudSqlService;

public class GCPDB {
	
    public static void main(String[] args) throws Exception {
    	
        User user = new User(1, "John Doe", "john@example.com");

        new CloudSqlService().saveUser(user);
        new FirestoreService().saveUser(user);
        new BigtableService().saveUser(user);

        System.out.println("User saved to Cloud SQL, Firestore, and Bigtable.");
    }
}