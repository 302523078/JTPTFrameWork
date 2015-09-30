/**
 * Copyright 2010-2012 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hisense.core.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import java.io.IOException;

public class MyGeometryDeserializer extends JsonDeserializer<Geometry> {

	public static final int SRID = 4326;

	@Override
	public Geometry deserialize(JsonParser parser,
			DeserializationContext context) throws IOException,
            JsonProcessingException {

		WKTReader reader = new WKTReader();
		Geometry geo = null;
		try {
			String geoStr = parser.getText();
			if (geoStr != null && !geoStr.isEmpty()) {
				geo = reader.read(geoStr);
				geo.setSRID(SRID);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return geo;
	}
}
