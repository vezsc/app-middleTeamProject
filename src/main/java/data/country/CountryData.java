package data.country;

import com.google.gson.annotations.SerializedName;

public class CountryData {
	@SerializedName("alarm_lvl")
	String alarmLvl;

	@SerializedName("continent_eng_nm")
	String continentEngNm;

	@SerializedName("continent_nm")
	String continentNm;

	@SerializedName("country_eng_nm")
	String countryEngNm;

	@SerializedName("country_nm")
	String countryNm;

	@SerializedName("dang_map_download_url")
	String mapUrl;

	@SerializedName("flag_download_url")
	String flagUrl;

	@SerializedName("remark")
	String remark;

	public String getRemark() {
		return remark;
	}

	public String getAlarmLvl() {
		return alarmLvl;
	}

	public String getContinentEngNm() {
		return continentEngNm;
	}

	public String getContinentNm() {
		return continentNm;
	}

	public String getCountryEngNm() {
		return countryEngNm;
	}

	public String getCountryNm() {
		return countryNm;
	}

	public String getMapUrl() {
		return mapUrl;
	}

	public String getFlagUrl() {
		return flagUrl;
	}

}
