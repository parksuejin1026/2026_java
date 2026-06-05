import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class ZombieGame extends JFrame {
    private final GamePanel panel = new GamePanel();

    public ZombieGame() {
        setTitle("Zombie Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }

    class GamePanel extends JPanel implements KeyListener, Runnable {
        private static final int FLOOR_Y = 200;

        GraphicHero hero = new GraphicHero(30);
        GraphicZombie zombie1 = new GraphicZombie(150);
        GraphicZombie zombie2 = new GraphicZombie(260);
        GraphicZombie zombie3 = new GraphicZombie(380);

        boolean gameover;
        boolean clear;

        public GamePanel() {
            addKeyListener(this);
            hero.dir = 1;
            new Thread(this).start();
        }

        // 게임이 실행되는 동안 0.2초마다 좀비를 움직이고 충돌을 확인한다.
        @Override
        public void run() {
            while (true) {
                if (!gameover && !clear) {
                    zombie1.randomMove();
                    zombie2.randomMove();
                    zombie3.randomMove();

                    checkCollision();
                    checkClear();
                }

                repaint();

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // 주인공과 좀비의 사각형 영역이 겹치면 충돌로 판단한다.
        public void checkCollision() {
            Rectangle heroBox = hero.getBounds();

            if (heroBox.intersects(zombie1.getBounds())
                    || heroBox.intersects(zombie2.getBounds())
                    || heroBox.intersects(zombie3.getBounds())) {
                gameover = true;
            }
        }

        // 주인공이 오른쪽 끝까지 도착하면 성공 처리한다.
        public void checkClear() {
            if (hero.x >= 500 - hero.imgWidth) {
                clear = true;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.ORANGE);
            g.fillRect(0, FLOOR_Y, getWidth(), getHeight() - FLOOR_Y);

            hero.paint(g);
            zombie1.paint(g);
            zombie2.paint(g);
            zombie3.paint(g);

            if (gameover) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Dialog", Font.BOLD, 24));
                g.drawString("좀비와 충돌했습니다.", 140, 120);
                g.setFont(new Font("Dialog", Font.PLAIN, 14));
                g.drawString("SPACE 키를 누르면 다시 시작합니다.", 145, 145);
            } else if (clear) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Dialog", Font.BOLD, 24));
                g.drawString("목적지에 도착했습니다.", 135, 120);
                g.setFont(new Font("Dialog", Font.PLAIN, 14));
                g.drawString("SPACE 키를 누르면 다시 시작합니다.", 145, 145);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if ((gameover || clear) && keyCode == KeyEvent.VK_SPACE) {
                restart();
                return;
            }

            if (gameover || clear) {
                return;
            }

            if (keyCode == KeyEvent.VK_RIGHT) {
                hero.moveRight();
            } else if (keyCode == KeyEvent.VK_LEFT) {
                hero.moveleft();
            }

            checkCollision();
            checkClear();
            repaint();
        }

        public void restart() {
            hero = new GraphicHero(30);
            hero.dir = 1;
            zombie1 = new GraphicZombie(150);
            zombie2 = new GraphicZombie(260);
            zombie3 = new GraphicZombie(380);
            gameover = false;
            clear = false;
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ZombieGame());
    }
}
