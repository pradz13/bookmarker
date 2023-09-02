package com.project.bookmarker.repository;

import com.project.bookmarker.domain.Bookmark;
import com.project.bookmarker.dto.BookmarksDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    @Query("select new com.project.bookmarker.dto.BookmarksDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b")
    Page<BookmarksDTO> findBookmarks(Pageable pageable);

    @Query("""
    select new com.project.bookmarker.dto.BookmarksDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b
    where lower(b.title) like lower(concat('%', :query, '%'))
    """)
    Page<BookmarksDTO> searchBookmarks(Pageable pageable, String query);
}
