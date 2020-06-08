package model;

public class Register {
	private String id;
	private String password1;
	private String password2;
	private String name;
	private int tel;
	private String email;
	private String dob;
	private String url;
	private String gender;

	public Register() {
	}

	public Register(String id, String password1, String password2, String name, int tel, String email, String dob,
			String url, String gender) {
		this.id = id;
		this.password1 = password1;
		this.password2 = password2;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.dob = dob;
		this.url = url;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}