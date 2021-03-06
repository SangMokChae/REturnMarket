package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import pdAction.AgreeAskAction;
import pdAction.AskDirectBuyAction;
import pdAction.BidPdAction;
import pdAction.DealPdAction;
import pdAction.DealPdInfoAction;
import pdAction.DelJjimAction;
import pdAction.DeletePdAction;
import pdAction.DirectBuyAction;
import pdAction.DirectBuyListAction;
import pdAction.GoUploadAction;
import pdAction.JjimListAction;
import pdAction.JjimPdAction;
import pdAction.ModiPdAction;
import pdAction.MyPdListAction;
import pdAction.ProductListAction;
import pdAction.RejectAskAction;
import pdAction.SearchPdAction;
import pdAction.PdUploadAction;
import pdAction.PdViewAction;
import vo.ActionForward;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("*.pd")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
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
		
		if (command.equals("/uploadPd.pd")) { // ?????? ????????? ?????? / session ?????? ??????
			action = new GoUploadAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/addProduct.pd")) { // ???????????? ??????
			forward = new ActionForward();
			forward.setPath("/jsp/product/addProduct.jsp");
		} else if(command.equals("/pdUploadAction.pd")) { // ????????? ??????
			action = new PdUploadAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/productList.pd")) { // ?????? ???????????? ????????????
			action = new ProductListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/pdView.pd")) { // ?????? ?????? ??????
			action = new PdViewAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/bidPd.pd")) { // ??????
			action = new BidPdAction();
			try {
				forward = action.execute(request, response); 
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/searchPd.pd")) { // ??????
			action = new SearchPdAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/jjimPd.pd")) { // ????????? ??????
			action = new JjimPdAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/jjimList.pd")) { // ????????? ???????????? ??????
			action = new JjimListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/delJjim.pd")) { // ????????? ?????????
			action = new DelJjimAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/directBuy.pd")) { // ?????????????????? ?????? ???????????? ??????
			action = new DirectBuyAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/askDirectBuy.pd")) { // ???????????? ?????? ????????????
			action = new AskDirectBuyAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/directBuyList.pd")) { // ???????????? ?????? ????????? ??????
			action = new DirectBuyListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/agreeAsk.pd")) { // ?????? ?????? ??????
			action = new AgreeAskAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/rejectAsk.pd")) { // ?????? ?????? ??????
			action = new RejectAskAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/modiPd.pd")) { // ??? ???????????? ??????
			forward = new ActionForward();
			forward.setPath("/jsp/product/modiPd.jsp");
		} else if(command.equals("/modiPdAction.pd")) {
			action = new ModiPdAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/delPd.pd")) { // ??? ???????????? ??????
			action = new DeletePdAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/myPdList.pd")) { // ?????? ????????????
			action = new MyPdListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/dealPdInfo.pd")) { // ???????????? ?????? ???????????? ??????
			action = new DealPdInfoAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/dealPd.pd")) { // ?????? ??????
			action = new DealPdAction();
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
