package com.pe.multimodule.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractDto {

}
