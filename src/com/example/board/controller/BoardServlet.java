package com.example.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.board.model.dto.BoardDto;
import com.example.board.model.service.BoardService;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {

	private BoardService service = BoardService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");

		try {
			if (action.equals("list")) {
				
				List<BoardDto> boardList = service.list();
				
				req.setAttribute("boardList", boardList);
				req.getRequestDispatcher("pages/board/list.jsp").forward(req, resp);;
			} else if (action.equals("view")) {
				
				int bno = Integer.parseInt(req.getParameter("bno"));
				BoardDto board = service.view(bno);
				
				req.setAttribute("board", board);
				req.getRequestDispatcher("pages/board/view.jsp").forward(req, resp);
			} else if (action.equals("write")) {
				
				req.getRequestDispatcher("pages/board/write.jsp").forward(req, resp);
			} else if (action.equals("modify")) {
				
				int bno = Integer.parseInt(req.getParameter("bno"));
				BoardDto board = service.view(bno);
				
				req.setAttribute("board", board);
				req.getRequestDispatcher("pages/board/modify.jsp").forward(req, resp);
			} else if (action.equals("delete")) {
				
				int bno = Integer.parseInt(req.getParameter("bno"));
				service.delete(bno);
				
				req.getRequestDispatcher("pages/board/success.jsp").forward(req, resp);;
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("pages/error/commonError.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		
		try {
			if (action.equals("write")) {
				
				String btitle = req.getParameter("btitle");
				String bwriter = req.getParameter("bwriter");
				String bcontent = req.getParameter("bcontent");
				
				BoardDto board = new BoardDto();
				board.setBtitle(btitle);
				board.setBwriter(bwriter);
				board.setBcontent(bcontent);
				
				service.write(board);
				
				req.getRequestDispatcher("pages/board/success.jsp").forward(req, resp);
			} else if (action.equals("modify")) {
				
				int bno = Integer.parseInt(req.getParameter("bno"));
				String btitle = req.getParameter("btitle");
				String bwriter = req.getParameter("bwriter");
				String bcontent = req.getParameter("bcontent");
				
				BoardDto board = service.view(bno);
				board.setBtitle(btitle);
				board.setBwriter(bwriter);
				board.setBcontent(bcontent);
				
				service.modify(board);
				
				req.getRequestDispatcher("pages/board/success.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("pages/error/commonError.jsp");
		}
	}
}
