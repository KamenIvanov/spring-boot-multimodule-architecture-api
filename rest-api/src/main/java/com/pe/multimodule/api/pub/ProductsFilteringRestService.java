package com.pe.multimodule.api.pub;

import com.pe.multimodule.dto.ResponseDto;
import com.pe.multimodule.dto.product.ProductDescriptionDto;
import com.pe.multimodule.dto.product.ProductDescriptionsDto;
import com.pe.multimodule.dto.product.ProductSortOptionDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.UUID;

/**
 * @author kamen on 2.08.22 г.
 */
@Tag(name = "Products Filtering", description = "Used to filter products by anonymous accounts.")
public interface ProductsFilteringRestService {

    @Operation(summary = "Loads products in pages with the given sort applied.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The requested page's products.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDescriptionsDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid arguments supplied.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            })
    })
    ProductDescriptionsDto getProducts(
            @Parameter(description = "The page index. First page is index 1.", required = true, in = ParameterIn.QUERY) int page,
            @Parameter(description = "The page size, the minimum size is 1.", required = true, in = ParameterIn.QUERY) int size,
            @Parameter(description = "How the products should be sorted before put in the page.", required = true, in = ParameterIn.QUERY) ProductSortOptionDto sort
    );

    @Operation(summary = "Loads the products associated with the given identification.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The page associated with the given identification.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDescriptionDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "The provided identification is invalid.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "The product is not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))
            })
    })
    ProductDescriptionDto getProduct(@Parameter(description = "The product identification.", required = true, in = ParameterIn.PATH) UUID id);
}
