package controller.search;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.country.CountryData;
import util.CountryAPI;

@WebServlet("/search")
public class SearchController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("countryNm") != null) {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/search;charset=utf-8");
			String countryNm = req.getParameter("countryNm");

			List<CountryData> li = new LinkedList<>();

			CountryData[] countryLi = CountryAPI.getCountries().getData();
			for (CountryData i : countryLi) {
				if (i.getAlarmLvl() != null) {
					if (i.getCountryNm().matches("(.+)?" + countryNm + "(.+)?")) {
						li.add(i);
					}
				}
			}

			req.setAttribute("findSearch", li);
			req.getRequestDispatcher("/WEB-INF/views/search.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/index");
		}
	}
}