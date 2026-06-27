package com.pe.multimodule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author kamen on 4.08.22 г.
 */
@Schema(description = "Holds the pagination data.")
public abstract class PageDto extends AbstractDto {

    @Schema(description = "The total pages which can be fetched using the criteria which obtained this page.")
    @JsonProperty(value = "totalPages")
    private Integer totalPages;

    @Schema(description = "The total amount of items which can be fetched using the criteria which obtained this page.")
    @JsonProperty(value = "totalHits")
    private Long totalHits;

    protected PageDto(Integer totalPages, Long totalHits) {
        this.totalPages = totalPages;
        this.totalHits = totalHits;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Long totalHits) {
        this.totalHits = totalHits;
    }
}
