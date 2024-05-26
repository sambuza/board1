package com.board1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private int commentId;
    private int postId;
    private int userId;
    private String content;
    private LocalDateTime createdAt;
}
