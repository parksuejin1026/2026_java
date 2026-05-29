import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Assi1 extends JFrame{
	private final int FLYING_UNIT = 10; // 한번에 10픽셀을 이동하기 위해 생성, 키보드
	
	private ImageIcon paladogImage = new ImageIcon("images/paladog1.png");
	private JLabel paladogLabel = new JLabel(paladogImage);
	
	public Assi1() {
		setTitle("10주차 과제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(null); // 좌표를 직접 지정하기 위해 null사용
		c.setBackground(Color.white); // 배경 햐안색으로 설정
		
		paladogLabel.setLocation(50, 50); // 라벨 처음 위치 50, 50
		paladogLabel.setSize(250,250); // 라벨 사이즈 250, 250
		c.add(paladogLabel); // 라벨을 컨테이너에 추가
		
		MyGameListener listener = new MyGameListener(); // 마우스 및 키보드 리스너 클래스
		c.addMouseListener(listener); 
		c.addMouseMotionListener(listener);
		c.addKeyListener(listener);
		
		setSize(600, 600);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
		c.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Component com = (Component)e.getSource();
                com.setFocusable(true);
                com.requestFocus();
            }
        });
    }

    class MyGameListener extends MouseAdapter implements KeyListener {
        
        @Override
        public void mousePressed(MouseEvent e) {
            Point clickPoint = e.getPoint();
            
            if (paladogLabel.getBounds().contains(clickPoint)) { // 팔라독 라벨의 사각형 영역에 마우스의 클릭 포인트가 안에 있는가?? 
                paladogLabel.setLocation(paladogLabel.getX() + 1, paladogLabel.getY()); // true라면, 라벨을 클릭했을 때 X방향으로 1씩 이동
            } 
            else {
                int nextX = e.getX() - (100 / 2); // 라벨이 아닌 다른 곳을 클릭하면 그 위치로 이동하기 위해 좌표값 받기
                int nextY = e.getY() - (100 / 2);
                paladogLabel.setLocation(nextX, nextY);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int nextX = e.getX() - (100 / 2); // 드래그해서 움직일 때마다 좌표값 옮기기
            int nextY = e.getY() - (100 / 2);
            paladogLabel.setLocation(nextX, nextY);
        }

        @Override
        public void keyPressed(KeyEvent e) { // 키보드를 눌렀을 때
            int keyCode = e.getKeyCode();
            switch(keyCode) {
                case KeyEvent.VK_LEFT: // 왼쪽 방향키
                    paladogLabel.setLocation(paladogLabel.getX() - FLYING_UNIT, paladogLabel.getY());
                    break;
                case KeyEvent.VK_RIGHT: // 오른쪽 방향키
                    paladogLabel.setLocation(paladogLabel.getX() + FLYING_UNIT, paladogLabel.getY());
                    break;
                case KeyEvent.VK_UP: // 위쪽 방향키(구현하고 싶어서 함)
                	paladogLabel.setLocation(paladogLabel.getX(), paladogLabel.getY() - FLYING_UNIT);
                	break;
                case KeyEvent.VK_DOWN: // 아래쪽 방향키(구현하고 싶어서 함)
                	paladogLabel.setLocation(paladogLabel.getX(), paladogLabel.getY() + FLYING_UNIT);
            }
        }
        
        @Override public void keyReleased(KeyEvent e) {}
        @Override public void keyTyped(KeyEvent e) {}
    }

    public static void main(String[] args) {
        new Assi1();
    }
}