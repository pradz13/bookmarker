package com.project.bookmarker.dto.mapper;

import com.project.bookmarker.domain.Bookmark;
import com.project.bookmarker.dto.BookmarkDTO;
import com.project.bookmarker.dto.BookmarksDTO;
import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {
    public BookmarksDTO toDto(Bookmark bookmark) {
        BookmarksDTO bookmarksDTO = new BookmarksDTO();
        bookmarksDTO.setId(bookmark.getId());
        bookmarksDTO.setTitle(bookmark.getTitle());
        bookmarksDTO.setUrl(bookmark.getUrl());
        bookmarksDTO.setCreatedAt(bookmark.getCreatedAt());
        return bookmarksDTO;
    }

    public BookmarksDTO toDTO(Bookmark bookmark) {
        return new BookmarksDTO(
                bookmark.getId(),
                bookmark.getTitle(),
                bookmark.getUrl(),
                bookmark.getCreatedAt()
        );
    }
}
