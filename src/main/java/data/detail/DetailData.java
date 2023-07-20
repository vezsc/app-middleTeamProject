package data.detail;

import com.google.gson.annotations.SerializedName;

public class DetailData {
	@SerializedName("area")
	String area; // 면적

	@SerializedName("area_desc")
	String areaDesc; // 면적 설명

	@SerializedName("capital")
	String capital; // 수도

	@SerializedName("climate")
	String climate; // 기후

	@SerializedName("country_eng_nm")
	String countryEngNm; // 국가 영어 이름

	@SerializedName("country_nm")
	String countryNm; // 국가 한글 이름

	@SerializedName("establish")
	String establish; // 국경일

	@SerializedName("ethnic")
	String ethnic; // 민족

	@SerializedName("lang")
	String lang; // 언어

	@SerializedName("population")
	String population; // 인구

	@SerializedName("population_desc")
	String populationDesc; // 인구 설명

	@SerializedName("religion")
	String religion; // 종교
	
	@SerializedName("remark")
	String remark; // 비고, 나라설명 

	public String getArea() {
		return area;
	}

	public String getAreaDesc() {
		return areaDesc;
	}

	public String getCapital() {
		return capital;
	}

	public String getClimate() {
		return climate;
	}

	public String getCountryEngNm() {
		return countryEngNm;
	}

	public String getCountryNm() {
		return countryNm;
	}

	public String getEstablish() {
		return establish;
	}

	public String getEthnic() {
		return ethnic;
	}

	public String getLang() {
		return lang;
	}

	public String getPopulation() {
		return population;
	}

	public String getRemark() {
		return remark;
	}

	public String getPopulationDesc() {
		return populationDesc;
	}

	public String getReligion() {
		return religion;
	}
	

}
