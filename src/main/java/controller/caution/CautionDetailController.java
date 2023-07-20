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
import data.Comment;
import data.country.CountryData;
import data.detail.DetailData;
import repository.BoardsDAO;
import repository.CommentsDAO;
import util.CountryAPI;
import util.DetailAPI;

@WebServlet("/cautionDetail")
public class CautionDetailController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("countryNm") != null) {
			req.setCharacterEncoding("utf-8");
			String country = req.getParameter("countryNm");
			req.setAttribute("country", country);

			CountryData countryData = CountryAPI.findCountry(country);
			req.setAttribute("countryData", countryData);

			// sql문에서 continent, a, b가 필요
			// continent는 커서 값?
			// a 는 sql문에서 댓글들의 순번을 정해 줄 시작 값
			// b 는 sql문에서 댓글들의 순번을 정해 줄 끝 값

			// totalPage continent를 기준으로 댓글들을 긁어왔을때 commentLI에 몇 개가 들어있는지 알아야함 그거를 10개로 나눠야됨
			// ( 10개인 이유는 10개씩 표출 할거라)
			// 주의점 10으로 나눴을때 나머지 때문에 이상 현상이 발생할거임
			List<Comment> commentLi = CommentsDAO.findCountryComments(country);

			// 1. p(param("page") 값을 만들어야함 *주의점* null를 주의해야함
			int p;
			if (req.getParameter("page") == null) { // 이게 바로 컨트롤러를 타고 jsp로 가면 page를 받아올 수가 없음
				p = 1; // 그래서 1로 기본값을 잡아주는 작업
			} else { // 널이 아닐 때
				p = Integer.parseInt(req.getParameter("page")); // req.getParameter 무조건 String 그래서 String 이외의 값을 받고 싶을때는
																// 파싱해야함
			}

			// 2. 맵을 만들어서 a 값과 b 값을 정해주고, map put
			Map<String, Object> map = new LinkedHashMap<>();
			int a = p * 5 - 4; // 파람값에서 출력 하고자 하는 갯수를 곱해요 그리고 출력 하고자 하는 갯수의 -1개를 뺴줘요

			map.put("a", a);
			map.put("b", p * 5);
			map.put("country", country);

			// 5. DAO 사용 후 그 결과 값을
			List<Comment> pageCommentLi = CommentsDAO.findByCommentsAtoB(map);
			req.setAttribute("commentLi", pageCommentLi); // 여기에 넣어주면 됨

			// 3. List commentLi에 결과 값의 수를 사용해야함
			// 3-2 알아낸걸 가지고 totalPage를 만들어야함
			int totalPage = commentLi.size() % 5 == 0 ? commentLi.size() / 5 : commentLi.size() / 5 + 1;

			// 4. 그 totalPage를 jsp에서 사용 할 수 있게 처리
			req.setAttribute("totalPage", totalPage);

			DetailData detailData = DetailAPI.getCountries(country);
			req.setAttribute("DetailData", detailData);

			req.setAttribute("error", req.getParameter("error"));
			req.getRequestDispatcher("/WEB-INF/views/caution/cautionDetail.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("/");
		}
	}
}
