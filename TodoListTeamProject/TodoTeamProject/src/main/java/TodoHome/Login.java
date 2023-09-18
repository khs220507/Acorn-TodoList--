package TodoHome;

public class Login {
	String id;
	String pw;
	String name;
	String birth;
	String tel;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String id, String pw, String name, String birth, String tel) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", tel=" + tel + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
