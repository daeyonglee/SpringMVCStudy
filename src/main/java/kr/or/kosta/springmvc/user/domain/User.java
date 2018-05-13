package kr.or.kosta.springmvc.user.domain;

public class User {
	private String uno;
	private String upw;
	private String uname;
	private String upoint;

	public User() {}

	public User(String uno, String upw, String uname, String upoint) {
		super();
		this.uno = uno;
		this.upw = upw;
		this.uname = uname;
		this.upoint = upoint;
	}

	public String getUno() {
		return uno;
	}

	public void setUno(String uno) {
		this.uno = uno;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpoint() {
		return upoint;
	}

	public void setUpoint(String upoint) {
		this.upoint = upoint;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	@Override
	public String toString() {
		return "User [uno=" + uno + ", upw=" + upw + ", uname=" + uname + ", upoint=" + upoint + "]";
	}
}
