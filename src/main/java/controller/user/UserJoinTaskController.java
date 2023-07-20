package controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.User;
import repository.UsersDAO;

@WebServlet("/user/join-task")
public class UserJoinTaskController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("id") != null || req.getParameter("pass") != null || req.getParameter("nick") != null) {
			req.setCharacterEncoding("utf-8");
			String id = req.getParameter("id");
			String pass = req.getParameter("pass");
			String nick = req.getParameter("nick");

			Map<String, Object> map = new HashMap<>();
			map.put("id", id);
			map.put("pass", pass);
			map.put("nick", nick);
			int r = 0;
			if (!id.equals("") && !pass.equals("") && !nick.equals("")) {
				User user = UsersDAO.findUser(id);
				if (user == null) {
					r = UsersDAO.create(map);
				}
			}
			if (r == 1) {
				resp.sendRedirect("/");
			} else {
				resp.sendRedirect("/user/join");
			}
		} else {
			resp.sendRedirect("/");
		}
	}
}
