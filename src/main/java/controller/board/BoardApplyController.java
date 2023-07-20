package controller.board;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.AppliesDAO;

@WebServlet("/apply")
public class BoardApplyController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("boardId") != null || req.getParameter("entry") != null
				|| req.getParameter("countryNm") != null) {
			String boardId = req.getParameter("boardId");
			String entry = req.getParameter("entry");
			String countryNm = req.getParameter("countryNm");
			if (AppliesDAO.findByApply(boardId, entry) == 0) {
				AppliesDAO.apply(boardId, entry);
				resp.sendRedirect(
						"/boardDetail?boardId=" + boardId + "&countryNm=" + URLEncoder.encode(countryNm, "utf-8"));
			} else {
				req.setAttribute("complete", 5);
				resp.sendRedirect(
						"/boardDetail?boardId=" + boardId + "&countryNm=" + URLEncoder.encode(countryNm, "utf-8"));
			}
		}else {
			resp.sendRedirect("/");
		}

	}
}