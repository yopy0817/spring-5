package day02.ex08.autowired.quiz2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ApToy {

	@Autowired
	@Qualifier("bt1")
	private InterBattery battery;

	//배터리 일체형
	public ApToy(InterBattery battery) {
		this.battery = battery;
	}
		
	//배터리 에너지 보기
	public void button() {
		battery.energy();
	}
	
	//의존 객체 자동 주입시 추가
	public ApToy() {
		
	}
	
	
}
