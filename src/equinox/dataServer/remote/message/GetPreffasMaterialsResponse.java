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
package equinox.dataServer.remote.message;

import java.util.ArrayList;

import equinox.dataServer.remote.data.PreffasMaterial;
import equinox.serverUtilities.BigMessage;

/**
 * Class for get preffas materials response network message.
 *
 * @author Murat Artim
 * @date 23 Feb 2018
 * @time 13:19:05
 */
public class GetPreffasMaterialsResponse extends DataMessage implements BigMessage {

	/** Serial id. */
	private static final long serialVersionUID = 1L;

	/** Preffas materials. */
	private final ArrayList<PreffasMaterial> materials;

	/**
	 * No argument constructor for serialization.
	 */
	public GetPreffasMaterialsResponse() {
		materials = new ArrayList<>();
	}

	/**
	 * Returns preffas materials.
	 *
	 * @return preffas materials.
	 */
	public ArrayList<PreffasMaterial> getMaterials() {
		return materials;
	}

	/**
	 * Adds given material.
	 *
	 * @param material
	 *            Material to add.
	 */
	public void addMaterial(PreffasMaterial material) {
		materials.add(material);
	}

	@Override
	public boolean isReallyBig() {
		return materials.size() > 10;
	}
}
