package com.agile.demo.biz.board;

import com.agile.demo.biz.account.AccountRepository;
import com.agile.demo.biz.board.BoardRepository;
import com.agile.demo.biz.board.BoardEntity;

public interface BoardRepository extends JpaRepository<userId, Integer> {
}