/*
 * Copyright 2018 Murat Artim (muratartim@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package equinox.dataServer.task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import equinox.dataServer.client.DataClient;
import equinox.dataServer.remote.data.LinearMaterial;
import equinox.dataServer.remote.message.GetLinearMaterialsRequest;
import equinox.dataServer.remote.message.GetLinearMaterialsResponse;
import equinox.dataServer.server.DataServer;

/**
 * Class for get linear materials task.
 *
 * @author Murat Artim
 * @date 23 Feb 2018
 * @time 13:13:12
 */
public class GetLinearMaterials extends DatabaseQueryTask {

	/**
	 * Creates get linear materials task.
	 *
	 * @param server
	 *            Server instance.
	 * @param client
	 *            Requesting client.
	 * @param request
	 *            Request message.
	 */
	public GetLinearMaterials(DataServer server, DataClient client, GetLinearMaterialsRequest request) {
		super(server, client, request);
	}

	@Override
	protected void runTask() throws Exception {

		// no client
		if (client_ == null)
			throw new Exception("No connected client found for retrieving linear materials.");

		// create response message
		GetLinearMaterialsResponse response = new GetLinearMaterialsResponse();
		response.setListenerHashCode(request_.getListenerHashCode());

		// get request
		GetLinearMaterialsRequest request = (GetLinearMaterialsRequest) request_;
		String materialIsamiVersion = request.getMaterialIsamiVersion();

		// get connection to database
		try (Connection connection = server_.getDCP().getConnection()) {

			// create statement
			try (Statement statement = connection.createStatement()) {

				// get all linear materials
				try (ResultSet materials = statement.executeQuery("select * from linear_materials where isami_version = '" + materialIsamiVersion + "'")) {

					// loop over materials
					while (materials.next()) {

						// get material attributes
						LinearMaterial material = new LinearMaterial(materials.getLong("id"));
						material.setName(materials.getString("name"));
						material.setSpecification(materials.getString("specification"));
						material.setLibraryVersion(materials.getString("library_version"));
						material.setFamily(materials.getString("family"));
						material.setOrientation(materials.getString("orientation"));
						material.setConfiguration(materials.getString("configuration"));
						material.setCeff(materials.getDouble("par_ceff"));
						material.setM(materials.getDouble("par_m"));
						material.setA(materials.getDouble("par_a"));
						material.setB(materials.getDouble("par_b"));
						material.setC(materials.getDouble("par_c"));
						material.setFtu(materials.getDouble("par_ftu"));
						material.setFty(materials.getDouble("par_fty"));
						material.setIsamiVersion(materials.getString("isami_version"));

						// add material to response
						response.addMaterial(material);
					}
				}
			}
		}

		// respond to client
		client_.sendMessage(response);
	}
}
