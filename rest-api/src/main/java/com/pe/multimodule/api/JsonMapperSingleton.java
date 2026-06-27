package com.pe.multimodule.api;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import tools.jackson.core.SerializableString;
import tools.jackson.core.io.CharacterEscapes;
import tools.jackson.core.io.SerializedString;
import tools.jackson.core.json.JsonFactory;
import tools.jackson.databind.DefaultTyping;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JsonMapperSingleton {

    /**
     * According to ECMAScript language specification there are characters that must be escaped when used
     * in string literals. Jackson is escaping the ASCII codes below 0xF0 by default, but U+2028 and U+2029 characters
     * must be replaced with their escape sequences manually
     */
    protected static final char[] CHARS_TO_ESCAPE = new char[]{'\u2028', '\u2029'};

    private static final JsonMapper          jsonMapper;
    public static final  JsonMapperSingleton instance   = new JsonMapperSingleton();

    static {
        final JsonFactory jsonFactory = JsonFactory.builder()
                .characterEscapes(new CustomCharacterEscapes())
                .build();

        final var bigDecimalModule = new SimpleModule();
        bigDecimalModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);

        // 1. Define a validator which allows deserialization of our classes (Jackson 3 security)
        final var ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfBaseType("com.pe.multimodule")
                .allowIfSubType("com.pe.multimodule")
                .allowIfBaseType(Collection.class)
                .allowIfBaseType(Map.class)
                .build();

        jsonMapper = JsonMapper.builder(jsonFactory)
                .enable(SerializationFeature.INDENT_OUTPUT)
                .addModule(bigDecimalModule)
                .activateDefaultTyping(ptv, DefaultTyping.JAVA_LANG_OBJECT, JsonTypeInfo.As.PROPERTY)
                .build();
    }

    private JsonMapperSingleton() {
        // Singleton
    }

    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

    private static class CustomCharacterEscapes extends CharacterEscapes {
        private final Map<Integer, String> customEscapes;

        CustomCharacterEscapes() {
            customEscapes = createCharacterEscapes();
        }

        @Override
        public int[] getEscapeCodesForAscii() {
            return CharacterEscapes.standardAsciiEscapesForJSON();
        }

        /**
         * Special escape for the other non-ascii
         *
         * @param ch character to escape
         * @return escaped character ( \\uXXXX form )
         */
        @Override
        public SerializableString getEscapeSequence(int ch) {
            final String escapedSequence = customEscapes.get(ch);
            if (escapedSequence == null) {
                return null;
            }

            return new SerializedString(escapedSequence);
        }

        private Map<Integer, String> createCharacterEscapes() {
            final Map<Integer, String> escapes = new HashMap<>();
            for (char character : CHARS_TO_ESCAPE) {
                final String escaped = "\\u" + String.format("%04X", (int) character);
                escapes.put((int) character, escaped);
            }
            return escapes;
        }
    }
}
