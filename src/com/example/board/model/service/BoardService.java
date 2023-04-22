package com.example.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.example.board.model.dao.BoardDao;
import com.example.board.model.dto.BoardDto;

public class BoardService {

	private BoardService() {
	}

	private static BoardService instance = new BoardService();

	public static BoardService getInstance() {
		return instance;
	}

	private BoardDao dao = BoardDao.getInstance();

	public List<BoardDto> list() throws SQLException {
		return dao.selectAll();
	}

	public BoardDto view(int bno) throws SQLException {
		return dao.selectOne(bno);
	}

	public int write(BoardDto board) throws SQLException {
		return dao.insert(board);
	}

	public int modify(BoardDto board) throws SQLException {
		return dao.update(board);
	}

	public int delete(int bno) throws SQLException {
		return dao.delete(bno);
	}

}
