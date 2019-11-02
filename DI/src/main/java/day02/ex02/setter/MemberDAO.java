package day02.ex02.setter;

public class MemberDAO {
	
	private DatabaseDev ds;
	//세터생성
	public void setDs(DatabaseDev ds) {
		this.ds = ds;
	}

	public void info() {
		System.out.println("ds의 주소:" + ds.getUrl());
		System.out.println("ds의 아디:" + ds.getUid());
		System.out.println("ds의 비번:" +ds.getUpw());
	}
	
}
