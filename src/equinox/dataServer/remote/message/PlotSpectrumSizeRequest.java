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

/**
 * Class for plot spectrum size request network message.
 *
 * @author Murat Artim
 * @date 20 Feb 2018
 * @time 11:58:57
 */
public class PlotSpectrumSizeRequest extends DatabaseQueryRequest {

	/** Serial id. */
	private static final long serialVersionUID = 1L;

	/** Aircraft program, section and mission inputs. */
	private String program, section, mission;

	/**
	 * No argument constructor serialization.
	 */
	public PlotSpectrumSizeRequest() {
	}

	/**
	 * Returns aircraft program.
	 *
	 * @return Aircraft program.
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * Returns aircraft section.
	 *
	 * @return Aircraft section.
	 */
	public String getSection() {
		return section;
	}

	/**
	 * Returns fatigue mission.
	 *
	 * @return Fatigue mission.
	 */
	public String getMission() {
		return mission;
	}

	/**
	 * Sets aircraft program.
	 *
	 * @param program
	 *            Aircraft program.
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * Sets aircraft section.
	 *
	 * @param section
	 *            Aircraft section.
	 */
	public void setSection(String section) {
		this.section = section;
	}

	/**
	 * Sets fatigue mission.
	 *
	 * @param mission
	 *            Fatigue mission.
	 */
	public void setMission(String mission) {
		this.mission = mission;
	}
}
