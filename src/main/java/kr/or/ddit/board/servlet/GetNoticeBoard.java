package kr.or.ddit.board.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.BoardServiceInf;


@WebServlet("/getBoardList")
public class GetNoticeBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardServiceInf service = BoardServiceImpl.getInstance();

    public GetNoticeBoard() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no_seq = Integer.parseInt(request.getParameter("no_seq"));
		
		String pageString = request.getParameter("page");
		int page = pageString == null? 1 :Integer.parseInt(pageString);
		
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = pageSizeString == null? 10 : Integer.parseInt(pageSizeString);
		
		
		Map<String, Integer>map = new HashMap<String, Integer>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("category_seq",no_seq);
		
		Map<String, Object>resultMap = service.selectNoticeBoard(map);
		
		List<BoardVO> boardList = (List<BoardVO>) resultMap.get("boardList");
		for(BoardVO vo : boardList){
			vo.setTitle(vo.getTitle().replace(" ", "&nbsp"));
		}
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageNav", resultMap.get("pageNav"));
		
		RequestDispatcher rd = request.getRequestDispatcher("/main/boardList.jsp");
		rd.forward(request, response);
	}

	
}
