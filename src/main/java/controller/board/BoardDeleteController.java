package controller.board;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.BoardsDAO;

@WebServlet("/deleteBoard")
public class BoardDeleteController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("boardId") != null || req.getParameter("countryNm") != null) {
			String boardId = req.getParameter("boardId");
			String countryNm = req.getParameter("countryNm");
			int r = BoardsDAO.deleteTargetBoard(boardId);

			if (r == 1) {
				resp.sendRedirect("/cautionDetailBoard?countryNm=" + URLEncoder.encode(countryNm, "utf-8"));
			}
		}else {
			resp.sendRedirect("/");
		}
	}
}
