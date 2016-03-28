package com.benvesco.vesco_helixsorter.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A bunch of JSON utils to wrap Jackson functionality.
 * 
 * @author bvesco
 */
public class Json {
    private static final Logger logger = LoggerFactory.getLogger(Json.class);

    public static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T toPojo(String fromString, Class<T> clazz) {
	T parsed = null;

	try {
	    parsed = mapper.readValue(fromString, clazz);
	} catch (Exception e) {
	    logger.error("exception while parsing JSON: {}", e.getMessage());
	}

	return parsed;
    }

    public static <T> T toPojo(File fromFile, Class<T> clazz) {
	T parsed = null;

	try {
	    parsed = mapper.readValue(fromFile, clazz);
	} catch (Exception e) {
	    logger.error("exception while parsing JSON: {}", e.getMessage());
	}

	return parsed;
    }
}
