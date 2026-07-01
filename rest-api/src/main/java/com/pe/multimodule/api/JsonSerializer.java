package com.pe.multimodule.api;

import com.pe.multimodule.dto.AbstractDto;
import tools.jackson.databind.json.JsonMapper;

public class JsonSerializer {

    private static final JsonMapper jsonMapper = JsonMapperSingleton.instance.getJsonMapper();

    public static final JsonSerializer instance = new JsonSerializer();

    private JsonSerializer() {
        // Singleton
    }

    public String process(AbstractDto entity) {
        if (entity == null) {
            return null;
        }

        return jsonMapper.writeValueAsString(entity);
    }
}
