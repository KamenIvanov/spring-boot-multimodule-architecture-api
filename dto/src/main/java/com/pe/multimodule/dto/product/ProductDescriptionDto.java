package com.pe.multimodule.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pe.multimodule.dto.AbstractEntityDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "The publication's description.")
public class ProductDescriptionDto extends AbstractEntityDto {

    @Schema(description = "The product's sku identification.")
    @JsonProperty(value = "sku")
    private UUID sku;

    public ProductDescriptionDto() {
        // POJO
    }

    public ProductDescriptionDto(UUID id) {
        super(id);
    }

    public UUID getSku() {
        return sku;
    }

    public void setSku(UUID sku) {
        this.sku = sku;
    }

}
