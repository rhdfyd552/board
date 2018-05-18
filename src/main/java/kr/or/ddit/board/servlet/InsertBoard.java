package kr.or.ddit.board.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import util.FileUtil;
import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.file.model.FileVO;
import kr.or.ddit.file.service.FileServiceImpl;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.notice.service.NoticeServiceInf;


@WebServlet("/insertBoard")
@MultipartConfig(maxFileSize=1024*8000*5, maxRequestSize=1024*8000*5*5)
public class InsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf service = BoardServiceImpl.getInstance();
	FileServiceInf f_service = FileServiceImpl.getInstance();
	NoticeServiceInf n_service = NoticeServiceImpl.getInstance();
	
	
	private final String UPLOAD_PATH = "E:\\A_TeachingMaterial\\7.JspSpring\\uploadStorage";
  
  
    public InsertBoard() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<NoticeVO>notice = n_service.getNotice();
		
		request.setAttribute("notice", notice);
		
		RequestDispatcher rd = request.getRequestDispatcher("board/boardInsert.jsp");
		rd.forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("11111 : 서블렛시작");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category_seq = request.getParameter("notices");
		String reg_id = request.getParameter("reg_id");
		
		System.out.println("121212 : " + reg_id);
		BoardVO boVo = new BoardVO();
		boVo.setCategory_seq(Integer.parseInt(category_seq));
		boVo.setContent(content);
		boVo.setTitle(title);
		boVo.setReg_id(reg_id);
		System.out.println(boVo);
		int cnt= service.insertBoard(boVo);
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
					fiVo.setFi_board_seq(boVo.getBoard_seq());
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
			request.setAttribute("boardVO", boVo);
			response.sendRedirect(request.getContextPath()+"/getBoard?board_seq="+boVo.getBoard_seq()+"&category_seq="+category_seq);
		}else{
			response.sendRedirect(request.getContextPath()+"/board/boardInsert.jsp");
		}
	}

}
