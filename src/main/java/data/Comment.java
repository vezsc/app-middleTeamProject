package data;

import java.util.Date;

public class Comment {
	String country;
	String writer;
	String body;
	Date writed;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getWrited() {
		return writed;
	}

	public void setWrited(Date writed) {
		this.writed = writed;
	}

}
