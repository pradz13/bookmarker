package com.project.bookmarker.helper;

import com.project.bookmarker.domain.Bookmark;
import com.project.bookmarker.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

//@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(String... args) throws Exception {
        bookmarkRepository.save(new Bookmark(null, "Google", "https://www.google.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Instagram", "https://www.instagram.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Facebook", "https://www.facebook.com", Instant.now()));
    }
}
