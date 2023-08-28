package com.project.bookmarker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.bookmarker.domain.Bookmark;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class BookmarkDTO {
    private List<Bookmark> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;

    @JsonProperty("isFirstPage")
    private boolean isFirstPage;

    @JsonProperty("isLastPage")
    private boolean isLastPage;

    private boolean hasNext;
    private boolean hasPrevious;

    public BookmarkDTO(Page<Bookmark> bookmarkPage) {
        this.setData(bookmarkPage.getContent());
        this.setTotalElements(bookmarkPage.getTotalElements());
        this.setTotalPages(bookmarkPage.getTotalPages());
        this.setCurrentPage(bookmarkPage.getNumber() + 1);
        this.setFirstPage(bookmarkPage.isFirst());
        this.setLastPage(bookmarkPage.isLast());
        this.setHasNext(bookmarkPage.hasNext());
        this.setHasPrevious(bookmarkPage.hasPrevious());
    }
}
