package com.pe.multimodule.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pe.multimodule.dto.AbstractNamedEntityDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "The publication's description.")
public class ProductDescriptionDto extends AbstractNamedEntityDto {

    @Schema(description = "The product's sku identification.")
    @JsonProperty(value = "sku")
    private String sku;

    public ProductDescriptionDto() {
        // POJO
    }

    public ProductDescriptionDto(UUID id, String name) {
        super(id, name);
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

}
