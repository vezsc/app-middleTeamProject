package controller.board;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
import repository.BoardsDAO;

@WebServlet("/board/write-task")
public class BoardWriteTaskController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("continent") != null || req.getParameter("country") != null
				|| req.getParameter("body") != null || req.getParameter("totalUsers") != null
				|| req.getParameter("date") != null || req.getParameter("time") != null
				|| req.getParameter("title") != null) {
			if(req.getParameter("title").equals("") || req.getParameter("body").equals("") || req.getParameter("date").equals("") || req.getParameter("time").equals("")) {
				resp.sendRedirect("/");
				return;
			}

			
			
			
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("logonUser");
			// user.getNick();

			String nick = user.getNick();

			String continent = req.getParameter("continent");
			String country = req.getParameter("country");
			String body = req.getParameter("body");
			String totalUsers = req.getParameter("totalUsers");
			String date = req.getParameter("date");
			String time = date + " " + req.getParameter("time");
			String title = req.getParameter("title");

			if (continent.equals("아시아")) {
				continent = "Asia";
			} else if (continent.equals("유럽")) {
				continent = "Europe";
			} else if (continent.equals("아메리카")) {
				continent = "America";
			} else if (continent.equals("아프리카")) {
				continent = "Africa";
			} else if (continent.equals("중동")) {
				continent = "Middle East";
			}

			Map<String, Object> board = new LinkedHashMap<>();
			board.put("writer", nick);
			board.put("body", body);
			board.put("totalUsers", totalUsers);
			board.put("time", time);
			board.put("continent", continent);
			board.put("title", title);

			int r = BoardsDAO.createBoard(board);

			if (r == 1) {
				resp.sendRedirect("/cautionDetailBoard?countryNm=" + URLEncoder.encode(country, "utf-8"));
			} else {
				req.getRequestDispatcher(
						"/WEB-INF/views/moim/boardWrite.jsp?continent=" + URLEncoder.encode(continent, "utf-8")
								+ "&country=" + URLEncoder.encode(country, "utf-8") + "&error=-1")
						.forward(req, resp);
			}

		} else {
			resp.sendRedirect("/");
		}
	}
}
