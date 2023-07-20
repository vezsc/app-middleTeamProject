package controller.caution;

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

@WebServlet("/caution")
public class CautionController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("alarmLvl") != null) {
			String alarmLvl = req.getParameter("alarmLvl");

			CountryData[] countryLi = CountryAPI.getCountries().getData();

			List<CountryData> africa = new LinkedList<>();
			List<CountryData> america = new LinkedList<>();
			List<CountryData> asia = new LinkedList<>();
			List<CountryData> middleEast = new LinkedList<>();
			List<CountryData> europe = new LinkedList<>();

			for (int i = 0; i < countryLi.length; i++) {
				if (countryLi[i].getAlarmLvl() != null) {
					if (countryLi[i].getAlarmLvl().equals(alarmLvl + "")) {
						if (countryLi[i].getContinentNm().equals("아프리카")) {
							africa.add(countryLi[i]);

						} else if (countryLi[i].getContinentNm().equals("미주")) {
							america.add(countryLi[i]);

						} else if (countryLi[i].getContinentNm().equals("아주")) {
							asia.add(countryLi[i]);

						} else if (countryLi[i].getContinentNm().equals("유럽")) {
							europe.add(countryLi[i]);

						} else {
							middleEast.add(countryLi[i]);
						}
					}
				}
			}

			req.setAttribute("africa", africa);
			req.setAttribute("america", america);
			req.setAttribute("asia", asia);
			req.setAttribute("middleEast", middleEast);
			req.setAttribute("europe", europe);

			req.getRequestDispatcher("/WEB-INF/views/caution/caution" + alarmLvl + ".jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/");
		}
	}
}
