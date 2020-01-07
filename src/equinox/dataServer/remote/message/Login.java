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

import equinox.serverUtilities.AdministratorMessage;

/**
 * Class for login network message.
 *
 * @author Murat Artim
 * @date 20 Dec 2017
 * @time 15:26:36
 */
public final class Login extends DataMessage implements AdministratorMessage {

	/** Serial ID. */
	private static final long serialVersionUID = 1L;

	/** User password. */
	private String password_;

	/**
	 * No argument constructor for serialization.
	 */
	public Login() {
	}

	/**
	 * Creates a login message.
	 *
	 * @param password
	 *            Password. Note that the password is encoded.
	 */
	public Login(String password) {
		password_ = password;
	}

	/**
	 * Returns password. Note that the password is encoded.
	 *
	 * @return Password.
	 */
	public String getPassword() {
		return password_;
	}

	/**
	 * Removes password from this message.
	 */
	public void removePassword() {
		password_ = null;
	}
}