package com.pe.multimodule.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pe.multimodule.dto.PageDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Wrapper over the product collection.")
public class ProductsDto extends PageDto {

    @Schema(description = "The products collection.")
    @JsonProperty(value = "products")
    private List<ProductDto> products;

    public ProductsDto() {
        super(0, 0L);
    }

    public ProductsDto(Integer totalPages, Long totalHits, List<ProductDto> products) {
        super(totalPages, totalHits);
        this.products = products;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
