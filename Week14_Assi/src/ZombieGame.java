import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class ZombieGame extends JFrame {
    private final GamePanel panel = new GamePanel();

    // 게임 창을 만들고 화면에 패널을 붙인다.
    public ZombieGame() {
        setTitle("Zombie Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        // 키보드 입력은 현재 선택된 컴포넌트만 받을 수 있다.
        // 그래서 게임 화면인 panel이 방향키 입력을 받을 수 있도록 포커스를 준다.
        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }

    // 실제 게임 화면을 그리고 키 입력을 처리하는 패널이다.
    class GamePanel extends JPanel implements KeyListener, Runnable {
        // 쓰레드 작동을 위한 run 메서드
        @Override
        public void run() {
            while(true) {
                // 주인공 자동 움직임
                gameover = hero.heroMove();
                if (gameover == true) {
                    repaint();
                    break;
                }

                zombie1.randomMove();
                zombie2.randomMove();
                
                repaint();

                try {
                    Thread.sleep(200); // 0.2초 마다 쉼
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }
        GraphicHero hero = new GraphicHero(0, 174);
        GraphicZombie zombie1 = new GraphicZombie(150, 170);
        GraphicZombie zombie2 = new GraphicZombie(200, 170);
        // 오른쪽으로 이동할 때는 hero01.png, 왼쪽으로 이동할 때는 hero04.png를 사용한다.
        // ImageIcon으로 파일을 읽고, getImage()로 화면에 그릴 수 있는 Image 객체를 꺼낸다.
        // private final ImageIcon icon1 = new ImageIcon("images/hero01.png");
        // private final ImageIcon icon4 = new ImageIcon("images/hero04.png");
        // private final Image right = icon1.getImage();
        // private final Image left = icon4.getImage();

        // 노란색 바닥이 시작되는 y좌표
        private static final int FLOOR_Y = 200;

        // x는 용사의 가로 위치이다.
        // direction은 마지막으로 누른 방향을 기억한다.
        // 0이면 오른쪽 이미지, 1이면 왼쪽 이미지를 그린다.
        private int x = 0;
        private int direction = 0;
        boolean gameover;
        public GamePanel() {
            // 이 패널에서 발생하는 키보드 입력을 keyPressed 메소드가 받을 수 있게 등록한다.
            this.addKeyListener(this);
            hero.dir = 1;
            new Thread(this).start();
        }

        // 배경, 바닥, 용사를 화면에 그린다.
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 검은색 배경
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            // 노란색 바닥
            g.setColor(Color.ORANGE);
            g.fillRect(0, FLOOR_Y, getWidth(), getHeight() - FLOOR_Y);

            // 이미지를 그릴 때 y좌표는 이미지의 맨 위 위치를 의미한다.
            // 따라서 바닥 위치(FLOOR_Y)에서 이미지 높이를 빼면 용사의 발이 바닥에 닿는다.
            // int y = FLOOR_Y - icon1.getIconHeight();

            // // 바라보는 방향에 맞는 이미지를 그린다.
            // if (direction == 0) {
            //     g.drawImage(right, x, y, this);
            // } else {
            //     g.drawImage(left, x, y, this);
            // }
            if (gameover == true) {
                g.drawString("목적지에 도착했습니다. 게임 종료", 200, 150);
            }
            hero.paint(g);

            zombie1.paint(g);
            zombie2.paint(g);
        }

        // 방향키를 누르면 용사의 위치와 바라보는 방향을 바꾸고 화면을 다시 그린다.
        @Override
        public void keyPressed(KeyEvent e) {
            // 사용자가 누른 키가 어떤 키인지 숫자 코드로 가져온다.
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_RIGHT) {
                hero.moveRight();
                hero.dir = 1;
                repaint();
            } else if (keyCode == KeyEvent.VK_LEFT) {
                hero.moveleft();
                hero.dir = 2;
                repaint();
            } else if (keyCode == KeyEvent.VK_UP) {
                hero.jump();
                repaint();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}

        
    }

    // 프로그램 시작 지점
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ZombieGame());
    }
}
