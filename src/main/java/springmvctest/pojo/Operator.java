package springmvctest.pojo;

import javax.validation.constraints.Size;

public class Operator {
	private Integer id;
	
	@Size(min = 2, max = 64, message = "2~64字符")
	private String username;
	
	@Size(min = 6, max = 32, message = "6~32位")
	private String password;
	
	private Role role; // 对一关系
	
	private Boolean disabled;
	
	private String email; // alter table OPERATORS add column EMAIL varchar(128)

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

	public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
	public String toString() {
		return "Operator [id=" + id + ", username=" + username + ", password="
				+ password + ", role=" + role + ", disabled=" + disabled + "]";
	}
}
