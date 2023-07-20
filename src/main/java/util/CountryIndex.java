package util;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;

import data.country.CountryData;

public class CountryIndex {
	public static List<String> countryNms(CountryData[] countryDatas) {
		List<String> countryNms = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < countryDatas.length; i++) {
			if (countryDatas[i].getAlarmLvl() != null) {
				countryNms.add(countryDatas[i].getCountryNm());
			}
		}

		return countryNms;
	}
}
