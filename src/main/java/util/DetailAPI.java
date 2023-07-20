package util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import data.detail.DetailData;
import data.detail.DetailReseponseResult;

public class DetailAPI {
	public static  DetailData getCountries(String countryNm) {
		try {
			String target = "http://apis.data.go.kr/1262000/OverviewGnrlInfoService/getOverviewGnrlInfoList"; 
			
			String serviceKey = "serviceKey=hfY4jV%2FzCjpk50h155lj3ju6kuxtVukr064i%2F49ymXZ3BPHeRbhPckegY%2FY4b724KuPwgU%2FssMe8NwwvWwGgQA%3D%3D";
			String numOfRows = "&numOfRows=1";
			String pageNo = "&pageNo=1";
			String cond = "&cond[country_nm::EQ]=" + countryNm;
			String queryString = serviceKey + numOfRows + pageNo + cond;
			
			URI uri = new URI(target + "?" + queryString);

			// HttpClient 객체를 활용하는 방식
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			Gson gson = new Gson();
			DetailReseponseResult result = gson.fromJson(response.body(), DetailReseponseResult.class);
			DetailData detailData = result.getData()[0];
			
			return detailData;
			
		} catch (Exception e) {
			e.printStackTrace();
			 return null;
		}
	}
}
