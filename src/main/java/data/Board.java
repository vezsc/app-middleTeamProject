	package data;

public class Board {

	int id;
	String writer;
	String title;
	String body;

	int totalUsers;
	int currentUsers;

	String time;

	String continent;   

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCurrentUsers() {
		return currentUsers;
	}

	public void setCurrentUsers(int currentUsers) {
		this.currentUsers = currentUsers;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;

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

	public int getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


}
