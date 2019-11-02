package day02.ex03.battery;


public class ApToy {
	
	
	private InterBattery battery;

	//생성자
	public ApToy(InterBattery battery) {
		this.battery = battery;
	}
		
	//기능
	public void button() {
		battery.energy();
	}
	
	
	//자동주입으로 변경해볼까?-----------------------------------------------
//	@Autowired
//	@Qualifier("bt1")
//	private InterBattery battery;
//
//	//배터리 일체형
//	public ApToy(InterBattery battery) {
//		this.battery = battery;
//	}
//		
//	//배터리 에너지 보기
//	public void button() {
//		battery.energy();
//	}
//	
//	//의존 객체 자동 주입시 추가
//	public ApToy() {
//		
//	}
	
	
}
