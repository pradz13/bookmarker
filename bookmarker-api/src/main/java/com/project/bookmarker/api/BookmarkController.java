package com.project.bookmarker.api;

import com.project.bookmarker.dto.BookmarkDTO;
import com.project.bookmarker.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public BookmarkDTO getBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return bookmarkService.getBookmarks(page);
    }
}
