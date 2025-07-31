package com.gcp.db.services.firestore;

import com.gcp.db.services.model.User;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

public class FirestoreService {

	public void saveUser(User user) throws Exception {
		Firestore db = FirestoreClient.getFirestore();
		db.collection("users").document(String.valueOf(user.getId())).set(user).get();
	}
}