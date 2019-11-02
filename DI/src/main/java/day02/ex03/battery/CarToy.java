package day02.ex03.battery;


public class CarToy {
	
	
	private InterBattery battery;
	
	//setter
	public void setBattery(InterBattery battery) {
		this.battery = battery;
	}
	
	//getter
	public InterBattery getBattery() {
		return battery;
	}
	
	//배터리 에너지 보기
	public void button() {
		battery.energy();
	}
	
	
	//자동주입으로 변경해볼까?----------------------------------
//	@Resource(name="bt2")
//	private InterBattery battery;
//
//	public void setBattery(InterBattery battery) {
//		this.battery = battery;
//	}
//	
//	//배터리 분리형
//	public InterBattery getBattery() {
//		return battery;
//	}
//	
//	//배터리 에너지 보기
//	public void button() {
//		battery.energy();
//	}
}
