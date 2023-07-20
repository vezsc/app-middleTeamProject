package data.detail;

import data.country.CountryData;

public class DetailReseponseResult {
	int currentCount;
	int totalCount;
	DetailData[] data;

	public int getCurrentCount() {
		return currentCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public DetailData[] getData() {
		return data;
	}

}
