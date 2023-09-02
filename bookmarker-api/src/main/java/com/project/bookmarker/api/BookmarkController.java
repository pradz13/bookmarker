package com.project.bookmarker.api;

import com.project.bookmarker.dto.BookmarkDTO;
import com.project.bookmarker.dto.BookmarksDTO;
import com.project.bookmarker.dto.CreateBookmarkRequest;
import com.project.bookmarker.service.BookmarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarkDTO getBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                    @RequestParam(name = "query", defaultValue = "") String query) {

        if(query == null || query.trim().length() == 0) {
            return bookmarkService.getBookmarks(page);
        } else {
            return bookmarkService.searchBookmarks(page, query);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarksDTO createBookmark(@RequestBody @Valid CreateBookmarkRequest request) {
        return bookmarkService.createBookmark(request);
    }
}
