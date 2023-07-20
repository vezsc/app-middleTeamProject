package controller.search;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search-task")
public class SearchTaskController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("countryNm") != null) {
			String countryNm = req.getParameter("countryNm");

			resp.sendRedirect("/cautionDetail?CountryNm=" + URLEncoder.encode(countryNm, "UTF-8"));
		}else {
			resp.sendRedirect("/");
		}
	}
}
