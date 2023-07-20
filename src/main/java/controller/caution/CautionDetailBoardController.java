package controller.caution;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Board;
import data.country.CountryData;
import data.detail.DetailData;
import repository.BoardsDAO;
import util.CountryAPI;
import util.DetailAPI;

@WebServlet("/cautionDetailBoard")
public class CautionDetailBoardController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("countryNm") != null) {
			resp.setContentType("text/json;charset=utf-8");

			req.setCharacterEncoding("utf-8");
			String country = req.getParameter("countryNm");
			req.setAttribute("country", country);
			// System.out.println(country);

			CountryData countryData = CountryAPI.findCountry(country);
			req.setAttribute("countryData", countryData);

			String continent = countryData.getContinentEngNm();

			List<Board> boardLi = BoardsDAO.findByBoard(continent);
			int p;
			if (req.getParameter("page") == null) {
				p = 1;
			} else {
				p = Integer.parseInt(req.getParameter("page"));
			}
			Map<String, Object> map = new LinkedHashMap<>();

			map.put("a", p * 10 - 9);
			map.put("b", p * 10);
			map.put("continent", continent);
			// boardLi.size() == 191;
			int totalPage = boardLi.size() % 10 == 0 ? boardLi.size() / 10 : boardLi.size() / 10 + 1;

			List<Board> pageBoardLi = BoardsDAO.findByBoardsAtoB(map);

			req.setAttribute("totalPage", totalPage);
			req.setAttribute("boardLi", pageBoardLi);

			DetailData detailData = DetailAPI.getCountries(country);
			req.setAttribute("DetailData", detailData);

			req.setAttribute("error", req.getParameter("error"));
			req.getRequestDispatcher("/WEB-INF/views/caution/cautionBoardDetail.jsp").forward(req, resp);

		}else {
			resp.sendRedirect("/");
		}
	}
}
