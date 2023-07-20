package controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.country.CountryData;
import util.CountryAPI;

@WebServlet("/index/ajax")
public class IndexAjaxController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("word") != null) {
			String word = req.getParameter("word");
			resp.setContentType("text/plain;charset=utf-8");

			List<String> li = new LinkedList<>();

			CountryData[] countryLi = CountryAPI.getCountries().getData();

			PrintWriter out = resp.getWriter();
			for (CountryData data : countryLi) {
				if (data.getCountryNm().contains(word)) {
					if (!data.getAlarmLvl().equals("0")) {
						li.add(data.getCountryNm());
					}
				}
			}
			Gson gson = new Gson();

			out.println(gson.toJson(li));
		}else {
			resp.sendRedirect("/");
		}
	}
}
