package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Board;
import data.User;
import repository.AppliesDAO;
import repository.BoardsDAO;

@WebServlet("/boardDetail")
public class BoardDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("boardId") != null || req.getParameter("countryNm") != null) {
			int boardId = Integer.parseInt(req.getParameter("boardId"));
			String countryNm = req.getParameter("countryNm");
			req.setAttribute("countryNm", countryNm);

			int r = AppliesDAO.applicantCnt(boardId + "");
			req.setAttribute("currentUsers", r);

			Board targetBoard = BoardsDAO.findByTargetBoard(boardId);
			req.setAttribute("targetBoard", targetBoard);

			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("logonUser");
			String entry = user.getNick();

			if (AppliesDAO.findByApply(boardId + "", entry) != 0) {
				req.setAttribute("complete", 5);
			}

			req.getRequestDispatcher("/WEB-INF/views/moim/detail.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/");
		}
	}
}
