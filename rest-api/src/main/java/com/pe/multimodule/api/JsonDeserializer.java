package com.pe.multimodule.api;

import com.pe.multimodule.dto.AbstractDto;
import tools.jackson.databind.json.JsonMapper;

public class JsonDeserializer {

    private static final JsonMapper jsonMapper = JsonMapperSingleton.instance.getJsonMapper();

    public static final JsonDeserializer instance = new JsonDeserializer();

    private JsonDeserializer() {
       // Singleton
    }

    public <T extends AbstractDto> T process(String payload) {
        if (payload == null || payload.isBlank()) {
            return null;
        }

        // Jackson reads the @class from the JSON, checks it and returns ta sub class of AbstractDto
        return (T) jsonMapper.readValue(payload, AbstractDto.class);
    }
}
