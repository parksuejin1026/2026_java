package Point;

public class ColorPoint extends Point{
	private String color; // 점의 색
	public void setColor(String c) {
		this.color = c;
	}
	
	public void showColorPoint() {
		System.out.print(color);
		showPoint(); // Point 클래스의 메서드 호출
	}
}
