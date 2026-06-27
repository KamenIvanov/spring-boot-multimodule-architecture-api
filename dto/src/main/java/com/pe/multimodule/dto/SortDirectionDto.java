package com.pe.multimodule.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "The available sort directions.")
public enum SortDirectionDto implements Serializable {

    ASC,
    DESC

}
