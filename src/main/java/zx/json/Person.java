package zx.json;

import com.google.gson.annotations.SerializedName;

public class Person {
	@SerializedName("NAME")//gson�е�ע�⣬����ָ������jsonʱ����������
	private String name;
	private int age;
	private boolean adult;
	private transient String ignore;//��ϣ�������л�Ϊjson������
	
	public Person() {
		super();
	}
	public Person(String name, int age, boolean adult) {
		super();
		this.name = name;
		this.age = age;
		this.adult = adult;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isAdult() {
		return adult;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	public String getIgnore() {
		return ignore;
	}
	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", adult=" + adult + "]";
	}
}
