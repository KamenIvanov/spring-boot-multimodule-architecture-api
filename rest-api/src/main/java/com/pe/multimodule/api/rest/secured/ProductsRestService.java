package com.pe.multimodule.api.rest.secured;

import com.pe.multimodule.dto.ResponseDto;
import com.pe.multimodule.dto.SortDirectionDto;
import com.pe.multimodule.dto.product.NewProductDto;
import com.pe.multimodule.dto.product.ProductDto;
import com.pe.multimodule.dto.product.ProductSortOptionDto;
import com.pe.multimodule.dto.product.ProductsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.UUID;

public interface ProductsRestService extends CrudRestService<NewProductDto, ProductDto> {

    @Operation(summary = "Loads user's publications in pages.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The requested page's publications.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid user identification is supplied.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            ),
            @ApiResponse(responseCode = "401", description = "No authorization token is provided.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class))}
            )
    })
    ProductsDto getProducts(
            @Parameter(description = "The requested page index. The first page is 1.", in = ParameterIn.QUERY) int page,
            @Parameter(description = "An page's size. The minimum is 1 element.", in = ParameterIn.QUERY) int size,
            @Parameter(description = "How the publications should be sorted before put in the page.", in = ParameterIn.QUERY) ProductSortOptionDto sort,
            @Parameter(description = "How the products should be sorted before put in the page.", in = ParameterIn.QUERY) SortDirectionDto direction,
            @Parameter(description = "An user's identification.", required = true, in = ParameterIn.HEADER) UUID requesterId
    );
}
