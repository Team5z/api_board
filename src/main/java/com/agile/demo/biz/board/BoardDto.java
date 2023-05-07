package com.agile.demo.biz.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.agile.demo.biz.board.BoardEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int userId;
    private String title;
    private String content;
    private String writer;

    public static BoardDto toDto(BoardEntity board) {
        return new BoardDto(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getUser().getName());
    }

}