package day02.ex08.autowired.quiz2;

import javax.annotation.Resource;

public class CarToy {

	@Resource(name="bt2")
	private InterBattery battery;

	public void setBattery(InterBattery battery) {
		this.battery = battery;
	}
	
	//배터리 분리형
	public InterBattery getBattery() {
		return battery;
	}
	
	//배터리 에너지 보기
	public void button() {
		battery.energy();
	}
}
