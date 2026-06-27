package com.pe.multimodule.api;

import com.pe.multimodule.dto.AbstractDto;
import tools.jackson.databind.json.JsonMapper;

public class PeSerializer {

    private static final JsonMapper jsonMapper = JsonMapperSingleton.instance.getJsonMapper();

    public static final PeSerializer instance = new PeSerializer();

    private PeSerializer() {
        // Singleton
    }

    public String process(AbstractDto entity) {
        if (entity == null) {
            return null;
        }

        return jsonMapper.writeValueAsString(entity);
    }
}
