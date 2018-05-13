package kr.or.kosta.springmvc.aop.domain;

public class User {

	private String uno;
	private String upw;
	private String uname;
	private int upoint;
	
	public User() {}

	public User(String uno, String upw, String uname, int upoint) {
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

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUpoint() {
		return upoint;
	}

	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}

	@Override
	public String toString() {
		return "User [uno=" + uno + ", upw=" + upw + ", uname=" + uname + ", upoint=" + upoint + "]";
	}
}
