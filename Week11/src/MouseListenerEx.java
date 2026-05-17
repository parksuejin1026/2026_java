import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseListenerEx extends JFrame{
	
	private JLabel la = new JLabel ("Hello");;
	
	public MouseListenerEx() {
		setTitle("Mouse 이벤트 예제");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.addMouseListener(new MyMouseListener());
		
		c.setLayout(null);
		la.setSize(50, 20);
		la.setLocation(30, 30);
		c.add(la);
		
		setSize(250, 250);
		setVisible(true);
		}
	
class MyMouseListener implements MouseListener {
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		la.setLocation(x, y);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseListenerEx();
	}

}
