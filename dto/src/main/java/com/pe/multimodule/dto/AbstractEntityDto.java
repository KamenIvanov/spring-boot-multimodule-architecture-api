package com.pe.multimodule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.UUID;

public abstract class AbstractEntityDto extends AbstractDto {

    @Schema(description = "The entity identification.")
    @JsonProperty(value = "id")
    private UUID id;

    @Schema(description = "The exact time when the entity has been created.")
    @JsonProperty(value = "createdAt")
    private Instant createdAt;

    @Schema(description = "The exact time when the entity has been updated.")
    @JsonProperty(value = "updatedAt")
    private Instant updatedAt;

    protected AbstractEntityDto() {
        // POJO
    }

    protected AbstractEntityDto(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
