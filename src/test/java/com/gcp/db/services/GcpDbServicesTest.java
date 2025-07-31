package com.gcp.db.services;

import org.junit.Test;

import com.gcp.db.services.bigtable.BigtableService;
import com.gcp.db.services.firestore.FirestoreService;
import com.gcp.db.services.model.User;
import com.gcp.db.services.sql.CloudSqlService;

public class GcpDbServicesTest {

	@Test
	public void testSaveUserToAllDatabases() throws Exception {
		User user = new User(2, "Alice", "alice@example.com");

		new CloudSqlService().saveUser(user);
		new FirestoreService().saveUser(user);
		new BigtableService().saveUser(user);
	}
}