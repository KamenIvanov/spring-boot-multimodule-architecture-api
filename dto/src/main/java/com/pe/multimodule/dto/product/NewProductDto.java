package com.pe.multimodule.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pe.multimodule.dto.AbstractDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "The new product's data.")
public class NewProductDto extends AbstractDto {

    @Schema(description = "The product's sku identification.")
    @JsonProperty(value = "sku")
    private String sku;

    @Schema(description = "The product's price.")
    @JsonProperty(value = "price")
    private BigDecimal price;

    public NewProductDto() {
        // POJO
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
