package kr.or.kosta.springmvc.user.domain;

public class Login {

	private String uno;
	private String upw;
	private boolean useCookie;
	
	public Login() {}

	public Login(String uno, String upw, boolean useCookie) {
		super();
		this.uno = uno;
		this.upw = upw;
		this.useCookie = useCookie;
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

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "Login [uno=" + uno + ", upw=" + upw + ", useCookie=" + useCookie + "]";
	}
}
