import javax.swing.*;
import java.awt.*;

public class JPanelTest extends JFrame{
	private MyPanel panel = new MyPanel();
	public JPanelTest() {
		setTitle("패널 클래스 만들어서 패널 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 실제 패널 그리기 시작
			
			g.setColor(Color.BLUE);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50, 50, 50, 50);	
			g.setColor(Color.MAGENTA);
			g.drawRect(90, 90, 50, 50);
			g.drawString("자바는 재밌다", 30, 30);
			g.drawString("하늘 만큼 땅 만큼", 60, 60);
		}
			
	}
	
	public static void main(String[] args) {
		new JPanelTest();
	}
}