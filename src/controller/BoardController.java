package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import boardAction.DelQna;
import boardAction.DeleteCmt;
import boardAction.ModiQna;
import boardAction.ModiQnaAction;
import boardAction.NoticeAction;
import boardAction.NoticeSearch;
import boardAction.NoticeView;
import boardAction.QnaBoard;
import boardAction.QnaSearch;
import boardAction.QnaView;
import boardAction.UploadCommnet;
import boardAction.UploadQna;
import vo.ActionForward;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		Action action = null;
		
		System.out.println(command);
		
		if(command.equals("/noticeBoard.bo")) { // ?????????????????? ??????
			action = new NoticeAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/noticeSearch.bo")) { // ?????? ??????
			action = new NoticeSearch();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/noticeBoardResult.bo")) { // ?????? ????????? ???????????? ????????? ??????
			forward = new ActionForward();
			forward.setPath("/jsp/board/noticeBoard.jsp");
		} else if(command.equals("/noticeView.bo")) { // ???????????? ?????????
			action = new NoticeView();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/qnaBoard.bo")) { // qna??? ??????
			action = new QnaBoard();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/qnaView.bo")) { // qna ?????????
			action = new QnaView();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/writeQna.bo")) { // ???????????? ??????
			forward = new ActionForward();
			forward.setPath("/jsp/board/writeQna.jsp");
		} else if(command.equals("/uploadQna.bo")) { // ????????? ?????????
			action = new UploadQna();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/uploadComment.bo")) { // ?????? ?????????
			action = new UploadCommnet();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/modiQna.bo")) { // qna ??????
			action = new ModiQna();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/modiQnaAction.bo")) { // qna ??????
			action = new ModiQnaAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/delQna.bo")) { // qna ?????????
			action = new DelQna();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/qnaSearch.bo")) { // qna ?????? ?????? ??????
			action = new QnaSearch();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/deletCmt.bo")) { // ?????? ??????
			action = new DeleteCmt();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
