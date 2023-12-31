package com.project.bookmarker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookmarksDTO {
    private Long id;
    private String title;
    private String url;
    private Instant createdAt;
}
