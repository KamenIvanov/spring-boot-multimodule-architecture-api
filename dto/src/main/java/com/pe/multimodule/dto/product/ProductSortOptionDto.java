package com.pe.multimodule.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "The product's available sort options.")
public enum ProductSortOptionDto implements Serializable {

    NEWEST,
    OLDEST,
    HIGHEST_PRICE,
    LOWEST_PRICE

}
