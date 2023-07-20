package util;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Iterator;

import com.google.gson.Gson;

import data.country.CountryData;
import data.country.CountryResponseResult;

public class CountryAPI {
	
	static CountryResponseResult cashedCountryResponseResult = null;
	
	public static CountryResponseResult getCountries() {
		
		if(cashedCountryResponseResult != null) {
			return cashedCountryResponseResult;
		}
		
		try {
			String target = "http://apis.data.go.kr/1262000/TravelAlarmService2/getTravelAlarmList2"; 
			
			String serviceKey = "serviceKey=TT8ageplWrUZlpTAKWDAFtcnq5YyxBCi6RVOckgyry%2FNP0YPser9sZRuj2%2Bbx3wNI0wHk4pv5YJdw1bbcjPC9w%3D%3D";
			String numOfRows = "&numOfRows=197";
			String pageNo = "&pageNo=1";
			
			String queryString = serviceKey + numOfRows + pageNo;
			
			URI uri = new URI(target + "?" + queryString);
			

			// HttpClient 객체를 활용하는 방식
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			Gson gson = new Gson();
			CountryResponseResult result = gson.fromJson(response.body(), CountryResponseResult.class);
			cashedCountryResponseResult = result;
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			 return null;
		}
	}
	public static CountryData findCountry(String country) {
		try {
			String target = "http://apis.data.go.kr/1262000/TravelAlarmService2/getTravelAlarmList2"; 
			
			String serviceKey = "serviceKey=TT8ageplWrUZlpTAKWDAFtcnq5YyxBCi6RVOckgyry%2FNP0YPser9sZRuj2%2Bbx3wNI0wHk4pv5YJdw1bbcjPC9w%3D%3D";
			String numOfRows = "&numOfRows=197";
			String pageNo = "&pageNo=1";
			String cond = "&cond[country_nm::EQ]=" + URLEncoder.encode(country, "UTF-8");
			
			String queryString = serviceKey + numOfRows + pageNo + cond;
			
			URI uri = new URI(target + "?" + queryString);

			// HttpClient 객체를 활용하는 방식
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

			Gson gson = new Gson();
			// System.out.println(response.body());
			CountryResponseResult responseResult = gson.fromJson(response.body(), CountryResponseResult.class);
			CountryData result = responseResult.getData()[0];
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			 return null;
		}
	}
}
