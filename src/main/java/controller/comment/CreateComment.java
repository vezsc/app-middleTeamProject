package controller.comment;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
import repository.CommentsDAO;

@WebServlet("/createComment")
public class CreateComment extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("country") != null || req.getParameter("body") != null) {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("logonUser");

			String nick = user.getNick();
			// nick = "철이";
			String country = req.getParameter("country");
			String body = req.getParameter("body");

			Map<String, Object> map = new HashMap<>();

			map.put("country", country);
			map.put("writer", nick);
			map.put("body", body);

			int r = CommentsDAO.createComment(map);
			country = URLEncoder.encode(country, "utf-8");

			if (r == 1) {
				resp.sendRedirect("/cautionDetail?countryNm=" + country);
			} else {
				resp.sendRedirect("/cautionDetail?countryNm=" + country + "&error=2");
			}
		} else {
			resp.sendRedirect("/");
		}
	}
}
