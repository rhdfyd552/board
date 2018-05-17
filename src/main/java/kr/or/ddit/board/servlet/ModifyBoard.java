package kr.or.ddit.board.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import kr.or.ddit.notice.model.NoticeVO;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.notice.service.NoticeServiceInf;


@WebServlet("/modifyBoard")
@MultipartConfig(maxFileSize=1024*8000*5, maxRequestSize=1024*8000*5*5)
public class ModifyBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf service = BoardServiceImpl.getInstance();
	private final String UPLOAD_PATH = "E:\\A_TeachingMaterial\\7.JspSpring\\uploadStorage";
  
    public ModifyBoard() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String board_seq = request.getParameter("board_seq");
	
		BoardVO vo = service.getBoard(Integer.parseInt(board_seq));
		
		NoticeServiceInf noService = NoticeServiceImpl.getInstance();
		List<NoticeVO> notice = noService.getNotice();
		
		request.setAttribute("notice", notice);
		request.setAttribute("boardVO", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("board/boardModify.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String category_seq = request.getParameter("notices");
		String board_seq = request.getParameter("board_seq");
		String content = request.getParameter("content");
		
		Collection<Part> files = request.getParts(); 
		
		
		BoardVO vo = new BoardVO();
		
		vo.setBoard_seq(Integer.parseInt(board_seq));
		vo.setTitle(title);
		vo.setCategory_seq(Integer.parseInt(category_seq));
		vo.setContent(content);
		List<FileVO> fileList = new ArrayList<FileVO>();
		
		for(Part file : files){
			if(file.getName().equals("file")){
				if(file.getSize()>0){
					String filePath = UPLOAD_PATH + File.separator+UUID.randomUUID().toString();
					String name = file.getName();
					FileVO filevo = new FileVO();
					filevo.setFi_board_seq(Integer.parseInt(board_seq));
					filevo.setFi_path(filePath);
					filevo.setFi_name(name);
					fileList.add(filevo);
					
					file.write(filePath);
					file.delete();
				}
			}
		}
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("boardVO", vo);
		map.put("fileList", fileList);
		
		int cnt = service.boardModify(map);
		int fi_cnt=0;
				
		if(cnt>0){
			
			
			response.sendRedirect(request.getContextPath()+"/getBoard?board_seq="+board_seq+"&category_seq="+category_seq);
			
		}else{
			response.sendRedirect(request.getContextPath()+"/modifyBoard?board_seq="+board_seq);
		}
		
	}
}
