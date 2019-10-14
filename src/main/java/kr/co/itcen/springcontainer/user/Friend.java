package kr.co.itcen.springcontainer.user;

public class Friend {
	private String name;
	
	//기본생성자가 없음
	public Friend(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + "]";
	}
	
	

}
