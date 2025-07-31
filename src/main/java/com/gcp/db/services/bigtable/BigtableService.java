package com.gcp.db.services.bigtable;

import com.gcp.db.services.model.User;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.RowMutation;

public class BigtableService {
	
	private static final String INSTANCE_ID = "your-instance-id";
	private static final String TABLE_ID = "users";
	private static final String PROJECT_ID = "adroit-standard-431618-m4";

	public void saveUser(User user) throws Exception {
		
		try (BigtableDataClient dataClient = BigtableDataClient.create(PROJECT_ID, INSTANCE_ID)) {
			RowMutation row = RowMutation.create(TABLE_ID, String.valueOf(user.getId()))
					.setCell("cf1", "name", user.getName()).setCell("cf1", "email", user.getEmail());
			dataClient.mutateRow(row);
		}
	}
}
