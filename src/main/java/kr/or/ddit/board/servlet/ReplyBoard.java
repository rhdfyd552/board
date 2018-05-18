package kr.or.ddit.board.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import util.FileUtil;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.file.model.FileVO;
import kr.or.ddit.file.service.FileServiceImpl;
import kr.or.ddit.file.service.FileServiceInf;


@WebServlet("/replyBoard")
@MultipartConfig(maxFileSize=1024*8000*5, maxRequestSize=1024*8000*5*5)
public class ReplyBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf service = BoardServiceImpl.getInstance();
	FileServiceInf f_service = FileServiceImpl.getInstance();
	private final String UPLOAD_PATH = "E:\\A_TeachingMaterial\\7.JspSpring\\uploadStorage";
  
  
    public ReplyBoard() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_seq = request.getParameter("board_seq");
		
		BoardVO boVo = service.getBoard(Integer.parseInt(board_seq));
		
		String no_name = service.getNoticeName(boVo.getCategory_seq());
		
		request.setAttribute("no_name", no_name);
		request.setAttribute("no_seq", boVo.getCategory_seq());
		request.setAttribute("board_seq", board_seq);
		
		RequestDispatcher rd = request.getRequestDispatcher("board/boardForm.jsp");
		rd.forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		BoardVO vo = service.getBoard(board_seq);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int group_seq = vo.getGroup_seq();
		
		HttpSession session = request.getSession();
		
		BoardVO boVo = new BoardVO();
		boVo.setCategory_seq(vo.getCategory_seq());
		boVo.setContent(content);
		boVo.setGroup_seq(group_seq);
		boVo.setPboard_seq(board_seq);
		boVo.setTitle(title);
		boVo.setReg_id("sally");
		int cnt=0;
		try {
			
			cnt = service.insertReplyBoard(boVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Collection<Part>files = request.getParts();
		if(cnt >0){
		for(Part file : files){
			if(file.getName().equals("file")){
				if(file.getSize()>0){
					String name = file.getHeader("Content-disposition");
					int find = name.lastIndexOf(".")-1;
					String ex = name.substring(find+1,name.length());
					String realName = FileUtil.getFileName(name);
					System.out.println(realName+" :  "+ex);
					String filePath = UPLOAD_PATH+File.separator+UUID.randomUUID().toString();
					FileVO fiVo = new FileVO();
					fiVo.setFi_board_seq(board_seq);
					fiVo.setFi_name(realName);
					fiVo.setFi_path(filePath);
					
					
					int f_cnt = f_service.insetFile(fiVo);
					if(f_cnt>0){
						file.write(filePath);
						file.delete();
					}
				}
			}
		}
			response.sendRedirect(request.getContextPath()+"/getBoardList?page=1&pageSize=10&no_seq="+vo.getCategory_seq());
		}else{
			response.sendRedirect(request.getContextPath()+"/replyBoard?board_seq="+board_seq);
		}
	}

}
