package springmvctest.pojo;

public class Student {
	private Long id; // 当表中的数据行可能无限增长时，id列最好用Long
	private String name;
	private Gender gender; // 性别
	private Integer age;
	private String major; // 专业
	
	// 为了配合Mybatis，pojo类必须有无参的构造器和getter/setters
	public Student() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", major=" + major + "]";
	}
}
