package com.doyeon.web.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.doyeon.web.board.model.BoardVO;

public interface BoardService {

	public List<BoardVO> getBoardList() throws Exception;
	public void insertBoard(BoardVO boardVO) throws Exception;

}
