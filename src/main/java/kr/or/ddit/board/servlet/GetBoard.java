package kr.or.ddit.board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class GetBoard
 */
@WebServlet("/getBoard")
public class GetBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf service = BoardServiceImpl.getInstance();
    public GetBoard() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String board_seq = request.getParameter("board_seq");
		String category_seq = request.getParameter("category_seq");
		
		
		
		
		BoardVO vo = service.getBoard(Integer.parseInt(board_seq));
		String categoryName = service.getNoticeName(Integer.parseInt(category_seq));
		
		request.setAttribute("boardVO", vo);
		request.setAttribute("category_seq", categoryName);
		
		RequestDispatcher rd = request.getRequestDispatcher("board/board.jsp");
		rd.forward(request, response);
		
		
	}


}
