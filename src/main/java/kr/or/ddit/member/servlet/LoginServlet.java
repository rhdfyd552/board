package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.service.MemberServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		MemberServiceInf service = MemberServiceImpl.getInstancce();
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(mem_id);
		vo.setMem_pass(mem_pass);
		
		HttpSession session = request.getSession();
		session.setAttribute("mem_id", mem_id);
		
		boolean loginCheck = service.loginMeber(vo);
		if(loginCheck){
			response.sendRedirect(request.getContextPath()+"/mainNoticeList");
		}else{
			setCookie(mem_id,response);
			response.sendRedirect(request.getContextPath()+"/login/login.jsp");
		}
			
		
	}


	private void setCookie(String mem_id, HttpServletResponse response) {
		Cookie cookie = new Cookie("userId",mem_id);
		cookie.setMaxAge(30*24*60*60);
			
		Cookie rememberCookie = new Cookie("remember","true");
		rememberCookie.setMaxAge(30*24*60*60);
			
		response.addCookie(cookie);
		response.addCookie(rememberCookie);
	}
		

}
