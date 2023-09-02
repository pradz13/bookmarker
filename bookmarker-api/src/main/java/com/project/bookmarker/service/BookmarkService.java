package com.project.bookmarker.service;

import com.project.bookmarker.dto.BookmarkDTO;
import com.project.bookmarker.dto.BookmarksDTO;
import com.project.bookmarker.dto.mapper.BookmarkMapper;
import com.project.bookmarker.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    private final BookmarkMapper bookmarkMapper;

    @Transactional(readOnly = true)
    public BookmarkDTO getBookmarks(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        //Page<BookmarksDTO> bookmarksDtoPage = bookmarkRepository.findAll(pageable).map(bookmarkMapper::toDto);
        Page<BookmarksDTO> bookmarksDtoPage = bookmarkRepository.findBookmarks(pageable);
        return new BookmarkDTO(bookmarksDtoPage);
    }

    @Transactional(readOnly = true)
    public BookmarkDTO searchBookmarks(Integer page, String query) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        Page<BookmarksDTO> bookmarksDtoPage = bookmarkRepository.searchBookmarks(pageable, query);
        return new BookmarkDTO(bookmarksDtoPage);
    }
}
