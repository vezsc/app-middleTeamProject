package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
import repository.UsersDAO;

@WebServlet("/user/login-task")
public class UserLogInTaskController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("id") != null || req.getParameter("pass") != null) {
			HttpSession session = req.getSession();

			String id = req.getParameter("id");
			String pass = req.getParameter("pass");

			User user = UsersDAO.findUser(id);

			if (user == null) {
				resp.sendRedirect("/user/login?cause=error1");
			} else {
				if (user.getPass().equals(pass)) {
					session.setAttribute("logon", true);
					session.setAttribute("logonUser", user);
					resp.sendRedirect("/");
				} else {
					resp.sendRedirect("/user/login?cause=error2");
				}
			}
		}else {
			resp.sendRedirect("/");
		}
	}
}
