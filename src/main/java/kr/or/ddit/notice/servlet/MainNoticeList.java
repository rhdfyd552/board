package kr.or.ddit.notice.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.notice.service.NoticeServiceInf;


@WebServlet("/mainNoticeList")
public class MainNoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
    public MainNoticeList() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		NoticeServiceInf service = NoticeServiceImpl.getInstance();
		
		List<NoticeVO>noticeList = service.getNotice();
		
		session.setAttribute("noticeList", noticeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/mainBoardList");
		rd.forward(request, response);
		
		
	}


}
