package com.pe.multimodule.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pe.multimodule.dto.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Wrapper over the product collection.")
public class ProductDescriptionsDto extends PageDto {

    @Schema(description = "The products collection.")
    @JsonProperty(value = "products")
    private List<ProductDescriptionDto> products;

    public ProductDescriptionsDto() {
        super(0, 0L);
    }

    public ProductDescriptionsDto(Integer totalPages, Long totalHits, List<ProductDescriptionDto> products) {
        super(totalPages, totalHits);
        this.products = products;
    }

    public List<ProductDescriptionDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDescriptionDto> products) {
        this.products = products;
    }
}
