package springmvctest.pojo;

public class Operator {
	private Integer id;
	private String username;
	private String password;
	private String role;
	private Boolean disabled;

	public Operator() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public String toString() {
		return "Operator [id=" + id + ", username=" + username + ", password="
				+ password + ", role=" + role + ", disabled=" + disabled + "]";
	}
}
